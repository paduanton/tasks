package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q22 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double D, d, areaL, base, altura, areaT;
		
		System.out.println("Qual o valor da diagonal menor do losango?");
		d = teclado.nextDouble();
		System.out.println("Qual o valor da diagonal menor do losango?");
		D = teclado.nextDouble();
		
		areaL = (D * d) / 2; 
		
		System.out.println("A �rea do losango � " + areaL);
		System.out.println("...........................................");
		
		System.out.println("Qual o valor da base do tri�ngulo?");
		base = teclado.nextDouble();
		System.out.println("Qual o valor da altura do tri�ngulo?");
		altura = teclado.nextDouble();
		
		areaT = (base * altura) / 2;
		
		System.out.println("A �rea do tri�ngulo � " + areaT);
		
	}

}
