package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q42 {
	public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	double hora, valor;
	
	System.out.println("Insira a hora.");
	hora = teclado.nextDouble();
	
    valor = hora * 60;
    
    System.out.println("Passaram " + valor + " minutos desde o in�cio do dia.");
    
	
	}

}
