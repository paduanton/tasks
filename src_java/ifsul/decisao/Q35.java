package ifsul.decisao;
import java.util.Scanner;
public class Q35 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double total;
		
		System.out.print("Insira a quantidade de ma��s compradas: ");
		int maca = teclado.nextInt();
		
		if(maca < 12) {
			total = maca * 0.80;
			System.out.print("\nVoc� comprou "+maca+" ma��s.\nO pre�o das ma��s � de R$0,80\nO valor gasto foi R$"+total);
		} else {
			total = maca * 0.50;
			System.out.print("\nVoc� comprou "+maca+" ma��s.\nO pre�o das ma��s � de R$0,50\nO valor gasto foi R$"+total);
		  }	
	}	
}