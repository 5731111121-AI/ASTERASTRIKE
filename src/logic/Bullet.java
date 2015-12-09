package logic;

import java.awt.Graphics2D;

public class Bullet implements ICrashable, IRenderable {
	
	protected int damage;
	protected int speed;
	protected SpaceShip shooter;
	protected boolean isDestroyed;
	protected int direction;
	
	public Bullet(int damage, int speed,int direction,SpaceShip shooter) {
		this.damage = damage;
		this.speed = speed;
		this.direction=direction;
		this.shooter = shooter;
		isDestroyed = false;
	}
	
	@Override
	public void crash(IRenderable a) {
		// TODO Auto-generated method stub
		if(a instanceof SpaceShip){
			if(((SpaceShip)a).equals(this.shooter)) return;
			else {
				((SpaceShip)a).decreaseHP(this.damage);
				this.setDestroyed(true);
			}
		}
		else if(a instanceof Bullet) return;
		
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
		// TODO Auto-generated method stub
		
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public SpaceShip getShooter() {
		return shooter;
	}

	public void setShooter(SpaceShip shooter) {
		this.shooter = shooter;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
}
