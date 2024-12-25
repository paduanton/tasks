package ifsul.desafio;
import java.util.Scanner;
public class INVERTER {
	public static void main(String[] args) {
		Scanner t = new Scanner (System.in);
		
		long Ninvertido = 0;
		System.out.print("INSIRA O NUMERO DE UMA CORRENTE: ");
		long conta = t.nextLong();

		while(conta > 0) {  
                    Ninvertido *= 10;  
                    Ninvertido += (conta%10);  
                    conta /= 10;  
                    System.out.print("\nNUMERO DA CONTA INVERTIDO: "+Ninvertido);
                } 
				
	}
}

