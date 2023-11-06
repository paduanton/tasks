import numpy as np
import time
import pandas as pd
import math

################################################
# Variáveis globais necessárias:
################################################
gerador = np.random.RandomState()  # cria um gerador de números aleatórios (descomente se for usar array aleatório)
medicoes = []                      # lista que armazena os resultados das medições em memória

################################################
# Algoritmos de ordenação
################################################

# Função de Inserção Direta com Busca Linear
def insertion_sort(array):
    trocas = comparacoes = 0
    for i in range(1, len(array)):             # do segundo ao último (o primeiro faz parte do subarray ordenado)
        chave = array[i]                       # chave a inserir no subarray ordenado
        j = i-1                                # último elemento do subarray ordenado
        while (j >= 0) and (array[j] > chave): # busca linear da direita para a esquerda no subarray ordenado
            comparacoes = comparacoes + 1
            array[j+1] = array[j]
            j = j -1
            trocas = trocas + 1
        array[j+1] = chave
        trocas = trocas + 1
    return {'trocas':trocas, 'comparacoes':comparacoes}                         # retorna quantidade de operações

# >>>>> Insira aqui a implementação dos seus algoritmos <<<<<<<<<<<<<<<<<<<<<<<<<<<<

def insertion_sortBB(array):
    trocas = comparacoes = 0

    for i in range(1, len(array)):
        valor_atual_item = array[i]
        
        busca_binaria = binary_search(array, valor_atual_item, 0, i, 0)
        comparacoes = comparacoes + busca_binaria['comparacoes']

        posicao_busca = busca_binaria['resultado_busca'] + 1

        for j in range(i, posicao_busca, -1):
            array[j] = array[j - 1]
            trocas = trocas + 1

        array[posicao_busca] = valor_atual_item
        trocas = trocas + 1

    return {'trocas': trocas, 'comparacoes': comparacoes}

def binary_search(array, index, inicio, fim, comparacoes):
    if fim - inicio <= 1:
        if index < array[inicio]:
            comparacoes = comparacoes + 1
            return {
                'resultado_busca': inicio - 1,
                'comparacoes': comparacoes
            } 
        else:
            return {
                'resultado_busca': inicio,
                'comparacoes': comparacoes
            } 
    
    if inicio > fim:
        return {
        'resultado_busca': inicio,
        'comparacoes': comparacoes
    }

    meio = (inicio + fim) // 2 # operador // é necessário para garantir que estamos retornando um numero inteiro à variavel 'meio'  

    comparacoes = comparacoes + 1

    if array[meio] < index:
        return binary_search(array, index, meio, fim, comparacoes)
    elif array[meio] > index:
        return binary_search(array, index, inicio, meio, comparacoes)
    else:
        return {
            'resultado_busca': meio,
            'comparacoes': comparacoes
        }

def shellsort(array):
    trocas = comparacoes = 0

    # defina aqui sua versão da função shellsort

    return {'trocas':trocas, 'comparacoes':comparacoes}                         # retorna quantidade de operações

################################################
# Programa principal
################################################

# lista de algoritmos a testar (insira o seu, caso elabore outros):
algoritmos = {
    'ISBL': { 'nome': 'Inserção Direta com Busca Linear', 'funcao': insertion_sort },
    'ISBB': { 'nome': 'Inserção Direta com Busca Binária', 'funcao': insertion_sortBB },
    'ISSH': { 'nome': 'Inserção por ShellSort', 'funcao': shellsort },
    # insira o seu aqui usando a sintaxe acima, se necessário
}

# testa o desempenho dos algoritmos para diferentes quantidades (múltiplos de 10):
for qtd in [10**x for x in range(2, 5)]:
    max = qtd
    arrays = {
        "decrescente":        { 'tipo': 'D', 'conteudo': list(range(qtd, 0, -1))},         # array decrescente (pior caso)
        "random (aleatório)": { 'tipo': 'R', 'conteudo': gerador.randint(0, max+1, qtd)},  # gera array aleatório com 'qtd' números entre 0 e 'max'
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

# Cria dataframe pandas (i.e., uma tabela) que organiza os dados relacionados com a execução dos algorimos acima
df = pd.DataFrame(medicoes)
cols = ['algoritmo', 'tipo', 'quantidade', 'trocas', 'comparacoes', 'tempo']  # ordem correta das colunas
df = df[cols]

print(df) # imprime os dados de execução dos algoritmos