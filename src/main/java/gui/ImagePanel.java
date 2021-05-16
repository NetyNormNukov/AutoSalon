package gui;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 5219963684958461483L;
    private Image im;
    public ImagePanel(String path){
        super();
        try {
            im=ImageIO.read(new File(path));
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (im==null) {
                g.drawString("Error", 0, 0);
            } else {
                //g.drawImage(im, 0, 0, null);
                g.drawImage(im, 0, 0, 200, 200, null);
            }
    }
}

