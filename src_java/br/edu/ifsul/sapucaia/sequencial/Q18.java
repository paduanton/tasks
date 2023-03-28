package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q18 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double  nt1, nt2, nt3, nt4, nt5, media;
		
		System.out.println(" Insira a nota da primeira prova");
		nt1 = teclado.nextDouble();
		System.out.println(" Insira a nota da segunda prova");
		nt2 = teclado.nextDouble();
		System.out.println(" Insira a nota da terceira prova");
		nt3 = teclado.nextDouble();
		System.out.println(" Insira a nota da quarta prova");
		nt4 = teclado.nextDouble();
		System.out.println(" Insira a nota da quinta prova");
		nt5 = teclado.nextDouble();
		
		media = (nt1 + nt2 + nt3 + nt4 + nt5) / 5;
		
		System.out.println(" A media das notas � " + media);
		
	}

}
