package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q43 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double peso, porcentagem, pesoG, npeso, npeso2;
		
		System.out.println("Qual seu peso(Kg)?");
		peso = teclado.nextDouble();
		System.out.println("Insira a porcentagem que voc� engordou.");
		porcentagem = teclado.nextDouble();
		
		pesoG = peso*1000; npeso = peso+(0.12*peso); npeso2 = peso+((porcentagem/100)*peso);
		
		System.out.println("Seu peso em gramas: " + pesoG + "g" + "\n" + "Seu peso caso engorde 12% � de " + npeso + "Kg" + "\n" + "Seu novo peso segundo a porcentagem que voc� � de " + npeso2 + "Kg");
		
	}

}
