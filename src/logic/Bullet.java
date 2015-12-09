package logic;

import java.awt.Graphics2D;

public class Bullet implements ICrashable, IRenderable {
	
	protected int damage;
	protected int speed;
	protected int dir;
	private int x;
	private int y;
	protected SpaceShip shooter;
	protected boolean isDestroyed;
	
	public Bullet(int damage, int speed, int x, int y, SpaceShip shooter) {
		this.damage = damage;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.shooter = shooter;
		this.dir = (shooter instanceof MainShip) ? -1 : 1;
		isDestroyed = false;
	}
	
	public void update(){
		if(!isDestroyed) y += dir * speed;
	}
	
	@Override
	public void crash(ICrashable a, ICrashable b) {
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
