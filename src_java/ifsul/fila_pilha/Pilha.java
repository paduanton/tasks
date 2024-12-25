package ifsul.fila_pilha;

import static Fila_Pilha.Main.maxElemento;

import java.util.Scanner;

class Pilha {
    Scanner t = new Scanner(System.in);
    String H[] = new String[maxElemento];
    int topo = 0;

    void esvaziar() {

        System.out.println("pilha vazia");
        topo = 0;

    }

    void inserir() {

        if (topo == maxElemento)
            System.out.println("pilha cheia");

        else {

            System.out.print("elemento a ser inserido: ");
            String conjunto = t.next();
            H[topo] = conjunto;
            topo = topo + 1;

        }

    }

    void mostrar() {

        System.out.print("pihla: ");

        for (int i = 0; i < topo; i++)
            System.out.print(H[i] + "  ");

        System.out.print("\n");

    }

    void remover() {

        if (topo == 0)
            System.out.println("piha vazia");
        else
            topo = topo - 1;

    }


    void executar() {
        boolean executar = true;

        System.out.println("1 - inserir" +
                "\n2 - remover\n3 - esvaziar" +
                "\n4 - mostrar\n5 - parar\n");

        while (executar == true) {
            byte possibilidade = 0;

            while ((possibilidade < 1) || (possibilidade > 5)) {

                System.out.print("digite possibilidade: ");
                possibilidade = t.nextByte();
            }

            if (possibilidade == 1) inserir();
            if (possibilidade == 2) remover();
            if (possibilidade == 3) esvaziar();
            if (possibilidade == 4) mostrar();
            if (possibilidade == 5) executar = false;

            System.out.print("\n");

        }

    }

}