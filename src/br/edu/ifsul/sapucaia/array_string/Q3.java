package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q3 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		byte h, cont = 0;
		short[] X = new short[10];	
		short[] Y = new short[10];
		
		System.out.println("Insira 10 valores");
		for(h = 0; h <= 9; h++) {
			X[h] = t.nextShort();
			if(X[h] % 2 == 0) {
				Y[cont] = X[h];
				cont++;
			}
		} 
		System.out.println("Valores pares digitados");
		for(h = 0; h < cont; h++) {
			System.out.println(Y[h]);
		}
		System.out.println("Quantidade de pares: "+cont);
	}
}
/*
 * Fa�a um programa que l� 10 valores, armazena em um vetor X. Verifica os valores pares
 * digitados, armazena em um vetor Y mostra os valores pares digitados e a quantidade.
*/