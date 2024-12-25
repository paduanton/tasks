package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q15 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short num[] = new short[10]; byte cont = 0, h, indice[] = new byte[10];
		
		System.out.println("Informe o valor 'X': ");
		short x = t.nextShort();
		System.out.println("Insira 10 valores: ");
		for(h = 0; h < 10; h++) {
			num[h] = t.nextShort();
			if(num[h] == x) {
				indice[cont] = h;
			    cont++;
			}
		} 
		System.out.println("�ndices em que aparece o valor 'X'");
		for(h = 0; h < cont; h++) {
			System.out.println(indice[h]);
		}
	}
}
/*
 * Ler um vetor A de 10 elementos e um valor "x". Mostre as posi��es (�ndice) do vetor A em que
 * aparece um valor igual a "x".
*/