package logic;

import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import utility.DrawingUtility;

public class GameLogic {

	private static final GameLogic logic = new GameLogic();
	private static final int spawnDelay = 150;
	private int spawnDelayCounter;
	private int trippleSpawnChance;
	protected MainShip mainShip;
	protected PlayerStatus playerStatus;
	protected CopyOnWriteArrayList<EnemyShip> eShips;

	public GameLogic() {
		spawnDelayCounter = 0;
		mainShip = new MainShip(0);
		playerStatus = new PlayerStatus();
		eShips = new CopyOnWriteArrayList<EnemyShip>();
		RenderableHolder.getInstance().add(playerStatus);
		RenderableHolder.getInstance().add(mainShip);
	}

	public void update() {
		if (!playerStatus.isGameOver()) {
			mainShip.update();
			for (EnemyShip e : eShips) {
				e.update();
				if (mainShip.crash(e)) {
					mainShip.setDestroyed(true);
					e.setDestroyed(true);
					playerStatus.setGameOver(true);
				}
				if (e.isDestroyed) {
					eShips.remove(e);
					RenderableHolder.getInstance().getRenderableList().remove(e);
				}
			}
			for (IRenderable r1 : RenderableHolder.getInstance().getRenderableList()) {
				if (r1 instanceof Bullet) {
					((Bullet) r1).update();
					if (((Bullet) r1).isDestroyed) {
						RenderableHolder.getInstance().getRenderableList().remove(r1);
					}
				}
			}
			spawnDelayCounter = (++spawnDelayCounter) % spawnDelay;
			if (spawnDelayCounter == 0) {
				BufferedImage enemyImg = DrawingUtility.getImageFromResource("EnemyShip1.png");
				EnemyShip e = new EnemyShip(0, enemyImg);
				eShips.add(e);
				RenderableHolder.getInstance().add(e);
			}
		} else {
			
		}
	}

}
