package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.net.URISyntaxException;

import config.GlobalConfig;
import exception.NoSavFileException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import logic.Bullet;
import logic.EnemyShip;
import logic.ICrashable;
import logic.IRenderable;
import logic.MainShip;
import logic.RenderableHolder;
import logic.SpaceShip;
import utility.DrawingUtility;
import utility.GeneralUtility;
import utility.InputUtility;
import utility.ResourceUtility;
import utility.SavUtility;

public class GamePlay extends GameScene {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainShip mainShip;
	private int spawnDelay;
	private int spawnDelayCounter;
	private boolean isPlaying;
	private RenderObject bg = ResourceUtility.gameBG;
	private Thread enemySpawner;
	private static final int lowerBoundSpawnDelay = 180;
	private static final int upperBoundSpawnDelay = 300;
	private BufferedImage boom = DrawingUtility.getImageFromResource("boom.png");
	private Media boomSound;
	private MediaPlayer boomSoundPlayer;

	public GamePlay() {
		GlobalConfig.score = 0;
		mainShip = new MainShip(GlobalConfig.currentShip);

		spawnDelay = GeneralUtility.random(lowerBoundSpawnDelay, upperBoundSpawnDelay);
		spawnDelayCounter = 0;
		isPlaying = true;
		bg.topLeftAnimationAt(0, 0);
		bg.setZ(Integer.MIN_VALUE);
		
		if (GameManager.gameWindow.mediaPlayer != null) {
			GameManager.gameWindow.mediaPlayer.stop();
		}
		try {
			GameManager.gameWindow.music = new Media(GamePlay.class.getResource("/res/audio/main.mp3").toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		GameManager.gameWindow.mediaPlayer = new MediaPlayer(GameManager.gameWindow.music);
		GameManager.gameWindow.mediaPlayer.setCycleCount(Integer.MAX_VALUE);
		if(GlobalConfig.isSoundOn) GameManager.gameWindow.mediaPlayer.play();

		RenderableHolder.getInstance().getRenderableList().add(bg);
		RenderableHolder.getInstance().getRenderableList().add(mainShip);
		
		try {
			boomSound = new Media(GamePlay.class.getResource("/res/audio/3..2..1..GO!.mp3").toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		boomSoundPlayer = new MediaPlayer(boomSound);
		boomSoundPlayer.setCycleCount(1);
		if(GlobalConfig.isSoundOn) boomSoundPlayer.play();

		enemySpawner = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						enemySpawner.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (RenderableHolder.getInstance().getRenderableList()) {
						if(!isPlaying) {
							try {
								System.out.println("I'm waiting here");
								RenderableHolder.getInstance().getRenderableList().wait();
								System.out.println("The show must go on!");
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (++spawnDelayCounter % spawnDelay == 0) {
							spawnDelayCounter = 0;
							int tripleChance = GeneralUtility.random(1, 100);
							int grade;
							if (GlobalConfig.score / 2 > tripleChance) {
								grade = GeneralUtility.random(0, 2);
								RenderableHolder.getInstance().getRenderableList().add(new EnemyShip(grade));
								grade = GeneralUtility.random(1, 2);
								RenderableHolder.getInstance().getRenderableList().add(new EnemyShip(grade));
								RenderableHolder.getInstance().getRenderableList().add(new EnemyShip(2));
								spawnDelay = GeneralUtility.random(lowerBoundSpawnDelay, upperBoundSpawnDelay);
							} else {
								int doubleChance = GeneralUtility.random(1, 100);
								if (doubleChance < ((100 - GlobalConfig.score / 2) < 20 ? 20
										: (100 - GlobalConfig.score / 2))) {
									grade = GeneralUtility.random(0, 1);
									RenderableHolder.getInstance().getRenderableList().add(new EnemyShip(grade));
									spawnDelay = GeneralUtility.random(lowerBoundSpawnDelay, upperBoundSpawnDelay);
								} else {
									grade = GeneralUtility.random(0, 1);
									RenderableHolder.getInstance().getRenderableList().add(new EnemyShip(grade));
									grade = GeneralUtility.random(0, 2);
									RenderableHolder.getInstance().getRenderableList().add(new EnemyShip(grade));
									spawnDelay = GeneralUtility.random(lowerBoundSpawnDelay, upperBoundSpawnDelay);
								}
							}
						}
					}
				}
			}
		});
		
		enemySpawner.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.setFont(GlobalConfig.subFont.deriveFont(25));
		g2.drawString("Score: " + GlobalConfig.score, 10, 35);
		if (isPlaying) {
		} else {
			g2.drawString("paused", 895, 570);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected synchronized void update() {
		if (isPlaying) {
			synchronized (RenderableHolder.getInstance().getRenderableList()) {
				mainShip.update();
				for (IRenderable ir : RenderableHolder.getInstance().getRenderableList()) {
					if (!ir.isVisible()) {
						RenderableHolder.getInstance().getRenderableList().remove(ir);
					}
					if (ir instanceof Bullet) {
						((Bullet) ir).update();
						for (IRenderable ship : RenderableHolder.getInstance().getRenderableList()) {
							if (ship instanceof SpaceShip) {
								if (((Bullet) ir).crash((ICrashable) ship)) {
									((SpaceShip) ship).decreaseHP(((Bullet) ir).getDamage());
								}
							}
						}
					}
					if (ir instanceof EnemyShip) {
						((EnemyShip) ir).update();
						if (mainShip.crash((ICrashable) ir)) {
							mainShip.setHP(0);
							((EnemyShip) ir).setHP(0);
						}
						if (((EnemyShip) ir).getHP() == 0) {
							GlobalConfig.score += ((EnemyShip) ir).getScore();
						}
					}
					if (ir instanceof SpaceShip && ((SpaceShip) ir).getHP() == 0) {
						((SpaceShip) ir).setShipSprite(boom);
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						try {
							boomSound = new Media(GamePlay.class.getResource("/res/audio/boom.mp3").toURI().toString());
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
						boomSoundPlayer = new MediaPlayer(boomSound);
						boomSoundPlayer.setCycleCount(1);
						if(GlobalConfig.isSoundOn) boomSoundPlayer.play();
						((SpaceShip) ir).setDestroyed(true);
					}
				}

				if (InputUtility.getKeyTriggered(KeyEvent.VK_ESCAPE)) {
					isPlaying = false;
				}
			}
		} else {
			synchronized (RenderableHolder.getInstance().getRenderableList()) {
				if (InputUtility.getKeyTriggered(KeyEvent.VK_ESCAPE)) {
					isPlaying = true;
					RenderableHolder.getInstance().getRenderableList().notifyAll();
				}
			}
		}

		if (mainShip.isDestroyed()) {
			enemySpawner.stop();
			synchronized (RenderableHolder.getInstance().getRenderableList()) {
				RenderableHolder.getInstance().getRenderableList().clear();
			}
			
			try {
				SavUtility.saveGame();
			} catch (NoSavFileException e) {
				SavUtility.createDefaultSavFile();
				e.printStackTrace();
			}
			GameManager.gameWindow.switchScene(new GameOver());
		}

	}
}
