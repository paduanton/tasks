package ifsul.repeticao;
public class Q21_DOWHILE {
	public static void main(String[] args) {
		short soma = 0, h = 19;
		
		System.out.println("19 at� 219\n8 em 8...");
		do { 
			System.out.println(h);
			h += 8;
			soma += h;
		} while(h < 219);
		  soma += 19;
		System.out.print("219\nSoma de 8 em 8: "+soma);
	}
}