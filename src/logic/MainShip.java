package logic;

import config.GlobalConfig;
import utility.DrawingUtility;

public class MainShip extends SpaceShip {

	private int score;

	public MainShip(int grade) {
		super(grade);
		score = 0;
		switch (grade) {
		case 1:
			break;
		default:
			setShipPic(DrawingUtility.getImageFromResource("MainShip"));
			int shipHeight = shipPic.getHeight();
			y = GlobalConfig.SCREEN_HEIGHT - shipHeight;
			break;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void incScore(int amount) {
		score += amount;
		if (score < 0)
			score = 0;
	}

}
