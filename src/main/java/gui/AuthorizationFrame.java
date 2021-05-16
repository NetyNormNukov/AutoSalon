package gui;
import database.MySQLManager;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;

public class AuthorizationFrame extends JDialog {
	private static final long serialVersionUID = -6241908319980610135L;
	private JPanel contentPane;
	private JPanel headPanel;
	private JPanel centerPanel;
	private JPanel footPanel;
	
	private JTextField nameField;
	private JPasswordField passwordField;
	private Button signInButton;
	private Button exitButton;

    public AuthorizationFrame(ApplicationFrame parent) {
    	super(parent, true);
        setTitle("Authorization");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);        
        setBounds(this.getOwner().getX() + this.getOwner().getWidth() / 3, this.getOwner().getY() + this.getOwner().getHeight() / 4, 350, 210);
        setResizable(false);
        
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(Styles.Colors.BLUE, 3));
        headPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 6));
        headPanel.add(new JLabel("Enter your account data: "));
        contentPane.add(headPanel, BorderLayout.NORTH);        
        
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 12));
        centerPanel.add(new JLabel("Your name: "));
        nameField = new JTextField(20);
        centerPanel.add(nameField);
        centerPanel.add(new JLabel("Password:  "));
        passwordField = new JPasswordField(20);
        centerPanel.add(passwordField);
        signInButton = new Button("sign in", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
            MySQLManager manager = new MySQLManager();
            try {
                manager.openConnection();
                if(! manager.isManager(nameField.getText(), passwordField.getText()) || nameField.getText().equals("") || passwordField.getText().equals("")){
                    OptionPane.showMessageDialog(parent, "Wrong data", "Error", OptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    parent.setManager(manager.getManagerByPasswordAndName(nameField.getText(), passwordField.getText()));
                    this.dispose();
                }
            } catch (ClassNotFoundException | SQLException e) {
                OptionPane.showMessageDialog(parent, "Wrong data", "Error", OptionPane.ERROR_MESSAGE);
                return;
            }
        });
        centerPanel.add(signInButton);  
        exitButton = new Button("exit", Styles.Fonts.BUTTON, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> System.exit(0));
        centerPanel.add(exitButton);
        contentPane.add(centerPanel);
        
        footPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 12));
        footPanel.add(new JLabel("If you don't have an account, contact the administrator"));
        contentPane.add(footPanel, BorderLayout.SOUTH);
        setContentPane(contentPane);
        setVisible(true);
    }
}
