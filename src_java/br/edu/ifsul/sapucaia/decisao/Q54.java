package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q54 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("JOGO DA ADVINHA��O (N�MEROS)\nO jogador 1 deve indicar um n�mero (inteiro) para  o jogador 2 tentar acertar.\nO jogador 2 ter� 3 chances para acertar o n�mero indicado, e receber� dicas sempre que errar.\n\n- Jogador 1\nINDIQUE UM N�MERO: ");
		int indicacao = teclado.nextInt();
		System.out.print(".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n- Jogador 2 - Chance 1\nQual o n�mero secreto? ");
		int tentativa = teclado.nextInt();
	
		if(tentativa > indicacao) {
			System.out.print("\n- Jogador 2 - Chance 2\nO N�MERO SECRETO � MENOR\nInsira o n�mero secreto: ");
			tentativa = teclado.nextInt();
		} else if(tentativa < indicacao) {
			System.out.print("\n- Jogador 2 - Chance 2\nO N�MERO SECRETO � MAIOR\nInsira o n�mero secreto: ");
			tentativa = teclado.nextInt();
		} if(tentativa > indicacao) {
			System.out.print("\n- Jogador 2 - �ltima Chance\nO N�MERO SECRETO � MENOR\nDigite o n�mero secreto: ");
			tentativa = teclado.nextInt();
		} else if(tentativa < indicacao) {
			System.out.print("\n- Jogador 2 - �ltima Chance\nO N�MERO SECRETO � MAIOR\nDigite o n�mero secreto: ");
			tentativa = teclado.nextInt();
		} if(tentativa == indicacao) {
			System.out.print("\nParab�ns! Voc� acertou o n�mero secreto!");
		} if(tentativa != indicacao) {
			System.out.print("\nACABARAM SUAS CHANCES");
		} 
   }
}