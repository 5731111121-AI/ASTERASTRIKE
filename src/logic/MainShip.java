package logic;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import config.GlobalConfig;
import utility.DrawingUtility;
import utility.InputUtility;

public class MainShip extends SpaceShip {

	public MainShip(int grade) {
		super(grade);
		switch (grade) {
		case 1:
			break;
		default:
			BufferedImage shipImg = DrawingUtility.getImageFromResource("MainShip.png"); 
			setShipPic(shipImg);
			int shipHeight = shipPic.getHeight();
			y = GlobalConfig.SCREEN_HEIGHT - shipHeight;
			break;
		}
	}

	@Override
	public void shoot() {
		RenderableHolder.getInstance().add(new Bullet(bulletDamage, bulletSpeed, x + shipPic.getWidth() / 2, y, this));
	}

	@Override
	public void update() {
		if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)) {
			x += speedX;
			x = (x <= GlobalConfig.SCREEN_WIDTH - shipPic.getWidth()) ? x
					: GlobalConfig.SCREEN_WIDTH - shipPic.getWidth();
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT)) {
			x -= speedX;
			x = (x >= 0) ? x : 0;
		}
		if (InputUtility.getKeyPressed(KeyEvent.VK_DOWN)) {
			y += speedY;
			y = (y <= GlobalConfig.SCREEN_HEIGHT - shipPic.getHeight()) ? y
					: GlobalConfig.SCREEN_HEIGHT - shipPic.getHeight();
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
