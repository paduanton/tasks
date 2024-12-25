package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q50 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		byte h, h2, acerto = 0, gabarito[] = new byte[5], A[] = new byte[10];
		
		System.out.println("Insira o gabarito da LOTO");
		for(h = 0; h < 5; h++) {
			gabarito[h] = t.nextByte();
		}
		System.out.println("INSIRA A APOSTA");
		for(h = 0; h <= 9; h++) {
			A[h] = t.nextByte();
		}
		for(h = 0; h < 5; h++) {
			for(h2 = 0; h2 <= 9; h2++) {
				if(A[h2] == gabarito[h]) {
					acerto++;
				}
			}
		}
		System.out.println("Acertos: "+acerto);
	}
}
/*
 * Ler um vetor R de 5 elementos acertoendo o gabarito da LOTO. A seguir ler um vetor A de 
 * 10 elementos contendo uma aposta. A seguir imprima quantos pontos fez o apostador.
*/