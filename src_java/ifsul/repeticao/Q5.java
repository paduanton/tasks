package ifsul.repeticao;
public class Q5 {
	public static void main(String[] args) {
		short h = 0, cont = 0, soma = 0;
		
		for(h = 20; h <= 50; h++) {
			if(h % 2 != 0) {
				cont++;
				soma += h;	
			}
		}
		System.out.print("Soma dos �mpares: "+soma+"\nTotal de valores somados: "+cont);
	}
}