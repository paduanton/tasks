package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q71 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int somaP = 0, contN = 0;
		
		System.out.println("Digite 20 valores: ");
		for(byte h = 0; h < 11; h++) {
			int num = teclado.nextInt();
			if(num > -1) {
				somaP += num;
			} else {
				contN++;
			  }
		}
		System.out.print("Soma dos positivos: "+somaP+"\nTotal negativos: "+contN);
	}
}