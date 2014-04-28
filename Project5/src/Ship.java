import java.awt.Polygon;


public class Ship extends Polygon
{
	
	private int lives;
	private int dx, dy;
	private int xPoly[] = {100, 150, 200};
	private int yPoly[] = {50, 75, 100};
	private Polygon shipPoly;
	
	
	public Ship()
	{
		shipPoly = new Polygon(xPoly, yPoly, xPoly.length);
	}
	
	public int[] getxPoly() {
		return xPoly;
	}

	public void setxPoly(int[] xPoly) {
		this.xPoly = xPoly;
	}

	public int[] getyPoly() {
		return yPoly;
	}

	public void setyPoly(int[] yPoly) {
		this.yPoly = yPoly;
	}

	public Polygon getShipPoly() {
		return shipPoly;
	}

	public void setShipPoly(Polygon shipPoly) {
		this.shipPoly = shipPoly;
	}

	private void moveShip()
	{
		
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	
}
