import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.*;

class Ship extends JButton{
		
	private int x, y;
	/**
	 * Constructor for the Ship class 
	 */
	public Ship(ImageIcon s){
		
		super(s);
		x = 100;
		y = 100;
		setLocation(x,y);
		setSize(229, 106);
		setForeground(Color.RED);
		
	}   
	
	public void bounceShip(int dx, int dy){
		x = x + dx;
		y = y + dy;
		super.setLocation(x, y);
	}
	
	/**
	 * Method to move the ship to a random location on the screen
	 */
	public void moveShip(){
		Random rand = new Random();
		
		x = rand.nextInt(SpaceShip.FRAMEWIDTH - this.getWidth());
		y = rand.nextInt(SpaceShip.FRAMEHEIGHT - this.getHeight());
		setLocation(x, y);
	}
	
	
}