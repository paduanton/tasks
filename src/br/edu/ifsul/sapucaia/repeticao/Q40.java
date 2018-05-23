package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q40 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		short soma = 0, cont= 0;
		
		System.out.print("Informe um valor: ");
		short num = tec.nextShort();
		
		do {
			cont++;
			soma += cont;
		} while(cont < num);
		
		System.out.print("M�dia: "+soma/cont);
	}
}