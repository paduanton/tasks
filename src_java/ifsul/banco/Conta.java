package br.edu.ifsul.sapucaia.banco;
/**
 *
 * @author anton
 */
public class Conta {
  int numero;
  String dono;
  double saldo;
  double limite;

  Conta() {
  }

  public void saca(double quantidade) {
     double novoSaldo = this.saldo - quantidade;
     this.saldo = novoSaldo;
   }
  public void deposita(double quantidade) {
     this.saldo += quantidade;
   }
  public void transfere(Conta destino, double valor) {
    this.saldo = this.saldo - valor;
    destino.saldo = destino.saldo + valor;
  }
}
