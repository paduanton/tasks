package ifsul.array_string;
import java.util.Scanner;
public class Q34 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		byte dado[] = new byte[100], h, cont = 0; short soma = 0;
		
		System.out.println("Informe os 100 valores do lan�amento");
		for(h = 0; h <= 99; h++) {
			dado[h] = t.nextByte();
			soma += dado[h];
		}
		for(h = 0; h < 100; h++) {
			if(dado[h] > soma/100)
				cont++;
		}
		System.out.print("N�meros de lan�amentos maiores que a\nm�dia aritm�tica dos lan�amentos: "+cont);
	}
}
/*
 * Um dado � lan�ado 100 vezes e o valor correspondente � anotado. Fa�a um programa para
 * determinar e imprimir o n�mero de lan�amentos nos quais o resultado obtido � maior do 
 * que a m�dia aritm�tica dos lan�amentos.
*/