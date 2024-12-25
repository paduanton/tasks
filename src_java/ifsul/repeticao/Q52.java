package ifsul.repeticao;
public class Q52 {
	public static void main(String[] args) {

		for(byte h = 1; h < 6; h++) {
			System.out.println("\nTabuada do "+h+"\n");
			for(byte y = 1; y < 11; y++) {
				System.out.println(h+" x "+y+" = "+h*y);
			}
		}
	}
}