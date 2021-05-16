package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton {
	private static final long serialVersionUID = -7196363953902143443L;
	
	public Button(String text, Font font, Color textColor, Color back, ActionListener listener) {
		super(text);
		super.setFocusable(false);
		super.setFont(font);
		super.setBackground(back);
		super.setForeground(textColor);
		super.addActionListener(listener);
	}
}
