package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q119 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Quantos n�meros: ");
		short num = tec.nextShort();
		
		for(byte h = 1; h <= num*2; h++) {
			if(h % 2 == 0) {
				System.out.print(h+" ");
			}
		}
	}
}