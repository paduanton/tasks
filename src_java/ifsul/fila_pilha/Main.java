package br.edu.ifsul.sapucaia.fila_pilha;

import java.util.Scanner;

class Main {
    static int maxElemento = 500;

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Pilha pilha = new Pilha();
        Fila fila = new Fila();

        int tipoEstrutura = 0;

        while (tipoEstrutura != 9) {

            System.out.println("7 - PILHA\n8 - FILA\n9 - SAIR\n");

            System.out.print("Estrutura: ");
            tipoEstrutura = t.nextInt();

            if (tipoEstrutura == 7) {
                pilha.executar();
            } else if (tipoEstrutura == 8) {
                fila.executar();
            } else if (tipoEstrutura == 9) {
                break;
            } else {
                System.out.println("opcao 9 kk eae men");
            }

        }
    }
}