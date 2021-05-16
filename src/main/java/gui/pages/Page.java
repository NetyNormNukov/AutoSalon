package gui.pages;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import gui.ApplicationFrame;

public abstract class Page extends JPanel {
	private static final long serialVersionUID = -3481668154987152542L;
	protected ApplicationFrame parent;
	
	public Page(ApplicationFrame parent) {
		super(new BorderLayout());
		this.parent = parent;
	}
}
	