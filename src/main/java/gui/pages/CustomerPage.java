package gui.pages;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.ApplicationFrame;
import gui.Button;
import gui.MultiLabel;
import gui.Styles;

public class CustomerPage extends Page {
	private static final long serialVersionUID = 7574586796728736152L;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JLabel bankLabel;
	private MultiLabel requisitesLabel;
		
	private JPanel buttonsPanel;
	private Button backButton;
	
	public CustomerPage(ApplicationFrame parent) {
		super(parent);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();

		this.setLayout(layout);

		constraints.anchor = GridBagConstraints.NORTHWEST; 
		constraints.fill = GridBagConstraints.NONE;  
		constraints.gridheight = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER; 
		constraints.gridx = GridBagConstraints.RELATIVE; 
		constraints.gridy = GridBagConstraints.RELATIVE; 
		constraints.insets = new Insets(20, 50, 1, 0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		
		nameLabel = new JLabel("name: ���� ������ ".toUpperCase());
		nameLabel.setFont(Styles.Fonts.BIG_TEXT);
		layout.setConstraints(nameLabel, constraints);
		add(nameLabel);		
		
		constraints.insets.top = 1;
		addressLabel = new JLabel("address: kharkiv, ukraine ".toUpperCase());
		addressLabel.setFont(Styles.Fonts.BIG_TEXT);
		layout.setConstraints(addressLabel, constraints);
		add(addressLabel);
		
		phoneLabel = new JLabel("phone: +38988561738 ".toUpperCase());
		phoneLabel.setFont(Styles.Fonts.BIG_TEXT);
		layout.setConstraints(phoneLabel, constraints);
		add(phoneLabel);
		
		emailLabel = new JLabel("email: somebody.ni@gmail.com ".toUpperCase());
		emailLabel.setFont(Styles.Fonts.BIG_TEXT);
		layout.setConstraints(emailLabel, constraints);
		add(emailLabel);
		
		bankLabel = new JLabel("bank account: 1551500052405 ".toUpperCase());
		bankLabel.setFont(Styles.Fonts.BIG_TEXT);
		layout.setConstraints(bankLabel, constraints);
		add(bankLabel);
		
		requisitesLabel = new MultiLabel("REQUISITES: "
				+ " ", 70);
		requisitesLabel.setFont(Styles.Fonts.BIG_TEXT);
		layout.setConstraints(requisitesLabel, constraints);
		add(requisitesLabel);
		
		constraints.insets.left = 50;
		buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
		backButton = new Button("< back ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.back());
		buttonsPanel.add(backButton);
		constraints.insets.left = 15;
		layout.setConstraints(buttonsPanel, constraints);
		add(buttonsPanel);
	}
}
