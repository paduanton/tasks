package ifsul.repeticao;
public class Q21_FOR {
	public static void main(String[] args) {
		int soma = 0;
		
		System.out.println("19 at� 219\n8 em 8...");
		for(int h = 19; h <= 219; h += 8) {
			System.out.println(h);
			soma += h;
		}
		System.out.print("Soma de 8 em 8: "+soma);
	}
}