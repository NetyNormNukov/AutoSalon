package gui.pages;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Car;
import entities.Present;
import gui.ApplicationFrame;
import gui.Button;
import gui.Styles;

public class CarPage extends Page {
	private static final long serialVersionUID = 8648543856948552778L;
	private JLabel markLabel;
	private JLabel modelLabel;
	private JLabel regionLabel;
	private JLabel yearLabel;
	private JLabel colorLabel;
	private JLabel bodyLabel;
	private JLabel petrolLabel;
	private JLabel transmissionLabel;
	private JLabel typeOfDriveLabel;
	private JLabel engineLabel;
	private JLabel seatsLabel;
	private JLabel doorsLabel;
	private JLabel costLabel;
	private JLabel countLabel;
	
	private JPanel buttonsPanel;
	private Button backButton;
	private Button sellingButton;

	private int count;
	private double cost;
	private Car car;
	
	public CarPage(ApplicationFrame parent, Present present) {
		this(parent, present, true);
	}
	public CarPage(ApplicationFrame parent, Car car, int count, double cost, boolean selling){
		super(parent);
		this.car = car;
		this.count = count;
		this.cost = cost;
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();

		this.setLayout(layout);

		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridheight = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridy = GridBagConstraints.RELATIVE;
		constraints.insets = new Insets(10, 50, 1, 0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;

		markLabel = new JLabel("mark: "+car.getNameMark().toLowerCase() + " ");
		markLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(markLabel, constraints);
		add(markLabel);

		constraints.insets.top = 1;
		modelLabel = new JLabel("model: "+car.getModel().toLowerCase() + " ");
		modelLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(modelLabel, constraints);
		add(modelLabel);

		regionLabel = new JLabel("manufacture region: "+car.getRegion().toLowerCase() + " ");
		regionLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(regionLabel, constraints);
		add(regionLabel);

		yearLabel = new JLabel("year: "+car.getYear() + " ");
		yearLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(yearLabel, constraints);
		add(yearLabel);

		colorLabel = new JLabel("color: "+car.getColor().toLowerCase() + " ");
		colorLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(colorLabel, constraints);
		add(colorLabel);

		bodyLabel = new JLabel("body type: "+car.getBodyType().toLowerCase() + " ");
		bodyLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(bodyLabel, constraints);
		add(bodyLabel);

		petrolLabel = new JLabel("petrol type:"+car.getPetrolType().toLowerCase() + " ");
		petrolLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(petrolLabel, constraints);
		add(petrolLabel);

		transmissionLabel = new JLabel("transmission type: "+car.getTransmissionType().toLowerCase() + " ");
		transmissionLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(transmissionLabel, constraints);
		add(transmissionLabel);

		typeOfDriveLabel = new JLabel("type of drive: "+car.getDriveType().toLowerCase() + " ");
		typeOfDriveLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(typeOfDriveLabel, constraints);
		add(typeOfDriveLabel);

		engineLabel = new JLabel("engine volume: "+car.getEngineVolume() + " ");
		engineLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(engineLabel, constraints);
		add(engineLabel);

		seatsLabel = new JLabel("number of seats: "+car.getSeatsNumber() + " ");
		seatsLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(seatsLabel, constraints);
		add(seatsLabel);

		doorsLabel = new JLabel("number of doors: "+car.getDoorNumber() + " ");
		doorsLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(doorsLabel, constraints);
		add(doorsLabel);

		costLabel = new JLabel("cost: "+this.cost + " ");
		costLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(costLabel, constraints);
		add(costLabel);

		countLabel = new JLabel("count: "+this.count+ " ");
		countLabel.setFont(Styles.Fonts.MENU);
		layout.setConstraints(countLabel, constraints);
		add(countLabel);

		buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
		backButton = new Button("< back ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.back());
		buttonsPanel.add(backButton);
		if(selling) {
			sellingButton = new Button("selling > ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> parent.setPage(new SellingPage(parent, car, count, cost)));
			buttonsPanel.add(sellingButton);
		}
		constraints.insets.left = 15;
		layout.setConstraints(buttonsPanel, constraints);
		add(buttonsPanel);
	}
	public CarPage(ApplicationFrame parent, Present present, boolean selling) {
		this(parent, present.getCar(), present.getCountCar(), present.getCostCar(), selling);
	}
}
