package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q26 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Qual sua idade? ");
		int idade = teclado.nextInt();
		
		if(idade < 18) {
			System.out.print("\nVoc� � menor de idade, pois possui "+idade+" anos.");			
		} else {
			if(idade >= 18 && idade < 65) {
				System.out.print("\nVoc� � maior de idade, pois possui "+idade+" anos.");	
			} else if(idade == 65) {
				System.out.print("\nVoc� � idoso, pois possui 65 anos");			
			} else {
				System.out.print("\nVoc� � idoso, pois possui mais de 65 anos.");
			  }
		  }
	}
}