package config;

import java.awt.Font;

import utility.GeneralUtility;

public class GlobalConfig {

	public static final String GAME_NAME = "ASTERASTRIKE";
	public static final int REFRESH_DELAY = 30;
	//screen configuration
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 576;
	public static final int SCREEN_WIDTH_CENTER = SCREEN_WIDTH / 2;
	public static final int SCREEN_HEIGHT_CENTER = SCREEN_HEIGHT / 2;
	public static final Font mainFont = GeneralUtility.getFontFromResource("VanadineRg.ttf").deriveFont(Font.PLAIN, 30);
	public static final Font subFont = GeneralUtility.getFontFromResource("VenusRisingRg.ttf").deriveFont(Font.PLAIN, 20);
	//game configuration
	public static final int DEFAULT_SPEEDX = 2;
	public static final int DEFAULT_SPEEDY = 1;
	public static final int DEFAULT_MAXHP = 7;
	public static final int DEFAULT_BULLET_DAMAGE = 1;
	public static final int DEFAULT_SHOOTING_DELAY = 15;
	public static final int DEFAULT_BULLET_SPEED = 15;
	public static final int GAME_DELAY = 20;
	//game save
	public static int currentShip;
	public static int credits;
	public static int score;
	public static boolean isSoundOn;
	public static boolean[] isBought;
}
