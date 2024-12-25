package ifsul.decisao;
import java.util.Scanner;
public class Q3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Insira um n�mero: ");
		double num = teclado.nextDouble();
		
		if(num > 0) {
			System.out.print("\nN�MERO POSITIVO");
		} else if(num == 0) {
			System.out.print("\nN�MERO IGUAL A ZERO");
		} else {
			System.out.print("N�MERO NEGATIVO");
		  }
    }
}