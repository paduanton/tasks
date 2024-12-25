package ifsul.repeticao;
public class Q49 {
	public static void main(String[] args) {
		
		System.out.println("100 at� 500\nM�ltiplos de 3 ou 13...");
		for(short h = 100; h < 501; h++) {
			if(h % 3 == 0 || h % 13 == 0) {
				System.out.println(h);
			}
		}
	}
}