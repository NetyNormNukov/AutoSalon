package gui.pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import gui.Button;
import gui.MultiLabel;
import gui.Styles;
public class TableCell extends JPanel {
	private static final long serialVersionUID = 2053928373919419666L;
	private MultiLabel textArea;
	
	public TableCell(String text) {
		this(text, 20);
	}
	public TableCell(String text, ActionListener listener) {
		this(text, 20, listener);
	}
	public TableCell(String text, int symbolsInLine) {
		super();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();

		this.setLayout(layout);

		constraints.anchor = GridBagConstraints.CENTER; 
		constraints.fill = GridBagConstraints.NONE;  
		constraints.gridheight = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER; 
		constraints.gridx = GridBagConstraints.RELATIVE; 
		constraints.gridy = GridBagConstraints.RELATIVE; 
		constraints.insets = new Insets(3, 1, 3, 1);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;		
		
		
		textArea = new MultiLabel(text, symbolsInLine);
		textArea.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(textArea, constraints);
		add(textArea);
		setBorder(BorderFactory.createLineBorder(Styles.Colors.BLUE, 3));
	}
	public TableCell(String text, int symbolsInLine, ActionListener listener) {
		this(text, symbolsInLine);
		GridBagLayout layout = (GridBagLayout) this.getLayout();
		GridBagConstraints constraints = (GridBagConstraints) layout.getConstraints(textArea).clone();
		
		Button button = new Button("more >", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, listener);		
		/*constraints.insets.top = 10;
		constraints.insets.bottom = 10;*/
		layout.setConstraints(button, constraints);
		add(button);
	}
}
