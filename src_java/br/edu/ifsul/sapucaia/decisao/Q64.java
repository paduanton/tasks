package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q64 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		double hora, salario;
		
		System.out.println("Insira o n�mero de horas que trabalhou.");
		hora = teclado.nextDouble();
		System.out.println("Qual seu sal�rio por hora?");
        salario = teclado.nextDouble();
        
		if (hora > 40) {
			double extra = hora - 40, horaE = (extra * salario) * 2, total = ((hora * salario) - (2 * extra)) + horaE, salario1 = salario * hora;
			System.out.println("Sal�rio: R$" + salario1 + "\n" + "Sal�rio c/ hora extra: R$" + total);	
			
		} else {
			double salario1 = salario * hora;
	      System.out.println("Sal�rio: R$" + salario1);
	      
		}
   }	
}