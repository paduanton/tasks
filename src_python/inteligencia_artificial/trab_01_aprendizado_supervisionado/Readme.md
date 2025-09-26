
b inicial: 0.0
w inicial: 0.0
alpha (taxa de aprendizado): 0.01
num_iterations: 5000
MSE obtido (aprox.): 8.527708
Parâmetros finais (aprox.): b ≈ -3.450033, w ≈ 1.160625


Trabalho - Aprendizado Supervisionado


2) Ambiente e bibliotecas
Python 3.x
Bibliotecas utilizadas: numpy, pandas, matplotlib, tensorflow/keras
Bibliotecas adicionais instaladas além do que foi previsto no enunciado: time

3) Exercício 1 - Regressão Linear
Valores iniciais:
b0 = 0.0
w0 = 0.0
alpha = 0.01
num_iterations = 5000
Melhor erro quadrático: 8.527708

4) Exercício 2 - Tensorflow/Keras
4.1) Estatísticas dos datasets
MNIST: 10 classes; 60000 treino / 10000 teste; tamanho 28x28x1
Fashion-MNIST: 10 classes; 60000 treino / 10000 teste; tamanho 28x28x1
CIFAR-10: 10 classes; 50000 treino / 10000 teste; tamanho 32x32x3
CIFAR-100: 100 classes; 50000 treino / 10000 teste; tamanho 32x32x3

4.2) Melhor configuração de rede usada em cada dataset 
*Todos os modelos foram treinados usando o otimizador Adam, por 20 epochs, com learning rate 0.001 e loss function categorical_crossentropy
MNIST: (1) Conv(32, (3x3)) -> MaxPool(2,2) -> conv(64, (3x3)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dense(10) -> 98.75% test acc
       (2) Conv(32, (5x5)) -> MaxPool(2,2) -> conv(64, (5x5)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dense(10) -> 98.57% test acc
       (3) Conv(32, (3x3)) -> MaxPool(2,2) -> conv(64, (3x3)) -> MaxPool(2,2) -> Flatten -> Dense(256) -> Dense(10) -> 98.79% test acc
       (4) Conv(16, (3x3)) -> MaxPool(2,2) -> conv(32, (3x3)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dense(10) -> 98.58% test acc
       (5) Conv(32, (3x3)) -> MaxPool(2,2) -> conv(64, (3x3)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dropout(0.2) -> Dense(10) -> 98.86%

        Melhor resultado: (5), mas todos modelos tiveram performances semelhantes, o que provavelmente se deve ao fato do modelo sugerido já ser muito mais complexo que o necessário para a tarefa simples do mnist, o que é corroborado pelo fato do Dropout diminuir o overfitting. Aumentar o tamanho do kernels piorou a acurácio, o que pode ser devido ao fato das imagens não serem muito grandes e assim o tamanho do kernel 3x3 já é o suficiente. Aumentar o número de neurônios na última camada escondida aumentou a acurácia apenas marginalmente. De maneira interessante, cortar pela metade os filtros das camadas convolucionais diminuiu apenas um pouco da acurácia, favorecendo ainda mais a ideia dos modelos serem muito complexos.


Fashion-MNIST: CNN simples com dropout moderado; loss sparse_categorical_crossentropy; adam
        (1) Conv(32, (3x3)) -> MaxPool(2,2) -> conv(64, (3x3)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dropout(0.2) -> Dense(10) -> 89.09% test acc
        (2) Conv(32, (3x3)) -> MaxPool(2,2) -> conv(64, (3x3)) -> MaxPool(4,4) -> Flatten -> Dense(128) -> Dropout(0.2) -> Dense(10)-> 77.97% test acc
        (3) Conv(64, (3x3)) -> MaxPool(2,2) -> conv(128, (3x3)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dropout(0.2) -> Dense(10) -> 89.94% test acc
        (4) Conv(64, (7x7)) -> MaxPool(2,2) -> conv(128, (7x7)) -> MaxPool(2,2) -> Flatten -> Dense(128) -> Dropout(0.2) -> Dense(10) -> 90.05% test acc
        (5) Conv(64, (7x7)) -> MaxPool(2,2) -> conv(128, (7x7)) -> MaxPool(2,2) -> Flatten -> Dense(256) -> Dropout(0.2) -> Dense(10) -> 89.85% test acc

        Melhor Resultado: (4) Para esse dataset, aumentar o tamanho do kernel para 7x7 aumentou a acurácia, junto com o aumento do número de filtros. Dessa vez, aumentar o pooling causou uma queda na performance.

CIFAR-10: 
        (1) Conv(32, (3x3))x2 -> MaxPool(2x2) -> Conv(64, (3x3))x2 -> MaxPool(2x2) -> Flatten -> Dense (256) -> Dropout(0.4) -> Dense(10) -> 75.85% test acc
        (2) Conv(32, (3x3))x2 -> MaxPool(4x4) -> Conv(64, (3x3))x2 -> MaxPool(4x4) -> Flatten -> Dense (256) -> Dropout(0.4) -> Dense(10) -> 76.41% test acc
        (3) Conv(32, (3x3))x2 -> MaxPool(4x4) -> Conv(64, (3x3))x2 -> MaxPool(4x4) -> Flatten -> Dense (128) -> Dropout(0.4) -> Dense(10) -> 73.88% test acc
        (4) Conv(32, (3x3))x2 -> MaxPool(4x4) -> Dropout(0.4 ->) Conv(64, (3x3))x2 -> MaxPool(4x4) -> Flatten -> Dense (256) -> Dropout(0.4) -> Dense(10) -> 76.73% test acc
        (5) Conv(32, (3x3))x2 -> MaxPool(4x4) -> Dropout(0.4 ->) Conv(128, (3x3))x2 -> MaxPool(4x4) -> Flatten -> Dense (256) -> Dropout(0.4) -> Dense(10) -> 77.31% test acc

        Melhor resultado: (5) Aparentemente um grande problema da rede era overfitting. A inserção do segundo dropout após a primeira leva de convoluções junto com o aumento do pooling ajudou com isso, e então aumentando o número de filtros na segunda leva de convoluções resultou no melhor resultado possível. É interessante notar que antes de adicionar o segundo dropout, aumentar os parametros da rede, como o número de neurônios na camada densa em (3) piorou o resultado, provavelmente devido ao overfitting já presente.



CIFAR-100: 
        (1) Conv(64, (3x3))x2 -> MaxPool(2x2) -> Conv(128, (3x3))x2 -> MaxPool(2x2) -> Conv(256, (3x3)) -> MaxPool(2x2) -> Flatten -> Dense(512) -> Dropout(0.5) -> Dense(10) -> 38.37% test acc
        (2) Conv(64, (3x3))x2 -> MaxPool(4x4) -> Conv(128, (3x3))x2 -> MaxPool(4x4) -> Conv(256, (3x3)) -> MaxPool(2x2) -> Flatten -> Dense(512) -> Dropout(0.5) -> Dense(10) -> 38.81% test acc
        (3) Conv(64, (3x3))x2 -> MaxPool(4x4) -> Dropout(0.4) -> Conv(128, (3x3))x2 -> MaxPool(4x4) -> Conv(256, (3x3)) -> MaxPool(2x2) -> Flatten -> Dense(512) -> Dropout(0.5) -> Dense(10) -> 36.96% test acc
        (4) Conv(64, (3x3))x2 -> MaxPool(4x4) -> Conv(128, (3x3))x2 -> MaxPool(4x4) -> Conv(256, (3x3)) -> MaxPool(2x2) -> Flatten -> Dense(256) -> Dense(512) -> Dropout(0.5) -> Dense(10) -> 36.38% test acc
        (5) Conv(64, (5x5))x2 -> MaxPool(4x4) -> Conv(128, (5x5))x2 -> MaxPool(4x4) -> Conv(256, (5x5)) -> MaxPool(2x2) -> Flatten -> Dense(256) -> Dense(512) -> Dropout(0.5) -> Dense(10) -> 29.92% test acc

        Melhor resultado: (2) Aumentar a janela de pooling melhorou um pouco a performance do modelo, mas fora isso, as alterações resultaram em pioras. O aumento do kernel, principalmente, resultou em um aumento na performance do treino, mas uma grande piora no teste, indicando um forte overfitting. 

4.3) Resultados obtidos (tempo + acurácia)
Tempo e acurácia em teste:
MNIST: time = 793.88 s ; acc = 0.9886
Fashion-MNIST: time = 786.75 s ; acc = 0.9005
CIFAR-10: time = 3038.27 s ; acc = 0.7657
CIFAR-100: time = 10269.69 s ; acc = 0.4511

4.4) Questões solicitadas no enunciado
Q1 - Ranking de complexidade/dificuldade dos datasets (do mais simples ao mais difícil) e justificativas:
1) MNIST: imagens 28x28 em tons de cinza, alta separabilidade, baixa variância intra-classe
2) Fashion-MNIST: também 28x28 em cinza, porém classes de vestuário têm formas e texturas mais próximas entre si
3) CIFAR-10: imagens 32x32 coloridas; presença de fundo e maior variabilidade intra-classe
4) CIFAR-100: mesmas dimensões do CIFAR-10, porém 100 classes; alta confusão entre classes semelhantes e menor número de exemplos por classe

