package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q56 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		int num, centena, dezena, unidade;
		
		System.out.println("Insira um n�mero inteiro de 3 digitos");
		num = teclado.nextInt();
		
		centena = num/100;
		dezena = (num%100) / 10;
		unidade = (num%100)%10;
		
		//centena
		if (centena%2 == 0) {
			System.out.println("O algarismo da centena (" + centena + ") � par.");	
		} else {
	      System.out.println("O algarismo da centena (" + centena + ") � �mpar.");
	      
	    // dezena
		} if (dezena%2 == 0) {
			  System.out.println("O algarismo da dezena (" + dezena + ") � par.");
		} else {
		  System.out.println("O algarismo da dezena (" + dezena + ") � �mpar.");
		  
		// unidade
		} if (unidade%2 == 0) {
			  System.out.println("O algarismo da unidade (" + unidade + ") � par.");
		} else {
		  System.out.println("O algarismo da unidade (" + unidade+ ") � �mpar.");
		}
	}
}