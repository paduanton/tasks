package ifsul.sequencial;
import java.util.Scanner;
public class Q15_2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
                
		        double dolar, real, cotacao;
		        
		        System.out.println(" O d�lar est� cotado a quantos reais?");
		        cotacao = teclado.nextDouble();
		        System.out.println(" Digite a quantidade de reais (US$) a ser convertida para dol�res. ");
		        real = teclado.nextDouble();
		        
		        dolar = real / cotacao;
		        
		        System.out.println(real + " reais equivale � " + dolar + " d�lares, segundo a cota��o que voc� passou.");
		         
	}

}
