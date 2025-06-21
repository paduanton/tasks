from midiutil import MIDIFile

# Mapeamento dos instrumentos para o padrão General MIDI
INSTRUMENTOS_GM = {
    "Acoustic Grand Piano": 0,
    "Bright Acoustic Piano": 1,
    "Electric Guitar": 27,
    "Violin": 40,
    "Trumpet": 56,
    "Saxophone": 65,
    "Flute": 73,
    "Church Organ": 19,
    "Synth Lead": 80,
    "Pad": 88,
}

class ControladorAudio:
    def __init__(self):
        self.lista_notas = []
        self.volume_global = 100
        self.tempo = 0
        self.bpm = 120
        self.instrumento = 56
        self.arquivo_saida = "saida.mid"

    def set_lista_notas(self, lista):
        self.lista_notas = lista

    def configurar(self, bpm, instrumento_nome):
        self.bpm = bpm
        self.instrumento = INSTRUMENTOS_GM.get(instrumento_nome, 0)

    def iniciar_reproducao(self, nome_arquivo=None):
        if nome_arquivo is None:
            nome_arquivo = self.arquivo_saida

        if not nome_arquivo.lower().endswith('.mid'):
            nome_arquivo += '.mid'        

        midi_file = MIDIFile(1)  # 1 track
        track = 0
        canal = 0
        tempo = 0

        midi_file.addTempo(track, tempo, self.bpm)
        midi_file.addProgramChange(track, canal, tempo, self.instrumento)
        if self.lista_notas:
            instrumento = self.lista_notas[0].instrumento
            midi_file.addProgramChange(0, 0, 0, instrumento) 
        for nota in self.lista_notas:
            pitch = nota.converter_para_valor_midi()
            if not isinstance(pitch, int):
                continue            
            duracao = nota.duracao
            volume = nota.volume if hasattr(nota, 'volume') else self.volume_global
            midi_file.addNote(track, canal, pitch, tempo, duracao, volume)
            tempo += duracao

        with open(nome_arquivo, "wb") as output:
            midi_file.writeFile(output)

        print(f"Arquivo MIDI salvo como: {nome_arquivo}")
        self.arquivo_saida = nome_arquivo
        return nome_arquivo

    def limpar(self):
        self.lista_notas = []
        self.tempo = 0
