package br.edu.ifsul.sapucaia.repeticao;
public class Q24_FOR {
	public static void main(String[] args) {
		
		System.out.println("10 at� 150\nM�ltiplos de 3 e 7...");
		for(int h = 10; h <= 150; h++) {
			if(h % 3 == 0 && h % 7 == 0) {
				System.out.println(h);
			}
		}
	}
}