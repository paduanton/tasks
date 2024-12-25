package ifsul.CalculadoraGeometrica;

import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calcula calcula = new Calcula();
        char operacao;

        System.out.print("Insira o valor 1: ");
        calcula.num1 = teclado.nextDouble();
        System.out.print("Insira o valor 2: ");
        calcula.num2 = teclado.nextDouble();

        System.out.print("Selecione a operacao (+, -, /, *): ");
        operacao = teclado.next().charAt(0);

        switch (operacao) {
            case '+':
                System.out.println(calcula.soma());
                break;
            case '-':
                System.out.println(calcula.sub());
                break;
            case '*':
                System.out.println(calcula.mult());
                break;
            case '/':
                System.out.println(calcula.div());
                break;
            default:
                System.err.println("OPERACAO INVALIDA!");
                break;
        }
    }

}
