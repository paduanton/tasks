package ifsul.array_string;
import java.util.Scanner;
public class Q104 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		byte choice;
	        
	     do {
	    	 System.out.print("Gibbet");
	    	 String array[] = {"thelastchaos", "runner", "worm", "thelastofus", 
   		                       "easteregg", "brightside", "badside", "metalbar", 
   		                       "amy", "pether", "Carol", "ryan", "pistol", "tnt"};
	    	 String palavra = array[(int) (Math.random() * array.length)];
	            
	         System.out.print("\n\nThe word has "+palavra.length()+ " characters\n");

	            boolean game = true;
	            do {
	                char chars[] = new char[palavra.length()];
	                for (byte h = 0; h < palavra.length(); h++) {
	                    chars[h] = palavra.charAt(h);
	                    System.out.print("_ ");
	                }
	                boolean trials = true; byte mistake = 0;
	                char RightWord[] = new char[palavra.length()];
	                while (trials) {
	                    if(mistake < 5) {
	                        System.out.print("\n\nInsira uma letra: ");
	                        byte letraErrada = 0; char letra = t.next().charAt(0);
	                        String NewWord = "";
	                        for (int lc = 0; lc < palavra.length(); lc++) {
	                           
	                            if(letra == chars[lc]) {
	                                RightWord[lc] = letra;
	                            } else {
	                                letraErrada++;
	                              }
	                            if(RightWord[lc] == chars[lc]) {
	                                NewWord += RightWord[lc];
	                                System.out.print(RightWord[lc]+" ");

	                            } else {
	                                System.out.print("_ ");
	                              }
	                        }
	                        if(letraErrada >= palavra.length()) {
	                            System.out.print("\n\nWRONG CHARACTER");
	                            mistake++;
	                        }
	                        if(palavra.equals(NewWord)) {
	                            System.out.print("\n\nYou won it, the word is: '"+palavra+"'");
	                            trials = false;
	                        } 
	                    } else {
	                        System.out.print("\nYou Lose! ");
	                        System.out.print("The correct word is: '"+palavra+"'");
	                        trials = false;
	                      }
	                }
	                game = false;
	            } while(game);
	            
	            System.out.print("\nWould you like playing gibbet again?\n\n1 - YES\n2 - NO");
	            choice = t.nextByte();
	        } while(choice == 1);
	        System.out.print("\nTHE END GAME\n");
	
	}
}
/*
 * Quest�o 104. O jogo da forca � um jogo em que o jogador tem que acertar qual � a palavra proposta, tendo
 * como dica o n�mero de chars. A cada letra errada, � desenhada uma parte do corpo do enforcado. O jogo
 * termina ou com o acerto da palavra ou com o t�rmino do preenchimento das partes corp�reas do enforcado.
 * Por exemplo, para a palavra "MERCADO", se escreve: M E R C A D O �> _ _ _ _ _ _ _
 * O jogador que tenta adivinhar a palavra deve ir dizendo as letras que podem existir na palavra. Cada letra que
 * ele acerta � escrita no espa�o correspondente. M _ _ C A _ _
 * Caso a letra n�o exista nessa palavra, desenha-se uma parte do corpo (iniciando pela cabe�a, tronco, bra�os)
 * O jogo � ganho se a palavra � adivinhada. Caso o jogador n�o descubra qual palavra � ele que perde.
*/