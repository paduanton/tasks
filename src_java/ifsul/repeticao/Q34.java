package ifsul.repeticao;
import java.util.Scanner;
public class Q34 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		long soma = 0, contP = 0, contI = 0;
		
		for(byte h = 1; h < 11; h++) {
			System.out.print("Digite um n�mero: ");
			long num = teclado.nextLong();
			if(num % 2 == 0) {
				contP++;
			} else {
				contI++;
			  }
			soma += num;
		}
		if(soma % 2 != 0) {
			System.out.print("Soma dos valores: "+soma+"\nN�meros �mpares digitados: "+contI);
		} else {
			System.out.print("Soma dos valores: "+soma+"\nN�meros pares digitados: "+contP);
		  }
	}
}