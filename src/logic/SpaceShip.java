package logic;

import config.GlobalConfig;

public abstract class SpaceShip implements ICrashable, IRenderable {

	protected int HP;
	protected int maxHP;
	protected int speedX;
	protected int speedY;
	protected int shootingDelay;
	protected boolean isDestroyed;
	protected int direction;
	protected int x;
	protected int y;


	public SpaceShip(int maxHP, int speedX, int speedY,int shootingDelay,int direction) {
		this.maxHP = this.HP = maxHP;
		this.speedX = speedX;
		this.speedY = speedY;
		this.shootingDelay = shootingDelay;
		this.direction=direction;
		isDestroyed = false;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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
}
