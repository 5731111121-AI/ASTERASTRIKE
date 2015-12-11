package utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawingUtility {

	public static BufferedImage getImageFromResource(String directory) {
		return getImage("res/pic/" + directory);
	}
	
	public static BufferedImage getImage(String directory) {
		try {
			return ImageIO.read(DrawingUtility.class.getClassLoader().getResource(directory));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//protected static final BufferedImage BACKGROUND = getImageFromResource("background-sprite.jpg");
}
