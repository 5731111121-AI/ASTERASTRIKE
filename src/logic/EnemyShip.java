package logic;

import config.GlobalConfig;
import utility.GeneralUtility;
import utility.ResourceUtility;

public class EnemyShip extends SpaceShip {

	private int score;

	public EnemyShip(int grade) {
		super(grade);
		y = 0;
		switch (grade) {
		case 1:
			setShipSprite(ResourceUtility.enemy_1);
			x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - ResourceUtility.enemy_1.getWidth());
			HP = maxHP = 8;
			speedX = 3;
			speedY = 2;
			shootingDelay = 300;
			bulletSpeed = 10;
			bulletDamage = 2;
			score = 2;
			break;
		case 2:
			setShipSprite(ResourceUtility.enemy_2);
			x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - ResourceUtility.enemy_2.getWidth());
			HP = maxHP = 25;
			shootingDelay = 25;
			bulletSpeed = 25;
			bulletDamage = 5;
			score = 3;
			break;
		default:
			setShipSprite(ResourceUtility.enemy_0);
			x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - ResourceUtility.enemy_0.getWidth());
			HP = maxHP = 4;
			speedX = 3;
			speedY = 2;
			shootingDelay = 20;
			score = 1;
			break;
		}
	}

	public int getScore() {
		return score;
	}

	@Override
	public void shoot() {
		if (HP != 0)
			if (grade < 2)
				RenderableHolder.getInstance().add(new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth() / 2,
						y + shipSprite.getHeight(), this));
			else {
				RenderableHolder.getInstance().add(new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth() / 2,
						y + shipSprite.getHeight(), this));
				RenderableHolder.getInstance()
						.add(new Bullet(bulletDamage, bulletSpeed, x, y + shipSprite.getHeight(), this));
				RenderableHolder.getInstance().add(new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth(),
						y + shipSprite.getHeight(), this));
			}
	}

	@Override
	public void update() {
		if (!isDestroyed) {
			y += speedY;
			if (y > GlobalConfig.SCREEN_HEIGHT) {
				isDestroyed = true;
				return;
			}
			if (shootingDelayCounter++ % shootingDelay == 0) {
				shoot();
			}
		}
	}

}
