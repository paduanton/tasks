package ifsul.sequencial;
import java.util.Scanner;
public class Q45 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        
        double apartamentos, diaria, promocao, ocupacao, expectativa;
        
        System.out.print("Qual a quantidade de apartamentos? ");
        apartamentos = teclado.nextDouble();
        System.out.print("Qual o  pre�o da di�ria normal? ");
        diaria = teclado.nextDouble();
        System.out.print("Insira porcentagem de desconto da promo��o: ");
        promocao = teclado.nextDouble();
        System.out.print("Qual a ocupa��o m�dia (%) do hotel sem promo��o? ");
        ocupacao = teclado.nextDouble();
        System.out.print("Qual a porcentagem estimada da ocupa��o depois da promo��o? ");
        expectativa = teclado.nextDouble();
        
        double diariaP = diaria-((promocao/100)*diaria), valorM = 30*(diaria*((ocupacao/100)*apartamentos)), valorM2 = 30*(diariaP*((expectativa/100)*apartamentos)), diferenca = valorM2-valorM, promocao2 = 30*(diaria*((expectativa/100)*apartamentos)); 
        double x = promocao2-valorM2;		
        System.out.print("\nValor da di�ria no per�odo da promo��o: R$" + diariaP + "\n" + "Valor m�dio arrecadado sem a promo��o (mensal), com a ocupa��o m�dia de " + ocupacao + "%" + ": R$" + valorM + "\n" + "Valor m�dio arrecadado com a promo��o (mensal), com a ocupa��o de " + expectativa + "%"+ ": R$" + valorM2 + "\n" + "Com a ocupa��o estimada de " + expectativa + "%" + ", com a di�ria em seu valor normal, o hotel teria ganho R$" + promocao2 + "\n" + "O preju�zo foi de R$" + x);
       
    }

}