Q2 - Melhor acurácia por dataset e mudanças que mais impactaram:
MNIST: melhor acc = 0.9900 ; mudanças úteis: uso de CNN em vez de MLP; duas camadas conv e pooling
Fashion-MNIST: melhor acc = 0.9228 ; mudanças úteis: dropout moderado melhorou generalização
CIFAR-10: melhor acc = 0.7657 ; mudanças úteis: dois blocos conv empilhados e dropout na densa
CIFAR-100: melhor acc = 0.4511 ; mudanças úteis: mais profundidade e filtros; ainda limitado pelo número de classes e poucas épocas

1) Extras implementados
Além dos tópicos base do solicitado no enunciado, foi implementando alguns recursos extras, como foi  realizada a divisão do conjunto de treino em treino e validação, permitindo acompanhar a evolução do modelo em dados não vistos durante as épocas de treinamento. Também foi ajustado o hiperparâmetro batch_size para 128, de forma a equilibrar tempo de execução e desempenho. Incluímos a medição de tempo de treinamento utilizando a biblioteca time, para registrar o custo computacional em cada dataset. Por fim, em alguns modelos (como Fashion-MNIST e CIFAR-10) foi utilizado dropout para melhorar a generalização. Essas técnicas não eram obrigatórias, mas ajudaram na análise e contribuíram para a precisão dos resultados durante o estudo e testes realizados.

