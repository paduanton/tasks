package ifsul.thelastchaos2;
import java.util.Random;
import javax.swing.JOptionPane;
public class battle {
	public static int battle() {  // third method: the battle
        buttons.buttons(null,null, "Ok");
        Random random = new Random();
        /* speed: how hard to get a shot. 
         * healthE: enemy health.
         * healthP: player health. 
         * bullets: how many bullets you have. */
        int turn, speed = 0, defense = 0, healthE = 0, healthP = 10, bullets = 2, choice = JOptionPane.NO_OPTION;
        int randomN = random.nextInt(2) + 1;  // fast or slow
        int points = 0;
        
        switch(randomN) {
        case 1:    // runner (fast)
        	healthE = 10;
            speed = 7;
            defense = 3;
            JOptionPane.showMessageDialog(null, "You got in a battle and you will face an infected.\nYou are facing a RUNNER zombie and you'll have\n to think what's the best way to defeat him.\n\nHe moves very fast, but he isn't very resistant.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            cancel.cancel(choice);
            break;   
        case 2:    // worm (slow)
        	healthE = 15;
            speed = 3;
            defense = 7;
            JOptionPane.showMessageDialog(null, "You got in a battle and you will face an infected.\nYou are facing a WORM zombie and you'll have\n to think what's the best way to defeat him.\n\nHe is slow, but he is very resistant.", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            cancel.cancel(choice);
            break;
        } for(turn = 1; healthE > 0 && healthP > 0; turn++) {
       	    buttons.buttons("Pistol","Metal Bar","Ok");
            choice = JOptionPane.showConfirmDialog(null, "       Turn "+turn+"\nYour health: "+healthP+"\nEnemy's health: "+healthE+"\nBullets: "+bullets+"\n\nSelect your weapon:"); 
            cancel.cancel(choice);
             
            if(choice == JOptionPane.YES_OPTION) {   // shot
               if(bullets <= 0) {   // no bullets = death
            	   healthP -= 10;
               } else {
            	   bullets--;
                   randomN = random.nextInt(10) + 1;
                   if(speed > randomN) {   // 70% to fast. 30% to slow
                	   randomN = random.nextInt(2) + 1;
                       healthP = healthP - ( randomN + 3);
                       JOptionPane.showMessageDialog(null, "            You missed the shot", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                   } else {  // right shot
                	   randomN = random.nextInt(4) + 1;
                       healthE = healthE - (randomN + 6);
                       JOptionPane.showMessageDialog(null, "                You hit the shot", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                     }
                 }
            } else {    // metal bar
            	randomN = random.nextInt(10) + 1;
                if(defense > randomN) {  // 30% to fast. 70% to slow
               	    randomN = random.nextInt(2) + 1;
                    healthP = healthP - (randomN + 5);
                    JOptionPane.showMessageDialog(null, "     The infected counterattacked", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);  
                } else {
                	randomN = random.nextInt(3) + 1;
                    healthE = healthE - (randomN + 8);
                    JOptionPane.showMessageDialog(null, "         You hit him", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
                  }
              }
            
            if(healthE <= 0 || healthP <= 0) {
            	if(healthE <= 0) {
            		while(points != turn){
            			points++;
            		}
            		JOptionPane.showMessageDialog(null, "       You have killed the infected. + ("+points+") points", "The Last Chaos", JOptionPane.PLAIN_MESSAGE);
            	} else {
            		JOptionPane.showMessageDialog(null, "          You died.","WARNING", JOptionPane.ERROR_MESSAGE);
            		end.end(3);
            	  }
            }
        }
        return points;
     }
}