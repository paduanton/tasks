package ifsul.decisao;
import java.util.Scanner;
public class Q21 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("DIGITE O SEU ANO DE NASCIMETO: ");
		int nascimento = teclado.nextInt();
		System.out.print("INSIRA O ANO ATUAL: ");
		int ano = teclado.nextInt();
		
		if(nascimento <= 0 || nascimento > ano) {
			System.out.print("\nVOC� N�O INSERIU UM ANO DE NASCIMENTO V�LIDO");
		} else {
			ano = ano - nascimento;
			System.out.print("\nIDADE: "+ano);
		  }
	}
}