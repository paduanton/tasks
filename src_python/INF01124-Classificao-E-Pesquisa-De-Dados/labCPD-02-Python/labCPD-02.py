# Bibliotecas necessárias ao script:
import numpy as np  # importa a biblioteca numpy (que trabalha com arrays numéricos)
import time         # importa a biblioteca utilizada para contar o tempo
import pandas as pd # biblioteca para trabalhar com data frames
import math
import random

################################################
# Algoritmos de ordenação
################################################

# Bubblesort
def bubble_sort(array):
    trocas = comparacoes = pos_troca = 0
    qtd_elementos = len(array)-1
    troca = True

    while troca:
        troca = False
        for i in range(0, qtd_elementos):
            comparacoes = comparacoes + 1
            if array[i] > array[i+1]:
                tmp = array[i]
                array[i] = array[i+1]
                array[i+1] = tmp
                troca = True
                pos_troca = i
                trocas = trocas + 1
        qtd_elementos = pos_troca

    return {'trocas':trocas, 'comparacoes':comparacoes}

# Quicksort e funções auxiliares
def quick_sort(array):
    log_operacoes = {'trocas':0, 'comparacoes':0}
    quicksort(array, 0, len(array)-1, log_operacoes)
    return log_operacoes

def quicksort(array, inicio, fim, log_operacoes):
    if fim > inicio:
        pivo = particiona(array, inicio, fim, log_operacoes)
        quicksort(array, inicio, pivo-1, log_operacoes)
        quicksort(array, pivo+1, fim, log_operacoes)
    return log_operacoes

def particiona(array, esquerda, direita, log_operacoes):
    pivo = esquerda
    i = pivo + 1
    j = direita

    while i<j:
        while (array[j] >= array[pivo]) and (j > esquerda): # procura menor à direita
            j = j - 1
            log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1

        while (array[i] < array[pivo]) and (i < direita): # procura maior à esquerda
            log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1
            i = i + 1

        if (i<j) and (array[i] > array[j]):
            log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1
            log_operacoes['trocas'] = log_operacoes['trocas'] + 1
            tmp = array[i]
            array[i] = array[j]
            array[j] = tmp

    if array[j] < array[pivo]:
        log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1
        log_operacoes['trocas'] = log_operacoes['trocas'] + 1
        tmp = array[j]
        array[j] = array[pivo]
        array[pivo] = tmp

    return j;

################################################
# Implementação dos seus algoritmos:

def comb_sort(array):
    log_operacoes = {'trocas':0, 'comparacoes':0}
    
    tamanho  = intervalo = len(array)
  
    loop = True
 
    while intervalo != 1 or loop == 1: 
        intervalo = int((intervalo * 10)/13)

        if intervalo < 1:
            intervalo = 1

        loop = False
 
        for indice in range(0, (tamanho-intervalo)):
            if array[indice] > array[indice + intervalo]:
                log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1

                temp = array[indice]
                array[indice] = array[indice + intervalo]
                array[indice + intervalo] = temp

                log_operacoes['trocas'] = log_operacoes['trocas'] + 2

                loop = True

    return log_operacoes

def shake_sort(array):
    log_operacoes = {'trocas':0, 'comparacoes':0}
    
    esquerda = 0 
    direita = len(array) - 1
    k = len(array);

    loop = True

    while loop:
        for j in range (direita, esquerda, -1):
            if (array[j] < array[j-1]):
                log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1

                temp = array[j]
                array[j] = array[j-1]
                array[j-1] = temp

                log_operacoes['trocas'] = log_operacoes['trocas'] + 2

                k = j
        
        esquerda = k
        
        for j in range (esquerda, direita):
            if (array[j] > array[j+1]):
                log_operacoes['comparacoes'] = log_operacoes['comparacoes'] + 1

                temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp

                log_operacoes['trocas'] = log_operacoes['trocas'] + 2
                k = j
        direita = k;
        
        if (esquerda >= direita):
            loop = False
    return log_operacoes

def quicksort2(array, inicio, fim, log_operacoes):
    if fim > inicio:

        random.shuffle(array)

        pivo = particiona(array, inicio, fim, log_operacoes)
        quicksort(array, inicio, pivo-1, log_operacoes)
        quicksort(array, pivo+1, fim, log_operacoes)
    return log_operacoes


################################################
# Programa Principal
################################################

# Avalia o desempenho de algoritmos para diferentes tipos de arrays com diferentes tamanhos

# Variáveis globais necessárias:
gerador = np.random.RandomState()  # cria um gerador de números aleatórios (descomente se for usar array aleatório)
medicoes = []                      # lista que armazena os resultados das medições em memória

# lista de algoritmos a testar (insira o seu, caso elabore outros):
algoritmos = {
    'BSRT': { 'nome': 'Bubble sort', 'funcao': bubble_sort },
    'QSTR': { 'nome': 'Quick sort tradicional', 'funcao': quick_sort},
    'CBST': { 'nome': 'Comb sort ', 'funcao': comb_sort},
    'SKST': { 'nome': 'Shake sort', 'funcao': shake_sort},
}

# testa o desempenho dos algoritmos para diferentes tipos e quantidades (múltiplos de 10):
for qtd in [10**x for x in range(2, 3)]:
  arrays = {
      "decrescente":        { 'tipo': 'D', 'conteudo': list(range(qtd, 0, -1))},         # array decrescente (pior caso)
      "random (aleatório)": { 'tipo': 'R', 'conteudo': gerador.randint(0, qtd+1, qtd)},  # gera array aleatório com 'qtd' números entre 0 e 'qtd'
      "crescente":          { 'tipo': 'C', 'conteudo': list(range(0,qtd))}               # crescente (já ordenado)
  }

  for array_info in arrays:                                      # itera sobre cada um dos tipos de array
      array = arrays[array_info]['conteudo']
      print('---------------------------------------------------')
      print(f'Criando array {array_info} de tamanho {qtd}:')
      print(f'{array}\n')

      for algoritmo in algoritmos:                       # itera sobre cada um dos algoritmos enunciados anteriormente
          print('=> Avaliando ordenação por "', algoritmos[algoritmo]['nome'], '" no array...')

          array_tmp = array.copy()                       # faz cópia do array para não perder

          tempo = time.process_time()                     # armazena o tempo de início do processamento
          m = algoritmos[algoritmo]['funcao'](array_tmp ) # aplica algorimo e retorna quantidade de trocas e comparações em 'm'
          t = time.process_time() - tempo                 # verifica o tempo de fim de processamento e calcula a diferença
          print('\nArray ordenado:\n', array_tmp, '\n')

          # armazena informações sobre a execução do algoritmo em um dicionário:
          medicao = {}
          medicao['algoritmo']=algoritmo
          medicao['tipo']=arrays[array_info]['tipo']
          medicao['quantidade']=qtd
          medicao['trocas']=m['trocas']
          medicao['comparacoes']=m['comparacoes']
          medicao['tempo']=t

          medicoes.append(medicao)                              # adiciona medição em uma lista de medições

print('Fim do processamento!')