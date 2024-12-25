package ifsul.array_string;
import java.util.Scanner;
public class Q7 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short num[] = new short[5]; short num2[] = new short[5];
		int soma1 = 0, soma2 = 0;
		
		System.out.println("Digite 10 valores");
		for(byte h = 0; h < 5; h++) {
			num[h] = t.nextShort();
			num2[h] = t.nextShort();
			soma1 += num[h]; soma2 += num2[h];
		} 
		System.out.print("Soma: "+(soma1+soma2));
	}
}
/*
 * Cria um algoritmo que armazena n�meros em dois vetores de inteiros de cinco 
 * elementos cada. Mostra o resultado da soma dos vetores.
*/