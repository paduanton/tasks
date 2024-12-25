package ifsul.repeticao;
import java.util.Scanner;
public class Q82 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int num, max , maior = 0, menor = 0, soma = 0, maior20 = 0, intervalo = 0, intervaloMax = 1; byte h = 0;
        float media = 0, maior10 = 0;

        System.out.print("Quer digitar quantos n�meros? ");
        max = t.nextInt();   
        System.out.println("Insira "+max+" valores inteiros");
        for(h = 0; h < max; h++) {
        	 num = t.nextInt();
             if(h == 0) {
             	maior = num - 1;
             	menor = num + 1;
             }
             if(maior < num) {
             	maior = num;
             } if(menor > num) {
             	  menor = num;
             } if(num > 20){
             	  maior20++;
             } if(num > 10) {
             	  maior10++;
             } if(num >= 10 && num <= 100){
             	  intervalo = intervalo + num;
                   intervaloMax++;
             } soma += num;
        }
        maior10 = (100*maior10)/h; media = soma / max;
        System.out.print("Maior: "+maior+" - Menor n�mero: "+menor
        		        +"\nSoma: "+soma
        		        +"\nM�dia: "+media
        		        +"\nPorcentagem dos n�meros maiores que 10: "+maior10+"%");
        media = intervalo / intervaloMax;
        System.out.print("\nA m�dia dos valores entre 10 e 100: "+media);
    }
}
 

