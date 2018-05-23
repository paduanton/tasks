/**
 * Created by IntelliJ IDEA.
 * User: anton
 * Date: 11/11/2017
 * Time: 23:52
 */
package br.edu.ifsul.sapucaia.ProblemaDeJosephus;

public class Lista {
	Nodo auxiliar = null;
	Nodo primeiro = null;
	Nodo nodo = null;

	public void criaLista(int n) {
		for (int i = 1; i <= n; i++) {

			if (nodo != null) {
				auxiliar = nodo;

			}
			nodo = new Nodo();

			nodo.setValor(i);

			if (i >= n) {
				nodo.setProximo(primeiro);
				primeiro.setAnterior(nodo);
			}
			if (i > 1) {
				auxiliar.setProximo(nodo);
				nodo.setAnterior(auxiliar);

			}

			if (i == 1) {
				primeiro = nodo;
			}

		}
	}

	public void imprimirLista(int n) {

		for (int i = 1; i <= n; i++) {
			nodo = nodo.getProximo();

			System.out.print(nodo.getValor() + "| ");

		}
		System.out.println();
	}

	public void remover(int m) {

		while (nodo.getAnterior() != nodo) {
			for (int i = 1; i <= m; i++) {
				nodo = nodo.getProximo();

			}

			auxiliar = nodo;
			while (nodo.getProximo() != auxiliar || auxiliar.getAnterior() != nodo) {
				nodo = nodo.getProximo();
				System.out.print(nodo.getValor() + " |");

			}
			System.out.println();
			nodo = auxiliar;

			nodo.getProximo().setAnterior(nodo.getAnterior());
			nodo.getAnterior().setProximo(nodo.getProximo());

		}
		nodo.setAnterior(null);
		nodo.setProximo(null);

	}

	public int ultimo() {
		return nodo.getValor();
	}
}
