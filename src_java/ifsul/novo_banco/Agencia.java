package ifsul.novo_banco;

import java.util.Scanner;

public class Agencia {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Conta conta1 = new Conta();
        Conta conta2 = new Conta("Antonio Júnior", 4976, 4000.35);
        try {
            conta1.setNumero(6794);
            conta1.setTitular("Natália Pintos da Silva");
            conta1.setSaldo(3500.40);

            System.out.print("\nNúmero da conta 1: " + conta1.getNumero());
            System.out.print("\nTitular 1: " + conta1.getTitular());
            System.out.print("nSaldo atual 1 : R$" + conta1.getSaldo());
            System.out.print("\nVocê pode sacar no máximo R$1600\n");

            conta1.sacar(1100);
            System.out.print(conta1.getTitular() + " sacou R$1100,00");
            System.out.print("\nNovo Saldo: R$" + conta1.getSaldo());
            System.out.println("\nDeseja efetuar um depósito?   1 - Sim  2 - Não");
            byte escolha = t.nextByte();
            if (escolha == 1) {
                System.out.print("\nQual quantia deseja depositar?");
                double quantiaDeposito = t.nextDouble();
                conta1.depositar(quantiaDeposito);
            }
            System.out.println("\n------------------------------------------------\nConta 2");
            System.out.print("\nNúmero da conta 2: " + conta2.getNumero());
            System.out.print("\nTitular 2: " + conta2.getTitular());
            System.out.print("\nSaldo atual1 : R$" + conta2.getSaldo());
            System.out.print("\nVocê pode sacar no máximo R$1600\n");

            conta2.sacar(1800);
            System.out.print(conta2.getTitular() + " sacou R$1800,00");
            System.out.print("\nNovo Saldo: R$" + conta2.getSaldo());
            System.out.println("\nDeseja efetuar um depósito?   1 - Sim  2 - Não");
            escolha = 0;
            escolha = t.nextByte();
            if (escolha == 1) {
                System.out.print("\nQual quantia deseja depositar?");
                double quantiaDeposito = t.nextDouble();
                conta2.depositar(quantiaDeposito);
            }
        } catch (IllegalArgumentException erro) {
            System.err.print(erro.getMessage());
        }
    }
}