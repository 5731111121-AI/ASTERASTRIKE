package logic;

import java.awt.Graphics2D;

public class Bullet implements ICrashable, IRenderable {
	
	protected int damage;
	protected int speed;
	protected SpaceShip shooter;
	protected boolean isDestroyed;
	
	public Bullet(int damage, int speed, SpaceShip shooter) {
		this.damage = damage;
		this.speed = speed;
		this.shooter = shooter;
		isDestroyed = false;
	}
	
	@Override
	public void crash(IRenderable a, IRenderable b) {
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
		// TODO Auto-generated method stub
		
	}
}
