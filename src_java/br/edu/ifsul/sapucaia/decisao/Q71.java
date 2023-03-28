package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q71 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("INSIRA A SENHA");
		int senha = teclado.nextInt();
         
		if (senha == 123456 || senha == 654321) {
			System.out.println("ACESSO PERMITIDO");
		} else {
	      System.out.println("ACESSO NEGADO");
	      
		}
   }	
}