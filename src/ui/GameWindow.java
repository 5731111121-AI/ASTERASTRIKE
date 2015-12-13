package ui;

import javax.swing.JFrame;

import config.GlobalConfig;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utility.ResourceUtility;

public class GameWindow extends JFrame {

	private GameScene currentScene;
	public Media music;
	public MediaPlayer mediaPlayer;
	public boolean isPlaying = false;
	
	protected GameWindow(GameScene gameScene) {
		super(GlobalConfig.GAME_NAME);
		
		currentScene = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setIconImage(ResourceUtility.enemy_2);
		setResizable(false);
		
		switchScene(gameScene);
		setLocationRelativeTo(null);
	}
	
	protected void switchScene(GameScene scene) {
		if (currentScene != null) {
			remove(currentScene);
		}
		currentScene = scene;
		add(currentScene);
		pack();
		validate();
		setVisible(true);
		currentScene.requestFocusInWindow();
	}
	
	protected GameScene getCurrentScene() {
		return currentScene;
	}
}
