package utility;

import java.awt.image.BufferedImage;

public class ResourceUtility {

	public BufferedImage mainShipSprite;
	//general
	public static final BufferedImage titleBG = DrawingUtility.getImageFromResource("titleSprite.jpg");
	public static final BufferedImage logo = DrawingUtility.getImageFromResource("logo.png");
	public static final BufferedImage gameBG = DrawingUtility.getImageFromResource("backgroundSprite.jpg");
	
	//ship
	public static final BufferedImage ship_0 = DrawingUtility.getImageFromResource("ship0.png");
	public static final BufferedImage ship_1 = DrawingUtility.getImageFromResource("ship1.png");
	public static final BufferedImage ship_2 = DrawingUtility.getImageFromResource("ship2.png");
	public static final BufferedImage ship_3 = DrawingUtility.getImageFromResource("ship3.png");
	public static final BufferedImage ship_4 = DrawingUtility.getImageFromResource("ship4.png");
	public static final BufferedImage enemy_0 = DrawingUtility.getImageFromResource("enemy0.png");
	public static final BufferedImage enemy_1 = DrawingUtility.getImageFromResource("enemy1.png");
	public static final BufferedImage enemy_2 = DrawingUtility.getImageFromResource("enemy2.png");
}
