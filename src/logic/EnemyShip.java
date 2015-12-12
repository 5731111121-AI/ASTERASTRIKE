package logic;

import config.GlobalConfig;
import utility.GeneralUtility;
import utility.ResourceUtility;

public class EnemyShip extends SpaceShip {

	public EnemyShip(int grade) {
		// TODO Auto-generated constructor stub
		super(grade);
		y = 0;
		switch (grade) {
		case 1:
			setShipSprite(ResourceUtility.enemy_1);
			x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - ResourceUtility.enemy_1.getWidth());
			HP = maxHP = 6;
			speedX = 3;
			speedY = 3;
			shootingDelay = 18;
			bulletSpeed = 18;
			bulletDamage = 2;
			break;
		case 2:
			setShipSprite(ResourceUtility.enemy_2);
			x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - ResourceUtility.enemy_2.getWidth());
			HP = maxHP = 25;
			shootingDelay = 25;
			bulletSpeed = 25;
			bulletDamage = 5;
			break;
		default:
			setShipSprite(ResourceUtility.enemy_0);
			x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - ResourceUtility.enemy_0.getWidth());
			HP = maxHP = 4;
			speedX = 3;
			speedY = 2;
			shootingDelay = 20;
			break;
		}
	}

	@Override
	public void shoot() {
		if (grade < 2)
			RenderableHolder.getInstance().add(new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth() / 2,
					y + shipSprite.getHeight(), this));
		else {
			RenderableHolder.getInstance().add(new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth() / 2,
					y + shipSprite.getHeight(), this));
			RenderableHolder.getInstance()
					.add(new Bullet(bulletDamage, bulletSpeed, x, y + shipSprite.getHeight(), this));
			RenderableHolder.getInstance().add(
					new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth(), y + shipSprite.getHeight(), this));
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
