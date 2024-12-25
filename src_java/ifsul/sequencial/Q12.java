package ifsul.sequencial;
import java.util.Scanner;
public class Q12 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("INSIRA O DIA: ");
	    byte dia = (byte) teclado.nextInt();
		System.out.print("INSIRA O M�S: ");
	    byte mes = (byte) teclado.nextInt();
    	System.out.print("INSIRA O ANO: ");
	    byte ano = (byte) teclado.nextInt();

        System.out.print("\nDATA: "+dia+"/"+mes+"/"+ano);
    }
}
