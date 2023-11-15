def shellSort(array):
    quantidade_itens = len(array)

    meio = quantidade_itens // 2

    while meio > 0:
        for i in range(meio, quantidade_itens):
            valor = array[i]
            
            j = i

            while j >= meio and array[j - meio] > valor:
                intervalo = j - meio

                array[j] = array[intervalo]
                j = intervalo
            array[j] = valor

        meio = meio // 2


#driver code
array = [9, 1, 8, 2, 7, 3, 6, 4, 5]
print("The original array is:", array)
size = len(array)
shellSort(array)
print('Sorted Array is:', array)