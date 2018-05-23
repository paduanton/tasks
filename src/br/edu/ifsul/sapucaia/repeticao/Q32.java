package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q32 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Digite um n�mero: ");
		long num = teclado.nextLong();
		System.out.print("Insira outro n�mero: ");
		long num1 = teclado.nextLong();
		
		if(num1 > num) {
			while(num <= num1) {
				System.out.print(num+" ");
				num++;
			}
		}
	}
}