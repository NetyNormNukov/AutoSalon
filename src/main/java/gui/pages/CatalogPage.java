package gui.pages;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import database.MySQLManager;
import gui.ApplicationFrame;
import gui.Styles;

public class CatalogPage extends Page {
	private static final long serialVersionUID = -3481668154987152542L;	
	private FiltersPanel filtersPanel;
	private CatalogPanel catalogPanel;
	
	public CatalogPage(ApplicationFrame parent) {
		super(parent);		
		filtersPanel = new FiltersPanel();
		super.add(filtersPanel, BorderLayout.NORTH);
		catalogPanel = new CatalogPanel();
		super.add(catalogPanel, BorderLayout.CENTER);
		
	}
	private class FiltersPanel extends JPanel {
		private static final long serialVersionUID = -8146284544728838159L;
		private JLabel markLabel;
		private JComboBox<String> markBox;
		private JLabel regionLabel;
		private JComboBox<String> regionBox;
		private JLabel colorLabel;
		private JComboBox<String> colorBox;
		private JLabel bodyLabel;
		private JComboBox<String> bodyBox;
		private JLabel petrolLabel;
		private JComboBox<String> petrolBox;
		private JLabel transmissionLabel;
		private JComboBox<String> transmissionBox;
		private JLabel typeOfDriveLabel;
		private JComboBox<String> typeOfDriveBox;
		private JLabel seatsLabel;
		private JComboBox<String> seatsBox;
		private JLabel doorsLabel;
		private JComboBox<String> doorsBox;
		private JLabel yearFromLabel;
		private JSpinner yearFromSpinner;
		private JLabel yearToLabel;
		private JSpinner yearToSpinner;
		private JLabel costFromLabel;
		private JSpinner costFromSpinner;
		private JLabel costToLabel;
		private JSpinner costToSpinner;
		
		
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
			constraints.insets = new Insets(10, 20, 0, 0);
			constraints.ipadx = 0;
			constraints.ipady = 0;
			constraints.weightx = 1;
			constraints.weighty = 1;

