package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q32 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("DIGITE O ANO DE NASCIMENTO DO PRIMEIRO IRM�O: ");
		int idade1 = teclado.nextInt();
		System.out.print("DIGITE O ANO DE NASCIMENTO DO SEGUNDO IRM�O: ");
		int idade2= teclado.nextInt();
		System.out.print("DIGITE O ANO DE NASCIMENTO DO TERCEIRO IRM�O: ");
		int idade3 = teclado.nextInt();
		
		if (idade1 == idade2 && idade3 == idade1) {
			System.out.print("\n" + "S�O TRIG�MEOS");
		} else {
			if (idade1 != idade2 && idade3 != idade1) {
				System.out.print("\n" + "S�O IRM�OS");
			} else {
				System.out.print("\n" + "S�O G�MEOS");
			}
			
	
		}
		
	}
	
}