package ifsul.repeticao;
import java.util.Scanner;
public class Q17 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		byte y, h, soma = 0, produto = 1;
		
		System.out.print("Informe um valor inteiro: ");
		y = (byte) teclado.nextInt();
		
		for(h = 1; h <= y; h++) {
			System.out.println(h);
			if(h % 2 == 0) {
				soma += h;
			} else {
				produto *= h;
			  }
		}
		System.out.print("Soma dos pares: "+soma+"\nProduto dos �mpares: "+produto);
	}
}