package br.edu.ifsul.sapucaia.repeticao;
public class Q57 {
	public static void main(String[] args) {
		
		System.out.println("100 at� 200\n�mpares...");
		for(short h = 1; h < 201; h++) {
			if(h % 2 != 0) {
				System.out.println(h);
			}
		}
	}
}