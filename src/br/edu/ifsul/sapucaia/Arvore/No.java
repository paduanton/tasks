package br.edu.ifsul.sapucaia.Arvore;

public class No {

    private int valor;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;

    public No(int valor) {
        this.valor = valor;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
        this.pai = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getfilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setfilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getfilhoDireito() {
        return filhoDireito;
    }

    public void setfilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    boolean ehFolha() {
        return this.getfilhoEsquerdo() == null && this.getfilhoDireito() == null;
    }

    @Override
    public String toString() {
        return "" + this.getValor();
    }

    public boolean ehMenorQue(No noComparado) {
        return this.getValor() < noComparado.getValor();
    }

    public boolean ehMaiorOuIgualQue(int valor) {
        return this.getValor() >= valor;
    }

    public boolean ehIgualA(int valor) {
        return this.getValor() == valor;
    }

    public boolean ehIgualA(No noComparado) {
        return this.getValor() == noComparado.getValor();
    }

}
