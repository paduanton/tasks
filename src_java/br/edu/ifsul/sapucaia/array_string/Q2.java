package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short[] num = new short[10]; short h;
		
		System.out.println("Informe 10 valores");
		for(h = 0; h <= 9; h++) {
			num[h] = t.nextShort();
		}
		System.out.println("Valores maior que 50");
		for(h = 0; h < 10 ; h++) {
			if(num[h] > 50) {
				System.out.println(num[h]);
			}
		}
	}
}