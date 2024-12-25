package ifsul.decisao;
import java.util.Scanner;
public class Q91 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Insira o valor de X");
		double x = teclado.nextDouble();
         
		x = 5*x + 3/Math.sqrt(Math.pow(x,2)- 16);
		System.out.println("O valor de X � " + x);
   }	
}