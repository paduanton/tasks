package br.edu.ifsul.sapucaia.LP;
public class Funcionario {
	private String telefone;
	private double salario;
	private String cargo;
	private String nome;
	private String cpf;

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) throws Exception {
		if(cpf.length() == 11){
			this.cpf = cpf;
		} else {
			throw new Exception("CPF inv�lido");
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws Exception {
		if(telefone.length() != 9 && telefone.length() != 8) {
			telefone = telefone;
			throw new Exception("Telefone inv�lido");
		} else {
			this.telefone = telefone;
		}
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) throws Exception{
		if(salario < 880) {
			throw new Exception("Defina um nome a construtora!");
		} else {
			this.salario = salario;
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) throws IllegalArgumentException{
		if(cargo.length() > 0) {
			this.cargo = cargo;
		}else{
			throw new IllegalArgumentException("Cargo n�o existente");
		}
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws IllegalArgumentException{
		if(nome.length() <= 0){
			throw new IllegalArgumentException("Valor negativo!");
		}else{
			this.nome = nome;
		}
	}
}
