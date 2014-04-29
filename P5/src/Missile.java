

import java.awt.Rectangle;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Missile 
{
	private	int missileX;
	private	int missileY;
	private	float missileDx;
	private	float missileDy;
	private Rectangle missile;


	private Image missileImg;

	public Missile() throws SlickException
	{
		this.missileX = 350;
		this.missileY = 650;
		missileImg = new Image("res/Missile.png");
	}
	public Rectangle Missile()
	{
		missile = new Rectangle(2, 4);

		return missile;
	}
	public Rectangle getMissile() {
		return missile;
	}
	public void setMissile(Rectangle missile) {
		this.missile = missile;
	}
	public int getMissileX() {
		return missileX;
	}
	public void setMissileX(int missileX) {
		this.missileX = missileX;
	}
	public int getMissileY() {
		return missileY;
	}
	public void setMissileY(int missileY) {
		this.missileY = missileY;
	}
	public float getMissileDx() {
		return missileDx;
	}
	public void setMissileDx(float missileDx) {
		this.missileDx = missileDx;
	}
	public float getMissileDy() {
		return missileDy;
	}
	public void setMissileDy(float missileDy) {
		this.missileDy = missileDy;
	}
	public Image getMissileImg() {
		return missileImg;
	}
	public void setMissileImg(Image missileImg) {
		this.missileImg = missileImg;
	}
	public void MoveMissile()
	{
		missileY -= 1;
	}
}
