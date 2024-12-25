package ifsul.sequencial;
import java.util.Scanner;
public class Q37 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Insira quantos anos pretender� viver");
		int anos = teclado.nextInt();
		
		int coracaoA = 31557600*anos;
		
		System.out.println("Seu cora��o bater� aproximadamente " + coracaoA + " vezes se voc� viver " + anos +" anos.");
		
	}
	
}