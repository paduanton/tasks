package ifsul.sequencial;
import java.util.Scanner;
public class Q15 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
                
		        double dolar, real, cotacao;
		        
		        System.out.println(" O d�lar est� cotado a quantos reais?");
		        cotacao = teclado.nextDouble();
		        System.out.println(" Digite a quantidade de dol�res (US$) a ser convertida para reais. ");
		        dolar = teclado.nextDouble();
		        
		        real = dolar * cotacao;
		        
		        System.out.println(dolar + " d�lares equivale � " + real + " reais, segundo a cota��o que voc� passou.");
		         
	}

}
