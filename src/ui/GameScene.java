package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import config.GlobalConfig;
import utility.InputUtility;
import logic.IRenderable;
import logic.IRenderableHolder;

public class GameScene extends JComponent{
	public GameScene(){
		super();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(GlobalConfig.SCREEN_WIDTH,GlobalConfig.SCREEN_HEIGHT));
		setVisible(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(arg0.getKeyCode(),false);
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(arg0.getKeyCode(), true);
			}
			
		
		});
	}	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		
	}
}
