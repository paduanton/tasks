package ifsul.decisao;
import java.util.Scanner;
public class Q53{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double corrente, poupanca, contaE, contaE2;
		System.out.println("INSIRA O SALDO DA SUA CONTA CORRENTE");
		corrente = teclado.nextDouble();
		System.out.println("INSIRA O SALDO DA SUA CONTA POUPAN�A");
		poupanca = teclado.nextDouble();
		
		if (corrente < 1000 && poupanca < 1000) {
			System.out.println("SEM CONTA ESPECIAL");
			
		} else { 
			if(corrente > poupanca) {
			   corrente = 2 * corrente; poupanca = poupanca * 3;
			} if (corrente > poupanca) {
                  System.out.println("Valor limite da conta especial: R$" + corrente);
             } else {
	           System.out.println("Valor limite da conta especial: R$" + poupanca);
             }
       }  
   }
}