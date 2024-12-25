package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q18 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short A[] = new short[10]; byte h;
		
		System.out.println("Insira 10 valores");
		for(h = 0; h < 10; h++) {
			A[h] = t.nextShort();
			if(A[h] < 0)
				A[h] = 0;
		} 
		System.out.println("VALORES MODIFICADOS");
		for(h = 0; h <= 9; h++) {
			System.out.println(A[h]);
		}
	}
}
/*
 * Fa�a um programa que l� 10 elementos em um vetor A. Ap�s o termino do preenchimento do
 * vetor, trocar todos os valores negativos do vetor por 0 (zero). Ao final, mostrar os 
 * valores do vetor modificado.
*/