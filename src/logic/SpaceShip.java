package logic;

import java.awt.image.BufferedImage;

import config.GlobalConfig;

public abstract class SpaceShip implements ICrashable, IRenderable {

	protected int HP;
	protected int maxHP;
	protected int speedX;
	protected int speedY;
	protected int x;
	protected int y;
	protected int shootingDelay;
	protected int bulletSpeed;
	protected boolean isDestroyed;
	protected int grade;
	protected BufferedImage shipPic;

	public SpaceShip(int grade, BufferedImage shipPic) {
		maxHP = this.HP = GlobalConfig.DEFAULT_MAXHP;
		x = GlobalConfig.SCREEN_WIDTH_CENTER;
		y = GlobalConfig.SCREEN_HEIGHT;
		speedX = GlobalConfig.DEFAULT_SPEEDX;
		speedY = GlobalConfig.DEFAULT_SPEEDY;
		shootingDelay = GlobalConfig.DEFAULT_SHOOTING_DELAY;
		bulletSpeed = GlobalConfig.DEFAULT_BULLET_SPEED;
		isDestroyed = false;
	}
	
	public SpaceShip(int grade) {
		maxHP = this.HP = GlobalConfig.DEFAULT_MAXHP;
		x = GlobalConfig.SCREEN_WIDTH_CENTER;
		y = GlobalConfig.SCREEN_HEIGHT;
		speedX = GlobalConfig.DEFAULT_SPEEDX;
		speedY = GlobalConfig.DEFAULT_SPEEDY;
		shootingDelay = GlobalConfig.DEFAULT_SHOOTING_DELAY;
		bulletSpeed = GlobalConfig.DEFAULT_BULLET_SPEED;
		shipPic = null;
		isDestroyed = false;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public BufferedImage getShipPic() {
		return shipPic;
	}

	public void setShipPic(BufferedImage shipPic) {
		this.shipPic = shipPic;
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
}
