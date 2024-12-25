package ifsul.decisao;
import java.util.Scanner;
public class Q67 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("INSIRA O M�S ATUAL: ");
        int mes = teclado.nextInt();
        
     switch (mes) {
     
     case 1:
    	 System.out.print("JANEIRO");
         break;
     case 2:
    	 System.out.print("FEVEREIRO");
         break;
     case 3:
    	 System.out.print("MAR�O");
    	 break;
     case 4:
    	 System.out.print("ABRIL"); 
     case 5:
    	 System.out.print("MAIO");
         break;
     case 6:
    	 System.out.print("JUNHO");
         break;
     case 7:
    	 System.out.print("JULHO");
    	 break;
     case 8:
    	 System.out.print("AGOSTO"); 
    	 break;
     case 9:
    	 System.out.print("SETEMBRO");
         break;
     case 10:
    	 System.out.print("OUTUBRO");
         break;
     case 11:
    	 System.out.print("NOVEMBRO");
    	 break;
     case 12:
    	 System.out.print("DEZEMBRO"); 
    	 break;
    default:
   	 System.out.print("M�S INV�LIDO");
    	
     }
  }
}
