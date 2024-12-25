package br.edu.ifsul.sapucaia.repeticao;
public class Q21_WHILE {
	public static void main(String[] args) {
		short soma = 0, h = 19;
		
		System.out.println("19 at� 219\n8 em 8...\n19");
		while(h < 219) { 
			h += 8;
			System.out.println(h);
			soma += h;
		} soma += 19;
		System.out.print("Soma de 8 em 8: "+soma);
	}
}