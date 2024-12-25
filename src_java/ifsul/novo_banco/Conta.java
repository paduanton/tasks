package ifsul.novo_banco;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) throws IllegalArgumentException {
        if (titular.equals("")) {
            throw new IllegalArgumentException("O titular não é válido (campo vazio)");
        } else
            this.titular = titular;
    }

    public int getNumero() throws IllegalArgumentException {
        return this.numero;
    }

    public void setNumero(int valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Número inválido");
        } else
            this.numero = valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) throws IllegalArgumentException {
        if (saldo <= 0) {
            throw new IllegalArgumentException("Saldo inválido");
        } else
            this.saldo = saldo;
    }

    public Conta() {  // construtor padrão
        saldo = 0;
        numero = 0;
        titular = "";
    }

    public Conta(String titular, int numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            if (valor <= 1600) {   // $1600 é o máximo que pode ser sacado!!
                this.saldo = this.saldo - valor;
                System.out.println("Saque efetuado com sucesso.");
            } else {
                throw new IllegalArgumentException("Não é possível sacar um valor maior que R$1600,00\n");
            }
        } else {
            throw new IllegalArgumentException("O saldo não é suficiente");
        }
    }

    public void depositar(double deposito) {
        if (this.saldo < deposito) {
            throw new IllegalArgumentException("Depósito não pôde ser efetuado.");
        } else {
            throw new IllegalArgumentException("Depósito efetuado com sucesso.");
        }
    }
}