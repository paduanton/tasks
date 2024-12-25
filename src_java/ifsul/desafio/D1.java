package ifsul.desafio;
import java.util.Scanner;
public class D1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("INSIRA O N�MERO DE UMA CORRENTE COM 3 D�GITOS: ");
		int conta = teclado.nextInt();
		  
		int centena = conta / 100, dezena = (conta%100) / 10, unidade = (conta%100) % 10;
		int U = unidade * 100, D = dezena * 10, contaI = centena + D + U, soma = contaI + conta;
		int centena1 = soma / 100, dezena1 = (soma%100) / 10,	unidade1 = (soma%100) % 10;
		int D1 = dezena1 * 2, U1 = unidade1 * 3, soma1 = centena1 + D1 + U1, digito = (soma1 % 100) % 10;
		
		System.out.print("Conta c/ d�gito verificador: " + conta + "-" + digito);			
	}
}
