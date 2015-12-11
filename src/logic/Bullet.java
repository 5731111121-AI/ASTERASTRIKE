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
	private static final int bulletWidth = 6;
	private static final int bulletHeight = 10;
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
		if (!isDestroyed) {
			y += dir * speed;
			for (IRenderable r : RenderableHolder.getInstance().getRenderableList()) {
				if (r instanceof SpaceShip) {
					if (this.crash((SpaceShip) r)) {
						((SpaceShip) r).decreaseHP(this.damage);
						this.isDestroyed = true;
					}
				}
			}
		}
		if (y > GlobalConfig.SCREEN_HEIGHT)
			isDestroyed = true;
	}

	@Override
	public boolean crash(ICrashable a) {
		return false;
	}

	public boolean crash(SpaceShip a) {
		if (a == shooter)
			return false;

		int ax1 = a.x;
		int ay1 = a.y;
		int ax2 = a.x + a.shipPic.getWidth();
		int ay2 = a.y + a.shipPic.getHeight();
		int bx1 = this.x;
		int by1 = this.y;
		int bx2 = this.x + bulletWidth;
		int by2 = this.y + bulletHeight;

		if (by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1) {
			return false;
		} else {
			HashSet<String> maskA = a.getMask(a);
			HashSet<String> maskB = new HashSet<String>();
			for (int i = x; i < x + bulletWidth; i++) {
				for (int j = y; j < y + bulletHeight; j++) {
					maskB.add(i + ", " + j);
				}
			}
			maskA.retainAll(maskB);
			if (maskA.size() == 0)
				return true;
			return false;
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
		g2.setColor(new Color(255, 0, 200, 40));
		if (shooter instanceof MainShip)
			g2.setColor(Color.CYAN);
		g2.fillRect(x - 3, y, bulletWidth, bulletHeight);
	}
}
