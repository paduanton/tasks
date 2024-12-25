package ifsul.array_string;
import java.util.Scanner;
public class Q61 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		System.out.println("INSIRA UMA FRASE ");
		String frase = t.nextLine();
	
		StringBuffer inversao = new StringBuffer(frase);  
		inversao = inversao.reverse();  
		System.out.print("\nFrase invertida\n"+inversao);
	}
}
