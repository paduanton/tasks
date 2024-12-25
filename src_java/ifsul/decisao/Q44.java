package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q44 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
;
		System.out.print("Qual seu nome? ");
		String nome = teclado.nextLine();
		System.out.print("Insira seu turno de estudo (M - manh�, T - tarde ou N - noite): ");
		String turno = teclado.next();
		
		if (turno.equals("M") == false && turno.equals("T") == false && turno.equals("N") == false) {
			System.out.print("Turno inv�lido");
		} else {
			  if (turno.equals("M")) {
				System.out.print("Bom dia, " + nome + "!");
			} if (turno.equals("T")){
				  System.out.print("Boa tarde, " + nome + "!");
			} if (turno.equals("N")) {
				  System.out.print("Boa noite, " + nome +"!");
			}
			
		}
		
	}
	
}