/**
 * 
 */

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
/**
 * @author chrissayre
 *
 */
/**
 * @author csayre
 *
 */
public class Asteroid extends Polygon{

	private Polygon asteroid;
	private Polygon ship;
	private int x,y;
	private Image shipImg;
	private Graphics g;
	private boolean isAlive;
	
	//Set image for the ship, then set polygon to around the image inside. Should work, if not then you're fucked
	
	/**
	 * Asteroid constructor
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public Asteroid(int x,int y) throws SlickException{
		this.x = x;
		this.y = y;	
		this.isAlive = true;
		shipImg = new Image("res/Asteroid1.png");
		g = new Graphics();
	}
	
	public Polygon Asteroid(){
		asteroid = new Polygon();
		asteroid.addPoint(x + 16, y + 23);
		asteroid.addPoint(x + 66, y + 10);
		asteroid.addPoint(x + 113, y + 18);
		asteroid.addPoint(x + 125, y + 76);
		asteroid.addPoint(x + 129, y + 89);
		asteroid.addPoint(x + 139, y + 115);
		asteroid.addPoint(x + 124, y + 118);
		asteroid.addPoint(x + 120, y + 128);
		asteroid.addPoint(x + 86, y + 124);
		asteroid.addPoint(x +  20, y + 123);
		
		return asteroid;
	}
	
	
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void setImage(Image s)
	{
		s = shipImg;
	}
	public Image getImage()
	{
		return shipImg;
	}
	public void draw(int x, int y) throws InterruptedException
	{
		System.out.println(shipImg);
		g.drawImage(shipImg, x, y);
	}
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	

}
