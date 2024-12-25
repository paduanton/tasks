package ifsul.sequencial;
import java.util.Scanner;
public class Q17 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double raio, area1, perimetro;
		
		System.out.println("Qual o raio do c�rculo?");
		raio = teclado.nextDouble();
		
		area1 = 3.14 * Math.pow(raio,2); perimetro = 2 * 3.14 * raio;
		
		System.out.println(" O perimetro do circulo � " + perimetro + "\n" + " A �rea do c�rculo � " + area1);
	}

}
