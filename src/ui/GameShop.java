package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import config.GlobalConfig;
import exception.NoSavFileException;
import logic.MainShip;
import utility.DrawingUtility;
import utility.InputUtility;
import utility.SavUtility;

public class GameShop extends GameScene {

	private static final RenderObject bg = new RenderObject(DrawingUtility.getImageFromResource("shopSprite.jpg"));
	private static final RenderObject[] ship = new RenderObject[5];
	private static int shopOption;
	private static final int price[] = {20, 50, 100, 250, 500};

	static {
		for (int i = 0; i < 5; i++) {
			ship[i] = new RenderObject(DrawingUtility.getImageFromResource("shopShip" + i + ".png"));
		}
	}

	public GameShop() {
		super();
		bg.topLeftAnimationAt(0, 0);
		for (int i = 0; i < 5; i++) {
			ship[i].centerAnimationAt(297, 250);
		}
		shopOption = 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		bg.render(g2);
		g2.setFont(GlobalConfig.subFont.deriveFont(20));
		g2.setColor(Color.white);
		g2.drawString("Current Credits: " + GlobalConfig.credits, 600, 30);
		switch (shopOption) {
		case 0:
			ship[shopOption].render(g2);
			g2.drawString("price: " + price[shopOption] + " credits", 150, 450);
			MainShip a = new MainShip(shopOption);
			int HP = a.getMaxHP();
			int speed = a.getSpeedX();
			int damage = a.getBulletDamage();
			int shootingDelay = a.getShootingDelay();
			int bulletSpeed = a.getBulletSpeed();
			g2.setColor(new Color(0, 0, 140));
			g2.drawString("HP:", 520, 140);
			g2.drawString("Speed:", 520, 180);
			g2.drawString("Damage:", 520, 220);
			g2.drawString("Shooting Delay:", 520, 260);
			g2.drawString("Bullet Speed:", 520, 300);
			g2.setColor(Color.black);
			g2.drawString("" + HP, 850, 140);
			g2.drawString("" + speed, 850, 180);
			g2.drawString("" + damage, 850, 220);
			g2.drawString("" + shootingDelay, 850, 260);
			g2.drawString("" + bulletSpeed, 850, 300);
			if(GlobalConfig.isBought[shopOption]) {
				String str = "You've bought it";
				if(GlobalConfig.currentShip == shopOption) {
					str = "Equiped";
				}
				g2.setColor(Color.darkGray);
				g2.drawString(str, 520, 450);
			} else {
				if (GlobalConfig.credits < price[shopOption]) {
					g2.setColor(new Color(150, 0, 0));
					g2.drawString("not enough credits", 520, 450);
				}
			}
			break;
		case 1:
			ship[shopOption].render(g2);
			g2.drawString("price: " + price[shopOption] + " credits", 150, 450);
			a = new MainShip(shopOption);
			HP = a.getMaxHP();
			speed = a.getSpeedX();
			damage = a.getBulletDamage();
			shootingDelay = a.getShootingDelay();
			bulletSpeed = a.getBulletSpeed();
			g2.setColor(new Color(0, 0, 140));
			g2.drawString("HP:", 520, 140);
			g2.drawString("Speed:", 520, 180);
			g2.drawString("Damage:", 520, 220);
			g2.drawString("Shooting Delay:", 520, 260);
			g2.drawString("Bullet Speed:", 520, 300);
			g2.setColor(Color.black);
			g2.drawString("" + HP, 850, 140);
			g2.drawString("" + speed, 850, 180);
			g2.drawString("" + damage, 850, 220);
			g2.drawString("" + shootingDelay, 850, 260);
			g2.drawString("" + bulletSpeed, 850, 300);
			if(GlobalConfig.isBought[shopOption]) {
				String str = "You've bought it";
				if(GlobalConfig.currentShip == shopOption) {
					str = "Equiped";
				}
				g2.setColor(Color.darkGray);
				g2.drawString(str, 520, 450);
			} else {
				if (GlobalConfig.credits < price[shopOption]) {
					g2.setColor(new Color(150, 0, 0));
					g2.drawString("not enough credits", 520, 450);
				}
			}
			break;
		case 2:
			ship[shopOption].render(g2);
			g2.drawString("price: " + price[shopOption] + " credits", 150, 450);
			a = new MainShip(shopOption);
			HP = a.getMaxHP();
			speed = a.getSpeedX();
			damage = a.getBulletDamage();
			shootingDelay = a.getShootingDelay();
			bulletSpeed = a.getBulletSpeed();
			g2.setColor(new Color(0, 0, 140));
			g2.drawString("HP:", 520, 140);
			g2.drawString("Speed:", 520, 180);
			g2.drawString("Damage:", 520, 220);
			g2.drawString("Shooting Delay:", 520, 260);
			g2.drawString("Bullet Speed:", 520, 300);
			g2.setColor(Color.black);
			g2.drawString("" + HP, 850, 140);
			g2.drawString("" + speed, 850, 180);
			g2.drawString("" + damage, 850, 220);
			g2.drawString("" + shootingDelay, 850, 260);
			g2.drawString("" + bulletSpeed, 850, 300);
			if(GlobalConfig.isBought[shopOption]) {
				String str = "You've bought it";
				if(GlobalConfig.currentShip == shopOption) {
					str = "Equiped";
				}
				g2.setColor(Color.darkGray);
				g2.drawString(str, 520, 450);
			} else {
				if (GlobalConfig.credits < price[shopOption]) {
					g2.setColor(new Color(150, 0, 0));
					g2.drawString("not enough credits", 520, 450);
				}
			}
			break;
		case 3:
			ship[shopOption].render(g2);
			g2.drawString("price: " + price[shopOption] + " credits", 150, 450);
			a = new MainShip(shopOption);
			HP = a.getMaxHP();
			speed = a.getSpeedX();
			damage = a.getBulletDamage();
			shootingDelay = a.getShootingDelay();
			bulletSpeed = a.getBulletSpeed();
			g2.setColor(new Color(0, 0, 140));
			g2.drawString("HP:", 520, 140);
			g2.drawString("Speed:", 520, 180);
			g2.drawString("Damage:", 520, 220);
			g2.drawString("Shooting Delay:", 520, 260);
			g2.drawString("Bullet Speed:", 520, 300);
			g2.setColor(Color.black);
			g2.drawString("" + HP, 850, 140);
			g2.drawString("" + speed, 850, 180);
			g2.drawString("" + damage, 850, 220);
			g2.drawString("" + shootingDelay, 850, 260);
			g2.drawString("" + bulletSpeed, 850, 300);
			if(GlobalConfig.isBought[shopOption]) {
				String str = "You've bought it";
				if(GlobalConfig.currentShip == shopOption) {
					str = "Equiped";
				}
				g2.setColor(Color.darkGray);
				g2.drawString(str, 520, 450);
			} else {
				if (GlobalConfig.credits < price[shopOption]) {
					g2.setColor(new Color(150, 0, 0));
					g2.drawString("not enough credits", 520, 450);
				}
			}
			break;
		case 4:
			ship[shopOption].render(g2);
			g2.drawString("price: " + price[shopOption] + " credits", 150, 450);
			a = new MainShip(shopOption);
			HP = a.getMaxHP();
			speed = a.getSpeedX();
			damage = a.getBulletDamage();
			shootingDelay = a.getShootingDelay();
			bulletSpeed = a.getBulletSpeed();
			g2.setColor(new Color(0, 0, 140));
			g2.drawString("HP:", 520, 140);
			g2.drawString("Speed:", 520, 180);
			g2.drawString("Damage:", 520, 220);
			g2.drawString("Shooting Delay:", 520, 260);
			g2.drawString("Bullet Speed:", 520, 300);
			g2.setColor(Color.black);
			g2.drawString("" + HP, 850, 140);
			g2.drawString("" + speed, 850, 180);
			g2.drawString("" + damage, 850, 220);
			g2.drawString("" + shootingDelay, 850, 260);
			g2.drawString("" + bulletSpeed, 850, 300);
			if(GlobalConfig.isBought[shopOption]) {
				String str = "You've bought it";
				if(GlobalConfig.currentShip == shopOption) {
					str = "Equiped";
				}
				g2.setColor(Color.darkGray);
				g2.drawString(str, 520, 450);
			} else {
				if (GlobalConfig.credits < price[shopOption]) {
					g2.setColor(new Color(150, 0, 0));
					g2.drawString("not enough credits", 520, 450);
				}
			}
			break;
		}
	}

	@Override
	protected void update() {
		if (InputUtility.getKeyTriggered(KeyEvent.VK_ENTER) || InputUtility.getKeyTriggered(KeyEvent.VK_SPACE)) {
			if (GlobalConfig.credits >= price[shopOption]) {
				GlobalConfig.currentShip = shopOption;
				GlobalConfig.isBought[shopOption] = true;
				GlobalConfig.credits -= price[shopOption];
				try {
					SavUtility.saveGame();
				} catch (NoSavFileException e) {
					SavUtility.createDefaultSavFile();
					e.printStackTrace();
				}
			}
		}

		if (InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)) {
			shopOption = (++shopOption) % 5;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)) {
			shopOption = shopOption - 1 < 0 ? 4 : shopOption - 1;
		}

		if (InputUtility.getKeyTriggered(KeyEvent.VK_ESCAPE)) {
			GameManager.gameWindow.switchScene(new GameMenu());
			try {
				SavUtility.saveGame();
			} catch (NoSavFileException e) {
				SavUtility.createDefaultSavFile();
				e.printStackTrace();
			}
		}
	}

}
