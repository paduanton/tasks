package ifsul.decisao;
import java.util.Scanner;
public class Q20 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("DIGITE SUA IDADE: ");
		int idade = teclado.nextInt();
		
		if(idade >= 18 && idade <= 67) {
			System.out.print("\nSua idade: "+idade+"\nPara doar sangue � necess�rio ter entre 18 e 67 anos\nVoc� pode doar sangue =D");
		} else {
			System.out.print("\nSua idade: "+idade+"\nPara doar sangue � necess�rio ter entre 18 e 67 anos\nVoc� n�o pode doar sangue =(");
		  }
	}
}