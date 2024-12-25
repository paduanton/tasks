package ifsul.repeticao;
import java.util.Scanner;
public class Q37 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int soma = 0; short h = 0;
		
		System.out.println("Digite 1 valor: ");
		short num = tec.nextShort();
		
		for(h = 1; h <= num; h++) {
			soma += h;
		}
		System.out.print("Soma: "+soma+"\nM�dia: "+soma/num);
	}
}