package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q13_WHILE {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		short soma = 0;
		
		System.out.print("Digite um intervalo: ");
		short num = tec.nextShort();
		System.out.print("                     ");
		short num2 = tec.nextShort();
		
		while(num < num2) {
			num++;
			soma += num;
		} soma++;
		System.out.print("Soma: "+soma);
	}
}