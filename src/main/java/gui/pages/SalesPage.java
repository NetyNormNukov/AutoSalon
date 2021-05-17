package gui.pages;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import entities.Present;
import gui.ApplicationFrame;
import gui.DateDiffer;
import gui.Styles;

public class SalesPage extends Page {
	private static final long serialVersionUID = -3697065762885541054L;
	private FiltersPanel filtersPanel;
	private DeliveriesPanel catalogPanel;
	
	public SalesPage(ApplicationFrame parent) {
		super(parent);		
		filtersPanel = new FiltersPanel();
		super.add(filtersPanel, BorderLayout.NORTH);
		catalogPanel = new DeliveriesPanel();
		super.add(catalogPanel, BorderLayout.CENTER);		
	}
	private class FiltersPanel extends JPanel {
		private static final long serialVersionUID = -8146284544728838159L;		
		private JLabel dateFromLabel;
		private JSpinner dateFromSpinner;
		private JLabel dateToLabel;
		private JSpinner dateToSpinner;
		
		public FiltersPanel() {
			super();
			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints constraints = new GridBagConstraints();

			this.setLayout(layout);

			constraints.anchor = GridBagConstraints.NORTHWEST; 
			constraints.fill = GridBagConstraints.NONE;  
			constraints.gridheight = 1;
			constraints.gridwidth = 1; 
			constraints.gridx = GridBagConstraints.RELATIVE; 
			constraints.gridy = GridBagConstraints.RELATIVE; 
			constraints.insets = new Insets(10, 20, 10, 0);
			constraints.ipadx = 0;
			constraints.ipady = 0;
			constraints.weightx = 1;
			constraints.weighty = 1;
			
			dateFromLabel = new JLabel("DATE FROM: ");
			dateFromLabel.setFont(Styles.Fonts.TEXT);
			layout.setConstraints(dateFromLabel, constraints);
			add(dateFromLabel);
			
			constraints.insets.top = 7;
			constraints.insets.left = 10;
			
			
		    Date min = null;
			try {
				min = DateDiffer.toDate("1970-01-01");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    Date max = new Date();
		    max.setDate(max.getDate() + 1);
		    max.setHours(0);
		    max.setMinutes(0);
		    
			dateFromSpinner = new JSpinner(new SpinnerDateModel(min, min, max, Calendar.DAY_OF_YEAR));
			dateFromSpinner.setFont(Styles.Fonts.TEXT);
			dateFromSpinner.addChangeListener(event -> {
				JSpinner spinner = (JSpinner) event.getSource();
				if(((Date) spinner.getValue()).compareTo((Date) dateToSpinner.getValue()) > 0) {
					Date date = (Date) spinner.getValue();
					date.setDate(date.getDate() - 1);
					spinner.setValue(date);
				}
			});
			layout.setConstraints(dateFromSpinner, constraints);
			add(dateFromSpinner);
			
			constraints.insets.top = 10;
			dateToLabel = new JLabel("DATE TO: ");
			dateToLabel.setFont(Styles.Fonts.TEXT);
			layout.setConstraints(dateToLabel, constraints);
			add(dateToLabel);
			
			constraints.insets.top = 7;
			dateToSpinner = new JSpinner(new SpinnerDateModel(max, min, max, Calendar.DAY_OF_WEEK_IN_MONTH));
			dateToSpinner.setFont(Styles.Fonts.TEXT);
			dateToSpinner.addChangeListener(event -> {
				JSpinner spinner = (JSpinner) event.getSource();
				if(((Date) spinner.getValue()).compareTo((Date) dateFromSpinner.getValue()) < 0) {
					Date date = (Date) spinner.getValue();
					date.setDate(date.getDate() + 1);
					spinner.setValue(date);
				}
			});
			layout.setConstraints(dateToSpinner, constraints);
			add(dateToSpinner);
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
					TableCell cell = new TableCell("CUSTOMER");
					layout.setConstraints(cell, constraints);
					add(cell); 
					cell = new TableCell("CAR");
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("COST");
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("COUNT");
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("DATE");
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("MANAGER");
					layout.setConstraints(cell, constraints);
					add(cell);
					cell = new TableCell("ANNOTATION");
					layout.setConstraints(cell, constraints);
					add(cell);
					for (int i = 1; i < 10; i++) {
						constraints.gridy = i;	
						cell = new TableCell("���� ������ � ����������", 30, 
								event -> parent.setPage(new CustomerPage(parent)) );
						layout.setConstraints(cell, constraints);
						add(cell);	
						cell = new TableCell("TOYOTA SLS-350R TOYOTA SLS-350R TOYOTA SLS-350R", 30, 
								event -> parent.setPage(new CarPage(parent, new Present(), false)) );
						layout.setConstraints(cell, constraints);
						add(cell);
						cell = new TableCell("2000$");
						layout.setConstraints(cell, constraints);
						add(cell);
						cell = new TableCell("5");
						layout.setConstraints(cell, constraints);
						add(cell);	
						cell = new TableCell("2000-08-01", 10);
						layout.setConstraints(cell, constraints);
						add(cell);							
						cell = new TableCell("���� ���� ������� � ������ ����������", 30);
						layout.setConstraints(cell, constraints);
						add(cell);
						cell = new TableCell("TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT ",
								 30);
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
