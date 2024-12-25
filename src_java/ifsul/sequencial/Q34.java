package ifsul.sequencial;
import java.util.Scanner;
public class Q34 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double raio, area;
		
		System.out.println("Qual o raio do c�rculo?");
		raio = teclado.nextDouble();
		
		area = 3.14 * Math.pow(raio,2); 
		
		System.out.println(" A �rea do c�rculo � " + area);
	}

}
