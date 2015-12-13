package logic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import config.GlobalConfig;

public abstract class SpaceShip implements ICrashable, IRenderable {

	protected int HP;
	protected int maxHP;
	protected int speedX;
	protected int speedY;
	protected int x;
	protected int y;
	protected int shootingDelayCounter;
	protected int shootingDelay;
	protected int bulletSpeed;
	protected boolean isDestroyed;
	protected int bulletDamage;
	protected int grade;
	protected BufferedImage shipSprite;

	public SpaceShip(int grade) {
		maxHP = this.HP = GlobalConfig.DEFAULT_MAXHP;
		x = GlobalConfig.SCREEN_WIDTH_CENTER;
		y = GlobalConfig.SCREEN_HEIGHT;
		speedX = GlobalConfig.DEFAULT_SPEEDX;
		speedY = GlobalConfig.DEFAULT_SPEEDY;
		shootingDelayCounter = 0;
		shootingDelay = GlobalConfig.DEFAULT_SHOOTING_DELAY;
		bulletSpeed = GlobalConfig.DEFAULT_BULLET_SPEED;
		bulletDamage = GlobalConfig.DEFAULT_BULLET_DAMAGE;
		this.grade = grade;
		isDestroyed = false;
	}

	public int getBulletDamage() {
		return bulletDamage;
	}

	public void setBulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public BufferedImage getShipSprite() {
		return shipSprite;
	}

	public void setShipSprite(BufferedImage shipPic) {
		this.shipSprite = shipPic;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP > 0 && HP < maxHP ? HP : maxHP;
	}

	public void decreaseHP(int damage) {
		HP = HP - damage <= 0 ? 0 : HP - damage;
		if (HP <= 0)
			isDestroyed = true;
	}

	public void increaseHP(int inc) {
		HP = HP + inc >= maxHP ? maxHP : HP + inc;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP > 0 ? maxHP : GlobalConfig.DEFAULT_MAXHP;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX > 0 ? speedX : GlobalConfig.DEFAULT_SPEEDX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY > 0 ? speedY : GlobalConfig.DEFAULT_SPEEDY;
	}

	public int getShootingDelay() {
		return shootingDelay;
	}

	public void setShootingDelay(int shootingDelay) {
		this.shootingDelay = shootingDelay;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
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
		g2.drawImage(shipSprite, null, x, y);
	}

	@Override
	public boolean crash(ICrashable a) {
		int ax1 = ((SpaceShip) a).x;
		int ay1 = ((SpaceShip) a).y;
		int ax2 = ((SpaceShip) a).x + ((SpaceShip) a).shipSprite.getWidth();
		int ay2 = ((SpaceShip) a).y + ((SpaceShip) a).shipSprite.getHeight();
		int bx1 = this.x;
		int by1 = this.y;
		int bx2 = this.x + this.shipSprite.getWidth();
		int by2 = this.y + this.shipSprite.getHeight();

		if (by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1) {
			return false; 
		} else {
			HashSet<String> maskShipA = getMask((SpaceShip) a);
			HashSet<String> maskShipB = getMask(this);

			maskShipB.retainAll(maskShipA);

			return maskShipB.size() > 0;
		}
	}

	public HashSet<String> getMask(SpaceShip c) {
		HashSet<String> mask = new HashSet<String>();
		BufferedImage img = c.shipSprite;
		int pixel, a;
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				pixel = img.getRGB(i, j);
				a = (pixel >> 24) & 0xff;
				if (a != 0) {
					mask.add((c.x + i) + ", " + (c.y - j));
				}
			}
		}
		return mask;
	}

	public abstract void update();
	
	public abstract void shoot();
}
