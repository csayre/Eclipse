import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.*;

class Ball extends JButton{
		
	private int x, y;
	/**
	 * Constructor for the Ship class 
	 */
	public Ball(ImageIcon s){
		super(s);
		x = 100;
		setSize(229, 106);
		setForeground(Color.RED);
		
	}   
	
	public void bounceBall(int dx, int dy){
		x = x + dx;
		y = y + dy;
		super.setLocation(x, y);
	}
	
	/**
	 * Method to move the ship to a random location on the screen
	 */
	public void moveBall(){
		Random rand = new Random();
		
		x = rand.nextInt(BallView.FRAMEWIDTH - this.getWidth());
		y = rand.nextInt(BallView.FRAMEHEIGHT - this.getHeight());
		setLocation(x, y);
	}
	
	
}