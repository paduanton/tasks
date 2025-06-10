from midiutil import MIDIFile
import os

class ControladorAudio:
    def __init__(self):
        self.lista_notas = []
        self.volume_global = 100
        self.tempo = 0
        self.arquivo_saida = "saida.mid" 

    def set_lista_notas(self, lista):
        self.lista_notas = lista

    def iniciar_reproducao(self, nome_arquivo=None):
        if nome_arquivo is None:
            nome_arquivo = self.arquivo_saida
        
        if not nome_arquivo.lower().endswith('.mid'):
            nome_arquivo += '.mid'
            
        midi_file = MIDIFile(1)
        canal = 0
        tempo = 0  
                
        if self.lista_notas:
            midi_file.addProgramChange(0, 0, 0, self.lista_notas[0].instrumento)
        
        for nota in self.lista_notas:
            nota.tocar(midi_file, canal, tempo)
            tempo += nota.duracao  
            
        with open(nome_arquivo, "wb") as output:
            midi_file.writeFile(output)
        
        self.arquivo_saida = nome_arquivo 
        return nome_arquivo

    def limpar(self):
        """Limpa o estado do controlador"""
        self.lista_notas = []
        self.tempo = 0