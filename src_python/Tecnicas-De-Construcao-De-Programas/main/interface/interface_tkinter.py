import tkinter as tk
from tkinter import filedialog, messagebox, ttk
from core.texto_musical import TextoMusical
from core.controlador_audio import ControladorAudio
import pygame 

class InterfaceTkinter:
    def __init__(self, root):
        self.root = root
        self.root.title("Gerador Musical MIDI")
        self.root.geometry("850x600")
        
        pygame.mixer.init()
        
        self.container = tk.Frame(root)
        self.container.pack(fill="both", expand=True)
        
        self.frames = {}
        
        for F in (TelaMenu, TelaComposicao, TelaReproducao):
            frame = F(self.container, self)  
            self.frames[F.__name__] = frame
            frame.grid(row=0, column=0, sticky="nsew")
        
        self.mostrar_tela("TelaMenu")
        
        self.arquivo_atual = None
        self.texto_musical = TextoMusical()
        self.controlador = ControladorAudio()

    def mostrar_tela(self, nome_tela):
        """Mostra a tela especificada"""
        frame = self.frames[nome_tela]
        frame.tkraise()
        
        if nome_tela == "TelaReproducao":
            frame.atualizar_interface()

class TelaMenu(tk.Frame):
    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        self.controller = controller
        
        tk.Label(self, text="Bem-vindo ao Gerador Musical MIDI", font=('Arial', 16)).pack(pady=50)
        
        btn_frame = tk.Frame(self)
        btn_frame.pack(pady=20)
        
        tk.Button(btn_frame, text="Nova Composição", 
                 command=lambda: controller.mostrar_tela("TelaComposicao")).pack(fill="x", pady=5)
        
        tk.Button(btn_frame, text="Carregar Arquivo", 
                 command=self.carregar_arquivo).pack(fill="x", pady=5)
        
        tk.Button(btn_frame, text="Sair", 
                 command=controller.root.quit).pack(fill="x", pady=5)

    def carregar_arquivo(self):
        caminho = filedialog.askopenfilename(filetypes=[("Arquivos de texto", "*.txt")])
        if caminho:
            try:
                with open(caminho, "r", encoding="utf-8") as f:
                    self.controller.arquivo_atual = caminho
                    conteudo = f.read()
                    self.controller.texto_musical.ler_texto(conteudo)
                    self.controller.mostrar_tela("TelaComposicao")
                    self.controller.frames["TelaComposicao"].text_input.delete(1.0, tk.END)
                    self.controller.frames["TelaComposicao"].text_input.insert(tk.END, conteudo)
            except Exception as e:
                messagebox.showerror("Erro", f"Erro ao carregar o arquivo: {e}")

class TelaComposicao(tk.Frame):
    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        self.controller = controller
        
        toolbar = tk.Frame(self)
        toolbar.pack(fill="x", pady=5)
        
        tk.Button(toolbar, text="← Voltar", command=lambda: controller.mostrar_tela("TelaMenu")).pack(side="left")
        tk.Button(toolbar, text="Salvar", command=self.salvar_arquivo).pack(side="left", padx=5)
        tk.Button(toolbar, text="Reproduzir", command=self.preparar_reproducao).pack(side="right")
        
        self.text_input = tk.Text(self, height=15, width=80, font=('Courier', 12))
        self.text_input.pack(fill="both", expand=True, padx=10, pady=5)
        
        self.status_bar = tk.Label(self, text="Pronto", bd=1, relief=tk.SUNKEN, anchor=tk.W)
        self.status_bar.pack(fill="x", side=tk.BOTTOM)

    def salvar_arquivo(self):
        conteudo = self.text_input.get("1.0", tk.END)
        caminho = filedialog.asksaveasfilename(
            defaultextension=".txt",
            filetypes=[("Arquivos de texto", "*.txt")])
        
        if caminho:
            try:
                with open(caminho, "w", encoding="utf-8") as f:
                    f.write(conteudo)
                self.controller.arquivo_atual = caminho
                self.status_bar.config(text=f"Arquivo salvo: {caminho}")
            except Exception as e:
                messagebox.showerror("Erro", f"Erro ao salvar o arquivo: {e}")

    def preparar_reproducao(self):
        entrada = self.text_input.get("1.0", tk.END).strip()
        self.controller.texto_musical.ler_texto(entrada)
        
        if not self.controller.texto_musical.validar_texto():
            messagebox.showerror("Erro", "Texto inválido. Use apenas A-H, +, -, <, > e números.")
            return
        
        self.controller.texto_musical.mapear_para_notas()
        self.controller.controlador.limpar()  
        self.controller.controlador.set_lista_notas(self.controller.texto_musical.notas)
        
        import time
        nome_arquivo = f"musica_{int(time.time())}"
        arquivo = self.controller.controlador.iniciar_reproducao(nome_arquivo)
        
        self.controller.mostrar_tela("TelaReproducao")
        self.controller.frames["TelaReproducao"].atualizar_interface()

