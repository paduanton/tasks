package br.edu.ifsul.sapucaia.arvore;

public class Arvore extends EstruturaArvore {

    @Override
    public boolean remove(int valor) {
        No noArvore = pesquisa(valor);

        if (noArvore == null) return false;

        if (noArvore.ehFolha()) {
            remocaoFolha(noArvore);
        } else {
            boolean possuiDoisFilhos = noArvore.getfilhoEsquerdo() != null && noArvore.getfilhoDireito() != null;

            if (possuiDoisFilhos) {
                remocaoComDoisFilhos(noArvore);
            } else {
                remocaoFilhoUnico(noArvore);
            }
        }

        return true;
    }

    private void remocaoFolha(No noArvore) {
        No pai = noArvore.getPai();

        if (noArvore.ehMenorQue(pai))
            pai.setfilhoEsquerdo(null);
        else
            pai.setfilhoDireito(null);

    }

    private void remocaoComDoisFilhos(No noArvore) {
        No novoFilho = sucessor(noArvore);
        remove(novoFilho.getValor());
        noArvore.setValor(novoFilho.getValor());
    }

    private void remocaoFilhoUnico(No noArvore) {
        No pai = noArvore.getPai();
        No filho;

        if (noArvore.getfilhoEsquerdo() != null)
            filho = noArvore.getfilhoEsquerdo();
        else
            filho = noArvore.getfilhoDireito();

        if (filho.ehMenorQue(pai))
            pai.setfilhoEsquerdo(filho);
        else
            pai.setfilhoDireito(filho);

    }

    void insere(int valor) {
        No no = new No(valor);
        No raiz = this.getRaiz();

        if (raiz == null) {
            this.setRaiz(no);
            return;
        }

        insere(raiz, no);
    }

    private void insere(No pai, No filho) {

        if (filho.ehMenorQue(pai)) {

            if (pai.getfilhoEsquerdo() == null) {
                pai.setfilhoEsquerdo(filho);
                filho.setPai(pai);
            } else
                insere(pai.getfilhoEsquerdo(), filho);

        } else if (pai.getfilhoDireito() == null) {
            pai.setfilhoDireito(filho);
            filho.setPai(pai);
        } else
            insere(pai.getfilhoDireito(), filho);

    }

    @Override
    public No pesquisa(int valor) {

        No raiz = this.getRaiz();

        if (raiz == null)
            return null;

        if (raiz.getValor() == valor)
            return raiz;

        if (raiz.ehMaiorOuIgualQue(valor))
            return pesquisa(raiz.getfilhoEsquerdo(), valor);
        else
            return pesquisa(raiz.getfilhoDireito(), valor);

    }

    private No pesquisa(No pai, int valor) {

        if (pai == null)
            return null;

        if (pai.ehIgualA(valor))
            return pai;

        if (pai.ehMaiorOuIgualQue(valor))
            return pesquisa(pai.getfilhoEsquerdo(), valor);
        else
            return pesquisa(pai.getfilhoDireito(), valor);
    }


    @Override
    public int alturaNO(No noArvore) {
        No raiz = this.getRaiz();

        if (raiz == null || noArvore == null) return -1;

        if (raiz.ehIgualA(noArvore)) return 0;

        int altura = 0;
        No no = noArvore;

        do {
            no = no.getPai();

            if (no == null) break;
            else altura++;

        } while (true);

        return altura;
    }

    @Override
    public String toString() {

        return this.leituraOrdem(this.getRaiz());
    }

    //pesquisa em ordem
    private String leituraOrdem(No noArvore) {
        if (noArvore == null)
            return "";

        return
                this.leituraOrdem(noArvore.getfilhoEsquerdo()) + " - " +
                        String.valueOf(noArvore.getValor()) + "" + this.leituraOrdem(noArvore.getfilhoDireito());
    }

    @Override
    public No sucessor(No noArvore) {
        if (noArvore == null) return null;

        No ramoDireita = noArvore.getfilhoDireito();

        if (ramoDireita != null) {
            No filhoEsquerda = ramoDireita.getfilhoEsquerdo();

            if (filhoEsquerda == null) return ramoDireita; //Caso o ramo nao tenha filho na esquerda, retorna ele mesmo.

            do {

                if (filhoEsquerda.getfilhoEsquerdo() == null) //Se não tem mais filhos, retorna
                    return filhoEsquerda;
                else
                    filhoEsquerda = filhoEsquerda.getfilhoEsquerdo(); //Caso tenha, procura o proximo filho na esquerda.

            } while (true);

        } else //Se nao tiver ramo na direita, retorna o primeiro acima do nó (pai).
            return noArvore.getPai();
    }

}
