package ifsul.decisao;
import java.util.Scanner;
public class Q24 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Qual a capital do Brasil? ");
		String capital = teclado.next();
		
		if(capital.equalsIgnoreCase("Bras�lia")) {
			System.out.print("\nParab�ns! Voc� acertou!");
		} else {
			System.out.print("\nVOC� ERROU. Tem mais duas chances para acertar.\nDICA: O nome da cidade come�a com a letra 'B' e termina com a letra 'A'.\nInsira a capital do Brasil: ");
			capital = teclado.next();
			if(capital.equalsIgnoreCase("Bras�lia")) {
				System.out.print("\nParab�ns! Voc� acertou!");
		    } else {
		    	System.out.print("\nVOC� ERROU NOVAMENTE. Tem mais uma chance para acertar.\nDICA: As 5 primeiras letras da capital s�o 'Bras�...'\nDigite a capital do Brasil: ");
			    capital = teclado.next();
			    if(capital.equalsIgnoreCase("Bras�lia")) {
			    	System.out.print("\nParab�ns! Voc� acertou!");
			    } else {
			    	System.out.print("\nVOC� ERROU PELA TERCEIRA VEZ, N�O TER� MAIS CHANCES PARA ACERTAR.");
			      }
		      }
		  }
    }
}