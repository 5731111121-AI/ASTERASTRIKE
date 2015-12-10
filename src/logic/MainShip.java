package logic;

import java.awt.event.KeyEvent;

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
			setShipPic(DrawingUtility.getImageFromResource("MainShip"));
			int shipHeight = shipPic.getHeight();
			y = GlobalConfig.SCREEN_HEIGHT - shipHeight;
			break;
		}
	}

	@Override
	public void shoot() {
		new Bullet(bulletDamage, bulletSpeed, x + shipPic.getWidth() / 2, y, this);
	}

	@Override
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
}
