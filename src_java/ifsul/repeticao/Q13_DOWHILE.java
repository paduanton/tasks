package ifsul.repeticao;
import java.util.Scanner;
public class Q13_DOWHILE {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		short soma = 0;
		
		System.out.print("Digite um intervalo: ");
		short num = tec.nextShort();
		System.out.print("                     ");
		short num2 = tec.nextShort();
		
		do {
			num++;
			soma += num;
		} while(num < num2); 
		  soma++;
		System.out.print("Soma: "+soma);
	}
}