class TelaReproducao(tk.Frame):
    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        self.controller = controller
        
        toolbar = tk.Frame(self)
        toolbar.pack(fill="x", pady=5)
        
        tk.Button(toolbar, text="← Voltar", command=lambda: controller.mostrar_tela("TelaComposicao")).pack(side="left")
        
        self.btn_play = tk.Button(toolbar, text="▶ Reproduzir", command=self.reproduzir)
        self.btn_play.pack(side="left", padx=5)
        
        self.btn_pause = tk.Button(toolbar, text="⏸ Pausar", command=self.pausar)
        self.btn_pause.pack(side="left", padx=5)
        
        self.btn_stop = tk.Button(toolbar, text="⏹ Parar", command=self.parar)
        self.btn_stop.pack(side="left", padx=5)
        
        self.notas_frame = tk.Frame(self)
        self.notas_frame.pack(fill="both", expand=True, padx=10, pady=5)
        
        self.status_bar = tk.Label(self, text="Pronto para reproduzir", bd=1, relief=tk.SUNKEN, anchor=tk.W)
        self.status_bar.pack(fill="x", side=tk.BOTTOM)
        
        self.progresso = ttk.Progressbar(self, orient="horizontal", mode="determinate")
        self.progresso.pack(fill="x", padx=10, pady=5)

    def atualizar_interface(self):
        """Atualiza a interface com as notas atuais"""
        for widget in self.notas_frame.winfo_children():
            widget.destroy()
        
        for i, nota in enumerate(self.controller.texto_musical.notas[:20]):  
            tk.Label(self.notas_frame, text=f"Nota {i+1}: {nota.nome} (Duração: {nota.duracao})").pack(anchor="w")

    def reproduzir(self):
        """Reproduz o arquivo MIDI gerado"""
        try:
            if not hasattr(self.controller.controlador, 'arquivo_saida'):
                self.controller.controlador.iniciar_reproducao()
            
            pygame.mixer.music.load(self.controller.controlador.arquivo_saida)
            pygame.mixer.music.play()
            self.status_bar.config(text="Reproduzindo...")
            
            self.atualizar_progresso()
            
        except Exception as e:
            messagebox.showerror("Erro", f"Erro ao reproduzir: {str(e)}")

    def atualizar_progresso(self):
        """Atualiza a barra de progresso durante a reprodução"""
        if pygame.mixer.music.get_busy():
            pos = pygame.mixer.music.get_pos() / 1000
            self.progresso["value"] = pos
            self.after(100, self.atualizar_progresso) 
        else:
            self.progresso["value"] = 0
            self.status_bar.config(text="Reprodução concluída")

    def pausar(self):
        """Pausa a reprodução"""
        pygame.mixer.music.pause()
        self.status_bar.config(text="Pausado")

    def parar(self):
        """Para a reprodução"""
        pygame.mixer.music.stop()
        self.status_bar.config(text="Parado")