package ifsul.sequencial;
import java.util.Scanner;
public class Q39 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double sminimo, qwatts;
		
		System.out.println("Qual o valor do sal�rio m�nimo?");
		sminimo = teclado.nextDouble();
		System.out.println("Quantos quilowatts foram gastos?");
		qwatts = teclado.nextDouble();
		
		double precoQW = (sminimo/7)/100, valor = qwatts*precoQW, nvalor = valor-(0.1*valor);
		
		System.out.println("O valor de cada quilowatts � R$" + precoQW + "\n" + "O valor total a ser pago � R$" + valor + "\n" + "O novo valor a ser pago com o desconto de 10% � R$" + nvalor);
		
	}
	
}