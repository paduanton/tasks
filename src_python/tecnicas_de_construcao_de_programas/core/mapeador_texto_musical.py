import random
from .nota_musical import NotaMusical

class MapeadorTextoMusical:
    def __init__(self, texto, oitava=4, instrumento=56):
        self.texto_original = texto
        self.instrumento_atual = instrumento
        self.oitava_atual = oitava
        self.volume_default = 100
        self.volume_atual = self.volume_default
        self.bpm = 120
        self.caractere_anterior = None
        self.nota_anterior = None
        self.oitava = oitava
        self.instrumento = instrumento

    def mapear_caractere(self, c):
        if c == ' ':        
            return NotaMusical(' ', 1, self.oitava_atual, self.volume_atual, self.instrumento_atual)
        
        elif c.lower() in 'abcdefg':
            nota = NotaMusical(c, 1, self.oitava_atual, self.volume_atual, self.instrumento_atual)
            self.nota_anterior = nota
            self.caractere_anterior = c
            return nota
        
        elif c == '+':
            self.volume_atual = min(self.volume_atual * 2, 127)
            return None
        elif c == '-':
            self.volume_atual = self.volume_default
            return None
        
        elif c.lower() in 'oiu':
            if self.caractere_anterior and self.caractere_anterior.lower() in 'abcdefg':
                return self.nota_anterior
            else:
                return NotaMusical(125, 1, self.oitava_atual, self.volume_atual, self.instrumento_atual)
        
        elif c.upper() == 'R':
            return None 
        elif self.caractere_anterior == 'R' and c == '+':
            self.oitava_atual = min(self.oitava_atual + 1, 8)
            return None
        elif self.caractere_anterior == 'R' and c == '-':
            self.oitava_atual = max(self.oitava_atual - 1, 1)
            return None
        
        elif c == '?':
            nota_aleatoria = random.choice(['A', 'B', 'C', 'D', 'E', 'F', 'G'])
            return NotaMusical(nota_aleatoria, 1, self.oitava_atual, self.volume_atual, self.instrumento_atual)
        
        elif c == '\n':
            self.instrumento_atual = (self.instrumento_atual + 1) % 128
            return None
                
        elif c.upper() == 'B' or c.upper() == 'P' or c.upper() == 'M':
            return None 
        elif ''.join([str(self.caractere_anterior), c]).upper() == 'BP':
            return None 
        elif ''.join([str(self.caractere_anterior), c]).upper() == 'PM':
            return None
        elif ''.join([str(self.caractere_anterior), c]).upper() == 'M+':
            self.bpm += 80
            return None
        elif c == ';':
            self.bpm = random.randint(40, 208) 
            return None
        
        self.caractere_anterior = c
        return None

    def get_bpm(self):
        return self.bpm