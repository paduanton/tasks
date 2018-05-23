package br.edu.ifsul.sapucaia.fila_pilha;

import java.util.Scanner;

import static br.edu.ifsul.sapucaia.fila_pilha.Main.maxElemento;

class Fila {
    Scanner t = new Scanner(System.in);

    String H[] = new String[maxElemento];
    int tamFila = 0;


    void mostrar() {

        System.out.print("fila: ");
        for (int i = 0; i < tamFila; ++i)
            System.out.print(H[i] + " ");

        System.out.print("\n");

    }

    void esvaziar() {
        System.out.println("fila limpa");
        tamFila = 0;

    }

    void remover() {

        if (tamFila == 0) {
            System.out.println("fila vazia: ");
        } else if (tamFila == 1) {
            tamFila = 0;
        } else if (tamFila > 1) {
            for (int i = 0; i < (tamFila - 1); ++i) {
                H[i] = H[i + 1];
            }
            tamFila--;
        }

    }

    void inserir() {
        if (tamFila == maxElemento) {
            System.out.println("fila cheia");
        } else {
            System.out.print("inserir elemento: ");
            H[tamFila] = t.next();
            tamFila++;
        }
    }


    void executar() {
        boolean executar = true;

        System.out.println("1 - inserir\n2 -r emover:\n" +
                "3 - mostrar\n4 - esvaziar\n5 - parar\n");

        while (executar == true) {

            byte possibilidade = 0;

            while ((possibilidade < 1) || (possibilidade > 5)) {

                System.out.print("digite possibilidade: ");
                possibilidade = t.nextByte();
            }

            if (possibilidade == 1) inserir();
            else if (possibilidade == 2) remover();
            else if (possibilidade == 3) mostrar();
            else if (possibilidade == 4) esvaziar();
            else executar = false;

            System.out.print("\n");
        }
    }
}