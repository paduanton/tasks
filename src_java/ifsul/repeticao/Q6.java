package ifsul.repeticao;
public class Q6 {
	public static void main(String[] args) {
		int h = 0;
		
		System.out.println("50 at� 5");
		for(h = 50; h >= 5; h--) {
			System.out.println(h);
		} 
		System.out.println("\n�mpares");
		for(h = 50; h >= 5; h--) {
			if(h % 2 != 0) {
				System.out.println(h);
			}
		}
	}
}