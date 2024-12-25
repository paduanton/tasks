package ifsul.decisao;
import java.util.Scanner;
public class Q43 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Digite seu nome: ");
		String nome = teclado.nextLine();
		System.out.print("" + "\n" +"INSIRA SUA NOTA NA PRIMEIRA AVALIA��O: ");
		double nota1 = teclado.nextDouble();
		System.out.print("INSIRA SUA NOTA NA SEGUNDA AVALIA��O: ");
		double nota2 = teclado.nextDouble();
		System.out.print("INSIRA SUA NOTA NA TERCEIRA AVALIA��O: ");
		double nota3 = teclado.nextDouble();
		System.out.print("\n" + "Voc� ganhou alguma nota 'b�nus' que ser� acrescentada na m�dia? ");
		String bonus = teclado.next();
		
	    if (bonus.equalsIgnoreCase("sim")) {
	    	System.out.print("Insira sua nota b�nus: ");
	    	double notab = teclado.nextDouble(); 
	    	double media = (nota1 + nota2 + nota3)/3 + notab;
	    	if (media < 6 && media >= 0) {
	    		System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Reprovado, faltou o estudo!");
	    	} else {
	    		if (media >= 6 && media < 7) {
	    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Recupera��o, pode melhorar.");
	    		} if (media >= 7 && media < 8.1) {
	    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Aprovado");
	    		} if (media >= 8.1 && media < 9.8) {
	    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Aprovado, mas n�o ganha coxinha. ;D");
	    		} if (media >= 9.8 && media < 10) {
	    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Aprovado, levando a cozinha no final do semestre. =D");
	    		} if (media > 10) {
	    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: 10 " + "\n" + "Aprovado, levando a coxinha no final do semestre. =D");
	    		} if(media < 0) {
	    			System.out.println("NOTA INV�LIDA");
	    		} if (media == 10) {
     	    		  System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: 10 " + "\n" + "Aprovado, levando a coxinha no final do semestre. =D");
	    		}
	    	}
	    } else {
	    	if (bonus.equalsIgnoreCase("n�o")) {
		    	double media = (nota1 + nota2 + nota3)/3;
		    	if (media < 6 && media >= 0) {
		    		System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Reprovado, faltou o estudo!");
		    	} else {
		    		if (media >= 6 && media < 7) {
		    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Recupera��o, pode melhorar.");
		    		} if (media >= 7 && media < 8.1) {
		    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Aprovado");
		    		} if (media >= 8.1 && media < 9.8) {
		    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Aprovado, mas n�o ganha coxinha. ;D");
		    		} if (media >= 9.8 && media < 10) {
		    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: " + media + " (se o n�mero tiver muitas casas decimais, considere somente a primeira)" + "\n" + "Aprovado, levando a cozinha no final do semestre. =D");
		    		} if (media > 10) {
		    			System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: 10 " + "\n" + "Aprovado, levando a coxinha no final do semestre. =D");
		    		} if(media < 0) {
		    			System.out.println("NOTA INV�LIDA");
		    		} if (media == 10) {
	     	    		  System.out.print("\n" + "Aluno: " + nome + "\n" + "M�dia: 10 " + "\n" + "Aprovado, levando a coxinha no final do semestre. =D");
		    		}
		    	}
		  }
	    }   
  }
}