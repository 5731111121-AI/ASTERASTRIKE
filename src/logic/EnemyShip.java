package logic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class EnemyShip extends SpaceShip implements Runnable {

	public EnemyShip(int grade, BufferedImage shipPic) {
		// TODO Auto-generated constructor stub
		super(grade, shipPic);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

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
		
	}

	@Override
	public void crash(IRenderable a, IRenderable b) {}

}
