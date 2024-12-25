package ifsul.repeticao;
import java.util.Scanner;
public class Q13_FOR {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int soma = 0;
		
		System.out.print("Digite um intervalo: ");
		int num = tec.nextInt();
		System.out.print("                     ");
		int num2 = tec.nextInt();
		
		for(int h = num; h<= num2; h++) {
			soma += h;
		}
		System.out.print("Soma: "+soma);
	}
}