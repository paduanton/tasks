package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q41 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		byte cont = 0, cont2 = 0;
		
		System.out.println("Digite 10 valores");
		for(byte h = 1; h < 11; h++) {
			int num = teclado.nextInt();
			if(num >= 10 && num <= 30) {
				cont++;
			} else {
				cont2++;
			  }
		}
		System.out.println(cont+" est�o no intervalo 10 - 30\n"+cont2+" n�o est�o no intervalo 10 - 30");
	}
}