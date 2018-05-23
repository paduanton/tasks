package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q88 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("INSIRA O TIPO DE CARRO (A, B OU C)");
		String carro = teclado.next();
		System.out.println("INSIRA O PERCURSO EM QUIL�METROS");
		double KM = teclado.nextDouble();
         
		if (carro.equals("A")) {
			double media = KM/12;
			System.out.println("O consumo estimado do combust�vel � de " + media + "km/l");
			
		} if (carro.equals("C")) {
			double media = KM/8;
			System.out.println("O consumo estimado do combust�vel � de " + media + "km/l");	
			
		} if (carro.equals("B")) {
			double media = KM/9;
			System.out.println("O consumo estimado do combust�vel � de " + media + "km/l");
		}	
   }	
}