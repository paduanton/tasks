package ifsul.sequencial;
import java.util.Scanner;
public class Q16 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println(" Qual valor da base do ret�ngulo? ");
		double base = teclado.nextDouble();
		System.out.println(" Qual a altura desse ret�ngulo? ");
		double altura = teclado.nextDouble();
		
		double area = base * altura;
		double perimetro = 2 *(base + altura);
		double quadrado = base * base, quadrado2 = altura * altura;
		double diagonal = Math.sqrt(quadrado + quadrado2);
		
		System.out.println(" A �rea do ret�ngulo � " + area + "\n" + " O perimetro do ret�ngulo � " + perimetro + "\n" + " A diagonal do ret�ngulo � " + diagonal);
	}

}
