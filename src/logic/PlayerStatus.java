package logic;

import java.awt.Graphics2D;

public class PlayerStatus implements IRenderable {
	
	private int score;
	
	public PlayerStatus() {
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void render(Graphics2D g2) {
		
	}

}
