package ifsul.repeticao;
import java.util.Scanner;
public class Q16 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		byte y, h, soma = 0, produto = 1;
		
		System.out.print("Informe um valor maior que 1 e menor que 100: ");
		y = (byte) teclado.nextInt();
		if(y > 1 && y < 101) {
			System.out.println("Intervalo de 1 at� "+y);
			for(h = 1; h <= y; h++) {
				System.out.println(h);
				if(h % 2 == 0) {
					soma += h;
				} else {
					produto *= h;
				  }
			}
			System.out.print("Soma dos pares: "+soma+"\nProduto dos �mpares: "+produto);
		} else {
			System.out.print("\nN�O � POSS�VEL MOSTRAR OS VALORES");
		  }
	}
}