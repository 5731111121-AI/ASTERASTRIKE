package logic;

import java.awt.Graphics2D;

public class MainShip extends SpaceShip {

	private int score;
	private int grade;
	
	public MainShip(int maxHP, int speedX, int speedY, int shootingDelay, int grade) {
		super(maxHP, speedX, speedY, shootingDelay);
		score = 0;
		this.grade = grade;
		SpecialShip.upgrade(this, this.grade);
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score < 0 ? 0 : score;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade < 0 ? 0 : grade;
	}



	@Override
	public boolean isVisible() {
		return !isDestroyed;
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE - 1;
	}

	@Override
	public void render(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crash(IRenderable a, IRenderable b) {
		// TODO Auto-generated method stub
		
	}

}
