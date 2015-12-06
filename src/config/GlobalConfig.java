package config;

import java.awt.Font;

public class GlobalConfig {

	public static final String GAME_NAME = "ASTERA STRIKE";
	//screen configuration
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 768;
	public static final int SCREEN_WIDTH_CENTER = SCREEN_WIDTH / 2;
	public static final int SCREEN_HEIGHT_CENTER = SCREEN_HEIGHT / 2;
	public static final Font mainFont = new Font("VanadineRg", Font.PLAIN, 40);
	public static final Font subFont = new Font("VenusRisingRg", Font.PLAIN, 40);
	//game configuration
	public static final int DEFAULT_SPEEDX = 50;
	public static final int DEFAULT_SPEEDY = 50;
	public static final int DEFAULT_MAXHP = 5;
	public static final int DEFAULT_BULLET_DAMAGE = 1;
	public static final int DEFAULT_SHOOTING_DELAY = 40;
	public static final int GAME_DELAY = 20;
}
