package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q36 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double fabrica, impostos, distribuidor;
		
		System.out.println("Qual o custo de f�brica de um carro?");
		fabrica = teclado.nextDouble();
		System.out.println("Insira porcentagem dos impostos sobre o carro.");
		impostos = teclado.nextDouble();
		System.out.println("Qual a porcentagem do distribuidor sobre o carro?");
		distribuidor = teclado.nextDouble();
		
		double porcentagemD = distribuidor/100, porcentagemI = impostos/100, totalD = porcentagemD*fabrica, totalI = porcentagemI*fabrica, consumidor  = totalD + totalI+fabrica;
		
		System.out.println("O custo do carro ao consumidor � R$" + consumidor);
		
	}
	
}