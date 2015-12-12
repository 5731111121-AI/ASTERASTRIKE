package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import config.GlobalConfig;
import utility.GeneralUtility;
import utility.InputUtility;
import utility.ResourceUtility;

public class GameTitle extends GameScene {
	
	private RenderObject bg = ResourceUtility.titleBG;
	private RenderObject logo = ResourceUtility.logo;
	
	public GameTitle() {
		super();
		bg.topLeftAnimationAt(0, 0);
		logo.topLeftAnimationAt(GlobalConfig.SCREEN_WIDTH_CENTER - logo.getWidth() / 2, GlobalConfig.SCREEN_HEIGHT_CENTER - logo.getHeight() / 2);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		bg.render(g2);
		logo.render(g2);
		Font font = GlobalConfig.mainFont.deriveFont(Font.BOLD, 16);
		g2.setFont(font);
		g2.setColor(Color.white);
		FontMetrics metrics = g2.getFontMetrics(font);
		Rectangle2D rect = metrics.getStringBounds("Athip Intaraphirom (5731111121) & Nontouch Boonyamanond (5730281021)", g2);
		g2.drawString("Athip Intaraphirom (5731111121) & Nontouch Boonyamanond (5730281021)", GlobalConfig.SCREEN_WIDTH - (int) rect.getWidth() - 5, GlobalConfig.SCREEN_HEIGHT - (int) rect.getHeight());
		rect = metrics.getStringBounds("A Programming Methodology I (2015/1) Project", g2);
		g2.drawString("A Programming Methodology I (2015/1) Project", GlobalConfig.SCREEN_WIDTH - (int) rect.getWidth() - 5, GlobalConfig.SCREEN_HEIGHT - (int) rect.getHeight() - 20);
		font = GlobalConfig.mainFont.deriveFont(Font.BOLD, 25);
		g2.setFont(font);
		rect = metrics.getStringBounds("Press Any Key To Continue . . .", g2);
		g2.drawString("Press Any Key To Continue . . .", GlobalConfig.SCREEN_WIDTH_CENTER - (int) rect.getWidth() / 2 - 35, GlobalConfig.SCREEN_HEIGHT_CENTER + 60);
	}

	@Override
	protected void update() {
		for(int i = 0; i < 255; i++){
			if (InputUtility.getKeyTriggered(i)) {
				GameManager.gameWindow.switchScene(new GameMenu());
			}
		}
	}

}
