package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q8 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		        int x;
		        
		        System.out.println(" INSIRA UM VALOR ");
		        x = teclado.nextInt();
		        
		        int antecessor = x - 1;
		        int sucessor = x + 1;
		        
		        System.out.println(" SEU ANTECESSOR � " + antecessor + " E SEU SUCESSOR � " + sucessor + ".");
		        
	}

}
