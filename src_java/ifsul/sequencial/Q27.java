package ifsul.sequencial;
import java.util.Scanner; 
public class Q27 { 
	public static void main(String[] args) { 
		Scanner	teclado	= new Scanner(System.in); 
		
		int dias, anos, meses, dias2; 
		
		System.out.println("Insira sua idade em dias"); 
		dias = teclado.nextInt(); 
		
		anos = dias / 365; 
		meses = (dias%365) / 30; 
		dias2 = (dias%365)%30; 
		
		System.out.println("Voc� tem " + anos + " anos " + meses + " meses e " + dias2 + " dias"); 
		
	}
	
}