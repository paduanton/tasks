package br.edu.ifsul.sapucaia.banco;

import br.edu.ifsul.sapucaia.banco.Conta;

/**
 *
 * @author anton
 */
public class TesteConta {
  public static void main(String[] args) {
    new Conta();  // cria o objeto
    // quando new é chamado, ele executa o construtor da classe
    Conta minhaConta = new Conta();
    Conta minhaConta2= new Conta();
    minhaConta.dono = "Antonio";
    minhaConta.saldo = 1000;
  
    minhaConta.saca(200);
   
    minhaConta.deposita(500);
    System.out.println();
    
    if(minhaConta == minhaConta2) { // compara os atributos de cada objeto
        System.out.print("Contas iguais");
    }
  }
}
