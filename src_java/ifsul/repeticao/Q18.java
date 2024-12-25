package ifsul.repeticao;
public class Q18 {
	public static void main(String[] args) {
		int h = 0, soma = 0;
		
		System.out.println("1 at� 20");
		while(h < 20) {
			h++;
			System.out.println(h);
			if(h % 2 == 0) {
				soma += h;
			}
		}
		System.out.println("Soma dos pares: "+soma);
	}
}