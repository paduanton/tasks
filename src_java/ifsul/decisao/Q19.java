package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q19 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("DIGITE UM N�MERO: ");
		double x = teclado.nextDouble();
		
		if (x > 20 && x < 30) {
			System.out.print(x + " est� entre 20 e 30");
		} else {
			if (x > 50 && x < 60) {
				System.out.print(x + " est� entre 50 e 60");
			} else {
				System.out.print(x + " est� fora dos intervalos 20-30 e 50-60");
			}
			
	
		}
		
	}
	
}