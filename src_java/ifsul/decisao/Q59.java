package ifsul.decisao;
import java.util.Scanner;
public class Q59 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("INSIRA A SIGLA DO ESTADO QUE VOC� MORA: ");
        String estado = teclado.next();
        
        switch(estado) {
        case "RS":
        	System.out.print("GA�CHO");
            break;
        case "RJ":
       	 System.out.print("CARIOCA");
            break;
        case "SP":
       	 System.out.print("PAULISTA");
       	 break;
        case "MG":
       	 System.out.print("MINEIRO"); 
       	 break;
       	 default:
      	 System.out.print("OUTRO ESTADO");   	
        }
    }
}