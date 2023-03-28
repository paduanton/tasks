package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q42 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double x1, x2, x3, x4 ,x5, media;
		System.out.println("INSIRA SUA NOTA NA PRIMEIRA AVALIA��O");
		x1 = teclado.nextDouble();
		System.out.println("INSIRA SUA NOTA NA SEGUNDA AVALIA��O");
		x2 = teclado.nextDouble();
		System.out.println("INSIRA SUA NOTA NA TERCEIRA AVALIA��O");
		x3 = teclado.nextDouble();
		System.out.println("INSIRA SUA NOTA NA QUARTA AVALIA��O");
		x4 = teclado.nextDouble();
		System.out.println("INSIRA SUA NOTA NA QUINTA AVALIA��O");
		x5 = teclado.nextDouble();
		
		media = (x1 + x2 + x3 + x4 + x5)/5;
		if (media >= 6) {
			System.out.println("\n" + "M�dia: " + media + "\n" + "APROVADO");
			
		} else {
			System.out.println("\n" + "M�dia: " + media + "\n" + "EM RECUPERA��O");
			     
		      
	    }
   }
}