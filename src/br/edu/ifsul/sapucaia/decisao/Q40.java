package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q40 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double h, pesoH, pesoM;
		System.out.println("INSIRA SUA ALTURA");
		h = teclado.nextDouble();
		System.out.println("INSIRA SEU SEXO (HOMEM - 'H', MULHER - 'M')");
		String indefinido = teclado.next();
		
		if (indefinido.equals("H")) {
			pesoH =(72.7*h) - 58;
			System.out.println("Sexo: Masculino" + "\n" + "Altura: " + h + "\n" + "Seu peso ideal � de " + pesoH + "kg");
			
		} else {
			if (indefinido.equals("M")) {
			pesoM = (62.1*h) - 44.7;
			System.out.println("Sexo: Feminino" + "\n" + "Altura: " + h + "\n" + "Seu peso ideal � de " + pesoM + "kg");
		 
	    }
	  }
   }	
}