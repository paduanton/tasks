class NotaMusical:
    def __init__(self, nome, duracao, oitava, volume=100, instrumento=0):
        self.nome = nome
        self.duracao = duracao
        self.oitava = oitava
        self.volume = volume
        self.instrumento = instrumento

    def tocar(self, midi_file, canal, tempo):
        if self.nome == ' ':
            return  # pausa

        nota_midi = self.converter_para_valor_midi()
        if nota_midi is None:
            return

        midi_file.addNote(
            track=0,
            channel=canal,
            pitch=nota_midi,
            time=tempo,
            duration=self.duracao,
            volume=self.volume
        )

    def converter_para_valor_midi(self):
        mapa_notas = {
            'C': 0,
            'D': 2,
            'E': 4,
            'F': 5,
            'G': 7,
            'A': 9,
            'B': 11
        }

        if isinstance(self.nome, int):
            return self.nome  # se for valor MIDI direto
        
        if not self.nome or self.nome == ' ':
            return None

        nota = str(self.nome).upper()[0]
        base = mapa_notas.get(nota, 0)
        if base is None:
            return None  # caractere inválido
    
        return base + (12 * self.oitava)
