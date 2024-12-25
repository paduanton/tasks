package ifsul.thelastchaos2;
import javax.swing.JOptionPane;
public class end {
public static int end(int end) {  // fourth method: the end game
	  int loop;
	  buttons.buttons("Yes", "No", "Ok");
	  if(end == 1) {
		  JOptionPane.showMessageDialog(null, "  Congratulations, you've finished\n      the game with a true end. \n\n+10 points" ,"The Last Chaos", JOptionPane.PLAIN_MESSAGE);
		  JOptionPane.showMessageDialog(null, "                The end begins..." ,"The Last Chaos", JOptionPane.PLAIN_MESSAGE);
		  return 10;
		  //score
	  } else if(end == 2) {  
  		  JOptionPane.showMessageDialog(null, "Congratulations, you've finished the\n      game with an alternative end.\n+"
  		  		+ ""
  		  		+ ""
  		  		+ "5 points", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
  		  return 5;
	  } else {
		  loop = JOptionPane.showConfirmDialog(null, "Do you want to try again?");
  	      cancel.cancel(loop);
  	      if(loop == JOptionPane.YES_OPTION) {
  	    	  battle.battle();
  	    	  loop = JOptionPane.YES_OPTION;
  	      }
	  } if(loop == JOptionPane.NO_OPTION) {  // don't repeat
      	  JOptionPane.showMessageDialog(null, "This game was made by Antonio Júnior and Marcelo Henrique.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
      	  JOptionPane.showMessageDialog(null, "            Thanks for playing!", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
      	  System.exit(0);
  	  }
	  return 0;
	}
}