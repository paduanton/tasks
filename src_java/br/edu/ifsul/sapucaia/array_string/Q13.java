package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q13 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int num[] = new int[10]; byte h;
		
		for(h = 0; h < 10; h++) {
			num[h] = (h+1)*10;
		}
		System.out.println("VETOR A");
		for(h = 0; h <= 9; h++) {
			System.out.println(num[h]);
		}
	}
}