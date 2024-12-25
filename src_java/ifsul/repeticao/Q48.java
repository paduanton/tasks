package ifsul.repeticao;
public class Q48 {
	public static void main(String[] args) {
		
		System.out.println("15 at� 150\nDivis�veis por 5 e 7...");
		for(short h = 15; h < 151; h++) {
			if(h % 5 == 0 && h % 7 == 0) {
				System.out.println(h);
			}
		}
	}
}