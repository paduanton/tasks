import random
def quick_sort(array):
    log_operacoes = {'trocas':0, 'comparacoes':0}
    quicksort(array, 0, len(array)-1, log_operacoes)
    return log_operacoes


def quicksort(array, inicio, fim, log_operacoes):
    if fim > inicio:

        random.shuffle(array) #torna array

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

array_tmp = list(range(10000, 0, -1))

quick_sort(array_tmp)

print('\nArray ordenado:\n', array_tmp, '\n')

print('Fim do processamento!')
