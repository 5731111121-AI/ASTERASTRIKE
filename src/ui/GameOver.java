package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URISyntaxException;

import config.GlobalConfig;
import exception.NoSavFileException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utility.InputUtility;
import utility.ResourceUtility;
import utility.SavUtility;

public class GameOver extends GameScene {
	
	private int score;
	private int earn;
	
	public GameOver() {
		score = GlobalConfig.score;
		earn = 0;
		
		if (GameManager.gameWindow.mediaPlayer != null) {
			GameManager.gameWindow.mediaPlayer.stop();
		}
		try {
			GameManager.gameWindow.music = new Media(GameOver.class.getResource("/res/audio/over.mp3").toURI().toString());
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
		g2.setFont(GlobalConfig.mainFont.deriveFont(25));
		g2.setColor(Color.white);
		g2.drawString("game over", 450, 150);
		g2.drawString("Your score:", 300, 300);
		g2.drawString("Earned credits:", 300, 400);
		g2.drawString("" + GlobalConfig.score, 600, 300);
		g2.drawString("" + earn, 600, 400);
		g2.drawString("Press any key to continue . . .", 600, 540);
	}

	@Override
	protected void update() {
		if(score > 0) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			score -= 2;
			if(score <= 0) score = 0;
			earn++;
		}
		for (int i = 0; i < 256; i++) {
			if (InputUtility.getKeyTriggered(i)) {
				GlobalConfig.credits += earn;
				GlobalConfig.score = 0;
				try {
					SavUtility.saveGame();
				} catch (NoSavFileException e) {
					SavUtility.createDefaultSavFile();
					e.printStackTrace();
				}
				GameManager.gameWindow.switchScene(new GameMenu());
			}
		}
	}

}
