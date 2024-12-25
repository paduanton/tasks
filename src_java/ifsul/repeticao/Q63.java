package ifsul.repeticao;
public class Q63 {
	public static void main(String[] args) {
		short soma = 0; float media = 0; 
		
		System.out.println("1 a 100");
		for(byte h = 1; h <= 100; h++) {
			System.out.println(h);
			soma += h;
			media = soma / h;
		}
		System.out.print("Soma dos valores: "+soma+"\nM�dia: "+media);
	}
}