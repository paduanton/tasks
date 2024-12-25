package ifsul.repeticao;
import java.util.Scanner;
public class Q42 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int maior = 0, menor = 0;
		
		System.out.println("Digite 3 valores inteiros");
		for(byte h = 0; h < 3; h++) {
			int num = tec.nextInt();
			
			if(h == 0) {
                maior = num-1;
                menor = num+1;
            } 
			if(maior < num){
                maior = num;
            } if(menor > num){
                menor = num;
              }
		}
		System.out.print("Maior n�mero: "+maior+"\nMenor n�mero: "+menor);
	}
}