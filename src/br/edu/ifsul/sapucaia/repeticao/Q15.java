package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q15 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		long h, y, soma = 0;
		
		System.out.print("Informe um valor: ");
		y = teclado.nextLong();
		
		for(h = 1; h <= y; h++) {
			if(h % 2 == 0) {
				soma += h;
			}
		}
		System.out.println("Soma dos pares: "+soma);
	}
}