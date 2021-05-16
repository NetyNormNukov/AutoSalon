package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MultiLabel extends JTextArea {
	private static final long serialVersionUID = 5873137767302063735L;
	
	public MultiLabel(String text, int symbolsInLine) {		
		super(parse(text, symbolsInLine));
		this.setEditable(false);
		this.setFocusable(false);
		this.setBackground(new JPanel().getBackground());
	}
	private static String parse(String text, int symbolsInLine) {
		if(text.length() > symbolsInLine) {	
			String temp = "";
			for(int i = 0; ((symbolsInLine-1) * i) <= text.length(); i++) {
				try {
					temp += text.substring((symbolsInLine-1) * i, (symbolsInLine-1) * (i+1)) + "\n";
				}catch(StringIndexOutOfBoundsException e) {}
			}
			temp += text.substring(text.length() - 1 - text.length() % symbolsInLine);
			text = temp;
		}
		return text;
	}
}
