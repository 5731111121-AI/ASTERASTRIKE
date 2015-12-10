package logic;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashSet;

import config.GlobalConfig;
import utility.InputUtility;

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
	protected BufferedImage shipPic;

	public SpaceShip(int grade, BufferedImage shipPic) {
		maxHP = this.HP = GlobalConfig.DEFAULT_MAXHP;
		x = GlobalConfig.SCREEN_WIDTH_CENTER;
		y = GlobalConfig.SCREEN_HEIGHT;
		speedX = GlobalConfig.DEFAULT_SPEEDX;
		speedY = GlobalConfig.DEFAULT_SPEEDY;
		shootingDelayCounter = 0;
		shootingDelay = GlobalConfig.DEFAULT_SHOOTING_DELAY;
		bulletSpeed = GlobalConfig.DEFAULT_BULLET_SPEED;
		bulletDamage = GlobalConfig.DEFAULT_BULLET_DAMAGE;
		this.shipPic = shipPic;
		this.grade = grade;
		isDestroyed = false;
	}

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
		g2.drawImage(shipPic, null, x, y);
	}

	@Override
	public boolean crash(ICrashable a, ICrashable b) {
		int ax1 = ((SpaceShip) a).x;
		int ay1 = ((SpaceShip) a).y;
		int ax2 = ((SpaceShip) a).x + ((SpaceShip) a).shipPic.getWidth();
		int ay2 = ((SpaceShip) a).x + ((SpaceShip) a).shipPic.getHeight();
		int bx1 = ((SpaceShip) b).x;
		int by1 = ((SpaceShip) b).y;
		int bx2 = ((SpaceShip) b).x + ((SpaceShip) b).shipPic.getWidth();
		int by2 = ((SpaceShip) b).x + ((SpaceShip) b).shipPic.getHeight();

		if (by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1) {
			return false;
		} else {
			HashSet<String> maskShipA = getMask((SpaceShip) a);
			HashSet<String> maskShipB = getMask((SpaceShip) b);

			maskShipA.retainAll(maskShipB);

			if (maskShipA.size() > 0) {
				return true;
			}
			return false;
		}
	}

	public HashSet<String> getMask(SpaceShip c) {
		HashSet<String> mask = new HashSet<String>();
		BufferedImage img = c.shipPic;
		int pixel, a;
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				pixel = img.getRGB(i, j);
				a = (pixel >> 24) & 0xff;
				if (a != 0) {
					mask.add((x + i) + ", " + (y - j));
				}
			}
		}
		return mask;
	}

	public void update() {
		if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)) {
			x += speedX;
			x = (x <= GlobalConfig.SCREEN_WIDTH - shipPic.getWidth()) ? x
					: GlobalConfig.SCREEN_WIDTH - shipPic.getWidth();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_D)) {
			x += speedX;
			x = (x <= GlobalConfig.SCREEN_WIDTH - shipPic.getWidth()) ? x
					: GlobalConfig.SCREEN_WIDTH - shipPic.getWidth();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT)) {
			x -= speedX;
			x = (x >= 0) ? x : 0;
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_A)) {
			x -= speedX;
			x = (x >= shipPic.getWidth()) ? x : shipPic.getWidth();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_DOWN)) {
			y += speedY;
			y = (y <= GlobalConfig.SCREEN_HEIGHT - shipPic.getHeight()) ? y
					: GlobalConfig.SCREEN_HEIGHT - shipPic.getHeight();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_S)) {
			y += speedY;
			y = (y <= GlobalConfig.SCREEN_HEIGHT - shipPic.getHeight()) ? y
					: GlobalConfig.SCREEN_HEIGHT - shipPic.getHeight();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_UP)) {
			y -= speedY;
			y = (y >= 300) ? x : 300;
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_W)) {
			y -= speedY;
			y = (y >= 300) ? x : 300;
		}
		if(shootingDelayCounter++ % shootingDelay == 0){
			shoot();
		}
	}
	
	public abstract void shoot();
}
