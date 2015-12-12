package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import config.GlobalConfig;
import logic.IRenderable;
import logic.RenderableHolder;
import utility.InputUtility;

public class GamePlay extends GameScene{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GamePlay() {
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(GlobalConfig.SCREEN_WIDTH, GlobalConfig.SCREEN_HEIGHT));
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) { /* not in used */ }
			
			@Override
			public void keyReleased(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), true);
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.black);
		g2d.clearRect(0, 0, GlobalConfig.SCREEN_WIDTH, GlobalConfig.SCREEN_HEIGHT);
		for (IRenderable en : RenderableHolder.getInstance().getRenderableList())
			if(en.isVisible())
				en.render(g2d);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}
}
