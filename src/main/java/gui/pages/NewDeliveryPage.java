package gui.pages;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import database.MySQLManager;
import database.SQLBuilder;
import entities.Car;
import entities.Customer;
import entities.Present;
import entities.Seller;
import gui.ApplicationFrame;
import gui.Button;
import gui.OptionPane;
import gui.Styles;

public class NewDeliveryPage extends Page {
	private static final long serialVersionUID = 4390494729144682937L;
	private JScrollPane scrollPane;
	private ContentPanel contentPanel;

	public NewDeliveryPage(ApplicationFrame parent) {
		super(parent);
		contentPanel = new ContentPanel();
		scrollPane = new JScrollPane(contentPanel);
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

		private JPanel cost_sale_Panel;
		private JLabel cost_sale_Label;
		private JSpinner cost_sale_Spinner;
		
		private JPanel countPanel;
		private JLabel countLabel;
		private JSpinner countSpinner;
		
		private JPanel annotationPanel;
		private JLabel annotationLabel;
		private JTextField annotationField;

		private CarsPanel carsPanel;
		
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

			MySQLManager manager = new MySQLManager();
			try {

				buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));

				backButton = new Button("< back ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.back());
				buttonsPanel.add(backButton);

				sellingButton = new Button("add delivery ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
					if (ContentPanel.this.modelField.getText().equals("") ||
							ContentPanel.this.regionField.getText().equals("") ||
							ContentPanel.this.engineField.getText().equals("") ||
							ContentPanel.this.sellerBox.getItemAt(ContentPanel.this.sellerBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.markBox.getItemAt(ContentPanel.this.markBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.colorBox.getItemAt(ContentPanel.this.colorBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.bodyBox.getItemAt(ContentPanel.this.bodyBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.petrolBox.getItemAt(ContentPanel.this.petrolBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.transmissionBox.getItemAt(ContentPanel.this.transmissionBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.typeOfDriveBox.getItemAt(ContentPanel.this.typeOfDriveBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.seatsBox.getItemAt(ContentPanel.this.seatsBox.getSelectedIndex()).equals("--Any--") ||
							ContentPanel.this.doorsBox.getItemAt(ContentPanel.this.doorsBox.getSelectedIndex()).equals("--Any--")
					) {
						OptionPane.showMessageDialog(NewDeliveryPage.this.parent, "Not all fields are filled.", "Error", OptionPane.ERROR_MESSAGE);
					}else {
						MySQLManager sqlmanager = new MySQLManager();
						try {
							sqlmanager.openConnection();
							Present car;
							if (carsPanel.cars.size() == 0) {
								car = sqlmanager.insertIntoCarAndGetNewPresent(
										markBox.getItemAt(markBox.getSelectedIndex()),
										modelField.getText(),
										colorBox.getItemAt(colorBox.getSelectedIndex()),
										regionField.getText(),
										engineField.getText(),
										yearSpinner.getValue()+"",
										bodyBox.getItemAt(bodyBox.getSelectedIndex()),
										transmissionBox.getItemAt(transmissionBox.getSelectedIndex()),
										petrolBox.getItemAt(petrolBox.getSelectedIndex()),
										typeOfDriveBox.getItemAt(typeOfDriveBox.getSelectedIndex()),
										seatsBox.getItemAt(seatsBox.getSelectedIndex()),
										doorsBox.getItemAt(doorsBox.getSelectedIndex()),
										(int) costSpinner.getValue(),
										(int) countSpinner.getValue()
								);

							} else {
								car = carsPanel.cars.get(0);
							}
							System.out.println("external" + car.toString());
							sqlmanager.insertIntoIn((String) sellerBox.getSelectedItem(), (int) countSpinner.getValue(), annotationField.getText(),
													car.getCar().getId(), (int) costSpinner.getValue());
						} catch (ClassNotFoundException | SQLException throwables) {
							throwables.printStackTrace();
						} finally {
							try {
								sqlmanager.close();
							} catch (SQLException throwables) {
								throwables.printStackTrace();
							}
						}
						OptionPane.showMessageDialog(NewDeliveryPage.this.parent, "Succefully added", "Message", OptionPane.INFORMATION_MESSAGE);
					}
				});
				buttonsPanel.add(sellingButton);

				layout.setConstraints(buttonsPanel, constraints);
				add(buttonsPanel);

				manager.openConnection();

				constraints.insets.left = 50;
				sellerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 1));

				sellerLabel = new JLabel("seller: ");
				sellerLabel.setFont(Styles.Fonts.MENU);
				sellerPanel.add(sellerLabel);

				java.util.List<String> sellers = manager.getSellersName();
				sellers.add(0, "--Any--");
				sellerBox = new JComboBox<String>(sellers.toArray(new String[sellers.size()]));
				sellerBox.setFont(Styles.Fonts.TEXT);
				sellerBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				sellerPanel.add(sellerBox);

				layout.setConstraints(sellerPanel, constraints);
				add(sellerPanel);

				constraints.insets.top = 1;
				markPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				markLabel = new JLabel("mark: ");
				markLabel.setFont(Styles.Fonts.MENU);
				markPanel.add(markLabel);

				java.util.List<String> marks = manager.getAutoMark();
				marks.add(0, "--Any--");
				markBox = new JComboBox<String>(marks.toArray(new String[marks.size()]));
				markBox.setFont(Styles.Fonts.TEXT);
				markBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				markPanel.add(markBox);

				layout.setConstraints(markPanel, constraints);
				add(markPanel);

				modelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				modelLabel = new JLabel("model: ");
				modelLabel.setFont(Styles.Fonts.MENU);
				modelPanel.add(modelLabel);

				modelField = new JTextField(15);
				modelField.setFont(Styles.Fonts.TEXT);
				modelField.getDocument().addDocumentListener(new DocumentListener() {
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
						NewDeliveryPage.ContentPanel.this.refresh();
					}
				});
				modelPanel.add(modelField);

				layout.setConstraints(modelPanel, constraints);
				add(modelPanel);

				regionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				regionLabel = new JLabel("manufacture region: ");
				regionLabel.setFont(Styles.Fonts.MENU);
				regionPanel.add(regionLabel);

				regionField = new JTextField(15);
				regionField.setFont(Styles.Fonts.TEXT);
				regionField.getDocument().addDocumentListener(new DocumentListener() {
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
						NewDeliveryPage.ContentPanel.this.refresh();
					}
				});
				regionPanel.add(regionField);

				layout.setConstraints(regionPanel, constraints);
				add(regionPanel);

				yearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				yearLabel = new JLabel("year: ");
				yearLabel.setFont(Styles.Fonts.MENU);
				yearPanel.add(yearLabel);

				yearSpinner = new JSpinner(new SpinnerNumberModel(2021, 1970, 2021, 1));
				yearSpinner.setFont(Styles.Fonts.TEXT);
				yearSpinner.addChangeListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				yearPanel.add(yearSpinner);

				layout.setConstraints(yearPanel, constraints);
				add(yearPanel);

				colorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				colorLabel = new JLabel("color: ");
				colorLabel.setFont(Styles.Fonts.MENU);
				colorPanel.add(colorLabel);

				java.util.List<String> colors = manager.getColor();
				colors.add(0, "--Any--");
				colorBox = new JComboBox<String>(colors.toArray(new String[colors.size()]));
				colorBox.setFont(Styles.Fonts.TEXT);
				colorBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				colorPanel.add(colorBox);

				layout.setConstraints(colorPanel, constraints);
				add(colorPanel);

				bodyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				bodyLabel = new JLabel("body type: ");
				bodyLabel.setFont(Styles.Fonts.MENU);
				bodyPanel.add(bodyLabel);

				java.util.List<String> bodies = manager.getBodyType();
				bodies.add(0, "--Any--");
				bodyBox = new JComboBox<String>(bodies.toArray(new String[bodies.size()]));
				bodyBox.setFont(Styles.Fonts.TEXT);
				bodyBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				bodyPanel.add(bodyBox);

				layout.setConstraints(bodyPanel, constraints);
				add(bodyPanel);

				petrolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				petrolLabel = new JLabel("petrol type: ");
				petrolLabel.setFont(Styles.Fonts.MENU);
				petrolPanel.add(petrolLabel);

				java.util.List<String> petrols = manager.getPetrolType();
				petrols.add(0, "--Any--");
				petrolBox = new JComboBox<String>(petrols.toArray(new String[petrols.size()]));
				petrolBox.setFont(Styles.Fonts.TEXT);
				petrolBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				petrolPanel.add(petrolBox);

				layout.setConstraints(petrolPanel, constraints);
				add(petrolPanel);

				transmissionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				transmissionLabel = new JLabel("transmission: ");
				transmissionLabel.setFont(Styles.Fonts.MENU);
				transmissionPanel.add(transmissionLabel);

				java.util.List<String> transmissions = manager.getTransmissionType();
				transmissions.add(0, "--Any--");
				transmissionBox = new JComboBox<String>(transmissions.toArray(new String[transmissions.size()]));
				transmissionBox.setFont(Styles.Fonts.TEXT);
				transmissionBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				transmissionPanel.add(transmissionBox);

				layout.setConstraints(transmissionPanel, constraints);
				add(transmissionPanel);

				typeOfDrivePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				typeOfDriveLabel = new JLabel("type of drive: ");
				typeOfDriveLabel.setFont(Styles.Fonts.MENU);
				typeOfDrivePanel.add(typeOfDriveLabel);

				java.util.List<String> typesOfDrive = manager.getTypeOfDrive();
				typesOfDrive.add(0, "--Any--");
				typeOfDriveBox = new JComboBox<String>(typesOfDrive.toArray(new String[typesOfDrive.size()]));
				typeOfDriveBox.setFont(Styles.Fonts.TEXT);
				typeOfDriveBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				typeOfDrivePanel.add(typeOfDriveBox);

				layout.setConstraints(typeOfDrivePanel, constraints);
				add(typeOfDrivePanel);

				enginePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				engineLabel = new JLabel("engine volume: ");
				engineLabel.setFont(Styles.Fonts.MENU);
				enginePanel.add(engineLabel);

				engineField = new JTextField(5);
				engineField.setFont(Styles.Fonts.TEXT);
				engineField.getDocument().addDocumentListener(new DocumentListener() {
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
						NewDeliveryPage.ContentPanel.this.refresh();
					}
				});
				enginePanel.add(engineField);

				layout.setConstraints(enginePanel, constraints);
				add(enginePanel);

				seatsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				seatsLabel = new JLabel("number of seats: ");
				seatsLabel.setFont(Styles.Fonts.MENU);
				seatsPanel.add(seatsLabel);

				seatsBox = new JComboBox<String>(new String[]{"--Any--", "1", "2", "3", "4", "5", "6","7", "8"});
				seatsBox.setFont(Styles.Fonts.TEXT);
				seatsBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				seatsPanel.add(seatsBox);

				layout.setConstraints(seatsPanel, constraints);
				add(seatsPanel);

				doorsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				doorsLabel = new JLabel("number of doors: ");
				doorsLabel.setFont(Styles.Fonts.MENU);
				doorsPanel.add(doorsLabel);

				doorsBox = new JComboBox<String>(new String[]{"--Any--", "1", "2", "3", "4", "5"});
				doorsBox.setFont(Styles.Fonts.TEXT);
				doorsBox.addItemListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				doorsPanel.add(doorsBox);

				layout.setConstraints(doorsPanel, constraints);
				add(doorsPanel);

				costPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				costLabel = new JLabel("cost: ");
				costLabel.setFont(Styles.Fonts.MENU);
				costPanel.add(costLabel);

				costSpinner = new JSpinner(new SpinnerNumberModel(50000, 1000, 1000000, 100));
				costSpinner.setFont(Styles.Fonts.TEXT);
				costSpinner.addChangeListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				costPanel.add(costSpinner);

				cost_sale_Label = new JLabel("cost to sell: ");
				cost_sale_Label.setFont(Styles.Fonts.MENU);
				costPanel.add(cost_sale_Label);

				cost_sale_Spinner = new JSpinner(new SpinnerNumberModel(60000, 0, 1000000, 100));
				cost_sale_Spinner.setFont(Styles.Fonts.TEXT);
				cost_sale_Spinner.addChangeListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
				costPanel.add(cost_sale_Spinner);

				layout.setConstraints(costPanel, constraints);
				add(costPanel);

				countPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));

