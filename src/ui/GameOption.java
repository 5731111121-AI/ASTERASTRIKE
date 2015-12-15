package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;

import config.GlobalConfig;
import exception.NoSavFileException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utility.DrawingUtility;
import utility.InputUtility;
import utility.ResourceUtility;
import utility.SavUtility;

public class GameOption extends GameScene {

	private static final RenderObject bg = new RenderObject(DrawingUtility.getImageFromResource("optionSprite.jpg"));
	private static final RenderObject sel = new RenderObject(DrawingUtility.getImageFromResource("optionSelector.png"));
	private static final int menucount = 2;
	private static int option = 0;
	private static int whatOptionDo[] = new int[2];
	private static String reset = "No";
	private static String isSoundOn = "On";

	public GameOption() {
		super();
		bg.topLeftAnimationAt(0, 0);
		if (GameManager.gameWindow.mediaPlayer != null) {
			GameManager.gameWindow.mediaPlayer.stop();
		}
		try {
			GameManager.gameWindow.music = new Media(GameOption.class.getResource("/res/audio/shop.mp3").toURI().toString());
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
		Font font = GlobalConfig.subFont.deriveFont(20);
		g2.setFont(font);
		g2.setColor(Color.white);
		g2.drawString("Sound", 100, 150);
		g2.drawString("< " + isSoundOn + " >", 800, 150);
		g2.drawString("Reset Game", 100, 350);
		g2.drawString("< " + reset + " >", 800, 350);
		int y = option == 0 ? 130 : 330;
		sel.topLeftAnimationAt(0, y);
		sel.render(g2);
	}

	@Override
	protected void update() {
		if (InputUtility.getKeyTriggered(KeyEvent.VK_ENTER)) {
			if (whatOptionDo[1] == 1) {
				SavUtility.createDefaultSavFile();
				isSoundOn = "On";
				reset = "No";
				option = whatOptionDo[0] = whatOptionDo[1] = 0;
			}
			if (whatOptionDo[0] == 0) {
				GlobalConfig.isSoundOn = true;
				reset = "No";
				option = whatOptionDo[1] = 0;
			} else {
				GlobalConfig.isSoundOn = false;
				reset = "No";
				option = whatOptionDo[1] = 0;
			}
			try {
				SavUtility.saveGame();
			} catch (NoSavFileException e) {
				SavUtility.createDefaultSavFile();
				e.printStackTrace();
			}
			GameManager.gameWindow.switchScene(new GameMenu());
		}
		
		if (InputUtility.getKeyTriggered(KeyEvent.VK_ESCAPE)) {
			if (GlobalConfig.isSoundOn) {
				whatOptionDo[0] = 0;
				isSoundOn = "On";
			} else {
				whatOptionDo[0] = 1;
				isSoundOn = "Off";
			}
			reset = "No";
			option = whatOptionDo[1] = 0;
			try {
				SavUtility.saveGame();
			} catch (NoSavFileException e) {
				SavUtility.createDefaultSavFile();
				e.printStackTrace();
			}
			GameManager.gameWindow.switchScene(new GameMenu());
		}

		if (InputUtility.getKeyTriggered(KeyEvent.VK_DOWN)) {
			option = (++option) % menucount;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_UP)) {
			option = option - 1 == -1 ? menucount - 1 : option - 1;
		}

		if (InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)) {
			whatOptionDo[option] = (++whatOptionDo[option]) % menucount;
			isSoundOn = whatOptionDo[0] == 0 ? "On" : "Off";
			reset = whatOptionDo[1] == 0 ? "No" : "Reset";
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)) {
			whatOptionDo[option] = whatOptionDo[option] - 1 == -1 ? menucount - 1 : whatOptionDo[option] - 1;
			isSoundOn = whatOptionDo[0] == 0 ? "On" : "Off";
			reset = whatOptionDo[1] == 0 ? "No" : "Reset";
		}
	}

}
