package ifsul.decisao;
import java.util.Scanner;
public class Q17 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("INFORME O SAL�RIO BRUTO: ");
		double salario = teclado.nextDouble();
		System.out.print("INSIRA O VALOR DA PRESTA��O: ");
		double prestacao = teclado.nextDouble();
		
		double emprestimo = (prestacao/100)*salario;
		double porcentagem = 0.3 * salario;
		if (emprestimo <= porcentagem) {
			System.out.print("\nO valor do sal�rio � de R$ " + salario + "\nO valor do empr�stimo � de R$" + prestacao + "\nO empr�stimo pode ser concedido, pois n�o ultrapassa o valor de 30% do sal�rio.");	
		} else {
			System.out.print("\nO valor do sal�rio � de R$ " + salario + "\nO valor do empr�stimo � de R$" + prestacao + "\nO empr�stimo n�o pode ser concedido, pois ultrapassa o valor de 30% do sal�rio.");
		  }
		
	}
}