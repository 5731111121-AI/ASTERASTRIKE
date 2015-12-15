package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.net.URISyntaxException;
import config.GlobalConfig;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utility.InputUtility;
import utility.ResourceUtility;

public class GameTitle extends GameScene {
	
	private RenderObject bg = ResourceUtility.titleBG;
	private RenderObject logo = ResourceUtility.logo;
	
	public GameTitle() {
		super();
		bg.topLeftAnimationAt(0, 0);
		logo.topLeftAnimationAt(GlobalConfig.SCREEN_WIDTH_CENTER - logo.getWidth() / 2, GlobalConfig.SCREEN_HEIGHT_CENTER - logo.getHeight() / 2);
		
		if (GameManager.gameWindow.mediaPlayer != null) {
			GameManager.gameWindow.mediaPlayer.stop();
		}
		try {
			GameManager.gameWindow.music = new Media(GameTitle.class.getResource("/" + ResourceUtility.URL_BGM).toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		GameManager.gameWindow.mediaPlayer = new MediaPlayer(GameManager.gameWindow.music);
		GameManager.gameWindow.mediaPlayer.setCycleCount(Integer.MAX_VALUE);
		if(GlobalConfig.isSoundOn) GameManager.gameWindow.mediaPlayer.play();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		bg.render(g2);
		logo.render(g2);
		Font font = GlobalConfig.subFont.deriveFont(Font.BOLD, 12);
		g2.setFont(font);
		g2.setColor(Color.white);
		FontMetrics metrics = g2.getFontMetrics(font);
		Rectangle2D rect = metrics.getStringBounds("Athip Intaraphirom (5731111121) & Nontouch Boonyamanond (5730281021)", g2);
		g2.drawString("Athip Intaraphirom (5731111121) & Nontouch Boonyamanond (5730281021)", GlobalConfig.SCREEN_WIDTH - (int) rect.getWidth() - 5, GlobalConfig.SCREEN_HEIGHT - (int) rect.getHeight());
		rect = metrics.getStringBounds("A Programming Methodology I (2015/1) Project", g2);
		g2.drawString("A Programming Methodology I (2015/1) Project", GlobalConfig.SCREEN_WIDTH - (int) rect.getWidth() - 5, GlobalConfig.SCREEN_HEIGHT - (int) rect.getHeight() - 20);
		font = GlobalConfig.mainFont.deriveFont(Font.BOLD, 25);
		g2.setFont(font);
		rect = metrics.getStringBounds("Press Any Key To Continue", g2);
		g2.drawString("Press Any Key To Continue", GlobalConfig.SCREEN_WIDTH_CENTER - (int) rect.getWidth() / 2, GlobalConfig.SCREEN_HEIGHT_CENTER + 80);
	}

	@Override
	protected void update() {
		for(int i = 0; i < 256; i++){
			if (InputUtility.getKeyTriggered(i)) {
				GameManager.gameWindow.switchScene(new GameMenu());
			}
		}
	}

}
