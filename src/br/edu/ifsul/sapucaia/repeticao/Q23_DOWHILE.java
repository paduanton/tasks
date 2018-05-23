package br.edu.ifsul.sapucaia.repeticao;
public class Q23_DOWHILE {
	public static void main(String[] args) {
		byte h = 20;
		
		System.out.println("20 at� 100\nM�ltiplos de 5...");
		do {
			h++;
			if(h % 5 == 0) {
				System.out.println(h);;
			}
		} while(h < 100);
	}
}