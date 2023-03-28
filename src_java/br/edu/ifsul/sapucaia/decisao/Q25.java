package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q25{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Insira um n�mero: ");
		long x1 = teclado.nextLong();
		System.out.print("Insira outro n�mero: ");
		long x2 = teclado.nextLong();
		
		if(x1 > x2) {
			if(x1 < 0) {
				System.out.print("\nQuadrado menor n�mero("+x2+"): "+Math.pow(x2, 2)+"\nRaiz quadrada do maior n�mero: N�O � POSS�VEL, POIS "+x1+" � UM N�MERO NEGATIVO.");
			} else {
				System.out.print("\nQuadrado menor n�mero("+x2+"): "+Math.pow(x2, 2)+"\nRaiz quadrada do maior n�mero ("+x1+"): "+Math.sqrt(x1));
			  }
		} else {
			if(x2 < 0) {
				System.out.print("\nQuadrado menor n�mero("+x1+"): "+Math.pow(x1, 2)+"\nRaiz quadrada do maior n�mero: N�O � POSS�VEL, POIS "+x2+" � UM N�MERO NEGATIVO.");
			} else {
				System.out.print("\nQuadrado menor n�mero("+x1+"): "+Math.pow(x1, 2)+"\nRaiz quadrada do maior n�mero ("+x2+"): "+Math.sqrt(x2));
			  }
		  }
    }
}