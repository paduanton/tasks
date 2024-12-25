package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q80 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		System.out.println("DIGITE UMA FRASE");
		String frase = t.nextLine();
		
		// replaceAll para String, utilizando " ao inv�s de '
		frase = frase.replace('a', 'x'); 
		frase = frase.replace('e', 'y');
		frase = frase.replace('i', 'w'); 
		frase = frase.replace('o', 'k');
		frase = frase.replace('u', 'z');
		
		System.out.print("FRASE CRIPTOGRAFADA\n"+frase);
	}
}
/*
 * a) A - X
 * b) E - Y
 * c) I - W
 * d) O - K
 * e) U - Z
 */