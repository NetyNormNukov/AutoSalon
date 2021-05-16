package gui.pages;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.ApplicationFrame;
import gui.Button;
import gui.Styles;

public class CarCell extends JPanel {
	private static final long serialVersionUID = -3059067480908071499L;
	private JLabel nameLabel;
	private JLabel yearLabel;
	private JLabel colorLabel;
	private JLabel bodyLabel;
	private JLabel petrolLabel;
	private JLabel transmissionLabel;
	private JLabel costLabel;
	
	public CarCell(ApplicationFrame frame, boolean selling) {
		super();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();

		this.setLayout(layout);

		constraints.anchor = GridBagConstraints.WEST; 
		constraints.fill = GridBagConstraints.NONE;  
		constraints.gridheight = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER; 
		constraints.gridx = GridBagConstraints.RELATIVE; 
		constraints.gridy = GridBagConstraints.RELATIVE; 
		constraints.insets = new Insets(10, 20, 1, 0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		
		nameLabel = new JLabel("toyota sls a-350 ");
		nameLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(nameLabel, constraints);
		add(nameLabel);
		
		constraints.insets.top = 1;
		yearLabel = new JLabel("Year: 2003");
		yearLabel.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(yearLabel, constraints);
		add(yearLabel);
		
		colorLabel = new JLabel("Color: blue");
		colorLabel.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(colorLabel, constraints);
		add(colorLabel);
		
		bodyLabel = new JLabel("Body type: minivan");
		bodyLabel.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(bodyLabel, constraints);
		add(bodyLabel);
		
		petrolLabel = new JLabel("Petrol type: GAS");
		petrolLabel.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(petrolLabel, constraints);
		add(petrolLabel);
		
		transmissionLabel = new JLabel("Transmission: mechanical");
		transmissionLabel.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(transmissionLabel, constraints);
		add(transmissionLabel);
		
		costLabel = new JLabel("Cost: 3000$");
		costLabel.setFont(Styles.Fonts.TEXT);
		layout.setConstraints(costLabel, constraints);
		add(costLabel);
		
		Button button = new Button("more >", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> frame.setPage(new CarPage(frame, selling)));
		
		constraints.insets.top = 10;
		constraints.insets.bottom = 10;
		layout.setConstraints(button, constraints);
		add(button);
		setBorder(BorderFactory.createLineBorder(Styles.Colors.BLUE, 3));
	}
	
	public CarCell(ApplicationFrame frame) {
		this(frame, true);
	}
}
