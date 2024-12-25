package ifsul.array_string;
import java.util.Scanner;
public class Q44 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int num[] = new int[100], par = 0, soma = 0, maior = 0, menor = 0;
		
		System.out.println("Informe 100 valores");
		for(byte h = 0; h <= 99; h++) {
			num[h] = t.nextInt();
			
			if(h == 0) {
				maior = num[h];
				menor = num[h];
			}
			if(num[h] > maior) {
				maior = num[h];
			} if(num[h] < menor) {
				menor = num[h];
			} if(num[h] % 2 == 0) {
				par++;
			  } soma += num[h];
		}
		System.out.print("Maior: "+maior+"\nMenor: "+menor+"\nPercentual dos pares: "+((par*100)/100)+"%\nM�dia dos valores do vetor: "+soma/100);
	}
}
/*
 * Criar um algoritmo que leia dados para um vetor de 100 elementos inteiros. Imprimir o maior e
 * o menor, sem ordenar, o percentual de n�meros pares e a m�dia dos elementos do vetor.
*/