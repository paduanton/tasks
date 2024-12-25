package ifsul.array_string;
import java.util.Scanner;
public class Q20 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short num[] = new short[10]; int num2[] = new int[10]; byte h;
		
		System.out.println("Insira 10 valores");
		for(h = 0; h < 10; h++) {
			num[h] = t.nextShort();
			if(num[h] % 2 == 0) {
				num2[h] = num[h]*2;
			} else {
				num2[h] = 3*num[h];
			 }
		} 
		System.out.println("VALORES MODIFICADOS");
		for(h = 0; h <= 9; h++) {
			System.out.println(num2[h]);
		}
	}
}
/*
 * Fa�a um algoritmo que leia um vetor de 10 elementos e gere um segundo vetor cujas posi��es
 * pares s�o o dobro do vetor original e as �mpares o triplo.
*/