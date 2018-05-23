package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q38 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Voc� trabalha na empresa 'KYZ Ltda' � quantos anos? ");
		byte ano = (byte) teclado.nextInt();
		System.out.print("Insira seu sal�rio: R$");
		double salario = teclado.nextDouble();
		
		if(ano >= 5) {
			System.out.print("\nSeu sal�rio: R$"+salario+"\nSeu b�nus: R$"+0.2*salario);
		} else {
			System.out.print("\nSeu sal�rio: R$"+salario+"\nSeu b�nus: R$"+0.1*salario);
		  }
	}
}