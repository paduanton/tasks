package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q55 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite 10 valores: ");
		for(byte h = 1; h < 11; h++) {
			int num = teclado.nextInt();
			System.out.println("N�mero: "+num+" |  Antecessor: "+(num-1)+" | Sucessor: "+(num+1));
		}
	}
}