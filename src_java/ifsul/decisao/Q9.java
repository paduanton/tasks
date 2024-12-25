package ifsul.decisao;
import java.util.Scanner;
public class Q9 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double x, quadrado, raiz;
		System.out.println("DIGITE UM N�MERO");
		x = teclado.nextDouble();
		
		if (x >= 0) {
			raiz = Math.sqrt(x);			
			System.out.println("Raiz quadrada do n�mero: " + raiz);
			
		} else {
			quadrado = Math.pow(x,2);
			System.out.println("Quadradi do n�mero: " + quadrado);
		}
		
	}
	
}