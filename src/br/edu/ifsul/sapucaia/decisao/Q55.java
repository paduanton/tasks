package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q55 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		double prova, trabalho, nota;
		
		System.out.println("INSIRA A NOTA DA PROVA");
		prova = teclado.nextDouble();
		System.out.println("INSIRA NOTA DO TRABALHO");
		trabalho = teclado.nextDouble();
		
		nota = (0.75 * prova) + (0.25 * trabalho);
		if (nota < 7) {
			System.out.println("Precisa de exame");
			
		} else {
	      System.out.println("Passou com " + nota + " de nota");
			
		}
	}
}