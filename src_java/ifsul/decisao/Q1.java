package ifsul.decisao;
import java.util.Scanner;
public class Q1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int x;
		System.out.print("DIGITE UM N�MERO: ");
		x = teclado.nextInt();
		
		if(x%2 == 0) {
			System.out.print("\n"+x+" � par.");
		} else {
			System.out.print("\n"+x+" � �mpar.");
		  }
	}
	
}