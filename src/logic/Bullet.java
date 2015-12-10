package logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashSet;

import config.GlobalConfig;

public class Bullet implements ICrashable, IRenderable {

	protected int damage;
	protected int speed;
	protected int dir;
	private int x;
	private int y;
	private static final int bulletWidth = 10;
	private static final int bulletHeight = 18;
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
		return false;
	}

	public boolean crash(SpaceShip a) {
		if (a == shooter)
			return false;
		HashSet<String> maskA = a.getMask(a);
		HashSet<String> maskB = new HashSet<String>();
		for (int i = x; i < bulletWidth; i++) {
			for (int j = y; j < bulletHeight; j++) {
				maskB.add(i + ", " + j);
			}
		}
		maskA.retainAll(maskB);
		if (maskA.size() == 0)
			return true;
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
		g2.setColor(new Color(255, 0, 200, 40));
		if (shooter instanceof MainShip)
			g2.setColor(Color.CYAN);
		g2.fillRect(x - 5, y, bulletWidth, bulletHeight);
	}
}
