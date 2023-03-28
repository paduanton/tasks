package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q31 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double valor2; String entrada;
		
		while(111 > 000) {
			System.out.print("--------------------------------------------------\nCALCULADORA\nInsira um n�mero: ");
			double valor1 = teclado.nextDouble();
			System.out.print("\n  - OPERA��ES POSS�VEIS -\n(+ | - | * | / | sqrt | pow)\nInsira a opera��o: ");
			entrada = teclado.next();
			
		    if(entrada.equalsIgnoreCase("sqrt") || entrada.equalsIgnoreCase("pow")) {
		    	if(entrada.equalsIgnoreCase("sqrt")) {
		    		System.out.print("\nRaiz quadrada("+valor1+"): "+Math.sqrt(valor1));
		    	} else {
		    		System.out.print("\nInsira a pot�ncia que deseja elevar o n�mero: ");
		    		valor2 = teclado.nextDouble();
		    		System.out.print(valor1+"^"+valor2+" = "+Math.pow(valor1, valor2));
		    	  }
		    } else {
		    	System.out.print("\nInsira o segundo n�mero: ");
		        valor2 = teclado.nextDouble();
		        
		        switch(entrada) {
		        case "*":
		        	System.out.print(valor1+" * "+valor2+" = "+valor1 * valor2);
		            break;
		        case "/":
		        	System.out.print(valor1+" / "+valor2+" = "+valor1 / valor2);
		            break;
		        case "+":
		        	System.out.print(valor1+" + "+valor2+" = "+valor1 + valor2);
		       	    break;
		        case "-":;
		        	System.out.print(valor1+" - "+valor2+" = "+(valor1 - valor2));
		       	    break;
		       	default:
		       		System.out.print("\nVOC� N�O INSERIU UMA OPERA��O V�LIDA");   	
		        }
		      }
		    System.out.print("\n--------------------------------------------------\nDeseja fazer outro c�lculo? ");
		    entrada = teclado.next();
            if(entrada.equalsIgnoreCase("sim")) {
	    		// 111 > 000
	    	} else {
	    		System.out.print("\nFIM DO PROGRAMA");
	    		System.exit(0);
	    	  }
		}
    }
}