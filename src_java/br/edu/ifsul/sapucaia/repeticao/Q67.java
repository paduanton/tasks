package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q67 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int maior = 0, menor = 0;
		
		System.out.println("Digite 10 valores: ");
		for(byte h = 0; h < 10; h++) {
			int num = tec.nextInt();
			
			if(h == 0) {
				menor = num;
			} if(num > maior){
                maior = num;
            } if(num < menor){
                menor = num;
              }
		}
		System.out.print("Maior n�mero: "+maior+"\nMenor n�mero: "+menor);
	}
}