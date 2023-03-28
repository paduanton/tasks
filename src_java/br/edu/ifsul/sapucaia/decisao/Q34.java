package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q34 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
;
		System.out.print("DIGITE UM N�MERO: ");
		int x = teclado.nextInt();
		 if (x == 5) { 
			 System.out.print("O n�mero digitado � igual a 5."); 
		 } else { 
			 if (x == 200) { 
				 System.out.print("O n�mero digitado � igual a 200.");
		      } else { 
		    	  if (x == 400) { 
		    		  System.out.print("O n�mero digitado � igual a 400.");
		    		  } else {
		    			  if (x >= 500 && x <= 1000) { 
		    				  System.out.print("O n�mero digitado est� entre 500 e 1000.");
		    				  } else {
		    					  System.out.print("O n�mero digitado � diferente de 5, 200, 400 e n�o est� no intervalo entre 500 e 1000.");
		    					  }
		            }
		        }
		 }

	}
}