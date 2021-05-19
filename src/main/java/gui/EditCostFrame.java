package gui;

import Exceptions.CarNotFoundException;
import database.MySQLManager;
import entities.Present;
import gui.ApplicationFrame;
import gui.Button;
import gui.OptionPane;
import gui.Styles;
import gui.pages.CarPage;
import gui.pages.CatalogPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EditCostFrame extends JDialog {
	private static final long serialVersionUID = -6241908319980610135L;
	private JPanel contentPane;
	private JPanel headPanel;
	private JPanel centerPanel;
    private JPanel footPanel;

	private JSpinner costSpinner;
	private Button acceptButton;
	private Button backButton;

	private Present present;

    public EditCostFrame(ApplicationFrame parent, CarPage page) {
    	super(parent, true);
    	this.present = page.car;
        setTitle("Edit Cost");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(this.getOwner().getX() + this.getOwner().getWidth() / 3, this.getOwner().getY() + this.getOwner().getHeight() / 4, 300, 160);
        setResizable(false);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(Styles.Colors.BLUE, 3));
        headPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 6));
        headPanel.add(new JLabel("Enter new selling cost: "));
        contentPane.add(headPanel, BorderLayout.NORTH);        
        
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 12));
        costSpinner = new JSpinner(new SpinnerNumberModel((int)present.getCostCar(), 0, 1_000_000, 100));
        costSpinner.setFont(Styles.Fonts.TEXT);
        centerPanel.add(costSpinner);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        footPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 12));
        acceptButton = new Button("accept ", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
            MySQLManager manager = new MySQLManager();
            try {
                manager.openConnection();
                int cost = (int) costSpinner.getValue();
                manager.updateCostCarByCost(present, cost);
                page.costLabel.setText("cost: "+cost+" ");
            } catch (ClassNotFoundException | SQLException | CarNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    manager.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            EditCostFrame.this.dispose();
        });
        footPanel.add(acceptButton);
        backButton = new Button("< back ", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> this.dispose());
        footPanel.add(backButton);
        contentPane.add(footPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setVisible(true);
    }
}
