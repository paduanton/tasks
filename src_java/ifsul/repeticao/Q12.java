package ifsul.repeticao;
import java.util.Scanner;
public class Q12 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		long h, y, w;
		
		System.out.println("Insira um intervalo de dois n�meros");
		y = teclado.nextLong();
		w = teclado.nextLong();
		
		System.out.println(y+" at� "+w);
		for(h = y; h <= w; h++) {
			System.out.println(h);
		}
	}
}