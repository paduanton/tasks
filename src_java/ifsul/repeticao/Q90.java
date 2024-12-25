package ifsul.repeticao;
import java.util.Scanner;
public class Q90 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int h = 0; short senha = 0;
		
		do {
			System.out.print("Insira a senha: ");
			senha = tec.nextShort();
			h++;
			if(senha != 2015)
				System.out.println("SENHA INV�LIDA\n");
		} while(senha != 2015);
		
		System.out.print("\nACESSO PERMITIDO\nSenha digitada "+h+" vezes");
	}
}