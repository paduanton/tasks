package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q30 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int nascimento, ano, calc, calc2;
		System.out.println("INSIRA SEU ANO DE NASCIMENTO");
		nascimento = teclado.nextInt();
		System.out.println("DIGITE O ANO ATUAL");
		ano = teclado.nextInt();
		
		calc = ano - nascimento;
		if (calc >= 50) {
			System.out.println("VOC� J� TEM 50 ANOS");
			
		} else {
			calc2 = 50 -  calc;
			System.out.println("Faltam " + calc2 + " anos para voc� ter 50 anos.");
		}
	}
	
}