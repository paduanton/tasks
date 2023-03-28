package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q39{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		short h = 0, soma = 0;
		
		System.out.print("Informe um valor: ");
		short num = teclado.nextShort();
		
		while(h < num) {
			h++;
			soma += h;
		}
		System.out.print("M�dia: "+soma/h);
	}
}