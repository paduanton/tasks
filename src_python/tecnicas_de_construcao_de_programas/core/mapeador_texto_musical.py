import random
from .nota_musical import NotaMusical

class MapeadorTextoMusical:
    def __init__(self, texto, oitava=4, instrumento=56, bpm=120):
        self.texto_original = texto
        self.instrumento_atual = instrumento
        self.oitava_atual = oitava
        self.volume_default = 100
        self.volume_atual = self.volume_default
        self.bpm = bpm
        self.caractere_anterior = None
        self.nota_anterior = None
        self.oitava = oitava
        self.instrumento = instrumento

    def mapear_caractere(self, c):
        par = f"{self.caractere_anterior or ''}{c}"

        # checar pares que mudam estado primeiro
        if par.upper() == 'M+':
            self.bpm = min(self.bpm + 80, 300) 
            self.caractere_anterior = None
            return None

        if par.upper() == 'R+':
            self.oitava_atual = min(self.oitava_atual + 1, 8)
            self.caractere_anterior = None
            return None

        if par.upper() == 'R-':
            self.oitava_atual = max(self.oitava_atual - 1, 1)
            self.caractere_anterior = None
            return None

        if par.upper() in ('BP', 'PM'):
            self.caractere_anterior = None
            return None

        # depois tratar caracteres únicos
        if c == ' ':
            nota = NotaMusical(' ', 1, self.oitava_atual, self.volume_atual, self.instrumento_atual, self.bpm)
            self.caractere_anterior = c
            return nota

        elif c.lower() in 'abcdefg':
            nota = NotaMusical(c, 1, self.oitava_atual, self.volume_atual, self.instrumento_atual, self.bpm)
            self.nota_anterior = nota
            self.caractere_anterior = c
            return nota

        elif c == '+':
            self.volume_atual = min(self.volume_atual * 2, 127)
            self.caractere_anterior = c
            return None

        elif c == '-':
            self.volume_atual = self.volume_default
            self.caractere_anterior = c
            return None

        elif c.lower() in 'oiu':
            if self.nota_anterior:
                self.caractere_anterior = c
                return self.nota_anterior
            else:
                self.caractere_anterior = c
                return NotaMusical(125, 1, self.oitava_atual, self.volume_atual, self.instrumento_atual, self.bpm)

        elif c == '?':
            nota_aleatoria = random.choice(['A', 'B', 'C', 'D', 'E', 'F', 'G'])
            self.caractere_anterior = c
            return NotaMusical(nota_aleatoria, 1, self.oitava_atual, self.volume_atual, self.instrumento_atual, self.bpm)

        elif c == '\n':
            self.instrumento_atual = (self.instrumento_atual + 1) % 128
            self.caractere_anterior = c
            return None

        elif c == ';':
            self.bpm = random.randint(40, 208)
            self.caractere_anterior = c
            return None

        # default
        self.caractere_anterior = c
        return None


    def get_bpm(self):
        return self.bpm
