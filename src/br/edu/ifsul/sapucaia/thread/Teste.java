package br.edu.ifsul.sapucaia.thread;

public class Teste {
    public static void main(String[] args) {
        Thread segundo = new Thread();
        Thread primeiro = new Thread();

        primeiro.setVar("TH1");
        primeiro.run();

        segundo.setRav("TH2");
        segundo.run();

        System.out.println(primeiro.getVar() + "\n" + segundo.getRav());
    }


}