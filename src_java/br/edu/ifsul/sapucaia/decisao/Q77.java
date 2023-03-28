package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q77 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("QUAL SUA IDADE?");
		int idade = teclado.nextInt();
         
		if (idade == 21) {
			System.out.println("VOC� TEM 21 ANOS");
		} else {
			if (idade > 21) {
				System.out.println("VOC� TEM MAIS QUE 21 ANOS");				
			} else {
				System.out.println("VOC� TEM MENOS QUE 21 ANOS");
			}
	      
		}
   }	
}