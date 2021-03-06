

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
		asteroid.addPoint(x + 8, y + 45);
		asteroid.addPoint(x + 2, y + 19);
		asteroid.addPoint(x + 9, y + 6);
		asteroid.addPoint(x + 25, y + 4);
		asteroid.addPoint(x + 35, y + 5);
		asteroid.addPoint(x + 44, y + 13);
		asteroid.addPoint(x + 44, y + 30);
		asteroid.addPoint(x + 47, y + 31);
		asteroid.addPoint(x + 46, y + 40);
		asteroid.addPoint(x +  10, y + 46);
		
		return asteroid;
	}
	
	public boolean collision(int x, int y)
	{
		boolean collision = false;
		if(asteroid.contains(x, y));
		{
			collision = true;
			System.out.println("shot");
		}
		return collision;
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
	public void draw(int x, int y) 
	{
		//System.out.println(shipImg);
		g.drawImage(shipImg, x, y);
	}
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	

}
