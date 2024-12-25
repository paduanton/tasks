package ifsul.thelastchaos2;
import javax.swing.JOptionPane;
public class tutorial {
	public static int tutorial() {
		int choice;
		
		buttons.buttons("Yes","No", "Ok"); 
		choice = JOptionPane.showConfirmDialog(null, "You will enter into your first battle in this run.\n    Do you wanna make a quick tutorial?");
		cancel.cancel(choice);
		if(choice == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "If you use melee attacks in the fast enemies, the chance to kill\nthem is higher because they can dodge bullets and his health\nis  fragile.  Slow  enemies are large  and their  health is higher.\nShoot  them  is  more  advantageous  because  shots  do more\ndamage and with melee attack the chance to  counterattack is\nvery bigger and how great they are their attacks cause more\ndamage.", "TUTORIAL", JOptionPane.INFORMATION_MESSAGE);
			return 1;
		} else {
			return 0;
		}
	}
}