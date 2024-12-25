package ifsul.sequencial;
import java.util.Scanner;
public class Q35 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int total, candidato, candidato2;
		
		System.out.println("Qual a quantidade total de eleitores?");
		total = teclado.nextInt();
		System.out.println("Qual a quantidade de votos do primeiro candidato?");
		candidato = teclado.nextInt();
		System.out.println("Qual a quantidade do segundo canditado?");
		candidato2 = teclado.nextInt();
		
		int percentual = (100*candidato)/total, percentual2 = (100*candidato2)/total, percentual3 = total-(percentual+percentual2);
		
		System.out.println("Percentual de votos do primeiro canditado: " + percentual + "%" + "\n" + "Percentual de votos do segundo candidato: " + percentual2 + "%" + "\n" + "Percentual de votos nulos: " + percentual3 + "%");
		
	}
	
}
		