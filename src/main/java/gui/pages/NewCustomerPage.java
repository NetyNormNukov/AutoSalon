package gui.pages;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gui.ApplicationFrame;
import gui.Button;
import gui.OptionPane;
import gui.Styles;

public class NewCustomerPage extends Page {
	private static final long serialVersionUID = 4390494729144682937L;
	private JScrollPane scrollPane;
	
	public NewCustomerPage(ApplicationFrame parent) {
		super(parent);
		scrollPane = new JScrollPane(new ContentPanel());
		add(scrollPane);
		
	}
	private class ContentPanel extends JPanel {
		private static final long serialVersionUID = 8444530915071096626L;
		private JPanel buttonsPanel;
		private Button backButton;
		private Button sellerButton;		
		
		private JPanel namePanel;
		private JLabel nameLabel;
		private JTextField nameField;
		
		private JPanel addressPanel;
		private JLabel addressLabel;
		private JTextField addressField;		
		
		private JPanel phonePanel;
		private JLabel phoneLabel;
		private JTextField phoneField;		
		
		private JPanel emailPanel;
		private JLabel emailLabel;
		private JTextField emailField;
		
		private JPanel bankPanel;
		private JLabel bankLabel;
		private JTextField bankField;
		
		private JPanel requisitesPanel;
		private JLabel requisitesLabel;
		private JTextField requisitesField;
		
		public ContentPanel() {
			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints constraints = new GridBagConstraints();

			this.setLayout(layout);

			constraints.anchor = GridBagConstraints.NORTHWEST; 
			constraints.fill = GridBagConstraints.NONE;  
			constraints.gridheight = 1;
			constraints.gridwidth = GridBagConstraints.REMAINDER; 
			constraints.gridx = GridBagConstraints.RELATIVE; 
			constraints.gridy = GridBagConstraints.RELATIVE; 
			constraints.insets = new Insets(10, 15, 1, 0);
			constraints.ipadx = 0;
			constraints.ipady = 0;
			constraints.weightx = 1;
			constraints.weighty = 1;
			

			buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
			
			backButton = new Button("< back ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.back());
			buttonsPanel.add(backButton);
		
			sellerButton = new Button("add customer ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
				if(ContentPanel.this.nameField.getText().equals("") ||
				   ContentPanel.this.addressField.getText().equals("") ||
				   ContentPanel.this.phoneField.getText().equals("") ||
				   ContentPanel.this.emailField.getText().equals("") ||
				   ContentPanel.this.bankField.getText().equals("") ){
					OptionPane.showMessageDialog(NewCustomerPage.this.parent, "Not all fields are filled.", "Error", OptionPane.ERROR_MESSAGE);							
				}
				else OptionPane.showMessageDialog(NewCustomerPage.this.parent, "Successfully added.", "Massage", JOptionPane.INFORMATION_MESSAGE);
			}) ;
			buttonsPanel.add(sellerButton);			
			
			layout.setConstraints(buttonsPanel, constraints);
			add(buttonsPanel);
			
			constraints.insets.left = 50;			
			
			namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			nameLabel = new JLabel("name: ");
			nameLabel.setFont(Styles.Fonts.MENU);
			namePanel.add(nameLabel);
			
			nameField = new JTextField(33);
			nameField.setFont(Styles.Fonts.TEXT);
			namePanel.add(nameField);
			
			layout.setConstraints(namePanel, constraints);
			add(namePanel);
			
			addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			addressLabel = new JLabel("address: ");
			addressLabel.setFont(Styles.Fonts.MENU);
			addressPanel.add(addressLabel);
			
			addressField = new JTextField(30);
			addressField.setFont(Styles.Fonts.TEXT);
			addressPanel.add(addressField);	
			
			layout.setConstraints(addressPanel, constraints);
			add(addressPanel);			
			
			phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			phoneLabel = new JLabel("phone: ");
			phoneLabel.setFont(Styles.Fonts.MENU);
			phonePanel.add(phoneLabel);
			
			phoneField = new JTextField(32);
			phoneField.setFont(Styles.Fonts.TEXT);
			phonePanel.add(phoneField);
					
			layout.setConstraints(phonePanel, constraints);
			add(phonePanel);			
			
			emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			emailLabel = new JLabel("email: ");
			emailLabel.setFont(Styles.Fonts.MENU);
			emailPanel.add(emailLabel);
			
			emailField = new JTextField(32);
			emailField.setFont(Styles.Fonts.TEXT);
			emailPanel.add(emailField);
					
			layout.setConstraints(emailPanel, constraints);
			add(emailPanel);
			
			bankPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			bankLabel = new JLabel("bank account: ");
			bankLabel.setFont(Styles.Fonts.MENU);
			bankPanel.add(bankLabel);
			
			bankField = new JTextField(25);
			bankField.setFont(Styles.Fonts.TEXT);
			bankPanel.add(bankField);
					
			layout.setConstraints(bankPanel, constraints);
			add(bankPanel);
			
			requisitesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			requisitesLabel = new JLabel("requisites: ");
			requisitesLabel.setFont(Styles.Fonts.MENU);
			requisitesPanel.add(requisitesLabel);
			
			requisitesField = new JTextField(28);
			requisitesField.setFont(Styles.Fonts.TEXT);
			requisitesPanel.add(requisitesField);
			
			layout.setConstraints(requisitesPanel, constraints);
			add(requisitesPanel);
		}		
	}	
}
