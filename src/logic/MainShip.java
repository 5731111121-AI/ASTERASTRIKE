package logic;

import java.awt.event.KeyEvent;
import config.GlobalConfig;
import utility.InputUtility;
import utility.ResourceUtility;

public class MainShip extends SpaceShip {

	public MainShip(int grade) {
		super(grade);
		int shipWidth = shipSprite.getWidth();
		int shipHeight = shipSprite.getHeight();
		x = GlobalConfig.SCREEN_WIDTH_CENTER - shipWidth / 2;
		y = GlobalConfig.SCREEN_HEIGHT - shipHeight;
		switch (grade) {
		case 1:
			setShipSprite(ResourceUtility.ship_1);
			HP = maxHP = 7;
			shootingDelay = 12;
			bulletSpeed = 20;
			break;
		case 2:
			setShipSprite(ResourceUtility.ship_2);
			HP = maxHP = 6;
			shootingDelay = 10;
			bulletSpeed = 18;
			bulletDamage = 2;
			speedX = speedY = 3;
			break;
		case 3:
			setShipSprite(ResourceUtility.ship_3);
			HP = maxHP = 8;
			shootingDelay = 8;
			bulletSpeed = 20;
			bulletDamage = 3;
			speedX = 4;
			speedY = 3;
			break;
		case 4:
			setShipSprite(ResourceUtility.ship_4);
			HP = maxHP = 10;
			shootingDelay = 5;
			bulletSpeed = 25;
			bulletDamage = 5;
			speedX = speedY = 5;
			break;
		default:
			setShipSprite(ResourceUtility.ship_0);
			speedX = 3;
			speedY = 2;
			break;
		}
	}

	@Override
	public void shoot() {
		RenderableHolder.getInstance()
				.add(new Bullet(bulletDamage, bulletSpeed, x + shipSprite.getWidth() / 2, y, this));
	}

	@Override
	public void update() {
		if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)) {
			x += speedX;
			x = (x <= GlobalConfig.SCREEN_WIDTH - shipSprite.getWidth()) ? x
					: GlobalConfig.SCREEN_WIDTH - shipSprite.getWidth();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT)) {
			x -= speedX;
			x = (x >= 0) ? x : 0;
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_DOWN)) {
			y += speedY;
			y = (y <= GlobalConfig.SCREEN_HEIGHT - shipSprite.getHeight()) ? y
					: GlobalConfig.SCREEN_HEIGHT - shipSprite.getHeight();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_UP)) {
			y -= speedY;
			y = (y <= 100) ? 100 : y;
		}
		if (++shootingDelayCounter % shootingDelay == 0) {
			shoot();
		}
	}
}
