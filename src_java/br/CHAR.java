package br;

import java.io.IOException;
import java.util.Scanner;
public class CHAR {
    public static void main(String[] args) throws IOException {
        Scanner t = new Scanner(System.in);

        System.out.println("TESTE");
        char c = (char)System.in.read();  // sintaxe char I - classe io
        char a = t.next().charAt(0);  // sixtaxe char II - classe Scanner

        if(a == 'a' && c == 'c' ) {  // comparar como números
            System.out.println("COMPARAÇÃO");
        }
    }
}
