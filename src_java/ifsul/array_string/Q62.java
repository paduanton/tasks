package ifsul.array_string;
import java.util.Scanner;
public class Q62 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		System.out.println("Digite 2 palavras");
		String p[] = new String[2];
		p[0] = t.next();
		p[1] = t.next();
		System.out.print("\nPalavra 1: "+p[0]+"\nPalavra 2: "+p[1]+"\n"
				+ "2� letra palavra 1: "+p[0].charAt(1)+"\n2� letra palavra 2: "+p[1].charAt(1));	
	}
}