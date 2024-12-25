package ifsul.repeticao;
public class Q19 {
	public static void main(String[] args) {
		int h = 9;
		
		System.out.println("�mpares entre 10 e 50");
		while(h < 50) {
			h++;
			if(h % 2 != 0) {
				System.out.println(h);
			}
		}
	}
}