package ifsul.decisao;
import java.util.Scanner;
public class Q22 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Insira o valor da presta��o: R$");
		double prestacao = teclado.nextDouble();
		System.out.print("Insira quantos meses a presta��o est� atrasada: ");
		int meses = teclado.nextInt();
		System.out.print("Insira o valor da taxa de juros: R$");
		double taxa = teclado.nextDouble();
		
		prestacao = prestacao + (prestacao*(taxa*100)*meses);
		System.out.print("\nVALOR DA PRESTA��O COM JUROS: R$"+prestacao);
	}
}