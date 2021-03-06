package ui;

import config.GlobalConfig;
import javafx.embed.swing.JFXPanel;
import logic.ResourceLoader;
import utility.InputUtility;

public class GameManager {

	public static GameWindow gameWindow;
	private static GameScene nextScene = null;

	public static void runGame() {
		new JFXPanel();

		gameWindow = new GameWindow(new GameLoadScreen());

		ResourceLoader loader = new ResourceLoader();
		Thread loaderThread = new Thread(loader);
		loaderThread.start();

		try {
			loaderThread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		if (!loaderThread.isAlive()) {
			gameWindow.switchScene(new GameTitle());
		}
		while (true) {
			try {
				Thread.sleep(GlobalConfig.REFRESH_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameWindow.getCurrentScene().repaint();
			gameWindow.getCurrentScene().update();
			InputUtility.postUpdate();
			if (nextScene != null) {
				gameWindow.switchScene(nextScene);
				nextScene = null;
			}
		}
	}

	public static void close() {
		gameWindow.dispose();
		System.exit(0);
	}
}
