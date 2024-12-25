package ifsul.repeticao;
public class Q22_DOWHILE {
	public static void main(String[] args) {
		short soma = 0; byte h = 50;
		
		System.out.println("50 at� 125\nM�ltiplos de 3...");
		do {
			h++;
			if(h % 3 == 0) {
				System.out.println(h);
				soma += h;
			}
		} while(h < 125); 
		System.out.print("Soma dos m�ltiplos de 3: "+soma);
	}
}