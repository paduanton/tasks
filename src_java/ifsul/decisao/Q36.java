package ifsul.decisao;
import java.util.Scanner;
public class Q36 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Quantos gols o INTER fez? ");
		int inter = teclado.nextInt();
		System.out.print("Quantos gols o GR�MIO marcou? ");
		int gremio = teclado.nextInt();
		
		if(inter > gremio) {
			System.out.println("\nINTERNACIONAL � O VENCEDOR\n\n      PLACAR\nINTER "+inter+" vs "+gremio+" GR�MIO\n\nO INTER fez "+(inter-gremio)+" gol(s)\n� mais que o GR�MIO.");
		} else {
			if(inter < gremio) {
				System.out.println("\nGR�MIO � O VENCEDOR\n\n      PLACAR\nINTER "+inter+" vs "+gremio+" GR�MIO\n\nO GR�MIO fez "+(gremio-inter)+" gol(s)\n� mais que o INTER.");
		    } else {
		    	System.out.println("\nEMPATE\n      PLACAR\nINTER "+inter+" vs "+gremio+" GR�MIO");	  
		      }
	      }
    }
}