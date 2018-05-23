package br.edu.ifsul.sapucaia.Arvore;

public abstract class EstruturaArvore {
    private No raiz;

    public abstract boolean remove(int valor);

    public abstract No pesquisa(int valor);

    public abstract int alturaNO(No noArvore);

    public abstract No sucessor(No noArvore);

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

}
