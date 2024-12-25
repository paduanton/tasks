package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q50 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		String cor; double total; int quantidade;
		
		System.out.print("Insira a cor do tipo de DVD (azul, rosa, verde e vermelho) que deseja comprar: ");
		cor = teclado.next();

		if (cor.equalsIgnoreCase("azul")) {
			System.out.print("\n COR |  PRE�O\nAzul | R$10,00\n\nQuantos DVDs quer comprar? ");
			quantidade = teclado.nextInt(); total = quantidade * 10;
			System.out.print("\nQUANTIDADE: " + quantidade + "\nCOR: Azul\nPRE�O: R$10,00\nTOTAL A SER PAGO: R$" + total);
		} else {
			if (cor.equalsIgnoreCase("rosa")) {
				System.out.print("\n COR |  PRE�O\nRosa | R$25,00\n\nQuantos DVDs quer comprar? ");
				quantidade = teclado.nextInt(); total = quantidade*25;
				System.out.print("\nQUANTIDADE: " + quantidade + "\nCOR: Rosa\nPRE�O: R$25,00\nTOTAL A SER PAGO: R$" + total);
			} if (cor.equalsIgnoreCase("verde")) {
				  System.out.print("\n COR  |  PRE�O\nVerde | R$35,00\n\nQuantos DVDs quer comprar? ");
				  quantidade = teclado.nextInt(); total = quantidade * 35;
				  System.out.print("\nQUANTIDADE: " + quantidade + "\nCOR: Verde\nPRE�O: R$35,00\nTOTAL A SER PAGO: R$" + total);
			} if (cor.equalsIgnoreCase("vermelho")) {
				  System.out.print("\n   COR   |  PRE�O\nVermelho | R$50,00\n\nQuantos DVDs quer comprar? ");
				  quantidade = teclado.nextInt(); total = quantidade * 50;
				  System.out.print("\nQUANTIDADE: " + quantidade + "\nCOR: Vermelho\nPRE�O: R$50,00\nTOTAL A SER PAGO: R$" + total);
			}
		}
   }
}