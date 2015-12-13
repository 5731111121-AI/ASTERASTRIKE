package utility;

import java.awt.image.BufferedImage;

import ui.RenderObject;

public class ResourceUtility {

	public BufferedImage mainShipSprite;
	//general
	public static final RenderObject titleBG = new RenderObject(DrawingUtility.getImageFromResource("titleSprite.jpg"));
	public static final RenderObject logo = new RenderObject(DrawingUtility.getImageFromResource("logo.png"));
	public static final RenderObject gameBG = new RenderObject(DrawingUtility.getImageFromResource("backgroundSprite.jpg"));
	public static final RenderObject menuBG0 = new RenderObject(DrawingUtility.getImageFromResource("menuSprite0.jpg"));
	public static final RenderObject menuBG1 = new RenderObject(DrawingUtility.getImageFromResource("menuSprite1.jpg"));
	public static final RenderObject menuBG2 = new RenderObject(DrawingUtility.getImageFromResource("menuSprite2.jpg"));
	public static final RenderObject menuBG3 = new RenderObject(DrawingUtility.getImageFromResource("menuSprite3.jpg"));
	public static final RenderObject menuSel = new RenderObject(DrawingUtility.getImageFromResource("menuSelector.png"));
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
