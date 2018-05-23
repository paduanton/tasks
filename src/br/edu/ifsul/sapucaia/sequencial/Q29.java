package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q29 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int total, vbranco, vnulo, vvalido;
		
		System.out.println("Qual a quantidade total de eleitores?");
		total = teclado.nextInt();
		System.out.println("Qual a quantidade de votos brancos?");
		vbranco = teclado.nextInt();
		System.out.println("Qual a quantidade de votos nulos?");
		vnulo = teclado.nextInt();
		System.out.println("Qual a quantidade de votos v�lidos?");
		vvalido = teclado.nextInt();
		
		int percentual = (100 * vbranco) / total, percentual1 = (100 * vnulo) / total, percentual2 = (100 * vvalido) / total;
		
		System.out.println("O percentual de votos nulos � " + percentual1 + "%" + "\n" + "O percentual de votos brancos � " + percentual + "%" + "\n" + "O percentual de pessoas com votos v�lidos � " + percentual2 + "%");
		
	}

}
