package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class Styles {
	public static class Fonts {
		public static final Font TITLE;
		public static final Font MENU; 
		public static final Font BUTTON;
		public static final Font TEXT;
		public static final Font BIG_TEXT;
		static {
	    	Font title = null;
	    	Font text = null;
			try {
				title = FontFile.getFont("bamf-italic-font.ttf", Font.PLAIN, 30);
				text = FontFile.getFont("AeroMaticsBold.ttf", Font.PLAIN, 17);
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
				title = new javax.swing.JLabel().getFont();
			}	
			TITLE = title;
			MENU = title.deriveFont(title.getStyle(), title.getSize() / 2);
			BUTTON = title.deriveFont(title.getStyle(), (int) (title.getSize() / 2.5));
			TEXT = text;
			BIG_TEXT = text.deriveFont(text.getStyle(), (int) (text.getSize() * 1.5));
	    }
	}
	public static class Colors {	    
	    public static final Color BLUE = Color.decode("#0000CD");
	    public static final Color LIGHT_BLUE = Color.decode("#0000FF");
	    public static final Color POWDER_BLUE = Color.decode("#B0E0E6");
	    public static final Color LIGHT_CYAN = Color.decode("#E0FFFF");
	    public static final Color WHITE = Color.WHITE;
	}    
    private Styles() {}
}
