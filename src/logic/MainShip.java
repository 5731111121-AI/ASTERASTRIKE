package logic;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import config.GlobalConfig;
import jdk.nashorn.internal.objects.Global;
import utility.InputUtility;

public class MainShip extends SpaceShip {

	private int score;
	private int grade;
	
	public MainShip(int maxHP, int speedX, int speedY, int shootingDelay, int grade,int direction) {
		super(maxHP, speedX, speedY, shootingDelay,direction);
		super.x=GlobalConfig.SCREEN_WIDTH_CENTER;
		super.y=GlobalConfig.SCREEN_HEIGHT_CENTER;
		score = 0;
		this.grade = grade;
		SpecialShip.upgrade(this, this.grade);
	}
	public void update(){
		if(InputUtility.getKeyPressed(KeyEvent.VK_LEFT)){
						this.x -=this.speedX;
						if(x < 0) x = 0;
					}
		else if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)){
						this.x += this.speedX;
						if(x>GlobalConfig.SCREEN_WIDTH) x =GlobalConfig.SCREEN_WIDTH;
					}
		else if (InputUtility.getKeyPressed(KeyEvent.VK_UP)){
						this.y -= this.speedY;
						if(y<0) y=0;
		}
		else if (InputUtility.getKeyPressed(KeyEvent.VK_DOWN)){
						this.y += this.speedY;
						if(y>GlobalConfig.SCREEN_HEIGHT) y=GlobalConfig.SCREEN_HEIGHT;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score < 0 ? 0 : score;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade < 0 ? 0 : grade;
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

	@Override
	public void crash(IRenderable a) {
		if(a instanceof SpaceShip){
			if(a instanceof EnemyShip){
			((EnemyShip) a).setDestroyed(true);
			this.setDestroyed(true);
			}
			else return;
		}
		else if(a instanceof Bullet){
			if(!(((Bullet) a).getShooter() instanceof MainShip)){
			this.decreaseHP(((Bullet) a).getDamage());
			((Bullet) a).setDestroyed(true);
			}
			else return;
		}
		
	}

}
