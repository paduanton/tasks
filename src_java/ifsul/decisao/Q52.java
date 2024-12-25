package ifsul.decisao;
import java.util.Scanner;
public class Q52 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("Qual seu peso? ");
		double peso = teclado.nextDouble();
		System.out.print("Qual sua altura? ");
		double altura = teclado.nextDouble();

		if(altura < 1.75 || altura > 1.90) {
			if(peso >= 70 && peso <= 80) {
				System.out.print("\nRECUSADO POR ALTURA");
			} else {
				System.out.print("\nTOTALMENTE RECUSADO");
			  }
		} else if(altura >= 1.75 && altura <= 1.90) {
			if(peso >= 70 && peso <= 80) {
				System.out.print("\nACEITO");
			} else {
				System.out.print("\nRECUSADO POR PESO");
			  }
			
		  }
	}
}