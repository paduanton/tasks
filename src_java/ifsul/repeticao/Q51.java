package ifsul.repeticao;
import java.util.Scanner;
public class Q51 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		byte negativo = 0, intervalo = 0, M100 = 0;
		
		System.out.println("Digite 15 valores");
		for(byte h = 0; h < 16; h++) {
			short num = teclado.nextShort();
			if(num < 0) {
				negativo++;
			} else if(num >= 15 && num <= 45) {
				intervalo++;
			} else if(num > 100) {
				M100++;
			  }
		}
		System.out.println("Menores que 0: "+negativo+"\nEntre o intervalo 15-45: "+intervalo+"\nMaior que 100: "+M100);
	}
}