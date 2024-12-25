package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q14 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		        
		        double x1;
		        double x2;
		        double dividendo;
		        double divisor;
		        double quociente;
		        double resto;
		        
		        System.out.println(" DIGITE UM VALOR ");
		        x1 = teclado.nextDouble();
		        System.out.println(" DIGITE UM VALOR PARA DIVIDIR O PRIMEIRO");
		        x2 = teclado.nextDouble();
		        
		        dividendo = x1;
		        divisor = x2;
		        quociente = x1 / x2;
		        resto = x1%x2; 
		        
		        System.out.println(" DIVIDENDO: " + dividendo);
		        System.out.println(" DIVISOR: " + divisor);
		        System.out.println(" QUOCIENTE (resultado): " + quociente);
		        System.out.println(" RESTO: " + resto);
	}

}
