/**
 * Created by IntelliJ IDEA.
 * User: anton
 * Date: 11/11/2017
 * Time: 23:51
 */
package br.edu.ifsul.sapucaia.ProblemaDeJosephus;
/* PROBLEMA DE JOSEPHUS*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Lista listacircular = null;

        System.out.println("digite quantas pessoas tem no circulo e a ordem para elas serem removidas");
        int quantidade = t.nextInt();
        int ordem = t.nextInt();
        if (quantidade <= 1) {
            System.out.println("nao eh possivel pois deve restar 1");
        } else {
            listacircular = new Lista();
            listacircular.criaLista(quantidade);
            listacircular.imprimirLista(quantidade);
            listacircular.remover(ordem);

            int posicao = listacircular.ultimo();
            System.out.println(posicao + " é a posicao que Josephus esta");
        }
        t.close();
    }
}
