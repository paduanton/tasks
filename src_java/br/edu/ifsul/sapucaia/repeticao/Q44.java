package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q44{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int h = 1, num;
		
		System.out.print("Informe um valor: ");
		num = teclado.nextInt();
		
		while(num <= 0) {
			System.out.print("Informe um valor maior que 0: ");
			num = teclado.nextInt();
		}
		
		if(num > 0) {
			while(h <= num) {
				System.out.print(h+" ");
				h++;	
			}
		} 
	}
}