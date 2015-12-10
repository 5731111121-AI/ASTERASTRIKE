package logic;

import config.GlobalConfig;
import utility.DrawingUtility;

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
		// TODO Auto-generated method stub
		
	}
}
