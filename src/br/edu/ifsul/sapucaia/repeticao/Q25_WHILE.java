package br.edu.ifsul.sapucaia.repeticao;
public class Q25_WHILE {
	public static void main(String[] args) {
		short h = 100;
		
		System.out.println("100 at� 300\nM�ltiplos de 5 ou 6...");
		while(h < 300) {
			h++;
			if(h % 5 == 0 || h %  6 == 0) {
				System.out.println(h);
			}
		}
	}
}