				countLabel = new JLabel("count: ");
				countLabel.setFont(Styles.Fonts.MENU);
				countPanel.add(countLabel);

				countSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
				countSpinner.setFont(Styles.Fonts.TEXT);
				countSpinner.addChangeListener(event -> {
					NewDeliveryPage.ContentPanel.this.refresh();
				});
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
				carsPanel = new CarsPanel();
				add(carsPanel);

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
		public void refresh(){
			super.remove(carsPanel);
			carsPanel = new CarsPanel();
			super.add(carsPanel);
			parent.revalidate();
			parent.repaint();
		}
		private class CarsPanel extends JPanel {
			private static final long serialVersionUID = 4313280640157064262L;
			protected List<Present> cars;

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

				MySQLManager manager = new MySQLManager();
				try {
					manager.openConnection();
					SQLBuilder bulder = new SQLBuilder(markBox.getItemAt(markBox.getSelectedIndex()),
							bodyBox.getItemAt(bodyBox.getSelectedIndex()),
							transmissionBox.getItemAt(transmissionBox.getSelectedIndex()),
							petrolBox.getItemAt(petrolBox.getSelectedIndex()),
							typeOfDriveBox.getItemAt(typeOfDriveBox.getSelectedIndex()),
							regionField.getText(),
							colorBox.getItemAt(colorBox.getSelectedIndex()),
							1970, (int) yearSpinner.getValue(),
							seatsBox.getItemAt(seatsBox.getSelectedIndex()),
							doorsBox.getItemAt(doorsBox.getSelectedIndex()),
							0, (int) costSpinner.getValue(),
							(int) cost_sale_Spinner.getValue()
							);
					cars = manager.getPresentBySql(bulder.searchCar());

					for (int i = 0, x = 0; i < cars.size(); i++, x++) {
						if(i % 5 == 0){
							constraints.gridy = i;
							x = 0;
						}
						CarCell cell = new CarCell(parent, cars.get(i));
						constraints.gridx = x;
						layout.setConstraints(cell, constraints);
						add(cell);
					}
				} catch (ClassNotFoundException | SQLException | CloneNotSupportedException | IllegalAccessException throwables) {
					throwables.printStackTrace();
				} finally {
					try {
						manager.close();
					} catch (SQLException throwables) {
						throwables.printStackTrace();
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
				private Present car;
				
				public CarCell(ApplicationFrame frame, Present car) {
					super();
					this.car = car;
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

					nameLabel = new JLabel((car.getCar().getNameMark() + " " + car.getCar().getModel()).toLowerCase() + " ");
					nameLabel.setFont(Styles.Fonts.MENU);
					layout.setConstraints(nameLabel, constraints);
					add(nameLabel);

					constraints.insets.top = 1;
					yearLabel = new JLabel("Year: "+car.getCar().getYear());
					yearLabel.setFont(Styles.Fonts.TEXT);
					layout.setConstraints(yearLabel, constraints);
					add(yearLabel);

					colorLabel = new JLabel("Color: "+car.getCar().getColor());
					colorLabel.setFont(Styles.Fonts.TEXT);
					layout.setConstraints(colorLabel, constraints);
					add(colorLabel);

					bodyLabel = new JLabel("Body type: "+car.getCar().getBodyType());
					bodyLabel.setFont(Styles.Fonts.TEXT);
					layout.setConstraints(bodyLabel, constraints);
					add(bodyLabel);

					petrolLabel = new JLabel("Petrol type: "+car.getCar().getPetrolType());
					petrolLabel.setFont(Styles.Fonts.TEXT);
					layout.setConstraints(petrolLabel, constraints);
					add(petrolLabel);

					transmissionLabel = new JLabel("Transmission: "+car.getCar().getTransmissionType());
					transmissionLabel.setFont(Styles.Fonts.TEXT);
					layout.setConstraints(transmissionLabel, constraints);
					add(transmissionLabel);

					costLabel = new JLabel("Cost: "+car.getCostCar());
					costLabel.setFont(Styles.Fonts.TEXT);
					layout.setConstraints(costLabel, constraints);
					add(costLabel);

					constraints.insets.top = 10;
					constraints.insets.bottom = 10;
					constraints.insets.left = 1;
					JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
					
					Button moreButton = new Button("more >", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> frame.setPage(new CarPage(frame, car, false)));
					buttonsPanel.add(moreButton);
					Button chooseButton = new Button("choose ^ ", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> { 						
						ContentPanel.this.markBox.setSelectedItem(car.getCar().getNameMark());
						ContentPanel.this.modelField.setText(car.getCar().getModel());
						ContentPanel.this.regionField.setText(car.getCar().getRegion());
						ContentPanel.this.yearSpinner.setValue(car.getCar().getYear());
						ContentPanel.this.colorBox.setSelectedItem(car.getCar().getColor());
						ContentPanel.this.bodyBox.setSelectedItem(car.getCar().getBodyType());
						ContentPanel.this.petrolBox.setSelectedItem(car.getCar().getPetrolType());
						ContentPanel.this.transmissionBox.setSelectedItem(car.getCar().getTransmissionType());
						ContentPanel.this.typeOfDriveBox.setSelectedItem(car.getCar().getDriveType());
						ContentPanel.this.engineField.setText(car.getCar().getEngineVolume()+"");
						ContentPanel.this.seatsBox.setSelectedItem(car.getCar().getSeatsNumber()+"");
						ContentPanel.this.doorsBox.setSelectedItem(car.getCar().getDoorNumber()+"");
						ContentPanel.this.costSpinner.setValue((int) car.getCostCar());
						
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
