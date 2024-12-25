package ifsul.sequencial;
import java.util.Scanner;
public class Q20 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println(" Qual valor da base do ret�ngulo? ");
		double base = teclado.nextDouble();
		System.out.println(" Qual a altura desse ret�ngulo? ");
		double altura = teclado.nextDouble();
		
		double area = base * altura;
		
		System.out.println(" A �rea do ret�ngulo � " + area );
	}

}
