package ifsul.array_string;
import java.util.Scanner;
public class Q66 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		System.out.print("Digite uma palavra: ");
		String palavra = t.next();
		System.out.print("Digite outra palavra: ");
		String palavra1 = t.next();
		
		int comp = palavra.compareToIgnoreCase(palavra1);
		
		if(comp == 0) {  // palavra.equalsIgnoreCase(palavra1)
			System.out.print("\nAs palavras s�o iguais");
		} else {
			System.out.print("\nAs palavras s�o diferentes");
		  }
	}
}

// Fa�a um programa que l� duas palavras e verificar se as mesmas s�o iguais.