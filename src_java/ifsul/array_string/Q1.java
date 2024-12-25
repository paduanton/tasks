package ifsul.array_string;
import java.util.Scanner;
public class Q1 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short[] num = new short[10];
		
		System.out.println("Informe 10 valores");
		for(byte h = 0; h <= 9; h++) {
			num[h] = t.nextShort();
		} 
		System.out.print("1� valor: "+num[0]+"\n5� valor"+num[4]);
	}
}