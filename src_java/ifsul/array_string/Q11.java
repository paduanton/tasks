package ifsul.array_string;
import java.util.Scanner;
public class Q11 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		byte num[] = new byte[10]; byte h;
		
		for(h = 0; h < 10; h++) {
			num[h] += 30;
		}
		System.out.println("VETOR A");
		for(h = 0; h <= 9; h++) {
			System.out.println(num[h]);
		}
	}
}
/*
 * Fa�a um programa que preenche um vetor A de 10 elementos com o valor 30. Ap�s o preenchimento
 * mostre o vetor A.
*/