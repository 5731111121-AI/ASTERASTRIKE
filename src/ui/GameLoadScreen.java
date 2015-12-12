package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import config.GlobalConfig;

public class GameLoadScreen extends GameScene {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameLoadScreen() {
		super();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.black);
		g2.clearRect(0, 0, GlobalConfig.SCREEN_WIDTH, GlobalConfig.SCREEN_HEIGHT);
		g2.setColor(Color.white);
		Font font = GlobalConfig.mainFont.deriveFont(Font.PLAIN, 40);
		g2.setFont(font);
		FontMetrics metrics = g2.getFontMetrics(font);
		Rectangle2D rect = metrics.getStringBounds("ASTERASTRIKE is now loading . . .", g2);
		g2.drawString("ASTERASTRIKE is now loading . . .", GlobalConfig.SCREEN_WIDTH_CENTER - (int) rect.getWidth() / 2,
				GlobalConfig.SCREEN_HEIGHT_CENTER - (int) rect.getHeight() / 2);
	}

	@Override
	protected void update() {
	}
}
