package ifsul.decisao;
import java.util.Scanner;
public class Q51 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		double maca, morango, desconto, total, frutas;
		System.out.println("Qual a quantidade (em Kg) de morangos adquiridos?");
		morango = teclado.nextDouble();
		System.out.println("Qual a quantidade (em Kg) de ma��s adquiridas?");
		maca = teclado.nextDouble();
		
		frutas = maca + morango;
		if(morango > 0 && morango <= 5) {
			morango = morango * 5;	
		} else {
			morango = morango * 4; 
		} if(maca > 0 && maca <= 5) {
			maca = maca * 3; 	
		} else {
			maca = maca * 2;
		  }
		total = maca + morango;	
		if (frutas > 8 || total > 35) {
			desconto = total - (0.2 * total);
			System.out.println("O valor das ma��s � R$" + maca + "\nO valor dos morangos � R$" + morango + "\n" + "O valor total � R$" + total + "\n" + "Com desconto de 20% fica R$" + desconto);
	
		} else {
			System.out.println("O valor das ma��s � R$" + maca + "\nO valor dos morangos � R$" + morango + "\n" + "O valor total � R$" + total);
		}
			
		}
	}