			MySQLManager manager = new MySQLManager();
			try {
				manager.openConnection();

				markLabel = new JLabel("MARK: ");
				markLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(markLabel, constraints);
				add(markLabel);

				constraints.insets.top = 5;
				constraints.insets.left = 10;
				List<String> marks = manager.getAutoMark();
				marks.add(0, "--Any--");
				markBox = new JComboBox<String>(marks.toArray(new String[marks.size()]));
				markBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(markBox, constraints);
				add(markBox);

				constraints.insets.top = 10;
				regionLabel = new JLabel("MANUFACTURE REGION: ");
				regionLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(regionLabel, constraints);
				add(regionLabel);

				constraints.insets.top = 5;
				List<String> regions = manager.getManufactureRegion();
				regions.add(0, "--Any--");
				regionBox = new JComboBox<String>(regions.toArray(new String[regions.size()]));
				regionBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(regionBox, constraints);
				add(regionBox);

				constraints.insets.top = 10;
				colorLabel = new JLabel("COLOR: ");
				colorLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(colorLabel, constraints);
				add(colorLabel);

				constraints.insets.top = 5;
				List<String> colors = manager.getColor();
				colors.add(0, "--Any--");
				colorBox = new JComboBox<String>(colors.toArray(new String[colors.size()]));
				colorBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(colorBox, constraints);
				add(colorBox);

				constraints.insets.top = 10;
				bodyLabel = new JLabel("BODY TYPE: ");
				bodyLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(bodyLabel, constraints);
				add(bodyLabel);

				constraints.insets.top = 5;
				constraints.gridwidth = GridBagConstraints.REMAINDER;
				List<String> bodies = manager.getBodyType();
				bodies.add(0, "--Any--");
				bodyBox = new JComboBox<String>(bodies.toArray(new String[bodies.size()]));
				bodyBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(bodyBox, constraints);
				add(bodyBox);

				constraints.insets.top = 10;
				constraints.gridwidth = 1;
				constraints.insets.left = 20;
				petrolLabel = new JLabel("PETROL TYPE: ");
				petrolLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(petrolLabel, constraints);
				add(petrolLabel);

				constraints.insets.top = 5;
				constraints.insets.left = 10;
				List<String> petrols = manager.getPetrolType();
				petrols.add(0, "--Any--");
				petrolBox = new JComboBox<String>(petrols.toArray(new String[petrols.size()]));
				petrolBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(petrolBox, constraints);
				add(petrolBox);

				constraints.insets.top = 10;
				transmissionLabel = new JLabel("TRANSMISSION: ");
				transmissionLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(transmissionLabel, constraints);
				add(transmissionLabel);

				constraints.insets.top = 5;
				List<String> transmissions = manager.getTransmissionType();
				transmissions.add(0, "--Any--");
				transmissionBox = new JComboBox<String>(transmissions.toArray(new String[transmissions.size()]));
				transmissionBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(transmissionBox, constraints);
				add(transmissionBox);

				constraints.insets.top = 10;
				typeOfDriveLabel = new JLabel("TYPE OF DRIVE: ");
				typeOfDriveLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(typeOfDriveLabel, constraints);
				add(typeOfDriveLabel);

				constraints.insets.top = 5;
				constraints.gridwidth = GridBagConstraints.REMAINDER;
				List<String> typesOfDrive = manager.getTypeOfDrive();
				typesOfDrive.add(0, "--Any--");
				typeOfDriveBox = new JComboBox<String>(typesOfDrive.toArray(new String[typesOfDrive.size()]));
				typeOfDriveBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(typeOfDriveBox, constraints);
				add(typeOfDriveBox);

				constraints.insets.top = 10;
				constraints.insets.left = 20;
				constraints.gridwidth = 1;
				yearFromLabel = new JLabel("YEAR FROM: ");
				yearFromLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(yearFromLabel, constraints);
				add(yearFromLabel);

				constraints.insets.top = 5;
				constraints.insets.left = 10;
				yearFromSpinner = new JSpinner(new SpinnerNumberModel(2000, 1970, 2021, 1));
				yearFromSpinner.setFont(Styles.Fonts.TEXT);
				yearFromSpinner.addChangeListener(event -> {
					JSpinner spinner = (JSpinner) event.getSource();
					if((int) spinner.getValue() > (int) yearToSpinner.getValue()) {
						spinner.setValue((int) spinner.getValue() + 1);
					}
				});
				layout.setConstraints(yearFromSpinner, constraints);
				add(yearFromSpinner);

				constraints.insets.top = 10;
				yearToLabel = new JLabel("YEAR TO: ");
				yearToLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(yearToLabel, constraints);
				add(yearToLabel);

				constraints.insets.top = 5;
				yearToSpinner = new JSpinner(new SpinnerNumberModel(2021, 1970, 2021, 1));
				yearToSpinner.setFont(Styles.Fonts.TEXT);
				yearToSpinner.addChangeListener(event -> {
					JSpinner spinner = (JSpinner) event.getSource();
					if((int) spinner.getValue() < (int) yearFromSpinner.getValue()) {
						spinner.setValue((int) spinner.getValue() + 1);
					}
				});
				layout.setConstraints(yearToSpinner, constraints);
				add(yearToSpinner);

				constraints.insets.top = 10;
				seatsLabel = new JLabel("SEATS  COUNT:");
				seatsLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(seatsLabel, constraints);
				add(seatsLabel);

				constraints.insets.top = 5;
				seatsBox = new JComboBox<String>(new String[] {"--Any--", "2", "3", "4", "5", "6", "7", "8"});
				seatsBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(seatsBox, constraints);
				add(seatsBox);

				constraints.insets.top = 10;
				doorsLabel = new JLabel("DOORS  COUNT: ");
				doorsLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(doorsLabel, constraints);
				add(doorsLabel);

				constraints.insets.top = 5;
				constraints.gridwidth = GridBagConstraints.REMAINDER;
				doorsBox = new JComboBox<String>(new String[] {"--Any--", "2", "3", "4", "5"});
				doorsBox.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(doorsBox, constraints);
				add(doorsBox);

				constraints.insets.top = 10;
				constraints.insets.left = 20;
				constraints.insets.bottom = 10;
				constraints.gridwidth = 1;
				costFromLabel = new JLabel("COST FROM: ");
				costFromLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(costFromLabel, constraints);
				add(costFromLabel);

				constraints.insets.top = 5;
				constraints.insets.left = 10;
				costFromSpinner = new JSpinner(new SpinnerNumberModel(3000, 100, 1000000, 100));
				costFromSpinner.setFont(Styles.Fonts.TEXT);
				costFromSpinner.addChangeListener(event -> {
					JSpinner spinner = (JSpinner) event.getSource();
					if((int) spinner.getValue() > (int) costToSpinner.getValue()) {
						spinner.setValue((int) spinner.getValue() - 100);
					}
				});
				layout.setConstraints(costFromSpinner, constraints);
				add(costFromSpinner);

				constraints.insets.top = 10;
				costToLabel = new JLabel("COST TO: ");
				costToLabel.setFont(Styles.Fonts.TEXT);
				layout.setConstraints(costToLabel, constraints);
				add(costToLabel);

				constraints.insets.top = 5;
				costToSpinner = new JSpinner(new SpinnerNumberModel(100000, 100, 1000000, 100));
				costToSpinner.setFont(Styles.Fonts.TEXT);
				costToSpinner.addChangeListener(event -> {
					JSpinner spinner = (JSpinner) event.getSource();
					if((int) spinner.getValue() < (int) costFromSpinner.getValue()) {
						spinner.setValue((int) spinner.getValue() + 100);
					}
				});
				layout.setConstraints(costToSpinner, constraints);
				add(costToSpinner);
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
	}
	private class CatalogPanel extends JScrollPane {
		private static final long serialVersionUID = 4313280640157064262L;		
		
		public CatalogPanel() {
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
			},	VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_AS_NEEDED);
		}
	}
}
