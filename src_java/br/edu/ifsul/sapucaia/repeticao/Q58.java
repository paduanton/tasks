package br.edu.ifsul.sapucaia.repeticao;
public class Q58 {
	public static void main(String[] args) {
		
		System.out.println("1 at� 500\nM�tliplos de 7...");
		for(short h = 1; h <= 500; h++) {
			if(h % 7 == 0) {
				System.out.println(h);
			}
		}
	}
}