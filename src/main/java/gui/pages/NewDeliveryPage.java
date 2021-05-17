package gui.pages;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import entities.Present;
import gui.ApplicationFrame;
import gui.Button;
import gui.Styles;

public class NewDeliveryPage extends Page {
	private static final long serialVersionUID = 4390494729144682937L;
	private JScrollPane scrollPane;
	
	public NewDeliveryPage(ApplicationFrame parent) {
		super(parent);
		scrollPane = new JScrollPane(new ContentPanel());
		add(scrollPane);
		
	}
	private class ContentPanel extends JPanel {
		private static final long serialVersionUID = 8444530915071096626L;
		private JPanel buttonsPanel;
		private Button backButton;
		private Button sellingButton;
		
		private JPanel sellerPanel;
		private JLabel sellerLabel;
		private JComboBox<String> sellerBox;
		
		private JPanel markPanel;
		private JLabel markLabel;
		private JComboBox<String> markBox;
		
		private JPanel modelPanel;
		private JLabel modelLabel;
		private JTextField modelField;
		
		private JPanel regionPanel;
		private JLabel regionLabel;
		private JTextField regionField;
		
		private JPanel yearPanel;
		private JLabel yearLabel;
		private JSpinner yearSpinner;
		
		private JPanel colorPanel;
		private JLabel colorLabel;
		private JComboBox<String> colorBox;
		
		private JPanel bodyPanel;
		private JLabel bodyLabel;
		private JComboBox<String> bodyBox;
		
		private JPanel petrolPanel;
		private JLabel petrolLabel;
		private JComboBox<String> petrolBox;
		
		private JPanel transmissionPanel;
		private JLabel transmissionLabel;
		private JComboBox<String> transmissionBox;
		
		private JPanel typeOfDrivePanel;
		private JLabel typeOfDriveLabel;
		private JComboBox<String> typeOfDriveBox;
		
		private JPanel enginePanel;
		private JLabel engineLabel;
		private JTextField engineField;
		
		private JPanel seatsPanel;
		private JLabel seatsLabel;
		private JComboBox<String> seatsBox;
		
		private JPanel doorsPanel;
		private JLabel doorsLabel;
		private JComboBox<String> doorsBox;
		
		private JPanel costPanel;
		private JLabel costLabel;
		private JSpinner costSpinner;
		
		private JPanel countPanel;
		private JLabel countLabel;
		private JSpinner countSpinner;
		
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
			

			buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
			
			backButton = new Button("< back ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.back());
			buttonsPanel.add(backButton);
		
			sellingButton = new Button("add delivery ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
				if(ContentPanel.this.modelField.getText().equals("") ||
				   ContentPanel.this.regionField.getText().equals("") ||
				   ContentPanel.this.engineField.getText().equals("") ){
					JOptionPane.showMessageDialog(NewDeliveryPage.this.parent, "Not all fields are filled.");							
				}
				else JOptionPane.showMessageDialog(NewDeliveryPage.this.parent, "Succefully added");
			}) ;
			buttonsPanel.add(sellingButton);			
			
			layout.setConstraints(buttonsPanel, constraints);
			add(buttonsPanel);
			
