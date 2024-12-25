package ifsul.decisao;
import java.util.Scanner;
public class Q48 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contagem = 0;
		
		System.out.print("INTERROGAT�RIO - Responda 'SIM' ou 'N�O' as perguntas.");
		System.out.print("\n" + "\n" + "Telefonou para a v�tima? ");
		String pergunta1 = teclado.next();
		System.out.print("Esteve no local do crime? ");
		String pergunta2 = teclado.next();
		System.out.print("Mora perto da v�tima? ");
		String pergunta3 = teclado.next();
		System.out.print("Devia algo para a v�tima? ");
		String pergunta4 = teclado.next();
		System.out.print("J� trabalhou com a v�tima? ");
		String pergunta5 = teclado.next();
		
	     	if (pergunta1.equalsIgnoreCase("sim")) {
			contagem = 1;} if (pergunta2.equalsIgnoreCase("sim")) {
			contagem = contagem + 1;} if (pergunta3.equalsIgnoreCase("sim")) {
			contagem = contagem + 1;} if (pergunta4.equalsIgnoreCase("sim")) {
			contagem = contagem + 1;} if (pergunta5.equalsIgnoreCase("sim")) {
			contagem = contagem + 1;}		

		if (contagem == 5) {
			System.out.print("\nClassifica��o do interrogado: ASSASSINO");
		} if (contagem == 0 || contagem == 1) {
		        System.out.print("\nClassifica��o do interrogado: INOCENTE");
		    } if (contagem == 2) {
		    	  System.out.print("\nClassifica��o do interrogado: SUSPEITO");
		    } if (contagem == 3 || contagem == 4) {
		    	  System.out.print("\nClassifica��o do interrogado: C�MPLICE");
		    }
  }
}