package logic;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameLogic implements IEnemyShipsHolder {
	
	private CopyOnWriteArrayList<EnemyShip> enemies;
	
	public GameLogic() {
		enemies = new CopyOnWriteArrayList<EnemyShip>();
	}
	
	public void update(){
		
	}

	@Override
	public CopyOnWriteArrayList<EnemyShip> getEnemyships() {
		return enemies;
	}

}
