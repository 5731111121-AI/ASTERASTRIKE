package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import config.GlobalConfig;
import logic.IRenderable;
import logic.RenderableHolder;
import utility.InputUtility;

public abstract class GameScene extends JPanel {

	protected BufferedImage backGround;
	protected BufferedImage selector;
	
	protected GameScene() {
		super();
		applyResize();
		validate();
		setDoubleBuffered(true);
		addListener();
		setFocusable(true);
		requestFocus();
	}
	
	protected void addListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (InputUtility.getKeyPressed(arg0.getKeyCode())) {
					InputUtility.setKeyPressed(arg0.getKeyCode(), false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (!InputUtility.getKeyPressed(arg0.getKeyCode())) {
					InputUtility.setKeyPressed(arg0.getKeyCode(), true);
					InputUtility.setKeyTriggered(arg0.getKeyCode(), true);
				}
			}
		});
	}
	
	protected void applyResize() {
		setPreferredSize(new Dimension(GlobalConfig.SCREEN_WIDTH, GlobalConfig.SCREEN_HEIGHT));
		validate();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(hints);
        g2.setBackground(Color.BLACK);
        g2.clearRect(0, 0, GlobalConfig.SCREEN_WIDTH, GlobalConfig.SCREEN_HEIGHT);
        if(RenderableHolder.getInstance().getRenderableList() != null){
        	CopyOnWriteArrayList<IRenderable> ro = (CopyOnWriteArrayList<IRenderable>) RenderableHolder.getInstance().getRenderableList();
        	for(IRenderable r : ro){
        		r.render(g2);
        	}
        }
	}
	
	protected abstract void update();
}
