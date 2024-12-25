package ifsul.decisao;
import java.util.Scanner;
public class Q41 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Quantos o INTER fez? ");
		int inter = teclado.nextInt();
		System.out.print("Quantos gols o GR�MIO marcou? ");
		int gremio = teclado.nextInt();
		
		if(inter > gremio) {
			System.out.print("\nINTERNACIONAL � O VENCEDOR");
		} else {
			if(inter < gremio) {
				System.out.print("\nGR�MIO � O VENCEDOR");
		    } else {
		    	System.out.print("\nEMPATE");	  
		      }
	      }
    }
}