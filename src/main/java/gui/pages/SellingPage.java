package gui.pages;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import entities.Car;
import entities.Present;
import gui.ApplicationFrame;
import gui.Button;
import gui.Styles;

public class SellingPage extends Page {
	private static final long serialVersionUID = 5545613204431814337L;
	private JScrollPane scrollPane;
	
	public SellingPage(ApplicationFrame parent) {
		super(parent);
		scrollPane = new JScrollPane(new ContentPanel());
		add(scrollPane);
		
	}
	private class ContentPanel extends JPanel {
		private static final long serialVersionUID = 8444530915071096626L;
		private JPanel buttonsPanel;
		private Button backButton;
		private Button sellingButton;
		
		private JPanel carPanel;
		private JLabel carLabel;
		private CarCell carCell;
		
		private JPanel countPanel;
		private JLabel countLabel;
		private JSpinner countSpinner;
		
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
		
		private JPanel annotationPanel;
		private JLabel annotationLabel;
		private JTextField annotationField;
		
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
			
			
			constraints.insets.left = 50;
			constraints.insets.top = 1;
			carPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 1));
			
			carLabel = new JLabel("car: ");
			carLabel.setFont(Styles.Fonts.MENU);
			carPanel.add(carLabel);
			
			carCell = new CarCell(parent, new Present(), false);
			carPanel.add(carCell);
			
			layout.setConstraints(carPanel, constraints);
			add(carPanel);	
			


			buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
			
			backButton = new Button("< back ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.back());
			buttonsPanel.add(backButton);
		
			sellingButton = new Button("sell ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
				if(ContentPanel.this.nameField.getText().equals("") ||
				   ContentPanel.this.addressField.getText().equals("") ||
				   ContentPanel.this.phoneField.getText().equals("") ||
				   ContentPanel.this.emailField.getText().equals("") ||
				   ContentPanel.this.bankField.getText().equals("")  ){
					JOptionPane.showMessageDialog(SellingPage.this.parent, "Not all fields are filled.");							
				}
				else JOptionPane.showMessageDialog(SellingPage.this.parent, "Succefully selled");
			}) ;
			buttonsPanel.add(sellingButton);			
			
			layout.setConstraints(buttonsPanel, constraints);
			add(buttonsPanel);
			
			countPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
			
			countLabel = new JLabel("count: ");
			countLabel.setFont(Styles.Fonts.MENU);
			countPanel.add(countLabel);
			
			countSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
			countSpinner.setFont(Styles.Fonts.TEXT);
			countPanel.add(countSpinner);
			
			layout.setConstraints(countPanel, constraints);
			add(countPanel);
			
			JLabel custLabel = new JLabel("customer data: ");
			custLabel.setFont(Styles.Fonts.MENU);
			layout.setConstraints(custLabel, constraints);
			add(custLabel);

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
			
			annotationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			annotationLabel = new JLabel("annotation: ");
			annotationLabel.setFont(Styles.Fonts.MENU);
			annotationPanel.add(annotationLabel);
			
			annotationField = new JTextField(28);
			annotationField.setFont(Styles.Fonts.TEXT);
			annotationPanel.add(annotationField);
					
			layout.setConstraints(annotationPanel, constraints);
			add(annotationPanel);
			
			JLabel label = new JLabel("proposed customers: ");
			label.setFont(Styles.Fonts.MENU);
			layout.setConstraints(label, constraints);
			add(label);
			CustomersPanel customersPanel = new CustomersPanel();
			add(customersPanel);
		}
		private class CustomersPanel extends JPanel {
			private static final long serialVersionUID = 4313280640157064262L;		
			
			public CustomersPanel() {				
				GridBagLayout layout = new GridBagLayout();
				GridBagConstraints constraints = new GridBagConstraints();

				this.setLayout(layout);

				constraints.anchor = GridBagConstraints.EAST; 
				constraints.fill   = GridBagConstraints.BOTH;  
				constraints.gridheight = 1;
				constraints.gridwidth  = 1; 
				constraints.gridx = GridBagConstraints.RELATIVE; 
				constraints.gridy = GridBagConstraints.RELATIVE; 
				constraints.insets = new Insets(1, 1, 1, 1);
				constraints.ipadx = 0;
				constraints.ipady = 0;
				constraints.weightx = 0.5;
				constraints.weighty = 0.5;				
				TableCell cell = new TableCell("NAME");
				layout.setConstraints(cell, constraints);
				add(cell); 
				cell = new TableCell("ADDRESS");
				layout.setConstraints(cell, constraints);
				add(cell);
				cell = new TableCell("PHONE");
				layout.setConstraints(cell, constraints);
				add(cell);
				cell = new TableCell("EMAIL");
				layout.setConstraints(cell, constraints);
				add(cell);
				cell = new TableCell("BANK ACCOUNT");
				layout.setConstraints(cell, constraints);
				add(cell);
				cell = new TableCell("REQUISITES");
				layout.setConstraints(cell, constraints);
				add(cell);
				cell = new TableCell("FAST CHOOSING");
				layout.setConstraints(cell, constraints);
				add(cell);
				for (int i = 1; i < 10; i++) {
					constraints.gridy = i;	
					cell = new TableCell("OOO \"���� � ������\" OOO \"���� � ������\"", 25);
					layout.setConstraints(cell, constraints);
					add(cell);	
					cell = new TableCell("Ukraine, Kharkiv, Dergrachi district, Petrovska st., 80", 25);
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("+380988561738");
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("somebody.wants@email.com");
					layout.setConstraints(cell, constraints);
					add(cell);	
					cell = new TableCell("21002102015212102020120", 10);
					layout.setConstraints(cell, constraints);
					add(cell);		
					cell = new TableCell("TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT ",
							 25);
					layout.setConstraints(cell, constraints);
					add(cell);	
					ButtonCell buttonCell = new ButtonCell();
					layout.setConstraints(buttonCell, constraints);
					add(buttonCell);
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
					   public void run() { 
						   SellingPage.this.scrollPane.getVerticalScrollBar().setValue(0);
					   }
					});
				}			
			}
			private class ButtonCell extends JPanel {
				private static final long serialVersionUID = 2053928373919419666L;
				
				
				public ButtonCell() {
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
					
					setBorder(BorderFactory.createLineBorder(Styles.Colors.BLUE, 3));
					
					Button button = new Button("choose ^ ", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event ->  {
						ContentPanel.this.nameField.setText("���� ������");
						ContentPanel.this.addressField.setText("���������� �������");
						ContentPanel.this.phoneField.setText("+380988561738");
						ContentPanel.this.emailField.setText("someone.it.@email.com");
						ContentPanel.this.bankField.setText("1231548446531534435");
						
						javax.swing.SwingUtilities.invokeLater(new Runnable() {
						   public void run() { 
							   SellingPage.this.scrollPane.getVerticalScrollBar().setValue(50);
						   }
						});
					});		
					layout.setConstraints(button, constraints);
					add(button);
				}
			}
		}
	}	
}
