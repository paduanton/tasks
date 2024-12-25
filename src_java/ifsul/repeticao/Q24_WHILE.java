package ifsul.repeticao;
public class Q24_WHILE {
	public static void main(String[] args) {
		short h = 10;
		
		System.out.println("10 at� 150\nM�ltiplos de 3 e 7...");
		while(h < 150) {
			h++;
			if(h % 3 == 0 && h %  7 == 0) {
				System.out.println(h);
			}
		}
	}
}