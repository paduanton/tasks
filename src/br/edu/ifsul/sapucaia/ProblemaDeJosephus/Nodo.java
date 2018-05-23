/**
 * Created by IntelliJ IDEA.
 * User: anton
 * Date: 11/11/2017
 * Time: 23:51
 */
package br.edu.ifsul.sapucaia.ProblemaDeJosephus;

public class Nodo {
    private Nodo proximo;
    private Nodo anterior;
    private int valor;

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}


