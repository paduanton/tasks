package ifsul.repeticao;
import java.util.Scanner;
public class Q10 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		short h = 120;
		
		do {
			System.out.println(h);
			h += 3;
		} while(h < 202);
	}
}