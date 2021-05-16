package gui.pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gui.ApplicationFrame;
import gui.Button;
import gui.Styles;

public class CustomersPage extends Page {
	private static final long serialVersionUID = 7753763746977742651L;
	private FiltersPanel filtersPanel;
	private DeliveriesPanel catalogPanel;
	
	public CustomersPage(ApplicationFrame parent) {
		super(parent);		
		filtersPanel = new FiltersPanel();
		super.add(filtersPanel, BorderLayout.NORTH);
		catalogPanel = new DeliveriesPanel();
		super.add(catalogPanel, BorderLayout.CENTER);		
	}
	private class FiltersPanel extends JPanel {
		private static final long serialVersionUID = -8146284544728838159L;		
		private JLabel searchLabel;
		private JTextField searchField;
		private Button newButton;
		
		public FiltersPanel() {
			super(new FlowLayout(FlowLayout.CENTER, 20, 5));
			
			searchLabel = new JLabel("SEARCH BY NAME: ");
			searchLabel.setFont(Styles.Fonts.TEXT);
			add(searchLabel);
			
			searchField = new JTextField(30);
			searchField.setFont(Styles.Fonts.TEXT);
			add(searchField);
			
			newButton = new Button("add new customer > ", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.setPage(new NewCustomerPage(parent)));
			add(newButton);
		}		
	}
	private class DeliveriesPanel extends JScrollPane {
		private static final long serialVersionUID = 4313280640157064262L;		
		
		public DeliveriesPanel() {
			super(new JPanel() {
				private static final long serialVersionUID = 7015453378652667511L;
				{				
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
					for (int i = 1; i < 10; i++) {
						constraints.gridy = i;	
						cell = new TableCell("OOO \"���� � ������\" OOO \"���� � ������\"", 25);
						layout.setConstraints(cell, constraints);
						add(cell);	
						cell = new TableCell("Ukraine, Kharkiv, Dergrachi district, Petrovska st., 80", 30);
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
								 35);
						layout.setConstraints(cell, constraints);
						add(cell);	
					}			
				}
			},	VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_AS_NEEDED);
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() { 
					DeliveriesPanel.this.getVerticalScrollBar().setValue(0);
				}
			});
		}
	}
}