			constraints.insets.left = 50;
			sellerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 1));
			
			sellerLabel = new JLabel("seller: ");
			sellerLabel.setFont(Styles.Fonts.MENU);
			sellerPanel.add(sellerLabel);
			
			sellerBox = new JComboBox<String>(new String[]{"hjuf b rjgsnf", "ideasoft", "elemento"});
			sellerBox.setFont(Styles.Fonts.TEXT);
			sellerPanel.add(sellerBox);
			
			layout.setConstraints(sellerPanel, constraints);
			add(sellerPanel);		

			constraints.insets.top = 1;
			markPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			markLabel = new JLabel("mark: ");
			markLabel.setFont(Styles.Fonts.MENU);
			markPanel.add(markLabel);
			
			markBox = new JComboBox<String>(new String[]{"TOYOTA", "HUINDAY", "CHEVROLET"});
			markBox.setFont(Styles.Fonts.TEXT);
			markPanel.add(markBox);		
			
			layout.setConstraints(markPanel, constraints);
			add(markPanel);
			
			modelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			modelLabel = new JLabel("model: ");
			modelLabel.setFont(Styles.Fonts.MENU);
			modelPanel.add(modelLabel);
			
			modelField = new JTextField(15);
			modelField.setFont(Styles.Fonts.TEXT);
			modelPanel.add(modelField);
			
			layout.setConstraints(modelPanel, constraints);
			add(modelPanel);
			
			regionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			regionLabel = new JLabel("manufacture region: ");
			regionLabel.setFont(Styles.Fonts.MENU);
			regionPanel.add(regionLabel);
			
			regionField = new JTextField(15);
			regionField.setFont(Styles.Fonts.TEXT);
			regionPanel.add(regionField);	
			
			layout.setConstraints(regionPanel, constraints);
			add(regionPanel);
			
			yearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			yearLabel = new JLabel("year: ");
			yearLabel.setFont(Styles.Fonts.MENU);
			yearPanel.add(yearLabel);
			
			yearSpinner = new JSpinner(new SpinnerNumberModel(2000, 1970, 2021, 1));
			yearSpinner.setFont(Styles.Fonts.TEXT);
			yearPanel.add(yearSpinner);
			
			layout.setConstraints(yearPanel, constraints);
			add(yearPanel);
			
			colorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			colorLabel = new JLabel("color: ");
			colorLabel.setFont(Styles.Fonts.MENU);
			colorPanel.add(colorLabel);
			
			colorBox = new JComboBox<String>(new String[] {"red", "blue", "green"});
			colorBox.setFont(Styles.Fonts.TEXT);
			colorPanel.add(colorBox);			
			
			layout.setConstraints(colorPanel, constraints);
			add(colorPanel);
			
			bodyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			bodyLabel = new JLabel("body type: ");
			bodyLabel.setFont(Styles.Fonts.MENU);
			bodyPanel.add(bodyLabel);
			
			bodyBox = new JComboBox<String>(new String[] {"red", "blue", "green"});
			bodyBox.setFont(Styles.Fonts.TEXT);
			bodyPanel.add(bodyBox);	
			
			layout.setConstraints(bodyPanel, constraints);
			add(bodyPanel);
			
			petrolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			petrolLabel = new JLabel("petrol type: ");
			petrolLabel.setFont(Styles.Fonts.MENU);
			petrolPanel.add(petrolLabel);
			
			petrolBox = new JComboBox<String>(new String[] {"gas", "diezel"});
			petrolBox.setFont(Styles.Fonts.TEXT);
			petrolPanel.add(petrolBox);
			
			layout.setConstraints(petrolPanel, constraints);
			add(petrolPanel);
			
			transmissionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			transmissionLabel = new JLabel("transmission: ");
			transmissionLabel.setFont(Styles.Fonts.MENU);
			transmissionPanel.add(transmissionLabel);
			
			transmissionBox = new JComboBox<String>(new String[] {"mechanical", "auto"});
			transmissionBox.setFont(Styles.Fonts.TEXT);
			transmissionPanel.add(transmissionBox);
			
			layout.setConstraints(transmissionPanel, constraints);
			add(transmissionPanel);
			
			typeOfDrivePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			typeOfDriveLabel = new JLabel("type of drive: ");
			typeOfDriveLabel.setFont(Styles.Fonts.MENU);
			typeOfDrivePanel.add(typeOfDriveLabel);
			
			typeOfDriveBox = new JComboBox<String>(new String[] {"front", "full"});
			typeOfDriveBox.setFont(Styles.Fonts.TEXT);
			typeOfDrivePanel.add(typeOfDriveBox);
			
			layout.setConstraints(typeOfDrivePanel, constraints);
			add(typeOfDrivePanel);
			
			enginePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			engineLabel = new JLabel("engine volume: ");
			engineLabel.setFont(Styles.Fonts.MENU);
			enginePanel.add(engineLabel);
			
			engineField = new JTextField(5);
			engineField.setFont(Styles.Fonts.TEXT);
			enginePanel.add(engineField);
					
			layout.setConstraints(enginePanel, constraints);
			add(enginePanel);
			
			seatsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			seatsLabel = new JLabel("number of seats: ");
			seatsLabel.setFont(Styles.Fonts.MENU);
			seatsPanel.add(seatsLabel);
			
			seatsBox = new JComboBox<String>(new String[] {"1", "2"});
			seatsBox.setFont(Styles.Fonts.TEXT);
			seatsPanel.add(seatsBox);
			
			layout.setConstraints(seatsPanel, constraints);
			add(seatsPanel);
			
			doorsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			doorsLabel = new JLabel("number of doors: ");
			doorsLabel.setFont(Styles.Fonts.MENU);
			doorsPanel.add(doorsLabel);
			
			doorsBox = new JComboBox<String>(new String[] {"1", "2"});
			doorsBox.setFont(Styles.Fonts.TEXT);
			doorsPanel.add(doorsBox);
			
			layout.setConstraints(doorsPanel, constraints);
			add(doorsPanel);
			
			costPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			costLabel = new JLabel("cost: ");
			costLabel.setFont(Styles.Fonts.MENU);
			costPanel.add(costLabel);
			
			costSpinner = new JSpinner(new SpinnerNumberModel(2000, 100, 100000, 100));		
			costSpinner.setFont(Styles.Fonts.TEXT);
			costPanel.add(costSpinner);
			
			layout.setConstraints(costPanel, constraints);
			add(costPanel);
			
			countPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			countLabel = new JLabel("count: ");
			countLabel.setFont(Styles.Fonts.MENU);
			countPanel.add(countLabel);
			
			countSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));		
			countSpinner.setFont(Styles.Fonts.TEXT);
			countPanel.add(countSpinner);
			
			layout.setConstraints(countPanel, constraints);
			add(countPanel);
			
			annotationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
			
			annotationLabel = new JLabel("annotation: ");
			annotationLabel.setFont(Styles.Fonts.MENU);
			annotationPanel.add(annotationLabel);
			
			annotationField = new JTextField(30);
			annotationField.setFont(Styles.Fonts.TEXT);
			annotationPanel.add(annotationField);
					
			layout.setConstraints(annotationPanel, constraints);
			add(annotationPanel);
			
			JLabel label = new JLabel("proposed cars: ");
			label.setFont(Styles.Fonts.MENU);
			layout.setConstraints(label, constraints);
			add(label);
			CarsPanel carsPanel = new CarsPanel();
			add(carsPanel);
		}
		private class CarsPanel extends JPanel {
			private static final long serialVersionUID = 4313280640157064262L;		
			
			public CarsPanel() {				
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
				for (int i = 0; i < 10; i++) {
					constraints.gridy = i;
					for (int j = 0; j < 5; j++) {
						CarCell cell = new CarCell(parent);
						constraints.gridx = j;
						layout.setConstraints(cell, constraints);
						add(cell);
					}			
				}			
			}
			private class CarCell extends JPanel {
				private static final long serialVersionUID = -3059067480908071499L;
				private JLabel nameLabel;
				private JLabel yearLabel;
				private JLabel colorLabel;
				private JLabel bodyLabel;
				private JLabel petrolLabel;
				private JLabel transmissionLabel;
				private JLabel costLabel;
				
				public CarCell(ApplicationFrame frame) {
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

					constraints.insets.top = 10;
					constraints.insets.bottom = 10;
					constraints.insets.left = 1;
					JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
					
					Button moreButton = new Button("more >", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> frame.setPage(new CarPage(frame, new Present(), false)));
					buttonsPanel.add(moreButton);
					Button chooseButton = new Button("choose ^ ", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> { 						
						ContentPanel.this.markBox.setSelectedIndex(0);
						ContentPanel.this.modelField.setText("SLS-350");
						ContentPanel.this.regionField.setText("Japan");
						ContentPanel.this.yearSpinner.setValue(2000);
						ContentPanel.this.colorBox.setSelectedIndex(0);
						ContentPanel.this.bodyBox.setSelectedIndex(0);
						ContentPanel.this.petrolBox.setSelectedIndex(0);
						ContentPanel.this.transmissionBox.setSelectedIndex(0);
						ContentPanel.this.typeOfDriveBox.setSelectedIndex(0);
						ContentPanel.this.engineField.setText("1.8");
						ContentPanel.this.seatsBox.setSelectedIndex(0);
						ContentPanel.this.doorsBox.setSelectedIndex(0);
						ContentPanel.this.costSpinner.setValue(2000);
						
						javax.swing.SwingUtilities.invokeLater(new Runnable() {
							   public void run() { 
								   NewDeliveryPage.this.scrollPane.getVerticalScrollBar().setValue(0);
							   }
						});
					});
					buttonsPanel.add(chooseButton);
					
					layout.setConstraints(buttonsPanel, constraints);
					add(buttonsPanel);
					
					setBorder(BorderFactory.createLineBorder(Styles.Colors.BLUE, 3));
				}
			}
		}
	}	
}
