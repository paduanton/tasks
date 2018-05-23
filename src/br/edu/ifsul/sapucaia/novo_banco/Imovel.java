package br.edu.ifsul.sapucaia.novo_banco;

public class Imovel {
    private int tamanho;
    private double valor;
    private int nroDonos;
    private String construtora;
    private String endereco;

    public String getEndereço() {
        return this.endereco;
    }

    public void setEndereço(String endereco) {
        if (endereco.length() > 0) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("Defina um nome a construtora!");
        }
    }

    public String getConstrutora() {
        return construtora;
    }

    public void setConstrutora(String construtora) {
        if (construtora.length() > 0) {
            this.construtora = construtora;
        } else {
            throw new IllegalArgumentException("Defina um nome a construtora!");
        }
    }

    public int getNroDonos() {
        return nroDonos;
    }

    public void setNroDonos(int nroDonos) throws IllegalArgumentException {
        if (nroDonos >= 0) {
            this.nroDonos = nroDonos;
        } else {
            throw new IllegalArgumentException("Tamanho negativo!");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) throws IllegalArgumentException {
        if (tamanho > 0) {
            this.tamanho = tamanho;
        } else {
            throw new IllegalArgumentException("Tamanho negativo!");
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws IllegalArgumentException {
        if (tamanho > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("Valor negativo!");
        }
    }
}