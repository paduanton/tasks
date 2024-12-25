package br.edu.ifsul.sapucaia.imobiliaria;
public class Imobiliaria {
	private static void main(String[] args) throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo("Corretor");
		funcionario.setCpf("672.964.878-27");
		funcionario.setSalario(2200);
		funcionario.setNome("Iara");
		funcionario.setTelefone("8945-4421");
		
		System.out.print("Cargp: "+funcionario.getCargo());
		System.out.print("Cpf: "+funcionario.getCpf());
		System.out.print("Sal�rio: "+funcionario.getSalario());
		System.out.printf("Nome: ",funcionario.getNome());
		System.out.print("Telefone: "+funcionario.getTelefone());
	}
}