import re
from .mapeador_texto_musical import MapeadorTextoMusical
from .controlador_audio import INSTRUMENTOS_GM
class TextoMusical:
    def __init__(self):
        self.conteudo = ""
        self.notas = []
        self.valido = False
        self.bpm = 120

    def ler_texto(self, input_str):
        self.conteudo = input_str

    def validar_texto(self):
        self.valido = self.texto_eh_valido()
        return self.valido

    def texto_eh_valido(self):
        padroes_invalidos = [
            r"<[^>]+>",
            r"\{.*?:.*?\}",
            r"\[.*?\]",
            r"[\$\=\(\)\{\}<>]"
        ]
        for padrao in padroes_invalidos:
            if re.search(padrao, self.conteudo):
                return False
        return True

    def mapear_para_notas(self):
        mapeador = MapeadorTextoMusical(
            texto=self.conteudo,
            oitava=self.oitava,
            instrumento=self.instrumento
        )

        self.notas.clear()
        for c in self.conteudo:
            nota = mapeador.mapear_caractere(c) 
            if nota:
                self.notas.append(nota)
    def configurar(self, bpm=120, instrumento="Acoustic Grand Piano", oitava=4):
        self.bpm = bpm
        self.instrumento = INSTRUMENTOS_GM.get(instrumento, 0)
        self.oitava = oitava
