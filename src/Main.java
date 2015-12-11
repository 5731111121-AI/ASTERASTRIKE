import javax.swing.JFrame;

import logic.GameLogic;
import ui.GamePlay;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("ASTERASTRIKE");
		GamePlay gp = new GamePlay();
		GameLogic gl = new GameLogic();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(gp);
		f.pack();
		f.setVisible(true);
		gp.setFocusable(true);
		gp.requestFocus();
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gp.repaint();
			gl.update();
		}
	}

}
