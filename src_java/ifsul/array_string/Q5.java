package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q5 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int[] num = new int[10]; 
		int soma = 0; byte cont = 0, h;
		
		System.out.println("Insira 10 valores");
		for(h = 0; h < 10; h++) {
			num[h] = t.nextInt();
			soma += num[h];
		}
		System.out.println("Valores maiores que a m�dia ("+soma/10+")");
		for(h = 0; h < 10; h++) {
			if(num[h] > soma/10) {
				cont++;
				System.out.println(num[h]);
			}
		}
		System.out.print("Quantidade de valores maiores que a m�dia: "+cont);
	}
}
/*
Fa�a um programa que l� 10 n�meros, calcula a m�dia e ao final
mostra quantos valores s�o maiores que a m�dia e os n�meros.
*/