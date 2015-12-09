package logic;

import java.awt.Graphics2D;

public class MainShip extends SpaceShip {

	private int score;

	public MainShip(int grade) {
		// TODO Auto-generated constructor stub
		super(grade);
		score = 0;
		switch (grade) {
		case 1:
			break;
		default:
			break;
		}
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
