package br.edu.ifsul.sapucaia.thelastchaos2;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class cancel {
	public static void cancel(int choice) {
		int loop = JOptionPane.YES_OPTION;
		
		if(choice == JOptionPane.CANCEL_OPTION) {
			UIManager.put("OptionPane.okButtonText", "OK");    
   	    	JOptionPane.showMessageDialog(null, "You canceled the game.\n        GAME OVER", "WARNING", JOptionPane.ERROR_MESSAGE);
   	    	System.exit(0);
   	   	}
	}
}