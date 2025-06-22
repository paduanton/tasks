from midiutil import MIDIFile
from pydub import AudioSegment

import os
import tempfile
import subprocess
from pydub import AudioSegment

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
        self.caminho_base_arquivos = "C:/Users/AntonioPádua/personal/tasks"
        self.lista_notas = []
        self.volume_global = 100
        self.tempo = 0
        self.bpm = 120
        self.instrumento = 56
        self.arquivo_saida = "saida.mp3"

    def set_lista_notas(self, lista):
        self.lista_notas = lista

    def configurar(self, bpm, instrumento_nome):
        self.bpm = bpm
        self.instrumento = INSTRUMENTOS_GM.get(instrumento_nome, 0)

    def iniciar_reproducao(self, nome_arquivo=None):
        if nome_arquivo is None:
            nome_arquivo = "saida"

        if nome_arquivo.lower().endswith('.mid'):
            nome_base = nome_arquivo[:-4]
        elif nome_arquivo.lower().endswith('.mp3'):
            nome_base = nome_arquivo[:-4]
        else:
            nome_base = nome_arquivo

    
        mid_path = f"{self.caminho_base_arquivos}/{nome_base}.mid"
        wav_path = f"{self.caminho_base_arquivos}/{nome_base}.wav"
        mp3_path = f"{self.caminho_base_arquivos}/{nome_base}.mp3"
        
        # mid_path = f"{nome_base}.mid"
        # wav_path = f"{nome_base}.wav"
        # mp3_path = f"{nome_base}.mp3"

        # Criar MIDI
        midi_file = MIDIFile(1)
        track = 0
        canal = 0
        tempo_batidas = 0.0
        bpm_atual = None

        bpm_inicial = self.lista_notas[0].bpm if self.lista_notas else self.bpm
        midi_file.addTempo(track, tempo_batidas, bpm_inicial)

        instrumento_inicial = self.lista_notas[0].instrumento if self.lista_notas else self.instrumento
        midi_file.addProgramChange(track, canal, tempo_batidas, instrumento_inicial)

        for nota in self.lista_notas:
            pitch = nota.converter_para_valor_midi()
            if not isinstance(pitch, int):
                continue

            duracao_beat = nota.duracao
            volume = getattr(nota, 'volume', self.volume_global)
            instrumento = getattr(nota, 'instrumento', self.instrumento)
            bpm_nota = getattr(nota, 'bpm', self.bpm)

            if bpm_nota != bpm_atual:
                midi_file.addTempo(track, tempo_batidas, bpm_nota)
                bpm_atual = bpm_nota

            # Continue inserindo as notas...
            midi_file.addNote(track, canal, pitch, tempo_batidas, duracao_beat, volume)
            tempo_batidas += duracao_beat

        with open(mid_path, "wb") as output:
            midi_file.writeFile(output)

        self.arquivo_saida = mid_path

        # Converter MIDI para WAV usando FluidSynth
        self.converter_midi_para_wav(mid_path, wav_path)
        # Converter WAV para MP3 usando pydub/ffmpeg
        self.converter_wav_para_mp3(wav_path, mp3_path)

        self.arquivo_saida = mp3_path
        return mp3_path

    def limpar(self):
        self.lista_notas = []
        self.tempo = 0

    def converter_midi_para_wav(self, mid_path, wav_path):
        soundfont_path = r"C:\SoundFonts\FluidR3_GM.sf2"

        subprocess.run([
            r"C:\SoundFonts\fluidsynth\fluidsynth-2.4.6-win10-x64\bin\fluidsynth.exe",
            "-ni",
            "-F", wav_path,
            "-r", "44100",
            soundfont_path,
            mid_path
        ], check=True)


    def converter_wav_para_mp3(self, wav_path, mp3_path):
        AudioSegment.converter = r"C:\SoundFonts\ffmpeg\ffmpeg-master-latest-win64-gpl-shared\ffmpeg-master-latest-win64-gpl-shared\bin\ffmpeg.exe"

        audio = AudioSegment.from_wav(wav_path)
        audio.export(mp3_path, format="mp3")
