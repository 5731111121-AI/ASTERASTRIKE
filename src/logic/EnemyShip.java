package logic;

import java.awt.Graphics2D;

public class EnemyShip extends SpaceShip implements Runnable {

	public EnemyShip(int maxHP, int speedX, int speedY, int shootingDelay) {
		super(maxHP, speedX, speedY, shootingDelay);
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
