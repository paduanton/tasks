package ifsul.decisao;
import java.util.Scanner;
public class Q45_Q46_Q47 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Insira a idade do  1� aluno (a): ");
		int aluno1 = teclado.nextInt();
		System.out.print("Insira a idade do  2� aluno (a): ");
		int aluno2 = teclado.nextInt();
		System.out.print("Insira a idade do  3� aluno (a): ");
		int aluno3 = teclado.nextInt();
		System.out.print("Insira a idade do  4� aluno (a): ");
		int aluno4 = teclado.nextInt();
		System.out.print("Insira a idade do  5� aluno (a): ");
		int aluno5 = teclado.nextInt();
		
		int media = (aluno1 + aluno2 + aluno3 + aluno4 + aluno5)/5;
		if(media < 25) {
			System.out.print("\n" + "Turma Jovem" + "\n" + "M�dia das idades: " + media + " anos" + "\n" + "\n" + "IDADE DOS ALUNOS" + "\n" + "O 1� aluno (a) tem " + aluno1 + " anos" + "\n" + "O 2� aluno (a) tem " + aluno2 + " anos" + "\n" + "O 3� aluno (a) tem " + aluno3 + " anos" + "\n" + "O 4� aluno (a) tem " + aluno4 + " anos" + "\n" + "O 5� aluno (a) tem " + aluno5 + " anos");
		} else {
			if(media >= 25 && media <= 40) {
				System.out.println("\n" + "Turma Adulta" + "\n" + "M�dia das idades: " + media + " anos" + "\n" + "\n" + "IDADE DOS ALUNOS" + "\n" + "O 1� aluno (a) tem " + aluno1 + " anos" + "\n" + "O 2� aluno (a) tem " + aluno2 + " anos" + "\n" + "O 3� aluno (a) tem " + aluno3 + " anos" + "\n" + "O 4� aluno (a) tem " + aluno4 + " anos" + "\n" + "O 5� aluno (a) tem " + aluno5 + " anos");
			} else {
				System.out.println("\n" + "Turma Idosa" + "\n" + "M�dia das idades: " + media + " anos" + "\n" + "\n" + "IDADE DOS ALUNOS" + "\n" + "O 1� aluno (a) tem " + aluno1 + " anos" + "\n" + "O 2� aluno (a) tem " + aluno2 + " anos" + "\n" + "O 3� aluno (a) tem " + aluno3 + " anos" + "\n" + "O 4� aluno (a) tem " + aluno4 + " anos" + "\n" + "O 5� aluno (a) tem " + aluno5 + " anos");
			  }
		  }
		
	}
}