package ifsul.array_string;
import java.util.Scanner;
public class Q4 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short A[] = new short[10]; int soma = 0;
		
		System.out.println("Digite 10 valores");
		for(byte h = 0; h <= 9; h++) {
			A[h] = t.nextShort();
			soma += A[h];
		} 
		System.out.print("Soma: "+soma);
	}
}