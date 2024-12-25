package ifsul.repeticao;
public class Q3 {
	public static void main(String[] args) {
		int soma = 0;
		
		System.out.print("23 at� 55\n\n");
		for(int h = 23; h <= 55; h++) {
			System.out.println(h);
			soma += h;
		}
		System.out.print("\nSoma dos valores: "+soma);
	}
}