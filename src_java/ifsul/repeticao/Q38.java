package ifsul.repeticao;
public class Q38 {
	public static void main(String[] args) {
		short soma = 0;
		
		for(short h = 50; h < 151; h++) {
			if(h % 2 == 0){
				soma += h;
			}
		}
		System.out.print("Soma dos pares de 50 at� 150: "+soma);
	}
}