package gui;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontFile {
	public static Font getFont(String filename, int style, float size) throws FontFormatException, IOException {		
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File(filename)).deriveFont(style, size);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        return font;
	} 
}
