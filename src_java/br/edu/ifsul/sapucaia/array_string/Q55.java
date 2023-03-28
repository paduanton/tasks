package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q55 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		double num[] = new double[100], soma = 0; 
		byte h, igual30 = 0, maiorM = 0, igualM = 0;
		
		System.out.println("Informe 100 valores");
		for(h = 0; h <= 99; h++) {
			num[h] = t.nextDouble();
			soma += num[h];
		} for(h = 0; h < 100; h++) {
			if(num[h] == 30) {
				igual30++;
			} if(num[h] > soma/100) {
				maiorM++;
			} else if(num[h] == soma/100) {
				igualM++;
			  }
		  }
		System.out.print("Quantidades de n�meros..."
				+ "\nIguais a 30: "+igual30+""
				+ "\nMaiores que a m�dia ("+soma/100+"): "+maiorM+""
				+ "\nIguais � m�dia ("+soma/100+"): "+igualM);
	}
}
/*
 * Fazer um algoritmo para ler um conjunto de 100 n�meros reais e informar:
 * a) Quantos n�meros lidos s�o iguais a 30
 * b) Quantos s�o maiores que a m�dia
 * c) Quantos s�o iguais � m�dia
*/