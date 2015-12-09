package logic;

import java.awt.Graphics2D;

public class EnemyShip extends SpaceShip implements Runnable {

	public EnemyShip(int maxHP, int speedX, int speedY, int shootingDelay,int direction) {
		super(maxHP, speedX, speedY, shootingDelay,direction);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

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
		
	}


	@Override
	public void crash(IRenderable a) {
		// TODO Auto-generated method stub
		if(a instanceof SpaceShip){
			if(a instanceof MainShip){
			((MainShip) a).setDestroyed(true);
			this.setDestroyed(true);
			}
			else return;
		}
		else if(a instanceof Bullet){
			if(!(((Bullet) a).getShooter() instanceof EnemyShip)){
			this.decreaseHP(((Bullet) a).getDamage());
			((Bullet) a).setDestroyed(true);
			}
			else return;
		}
	}

}
