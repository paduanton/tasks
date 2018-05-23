package br.edu.ifsul.sapucaia.thelastchaos2;
import javax.swing.UIManager;
public class buttons {
	public static void buttons(String opt1, String opt2, String opt3) {
		UIManager.put("OptionPane.yesButtonText", opt1);     
        UIManager.put("OptionPane.noButtonText", opt2);
        UIManager.put("OptionPane.okButtonText", opt3);   
    }
}
