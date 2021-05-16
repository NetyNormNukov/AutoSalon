package gui;
import javax.swing.*;

import entities.Manager;
import gui.pages.CatalogPage;
import gui.pages.Page;
import gui.pages.CatalogPage;
import gui.pages.CustomersPage;
import gui.pages.DeliveriesPage;
import gui.pages.Page;
import gui.pages.SalesPage;
import gui.pages.SellersPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayDeque;
import java.util.Deque;

public class ApplicationFrame extends JFrame {
    private static final long serialVersionUID = 2269971701250845501L;    		
    private JPanel contentPane; 
    
    private HeadPanel headPanel;    
    private Page currentPage;
    private FootPanel footPanel;
     
    private Deque<Page> pages = new ArrayDeque<>();
    
    public ApplicationFrame() {
        setTitle("AutoSalon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screensize.width/10, screensize.height/8, (int)(screensize.width/1.2), (int)(screensize.height/1.3));
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Styles.Colors.WHITE);
        
        headPanel = new HeadPanel();        
        contentPane.add(headPanel, BorderLayout.NORTH);        
        footPanel = new FootPanel();               
        contentPane.add(footPanel, BorderLayout.SOUTH);
        currentPage = new CatalogPage(this);
        contentPane.add(currentPage, BorderLayout.CENTER);
        setContentPane(contentPane);
        setVisible(true);
        //new AuthorizationFrame(this);
    }
    public void setPage(Page newPage) {
    	contentPane.remove(currentPage);
    	pages.addFirst(currentPage);
    	currentPage = newPage;
    	contentPane.add(currentPage, BorderLayout.CENTER);
    	this.revalidate();
    	this.repaint();
    }
    public void back() {
    	contentPane.remove(currentPage);
    	currentPage = pages.pollFirst();
    	contentPane.add(currentPage, BorderLayout.CENTER);
    	this.revalidate();
    	this.repaint();
    }
    public void setManager(Manager manager) {
    	footPanel.setManager(manager);
        setVisible(true);
    }
    
    
    private class HeadPanel extends JPanel {
		private static final long serialVersionUID = 5124266059046348123L;
		private JPanel titlePanel;
	    private MenuBar menuBar; 
		public HeadPanel() {
			super(new BorderLayout());	        
	        titlePanel = new JPanel();
	        titlePanel.setBackground(Styles.Colors.BLUE);
	        JLabel title = new JLabel("auto salon ");
	        title.setFont(Styles.Fonts.TITLE);        
	        title.setForeground(Styles.Colors.WHITE);
	        titlePanel.add(title);
	        super.add(titlePanel, BorderLayout.NORTH);        
	        
	        menuBar = new MenuBar();
	        super.add(menuBar, BorderLayout.SOUTH);
		}
		private class MenuBar extends JPanel {
	    	private static final long serialVersionUID = 5237335232850181080L;
	    	private Button catalogButton;
	        private Button deliveriesButton;
	        private Button salesButton;
	    	private Button sellersButton;
	        private Button customersButton;
	        
	    	public MenuBar() {
	    		super(new FlowLayout(FlowLayout.LEFT, 5, 5));
	            super.setBackground(Styles.Colors.BLUE);
	    		
	            catalogButton = new Button("catalog ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
	            	setPage(new CatalogPage(ApplicationFrame.this));
	            	pages.clear();
	            });
	            catalogButton.setBorder(BorderFactory.createEmptyBorder());
	            super.add(catalogButton);
	    		
	    		deliveriesButton = new Button("deliveries ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
	            	setPage(new DeliveriesPage(ApplicationFrame.this));
	            	pages.clear();
	            });
	    		deliveriesButton.setBorder(BorderFactory.createEmptyBorder());
	    		super.add(deliveriesButton);
	    		
	    		salesButton = new Button("sales ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
	    			setPage(new SalesPage(ApplicationFrame.this));
	            	pages.clear();
	    		});
	    		salesButton.setBorder(BorderFactory.createEmptyBorder());
	    		super.add(salesButton);
	    		
	    		sellersButton = new Button("sellers ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
	    			setPage(new SellersPage(ApplicationFrame.this));
	            	pages.clear();
	    		});
	    		sellersButton.setBorder(BorderFactory.createEmptyBorder());
	    		super.add(sellersButton);
	    		
	    		customersButton = new Button("customers ", Styles.Fonts.MENU, Styles.Colors.WHITE, Styles.Colors.BLUE, event -> {
	    			setPage(new CustomersPage(ApplicationFrame.this));
	            	pages.clear();
	    		});
	    		customersButton.setBorder(BorderFactory.createEmptyBorder());
	    		super.add(customersButton);
	    	}
	    }
    }
    
    private class FootPanel extends JPanel {
    	private static final long serialVersionUID = -430027279308530093L;
    	private JLabel currentManagerLabel;
        private Button logOutButton;   
        
    	public FootPanel() {
    		super(new FlowLayout(FlowLayout.RIGHT, 12, 12));
    		currentManagerLabel = new JLabel();
    		currentManagerLabel.setFont(Styles.Fonts.MENU);
    		currentManagerLabel.setForeground(Styles.Colors.WHITE);
            super.add(currentManagerLabel);
            
            logOutButton = new Button("log out", Styles.Fonts.MENU, Styles.Colors.WHITE, Color.RED, event -> {
            	currentManagerLabel.setText("");
        		logOutButton.setVisible(false);
        		ApplicationFrame.this.pages.clear();
        		ApplicationFrame.this.setPage(new CatalogPage(ApplicationFrame.this));
            	new AuthorizationFrame(ApplicationFrame.this);
            });
            logOutButton.setVisible(false);
            super.add(logOutButton);
            super.setBackground(Styles.Colors.BLUE); 
    	}
    	public void setManager(Manager manager) {
    		currentManagerLabel.setText(manager.getName().toLowerCase() + " " + manager.getSurname().toLowerCase() + " ");
    		logOutButton.setVisible(true);
    	}
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ApplicationFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
