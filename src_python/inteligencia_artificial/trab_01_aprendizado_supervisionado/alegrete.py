import numpy as np

def compute_mse(b, w, data):
    """
    Calcula o erro quadratico medio
    :param b: float - bias (intercepto da reta)
    :param w: float - peso (inclinacao da reta)
    :param data: np.array - matriz com o conjunto de dados, x na coluna 0 e y na coluna 1
    :return: float - o erro quadratico medio
    """
    x = data[:, 0]
    y = data[:, 1]
    y_pred = b + w * x
    return np.mean((y_pred - y) ** 2)


def step_gradient(b, w, data, alpha):
    """
    Executa uma atualização por descida do gradiente e retorna os valores atualizados de b e w.
    """
    x = data[:, 0]
    y = data[:, 1]
    n = len(x)

    residual = (b + w * x) - y
    db = (2.0 / n) * np.sum(residual)
    dw = (2.0 / n) * np.sum(residual * x)

    b_new = b - alpha * db
    w_new = w - alpha * dw
    return b_new, w_new


def fit(data, b, w, alpha, num_iterations):
    """
    Para cada época/iteração, executa uma atualização por descida de gradiente
    e registra os valores atualizados de b e w.
    Ao final, retorna duas listas: uma com os b e outra com os w
    obtidos ao longo da execução (o último valor de cada lista corresponde à última época).
    """
    bs, ws = [b], [w]
    for _ in range(num_iterations):
        b, w = step_gradient(b, w, data, alpha)
        bs.append(b)
        ws.append(w)
    return bs, ws
