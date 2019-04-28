package view;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fonts {
public static void font() throws FileNotFoundException, FontFormatException, IOException
{
	GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("Starjedi.ttf")));
	}
}
