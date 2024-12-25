package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q90 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Insira o valor de X para a fun��o f(x) = 8 / (2 - x)");
		double x = teclado.nextDouble();
         
		x = 8/(2-x);
		System.out.println("O valor de X � " + x);
   }	
}