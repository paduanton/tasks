package ifsul.decisao;
import java.util.Scanner;
public class Q69 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("INSIRA UM VALOR INTEIRO: ");
        int x = teclado.nextInt();
        System.out.print("INSIRA OUTRO VALOR INTEIRO: ");
        int x1 = teclado.nextInt();
        System.out.print("INSIRA MAIS UM N�MERO INTEIROS: ");
        int x2 = teclado.nextInt();
        
        if (x > x1) {
        	System.out.print("\nO PRIMEIRO N�MERO INSERIDO � O MAIOR");
        } else if (x1 > x2) {
        	System.out.print("\nO SEGUNDO N�MERO INSERIDO � O MAIOR");
        } else {
        	System.out.print("\nO TERCEIRO N�MERO INSERIDO � O MAIOR");

        }
  }
}
