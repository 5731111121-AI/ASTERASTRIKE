package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import config.GlobalConfig;

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

	public void update() {
		if (!isDestroyed)
			y += dir * speed;
		if (y > GlobalConfig.SCREEN_HEIGHT)
			isDestroyed = true;
	}

	@Override
	public boolean crash(ICrashable a, ICrashable b) {
		// TODO Auto-generated method stub
		return false;
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
		g2.setColor(new Color(255, 0, 200, 40));
		if(shooter instanceof MainShip) g2.setColor(Color.CYAN);
		g2.fillRect(x - 5, y, 10, 18);
	}
}
