package ifsul.decisao;
import java.util.Scanner;
public class Q39 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int livro; double calc1, calc2;
		System.out.println("INSIRA A QUANTIDADE DE LIVROS QUE DESEJA COMPRAR");
		livro = teclado.nextInt();
		
		calc1 = 0.25 * livro + 7.50;
		calc2 = 0.50 * livro + 2.50;
		if (calc1 < calc2) {
			System.out.println("Escolhendo o crit�rio de desconto 'A' voc� pagar� R$" + calc1 + "\n" + "Escolhendo o crit�rio de desconto 'B' voc� pagar� R$" + calc2 + "\n" + "O crit�rio de desconto 'A' � a melhor op��o.");
						
		} else {
			if (calc1 > calc2) {
			System.out.println("Escolhendo o crit�rio de desconto 'A' voc� pagar� R$" + calc1 + "\n" + "Escolhendo o crit�rio de desconto 'B' voc� pagar� R$" + calc2 + "\n" + "O crit�rio de desconto 'B' � a melhor op��o.");
			
			} else {
				if (calc1 == calc2) {
					System.out.println("Escolhendo o crit�rio de desconto 'A' voc� pagar� R$" + calc1 + "\n" + "Escolhendo o crit�rio de desconto 'B' voc� pagar� R$" + calc2 + "\n" + "N�o faz diferen�a qual crit�rio de desconto escolher.");
					
		        }
		           } 
	
		       }	
  }
}
