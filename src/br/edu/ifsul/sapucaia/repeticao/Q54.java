package br.edu.ifsul.sapucaia.repeticao;
public class Q54 {
	public static void main(String[] args) {
		
		System.out.println("1 at� 20\nPares...");
		for(byte h = 1; h < 21; h++) {
			if(h % 2 == 0) {
				System.out.println(h);
			}
		}
	}
}