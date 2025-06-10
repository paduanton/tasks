from midiutil import MIDIFile

class NotaMusical:
    def __init__(self, nome, duracao, oitava, volume, instrumento):
        self.nome = nome
        self.duracao = duracao
        self.oitava = oitava
        self.volume = volume
        self.instrumento = instrumento

    def tocar(self, midi_file, canal, tempo):
        if self.nome == ' ':
            return
        nota_midi = self.converter_para_valor_midi()
        midi_file.addProgramChange(canal, canal, tempo, self.instrumento)
        midi_file.addNote(canal, canal, nota_midi, tempo, self.duracao, self.volume)

    def converter_para_valor_midi(self):
        mapa_notas = {
            'C': 60,  # Dó
            'D': 62,  # Ré
            'E': 64,  # Mi
            'F': 65,  # Fá
            'G': 67,  # Sol
            'A': 69,  # Lá
            'B': 71   # Si
        }

        if isinstance(self.nome, int):
            return self.nome
        
        if self.nome == ' ':
            return None
            
        nota = str(self.nome).upper()[0] if self.nome else 'C'
        return mapa_notas.get(nota, 60) + (12 * (self.oitava - 4))
