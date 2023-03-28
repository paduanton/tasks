package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q49 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		double valor, valorG, valorA, litros;
		System.out.println("INSIRA O N�MERO DE LITROS VENDIDOS");
		litros = teclado.nextDouble();
		System.out.println("INSIRA O TIPO DE COMBUST�VEL('A' - �LCOOL, 'G' - GASOLINA)");
		String combustivel= teclado.next();
		
		valorA = litros * 1.90;
		valorG = litros * 2.50;
		if(combustivel.equals("G")) {
			if(litros > 0 && litros <= 20) {
				valor = litros * 2.50 - (valorG * 0.04);
				System.out.println("O valor a ser pago � R$" + valor);	
			} else {
				valor = litros * 2.50 - (litros * 0.06);
				System.out.println("O valor a ser pago � R$" + valor);
			}
		} else {
			if(combustivel.equals("A")) {
			if(litros > 0 && litros <= 20) {
				valor = litros * 1.90 - (valorA * 0.03);
				System.out.println("O valor a ser pago � R$" + valor);	
			} else {
				valor = litros * 1.90 - (litros * 0.05);
				System.out.println("O valor a ser pago � R$" + valor);
			  
			  }
			}
		  }
	}
}