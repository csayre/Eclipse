
import java.awt.Polygon;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpaceShip extends Polygon
{
	
	private Polygon ship;
	private int x,y;
	private Image shipImg;
	
	//Set image for the ship, then set polygon to around the image inside. Should work, if not then you're fucked
	
	
	public SpaceShip(int x,int y) throws SlickException{
		this.x = x;
		this.y = y;	
		shipImg = new Image("res/AsteroidShip.png");
	}
	public Polygon Ship(){
		ship = new Polygon();
		ship.addPoint((x + 22), (y + 33));
		ship.addPoint((x + 6), (y + 33));
		ship.addPoint((x + 14), (y + 31));
		ship.addPoint((x + 14), (y + 9));
		return ship;
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
}
