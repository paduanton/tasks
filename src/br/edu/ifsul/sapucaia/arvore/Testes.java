
package br.edu.ifsul.sapucaia.arvore;

public class Testes {


    public static void main(String args[]) {
        System.out.println(TestInserir01());
        System.out.println(TestInserir02());
        System.out.println(TestAlturaNo());
        System.out.println(TestSucessor());
        System.out.println(TestRemove01());
        System.out.println(TestRemove02());
        System.out.println(TestRemove03());

    }

    //0.2 pontos
    public static boolean TestInserir01() {
        Arvore a = new Arvore();
        a.insere(20);
        a.insere(10);
        a.insere(5);
        a.insere(12);
        a.insere(17);
        a.insere(3);
        a.insere(8);
        a.insere(4);
        return a.toString().equals(" - 3 - 4 - 5 - 8 - 10 - 12 - 17 - 20");
    }

    //0.2 pontos
    public static boolean TestInserir02() {
        Arvore a = new Arvore();
        a.insere(1);
        a.insere(2);
        a.insere(3);
        a.insere(4);
        a.insere(9);
        a.insere(1);
        a.insere(2);
        a.insere(3);
        return a.toString().equals(" - 1 - 1 - 2 - 2 - 3 - 3 - 4 - 9");
    }

    //0.4 pontos
    public static boolean TestAlturaNo() {
        Arvore a = new Arvore();
        a.insere(10);
        a.insere(8);
        a.insere(9);
        a.insere(5);
        a.insere(11);
        a.insere(4);
        a.insere(5);
        a.insere(1);
        a.insere(14);

        if (a.alturaNO(a.pesquisa(10)) != 0)
            return false;

        if (a.alturaNO(a.pesquisa(8)) != 1)
            return false;

        if (a.alturaNO(a.pesquisa(9)) != 2)
            return false;

        if (a.alturaNO(a.pesquisa(5)) != 2)
            return false;

        if (a.alturaNO(a.pesquisa(11)) != 1)
            return false;

        if (a.alturaNO(a.pesquisa(12)) != -1)
            return false;

        return true;
    }

    //0.3
    public static boolean TestSucessor() {
        Arvore a = new Arvore();
        a.insere(15);
        if (a.sucessor(a.getRaiz()) != null)
            return false;
        a.insere(8);
        a.insere(17);
        a.insere(6);
        a.insere(11);
        a.insere(10);
        a.insere(9);


        if (a.sucessor(a.pesquisa(11)).getValor() != 8)
            return false;

        else if (a.sucessor(a.pesquisa(6)).getValor() != 8)
            return false;

        else if (a.sucessor(a.pesquisa(8)).getValor() != 9)
            return false;

        else if (a.sucessor(a.pesquisa(10)).getValor() != 11)
            return false;

        else if (a.sucessor(a.pesquisa(17)).getValor() != 15)
            return false;

        return true;
    }

    //0.3 pontos
    public static boolean TestRemove01() {
        Arvore a = new Arvore();
        a.insere(5);
        a.insere(2);
        a.insere(3);
        a.insere(1);
        a.insere(7);
        a.insere(6);
        a.insere(8);
        a.remove(1);
        a.remove(6);
        if (!a.toString().equals(" - 2 - 3 - 5 - 7 - 8"))
            return false;

        if (a.remove(12) != false)
            return false;

        return true;

    }

    //0.4 pontos
    public static boolean TestRemove02() {
        Arvore a = new Arvore();
        a.insere(5);
        a.insere(2);
        a.insere(3);
        a.insere(1);
        a.insere(7);
        a.insere(6);
        a.insere(8);
        a.insere(4);
        a.remove(3);
        if (!a.toString().equals(" - 1 - 2 - 4 - 5 - 6 - 7 - 8"))
            return false;

        a.insere(10);
        a.insere(9);
        a.remove(10);
        if (!a.toString().equals(" - 1 - 2 - 4 - 5 - 6 - 7 - 8 - 9"))
            return false;


        return true;

    }

    //0.4 pontos
    public static boolean TestRemove03() {
        Arvore a = new Arvore();
        a.insere(15);
        a.insere(8);
        a.insere(11);
        a.insere(10);
        a.insere(9);
        a.insere(6);
        a.insere(17);
        a.insere(18);
        a.remove(8);

        if (!a.toString().equals(" - 6 - 9 - 10 - 11 - 15 - 17 - 18"))
            return false;

        a.remove(15);
        if (!a.toString().equals(" - 6 - 9 - 10 - 11 - 17 - 18"))
            return false;

        a.remove(11);
        if (!a.toString().equals(" - 6 - 9 - 10 - 17 - 18"))
            return false;


        return true;

    }
}
