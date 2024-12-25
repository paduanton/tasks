package ifsul.sequencial;
import java.util.Scanner;
public class Q28 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double salario, percentual;
		
		System.out.println("Qual seu sal�rio?");
		salario = teclado.nextDouble();
		System.out.println("Qual seu percentual do reajuste?");
		percentual = teclado.nextDouble();
		
		double s_reajustado = salario + (salario * percentual) / 100;
		
		System.out.println("Seu sal�rio era R$" + salario + "\n" + "O seu percentual de reajuste � " + percentual + "\n" + "O valor do seu sal�rio reajustado � R$" + s_reajustado);
	}

}
