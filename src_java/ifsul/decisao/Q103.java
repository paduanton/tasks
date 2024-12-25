package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q103 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String animal;
		
		System.out.print("Responda as perguntas para que o programa adivinhe qual animal foi escolhido.\n"
				+ "                                                  --------------------------------\n"
				+ "Lista de animais poss�veis de serem descobertos: |le�o - cavalo - homem - pinguim |\n"
				+ "                                                 |macaco - morcego - baleia - pato|\n"
				+ "                                                 |  avestruz - �guia - tartaruga  |\n"
				+ "                                                 |       crocodilo - cobra        |\n"
				+ "                                                  --------------------------------\n"
				+ "AS PALAVRAS QUE EST�O ENTRE ( ) EM ALGUMAS PERGUNTAS, INDICA O QUE DEVER SER DIGITADO NAS RESPOSTAS."
				+ "\n\n                     PERGUNTAS\n\n"
				+ "1) O animal escolhido � (mam�fero), (ave) ou (r�ptil)? ");
		animal = teclado.next();
		if(animal.equalsIgnoreCase("mam�fero")) {   // in�cio mam�fero
			System.out.print("a) � (quadr�pede), (b�pede), (voador) ou (aqu�tico)? ");
			animal = teclado.next();
			if(animal.equalsIgnoreCase("quadr�pede")) {
			    System.out.print("b) � herb�voro? ");
			    animal = teclado.next();
			    if(animal.equalsIgnoreCase("sim")) {
    			    System.out.print("                   ------\nAnimal escolhido: |CAVALO|\n                   ------");
    		    } else if(animal.equalsIgnoreCase("n�o") || animal.equalsIgnoreCase("nao")) {
    		    	System.out.print("                   ----\nAnimal escolhido: |LE�O|\n                   ----");
    		      }
			} else {
				if(animal.equalsIgnoreCase("b�pede")) {
					System.out.print("b) � on�voro? ");
					animal = teclado.next();
				    if(animal.equalsIgnoreCase("sim")) {
		    			System.out.print("                   -----\nAnimal escolhido: |HOMEM|\n                   -----");
		    		} else if(animal.equalsIgnoreCase("n�o") || animal.equalsIgnoreCase("nao")) {
		    			System.out.print("                   ------\nAnimal escolhido: |MACACO|\n                   ------");
			          }
			    } else if(animal.equalsIgnoreCase("voador")) {
			    	System.out.print("                   -------\nAnimal escolhido: |MORCEGO|\n                   -------");
				} else if(animal.equalsIgnoreCase("aqu�tico")) {
					System.out.print("                   ------\nAnimal escolhido: |BALEIA|\n                   ------");
  		          }		
	          } 
		} else if(animal.equalsIgnoreCase("ave")) {     // in�cio ave
			System.out.print("a) � n�o voadora? ");
			animal = teclado.next();
			if(animal.equalsIgnoreCase("sim")) {
				System.out.print("b) � tropical? ");
				animal = teclado.next();
			    if(animal.equalsIgnoreCase("sim")) {
				    System.out.print("                   --------\nAnimal escolhido: |AVESTRUZ|\n                   --------");
				} else if(animal.equalsIgnoreCase("n�o") || animal.equalsIgnoreCase("nao")) {
					System.out.print("                   -------\nAnimal escolhido: |PINGUIM|\n                   -------");				    	
				  }
			} else if(animal.equals("n�o")){
				System.out.print("a) � nadadora? ");
				animal = teclado.next();
				if(animal.equalsIgnoreCase("sim")) {
					System.out.print("                   ----\nAnimal escolhido: |PATO|\n                   ----");
				} else if(animal.equalsIgnoreCase("n�o") || animal.equalsIgnoreCase("nao")) {
					System.out.print("                   -----\nAnimal escolhido: |�GUIA|\n                   -----");
			      } 
			  } 
		  } else if(animal.equalsIgnoreCase("r�ptil")) {   // in�cio r�ptil
			  System.out.print("a) � carn�voro? ");
			  animal = teclado.next();
	           if(animal.equalsIgnoreCase("sim")) {
		          System.out.print("                   ---------\nAnimal escolhido: |CROCODILO|\n                   ---------");				    	
	           } else if(animal.equalsIgnoreCase("n�o") || animal.equalsIgnoreCase("nao")) {
	        	   System.out.print("a) � sem patas? ");
   	               animal = teclado.next();
   	               if(animal.equalsIgnoreCase("sim")) {
   	            	   System.out.print("                   -----\nAnimal escolhido: |COBRA|\n                   -----");				    	
   	           } else if(animal.equalsIgnoreCase("n�o") || animal.equalsIgnoreCase("nao")){
   	        	   System.out.print("                   ---------\nAnimal escolhido: |TARTARUGA|\n                   ---------");
	                 } 
                }
    	    } else {   // ave, r�ptil ou mam�fero = false
    	    	System.out.print("    ------------------------------------------------\n"
    	    			       + "   |ESSA CLASSIFICA��O DE ANIMAL N�O EST� DISPON�VEL|\n"
    	    			       + "    ------------------------------------------------");				    	
    	      }
		}
	}