package ifsul.decisao;
import java.util.Scanner;
public class Q23 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Quanto gastou em bebida? R$");
		double gasto1 = teclado.nextInt();
		System.out.print("Qual foi o gasto com comida? R$");
		double gasto2 = teclado.nextInt();
		
		gasto1 = gasto1 + gasto2; gasto2 = gasto1+(gasto2 = 0.1*gasto1);
		System.out.print("\nValor total: R$"+gasto1+"\nValor total c/ gorjeta do gar�om: R$"+gasto2);
	}
}