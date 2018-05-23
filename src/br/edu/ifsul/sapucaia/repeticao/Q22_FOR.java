package br.edu.ifsul.sapucaia.repeticao;
public class Q22_FOR {
	public static void main(String[] args) {
		int soma = 0;
		
		System.out.println("50 at� 125\nM�ltiplos de 3...");
		for(byte h = 50; h < 126; h++) {
			if(h % 3 == 0) {
				System.out.println(h);
				soma += h;
			}
		}
		System.out.print("Soma dos m�ltiplos de 3: "+soma);
	}
}