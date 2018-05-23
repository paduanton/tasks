package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q7 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int x, x2, soma, produto;
		System.out.println("DIGITE UM N�MERO INTEIRO");
		x = teclado.nextInt();
		System.out.println("DIGITE O SEGUNDO N�MERO INTEIRO");
		x2 = teclado.nextInt();
		
		soma = x + x2; produto = x * x2;
		if (produto < 75) {
			System.out.println("Valores: " + x + " e " + x2 + "\n" + "Soma: " + soma);
			
		} else {
			System.out.println("Valores: " + x + " e " + x2 + "\n" + "Produto: " + produto);
		}
		
	}
	
}