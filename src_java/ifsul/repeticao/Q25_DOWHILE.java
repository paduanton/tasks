package ifsul.repeticao;
public class Q25_DOWHILE {
	public static void main(String[] args) {
		short h = 100;
		
		System.out.println("100 at� 300\nM�ltiplos de 5 ou 6...");
		do {
			h++;
			if(h % 6 == 0 || h % 5 == 0) {
				System.out.println(h);;
			}
		} while(h < 300);
	}
}