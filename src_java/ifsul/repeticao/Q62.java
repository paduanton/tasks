package ifsul.repeticao;
public class Q62 {
	public static void main(String[] args) {
		
		System.out.println("1 a 600\nM�ltiplos de 13 e 17...");
		for(short h = 1; h < 601; h++) {
			if(h % 13 == 0 && h % 17 == 0) {
				System.out.println(h);
			}
		}
	}
}