package logic;

import java.awt.image.BufferedImage;

import config.GlobalConfig;
import utility.GeneralUtility;

public class EnemyShip extends SpaceShip{

	public EnemyShip(int grade, BufferedImage shipPic) {
		// TODO Auto-generated constructor stub
		super(grade, shipPic);
		y = 0;
		x = GeneralUtility.random(0, GlobalConfig.SCREEN_WIDTH - 150);
	}

	@Override
	public void shoot() {
		new Bullet(bulletDamage, bulletSpeed, x + shipPic.getWidth() / 2, y, this);
	}

	@Override
	public void update() {
		if(!isDestroyed) {
			y += speedY;
			if(y > GlobalConfig.SCREEN_HEIGHT) {
				isDestroyed = true;
				return;
			}
			if(shootingDelayCounter++ % shootingDelay == 0){
				shoot();
			}
		}
	}

}
