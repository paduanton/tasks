
package br.edu.ifsul.sapucaia.ListaCircular;
/**
 *
 * @author anton
 */

public class ListaCircular {
	Nodo nododelete = null;
	Nodo nodo = null;
	Nodo aux = null;
	Nodo primeiro = null;
	Nodo ultimo = null;

	public void CriarLista(int n) {
		for (int i = 1; i <= n; i++) {

			if (nodo != null) {
				aux = nodo;

			}
			nodo = new Nodo();

			nodo.setValor(i);

			if (i >= n) {
				nodo.setProx(primeiro);
				primeiro.setAnt(nodo);
			}
			if (i > 1) {
				aux.setProx(nodo);
				nodo.setAnt(aux);

			}

			if (i == 1) {
				primeiro = nodo;
			}

		}
		primeiro = null;
	}

	public void ImprimirListaCompleta(int n) {

		for (int i = 1; i <= n; i++) {
			nodo = nodo.getProx();

			System.out.print(nodo.getValor() + "| ");

		}
		System.out.println();
	}

	public void Remocao(int m, int l) {
		if (m == 0) {
			nodo = nodo.getProx();
		}
		while (nodo.getAnt() != nodo || nodo.getProx() != nodo) {
			if (m != 0 && nodo.getAnt() != nodo) {
				for (int i = 1; i <= m; i++) {
					nodo = nodo.getProx();

				}

				aux = nodo;
				while (nodo.getProx() != aux || aux.getAnt() != nodo) {
					nodo = nodo.getProx();
					System.out.print(nodo.getValor() + " |");

				}
				System.out.println();
				nodo = aux;

				CriarListaDelete(true, aux);
				nodo.getProx().setAnt(nodo.getAnt());
				nodo.getAnt().setProx(nodo.getProx());

			}

			if (l != 0 && nodo.getAnt() != nodo) {

				for (int i = 1; i <= l; i++) {
					nodo = nodo.getAnt();

				}

				aux = nodo;
				while (nodo.getProx() != aux || aux.getAnt() != nodo) {
					nodo = nodo.getProx();
					System.out.print(nodo.getValor() + " |");

				}
				System.out.println();
				nodo = aux;
				CriarListaDelete(false, aux);
				nodo.getProx().setAnt(nodo.getAnt());
				nodo.getAnt().setProx(nodo.getProx());

			}

		}
		nodo.setAnt(null);
		nodo.setProx(null);

	}

	public void CriarListaDelete(boolean direcao, Nodo nodinho) {

		if (nodinho.getProx() == nodinho) {
			System.out.println(nodinho.getAnt().getValor());
		}
		if (direcao == true && ultimo == null) {
			nododelete = new Nodo();
			nododelete.setValor(nodinho.getValor());
			if (direcao == true) {
				ultimo = nododelete;

			}

		} else {
			if (direcao == false && primeiro == null) {
				primeiro = nododelete;
				if (primeiro != null && ultimo != null) {
					primeiro.setProx(ultimo);
					ultimo.setAnt(primeiro);
				}
			}
			if (direcao == true) {

				nododelete = new Nodo();
				nododelete.setValor(nodinho.getValor());
				ultimo.setProx(nododelete);
				nododelete.setAnt(ultimo);
				ultimo = nododelete;
			} else {
				nododelete = new Nodo();
				nododelete.setValor(nodinho.getValor());
				primeiro.setAnt(nododelete);
				nododelete.setProx(primeiro);

				primeiro = nododelete;

			}

		}

	}

	public int Final() {

		return nodo.getValor();
	}

	public void ImprimirListaDelete() {

		System.out.println("Lista Excluidos: ");
		if (ultimo != null) {
			nododelete = ultimo;
			while (nododelete.getAnt() != null) {
				nododelete = nododelete.getAnt();
			}
			while (nododelete.getProx() != null) {
				nododelete = nododelete.getProx();
				System.out.print(nododelete.getValor() + ";");

			}
		}

	}
}