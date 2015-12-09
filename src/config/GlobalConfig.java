package config;

import java.awt.Font;

import utility.ResourceUtility;

public class GlobalConfig {

	public static final String GAME_NAME = "ASTERA STRIKE";
	//screen configuration
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 768;
	public static final int SCREEN_WIDTH_CENTER = SCREEN_WIDTH / 2;
	public static final int SCREEN_HEIGHT_CENTER = SCREEN_HEIGHT / 2;
	public static final Font mainFont = ResourceUtility.getFontFromResource("VanadineRg.ttf");
	public static final Font subFont = ResourceUtility.getFontFromResource("VenusRisingRg.ttf");
	//game configuration
	public static final int DEFAULT_SPEEDX = 50;
	public static final int DEFAULT_SPEEDY = 50;
	public static final int DEFAULT_MAXHP = 5;
	public static final int DEFAULT_BULLET_DAMAGE = 1;
	public static final int DEFAULT_SHOOTING_DELAY = 40;
	public static final int DEFAULT_BULLET_SPEED = 50;
	public static final int GAME_DELAY = 20;
}
