package ifsul.array_string;
import java.util.Scanner;
public class Q29 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		float preco[] = new float[5]; 
		String nome[] = new String[5];
		String nome2[] = new String[5];
		float precoBarato = 0, precoCaro = 0, soma = 0; String nomeCaro = "", nomeBarato = "";
		byte h, cont = 0, cont2 = 0, cont3 = 0;
		
		for(h = 0; h < 5; h++) {
			System.out.print("Produto "+(h+1)+"\nNome: ");
			nome[h] = t.next();
			System.out.print("Pre�o: R$");
			preco[h] = t.nextFloat();
			System.out.println();
			
			if(preco[h] < 50) {
				cont++;
			} if(preco[h] >= 35 && preco[h] <= 100) {
				nome2[cont3] = nome[h]; cont3++;
			} else if(preco[h] > 100) {
				soma += preco[h]; cont2++;
			  }
			if(h == 0) {
				precoBarato = preco[h]; precoCaro = preco[h];
				nomeBarato = nome[h]; nomeCaro = nome[h];
			}
			
			if(precoCaro < preco[h]) {
				nomeCaro = nome[h];
				precoCaro = preco[h];
			} if(preco[h] < precoBarato) {
				  precoBarato = preco[h];
				  nomeBarato = nome[h];
			  }
		}
		System.out.println("\nNome dos produtos com pre�o entre R$35,00 e R$100,00");
		for(h = 0; h < cont3; h++) {
			System.out.println(nome2[h]);
		}
		System.out.print("\nQuantidade de produtos com pre�o inferior a R$50,00: "+cont+""
				+ "\nM�dia de pre�os dos produtos com pre�o superior a R$100,00: R$"+soma/cont2+""
				+ "\nNome do produto mais caro: "+nomeCaro+""
				+ "\n\nProduto mais barato\nNome: "+nomeBarato+"\nPre�o: R$"+precoBarato);
	}
}
/*
Fa�a um programa que receba o nome de cinco produtos e seus respectivos pre�os, calcule e
mostre:
a) a quantidade de produtos com pre�o inferior a R$50,00;
b) o nome dos produtos com pre�o entre R$35,00 e R$100,00;
c) a m�dia de pre�os dos produtos com pre�o superior a R$100,00.
d) o nome do produto mais caro;
e) o pre�o e o nome do produto mais barato.
*/