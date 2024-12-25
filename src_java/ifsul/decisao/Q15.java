package ifsul.decisao;
import java.util.Scanner;
public class Q15 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("DIGITE UM N�MERO: ");
		int x = teclado.nextInt();
		System.out.print("DIGITE O SEGUNDO N�MERO: ");
		int x2 = teclado.nextInt();
		System.out.print("DIGITE O TERCEIRO N�MERO: ");
		int x3 = teclado.nextInt();
		System.out.print("DIGITE O �LTIMO N�MERO: ");
		int x4 = teclado.nextInt();
		
		int soma = x + x2; int soma2 = x3 + x4;
		if (soma == soma2) {
			System.out.print("\nVALORES\n"+x+" | "+x2+" | "+x3+" | "+x4+"\n\nSOMA DOS DOIS PRIMEIROS: "+soma+"\nSOMA DOS DOIS �LTIMOS: "+soma2);
		} else {
			if(soma % 2 == 0) {
				if(soma2 % 2 == 0) {
					System.out.print("\nVALORES\n"+x+" | "+x2+" | "+x3+" | "+x4+"\n\nSOMA DOS DOIS PRIMEIROS: PAR\nSOMA DOS DOIS �LTIMOS: PAR");
			    } else {
			    	System.out.print("\nVALORES\n"+x+" | "+x2+" | "+x3+" | "+x4+"\n\nSOMA DOS DOIS PRIMEIROS: PAR\nSOMA DOS DOIS �LTIMOS: �MPAR");
			      }
		    } else {
		    	if(soma2 % 2 == 0) {
		    		System.out.print("\nVALORES\n"+x+" | "+x2+" | "+x3+" | "+x4+"\n\nSOMA DOS DOIS PRIMEIROS: �MPAR\nSOMA DOS DOIS �LTIMOS: PAR");
		    	} else {
		    		System.out.print("\nVALORES\n"+x+" | "+x2+" | "+x3+" | "+x4+"\n\nSOMA DOS DOIS PRIMEIROS: �MPAR\nSOMA DOS DOIS �LTIMOS: �MPAR");
		    	  }
		      }
		  }
	}
}