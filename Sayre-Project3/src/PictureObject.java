import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

/**
 * @author ChrisSayre
 * @version Mar 20, 2014
 * @file PictureObject.java
 */


@SuppressWarnings("serial")
public class PictureObject extends JButton{


	/**
	 * properities of picture object
	 */

	private int collisionCount;
	private int x, y;
	private int dx, dy;
	private boolean isAlive;
	

	/**
	 * Constructor for the PictureObject class 
	 */
	public PictureObject(ImageIcon s){
		super(s);
		x = 100;
		setSize(50, 50);
		setForeground(Color.RED);
		this.isAlive = false;
		this.dx = 3;
		this.dy = 4;
		this.randomCollisionCount();

	}   
	
	/**
	 * creates a random collision count
	 */
	
	private void randomCollisionCount()
	{
		Random ranInt = new Random();
		this.collisionCount = ranInt.nextInt(5) + 3;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PictureObject [collisionCount=" + collisionCount + "]";
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * @return the collisionCount
	 */
	public int getCollisionCount() {
		return collisionCount;
	}

	/**
	 * @param collisionCount the collisionCount to set
	 */
	public void setCollisionCount(int collisionCount) {
		this.collisionCount = collisionCount;
	}
	
	/**
	 * Bounces ball
	 */

	public void bounceBall(){
		x = x + dx;
		y = y + dy;
		super.setLocation(x, y);
	}

	/**
	 * Method to move the ship to a random location on the screen
	 */
	public void moveBall(){
		Random rand = new Random();

		x = rand.nextInt(ObjectView.FRAMEWIDTH - this.getWidth());
		y = rand.nextInt(ObjectView.FRAMEHEIGHT - this.getHeight());
		setLocation(x, y);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the dx
	 */
	public int getDx() {
		return dx;
	}

	/**
	 * @param dx the dx to set
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}

	/**
	 * @return the dy
	 */
	public int getDy() {
		return dy;
	}

	/**
	 * @param dy the dy to set
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	/**
	 * reverses dx and dy for bounce. 
	 */
	public void reverse()
	{
		dx = -1 * dx;
		dy = -1 * dy;
	}	


}
