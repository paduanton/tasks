package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q19 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		 System.out.println(" Deseja saber a raiz quadrada de qual n�mero? ");
		 double x1 = teclado.nextDouble();
		 
		 double quadrado = Math.sqrt(x1);
		 System.out.println("A raiz quadrada do n�mero " + x1 + " � " + quadrado); 
	}

}
