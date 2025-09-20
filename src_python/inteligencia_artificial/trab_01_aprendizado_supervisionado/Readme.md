
b inicial: 0.0
w inicial: 0.0
alpha (taxa de aprendizado): 0.01
num_iterations: 5000
MSE obtido (aprox.): 8.527708
Parâmetros finais (aprox.): b ≈ -3.450033, w ≈ 1.160625


Trabalho - Aprendizado Supervisionado
1) Identificação do grupo

2) Ambiente e bibliotecas
Python 3.x
Bibliotecas utilizadas: numpy, pandas, matplotlib, tensorflow/keras
Bibliotecas adicionais instaladas além do que foi previsto no enunciado: time

1) Exercício 1 - Regressão Linear
Valores iniciais:
b0 = 0.0
w0 = 0.0
alpha = 0.01
num_iterations = 5000
Melhor erro quadrático: 8.527708

1) Exercício 2 - Tensorflow/Keras
4.1) Estatísticas dos datasets
MNIST: 10 classes; 60000 treino / 10000 teste; tamanho 28x28x1
Fashion-MNIST: 10 classes; 60000 treino / 10000 teste; tamanho 28x28x1
CIFAR-10: 10 classes; 50000 treino / 10000 teste; tamanho 32x32x3
CIFAR-100: 100 classes; 50000 treino / 10000 teste; tamanho 32x32x3

4.2) Melhor configuração de rede usada em cada dataset (resumo)
MNIST: CNN simples com conv(32,3), conv(64,3), maxpool, dense(128), softmax(10), loss sparse_categorical_crossentropy, otimizador adam
Fashion-MNIST: CNN simples com dropout moderado; loss sparse_categorical_crossentropy; adam
CIFAR-10: CNN com blocos conv(32,3)x2, conv(64,3)x2, maxpool, dense(256), dropout, softmax(10); loss sparse_categorical_crossentropy; adam
CIFAR-100: CNN mais profunda com conv(64,3)x2, conv(128,3)x2, conv(256,3), maxpools, dense(512) com dropout, softmax(100); loss sparse_categorical_crossentropy; adam
(ajuste estes textos se a sua arquitetura final diferir)

4.3) Resultados obtidos (10 épocas)
Tempo e acurácia em teste:
MNIST: time = 793.88 s ; acc = 0.9900
Fashion-MNIST: time = 786.75 s ; acc = 0.9228
CIFAR-10: time = 3038.27 s ; acc = 0.7657
CIFAR-100: time = 10269.69 s ; acc = 0.4511

4.4) Questões solicitadas no enunciado
Q1 - Ranking de complexidade/dificuldade dos datasets (do mais simples ao mais difícil) e justificativas:
1) MNIST: imagens 28x28 em tons de cinza, alta separabilidade, baixa variância intra-classe
2) Fashion-MNIST: também 28x28 em cinza, porém classes de vestuário têm formas e texturas mais próximas entre si
3) CIFAR-10: imagens 32x32 coloridas; presença de fundo e maior variabilidade intra-classe
4) CIFAR-100: mesmas dimensões do CIFAR-10, porém 100 classes; alta confusão entre classes semelhantes e menor número de exemplos por classe
5) 
Q2 - Melhor acurácia por dataset e mudanças que mais impactaram:
MNIST: melhor acc = 0.9900 ; mudanças úteis: uso de CNN em vez de MLP; duas camadas conv e pooling
Fashion-MNIST: melhor acc = 0.9228 ; mudanças úteis: dropout moderado melhorou generalização
CIFAR-10: melhor acc = 0.7657 ; mudanças úteis: dois blocos conv empilhados e dropout na densa
CIFAR-100: melhor acc = 0.4511 ; mudanças úteis: mais profundidade e filtros; ainda limitado pelo número de classes e poucas épocas

1) Extras implementados
Além dos tópicos base do solicitado no enunciado, foi implementando alguns recursos extras, como foi  realizada a divisão do conjunto de treino em treino e validação, permitindo acompanhar a evolução do modelo em dados não vistos durante as épocas de treinamento. Também foi ajustado o hiperparâmetro batch_size para 128, de forma a equilibrar tempo de execução e desempenho. Incluímos a medição de tempo de treinamento utilizando a biblioteca time, para registrar o custo computacional em cada dataset. Por fim, em alguns modelos (como Fashion-MNIST e CIFAR-10) foi utilizado dropout para melhorar a generalização. Essas técnicas não eram obrigatórias, mas ajudaram na análise e contribuíram para a precisão dos resultados durante o estudo e testes realizados.

