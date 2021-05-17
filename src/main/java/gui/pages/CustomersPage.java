package gui.pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import database.MySQLManager;
import entities.Customer;
import entities.Seller;
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
	@Override
	public void refresh(){
		super.remove(catalogPanel);
		catalogPanel = new DeliveriesPanel();
		super.add(catalogPanel, BorderLayout.CENTER);
		parent.revalidate();
		parent.repaint();
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
			searchField.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					onChange(e);
				}
				@Override
				public void removeUpdate(DocumentEvent e) {
					onChange(e);
				}
				@Override
				public void changedUpdate(DocumentEvent e){
					onChange(e);
				}
				public void onChange(DocumentEvent e) {
					CustomersPage.this.refresh();
				}
			});
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
					MySQLManager manager = new MySQLManager();
					try {
						manager.openConnection();

						List<Customer> customers = manager.getCustomers(filtersPanel.searchField.getText());
						for (int i = 1; i <= customers.size(); i++) {
							constraints.gridy = i;

							Customer customer = customers.get(i-1);
							cell = new TableCell(customer.getName(), 30);
							layout.setConstraints(cell, constraints);
							add(cell);
							cell = new TableCell(customers.get(i-1).getAddress(), 30);
							layout.setConstraints(cell, constraints);
							add(cell);
							cell = new TableCell(customers.get(i-1).getPhoneNumber());
							layout.setConstraints(cell, constraints);
							add(cell);
							cell = new TableCell(customers.get(i-1).getEmail(), 10);
							layout.setConstraints(cell, constraints);
							add(cell);
							cell = new TableCell(customers.get(i-1).getBankAccount(),20);
							layout.setConstraints(cell, constraints);
							add(cell);
							cell = new TableCell(customers.get(i-1).getRequisites(), 50);
							layout.setConstraints(cell, constraints);
							add(cell);
						}
					} catch (ClassNotFoundException | SQLException throwables) {
						throwables.printStackTrace();
					} finally {
						try {
							manager.close();
						} catch (SQLException throwables) {
							throwables.printStackTrace();
						}
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
