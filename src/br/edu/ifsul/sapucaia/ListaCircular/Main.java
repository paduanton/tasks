package br.edu.ifsul.sapucaia.ListaCircular;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author anton
 *
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n, m, p, l;
		Scanner teclado;
		ListaCircular listacircular = null;
		teclado = new Scanner(System.in);

		System.out.println("Digite quantas pessoas tem no círculo e a ordem para remove las no sentido horario e anti horario");

		n = teclado.nextInt();
		m = teclado.nextInt();
		l = teclado.nextInt();
		if (n <= 1) {
			System.out.println("Não é possível pois deve restar 1.");
		} else {
			listacircular = new ListaCircular();
			listacircular.CriarLista(n);

			listacircular.ImprimirListaCompleta(n);

			listacircular.Remocao(m,l);

			p = listacircular.Final();
			System.out.println(p + " é a posição em que Josephus deve estar.");
			listacircular.ImprimirListaDelete();
		}
		teclado.close();
	}

}