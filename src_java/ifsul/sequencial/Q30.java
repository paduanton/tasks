package ifsul.sequencial;
import java.util.Scanner;
public class Q30 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double odometroI, odometroF, combustivel, valor;
		
		System.out.println("Qual a marca��o do odometro (Km) no in�cio do dia?");
		odometroI = teclado.nextDouble();
		System.out.println("Quantos litros de combust�vel foram gastos?");
		combustivel = teclado.nextDouble();
		System.out.println("Qual o valor (R$) recebido dos passageiros?");
		valor = teclado.nextDouble();
		System.out.println("Qual a marca��o do odometro (Km) no final do dia?");
		odometroF = teclado.nextDouble();
		
		double media = (odometroF - odometroI) / combustivel, lucro = valor - (combustivel * 2.50);
		
		System.out.println("A m�dia do seu consumo � " + media + "Km/L" + "\n" + " O seu lucro l�quido foi de R$" + lucro);
		
	}
}
