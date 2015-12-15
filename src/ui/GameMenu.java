package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URISyntaxException;

import config.GlobalConfig;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utility.InputUtility;
import utility.ResourceUtility;

public class GameMenu extends GameScene {

	private RenderObject menuBG = ResourceUtility.menuBG0;
	private RenderObject logo = ResourceUtility.logo;
	private RenderObject sel = ResourceUtility.menuSel;
	private static int optionMenu = 0;

	public GameMenu() {
		super();
		menuBG.topLeftAnimationAt(0, 0);
		logo.topLeftAnimationAt(5, 5);
		
		if (GameManager.gameWindow.mediaPlayer != null) {
			GameManager.gameWindow.mediaPlayer.stop();
		}
		try {
			GameManager.gameWindow.music = new Media(GameMenu.class.getResource("/" + ResourceUtility.URL_BGM).toURI().toString());
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
		menuBG.render(g2);
		logo.render(g2);
		Font font = GlobalConfig.subFont.deriveFont(40);
		g2.setFont(font);
		g2.setColor(Color.white);
		FontMetrics metrics = g2.getFontMetrics(font);
		Rectangle2D rect1 = metrics.getStringBounds("START", g2);
		g2.drawString("START", 128 - (int) rect1.getWidth() / 2, GlobalConfig.SCREEN_HEIGHT - (int) rect1.getHeight());
		Rectangle2D rect2 = metrics.getStringBounds("SHOP", g2);
		g2.drawString("SHOP", 384 - (int) rect2.getWidth() / 2,
				GlobalConfig.SCREEN_HEIGHT - (int) rect2.getHeight());
		Rectangle2D rect3 = metrics.getStringBounds("OPTION", g2);
		g2.drawString("OPTION", 640 - (int) rect3.getWidth() / 2,
				GlobalConfig.SCREEN_HEIGHT - (int) rect3.getHeight());
		Rectangle2D rect4 = metrics.getStringBounds("EXIT", g2);
		g2.drawString("EXIT", 896 - (int) rect4.getWidth() / 2,
				GlobalConfig.SCREEN_HEIGHT - (int) rect4.getHeight());
		switch (optionMenu) {
		case 0:
			menuBG = ResourceUtility.menuBG0;
			sel.centerAnimationAt(128, GlobalConfig.SCREEN_HEIGHT - (int) rect1.getHeight() - 7);
			sel.render(g2);
			break;
		case 1:
			menuBG = ResourceUtility.menuBG1;
			sel.centerAnimationAt(128 + 256, GlobalConfig.SCREEN_HEIGHT - (int) rect2.getHeight() - 7);
			sel.render(g2);
			break;
		case 2:
			menuBG = ResourceUtility.menuBG2;
			sel.centerAnimationAt(128 + 2 * 256, GlobalConfig.SCREEN_HEIGHT - (int) rect3.getHeight() - 7);
			sel.render(g2);
			break;
		case 3:
			menuBG = ResourceUtility.menuBG3;
			sel.centerAnimationAt(128 + 3 * 256, GlobalConfig.SCREEN_HEIGHT - (int) rect4.getHeight() - 7);
			sel.render(g2);
			break;
		}
	}

	@Override
	protected void update() {
		if (InputUtility.getKeyTriggered(KeyEvent.VK_ENTER) || InputUtility.getKeyTriggered(KeyEvent.VK_SPACE)) {
			switch (optionMenu) {
			case 0:
				GameManager.gameWindow.switchScene(new GamePlay());
				break;
			case 1:
				GameManager.gameWindow.switchScene(new GameShop());
				break;
			case 2:
				GameManager.gameWindow.switchScene(new GameOption());
				break;
			case 3:
				GameManager.close();
				break;
			}
		}
		
		if (InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)){
			optionMenu = (++optionMenu) % 4;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)){
			optionMenu = optionMenu - 1 == -1 ? 3 : optionMenu - 1;
		}
	}

}
