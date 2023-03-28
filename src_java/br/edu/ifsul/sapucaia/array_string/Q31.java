package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q31 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short num[] = new short[20], menor = 0; byte h, cont = 0;
		
		System.out.println("Informe 20 valores");
		for(h = 0; h <= 19; h++) {
			num[h] = t.nextShort();
			if(h == 0) {
				menor = num[h];
			} if(num[h] < menor) {
				menor = num[h];
			  }
		}
		for(h = 0; h < 20; h++) {
			if(num[h] == menor)
				cont++;
		}
		System.out.print("Menor n�mero: "+menor+"\nN�mero de vezes digitado: "+cont);
	}
}
/*
 * Fa�a um programa onde o usu�rio digita 20 valores que s�o armazenados em um vetor. Encontre
 * ap�s a menor valor informado e a mostre, bem como o n�mero de vezes que esse valor apareceu 
 * no vetor.
*/