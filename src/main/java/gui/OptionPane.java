package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OptionPane extends JOptionPane {
	private static final long serialVersionUID = 588679326564178973L;
	
	private OptionPane() {}
	
	public static void showMessageDialog(JFrame parent, String message, String title, int messageType) {
		JOptionPane theOptionPane = new JOptionPane(message, messageType);
		JLabel label = (JLabel) ((JPanel)((JPanel)((JPanel) theOptionPane.getComponent(0)).getComponent(0)).getComponent(1)).getComponent(0);
		
		System.out.println(label.getText());
		label.setFont(Styles.Fonts.TEXT);
		label.validate();
		JPanel buttonPanel = (JPanel) theOptionPane.getComponent(1);
	    JButton buttonOk = (JButton) buttonPanel.getComponent(0);
	    buttonOk.setText(" ok ");
	    buttonOk.setFont(Styles.Fonts.BUTTON);
	    buttonOk.setBackground(Styles.Colors.BLUE);
	    buttonOk.setForeground(Styles.Colors.WHITE);
	    buttonOk.setFocusable(false);
	    buttonOk.validate();
	    JDialog theDialog = theOptionPane.createDialog(null, title);
	    theDialog.setVisible(true);  
	}
}
