package ifsul.sequencial;
import java.util.Scanner;
public class Q32 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		        
	            float C, F;
	            
	            System.out.println("Insira a temperatura em graus Celsius a ser convertida � Fahrenheit");
	            C = teclado.nextFloat();
	            
	            F = (9 * C + 160) / 5;
	            
	            System.out.println(C + " graus Celsius equivale a " + F + " graus medidos em Fahrenheit");
	           
	}

}
