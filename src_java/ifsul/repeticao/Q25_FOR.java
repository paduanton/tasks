package ifsul.repeticao;
public class Q25_FOR {
	public static void main(String[] args) {
		
		System.out.println("100 at� 300\nM�ltiplos de 5 ou 6...");
		for(int h = 100; h < 301; h++) {
			if(h % 5 == 0 || h % 6 == 0) {
				System.out.println(h);
			}
		}
	}
}