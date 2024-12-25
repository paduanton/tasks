package ifsul.repeticao;
public class Q23_WHILE {
	public static void main(String[] args) {
		byte h = 20;
		
		System.out.println("20 at� 100\nM�ltiplos de 5...");
		while(h < 100) {
			h++;
			if(h % 5 == 0) {
				System.out.println(h);
			}
		}
	}
}