

import java.util.LinkedList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class AsteroidGameScreen extends BasicGameState
{

	private int shipX = 350;
	private int shipY = 650;
	private int missileX1, missileX2;
	private int missileY1, missileY2;

	private Random rand = new Random();
	LinkedList<Missile> list = new LinkedList();

	private static Image shipImage;
	private static Image missileImage;
	private static Image asteroidImage;
	private Asteroid ast;
	private Asteroid ast2;
	private Asteroid ast3;
	private Asteroid ast4;
	private Asteroid ast5;
	private Asteroid ast6;
	private Asteroid ast7;
	private SpaceShip s;
	private Missile m1, m2;
	private boolean shot1, shot2 = false;
	private int lives;
	private int points;
	private int missileCounter = 0;
	private int i;
	private int x;
	private int y;
	private int asteroidRandX, asteroidY;
	private boolean shot = false;

	public AsteroidGameScreen(int state)
	{
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		this.s = new SpaceShip(shipX,shipY);
		this.m1 = new Missile();
		this.m2 = new Missile();
		this.ast = new Asteroid(50, 50);
		this.ast2 = new Asteroid(50, 50);
		this.ast3 = new Asteroid(50, 50);
		this.ast4 = new Asteroid(50, 50);
		this.ast5 = new Asteroid(50, 50);
		this.ast6 = new Asteroid(50, 50);
		this.ast7 = new Asteroid(50, 50);
		this.lives = 3;
		this.points = 0;
		this.asteroidRandX = rand.nextInt(700);
		this.asteroidY = 50;

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		//g.drawString("This is the play state", 50, 50);
		g.drawString("Lives: " + this.lives, 25, 25);
		g.drawString("Points: " + this.points, 25, 40);
		//Don't need the images here since they are already in the classes.
		//Make a add missles method that resembles the add tiefighters method in my code, but only when you press spacebar of course

		Input input = gc.getInput();

		//		shipImage = new Image("res/AsteroidShip.png");
		//		missileImage = new Image("res/AsteroidShip.png");

		addMissiles();


		//s.setImage(shipImage);
		s.Ship();

		//m.setMissileImg(missileImage);
		m1.Missile();
		m2.Missile();

		g.drawImage(shipImage, shipX, shipY);
		//		try {
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	
			ast.draw(asteroidRandX, asteroidY);
			ast2.draw(asteroidRandX, asteroidY);
			ast3.draw(asteroidRandX, asteroidY);
			ast4.draw(asteroidRandX, asteroidY);
			ast5.draw(asteroidRandX, asteroidY);
			ast6.draw(asteroidRandX, asteroidY);
			ast7.draw(asteroidRandX, asteroidY);

		if(shot1 == true)
		{
			g.drawImage(m1.getMissileImg(), missileX1, missileY1);
			//System.out.println("I am here");
		}
		if(shot2 == true)
		{
			g.drawImage(m2.getMissileImg(), missileX2, missileY2);
			//System.out.println("pew pew 2");
		}

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{

		Input input = gc.getInput();
		shipImage = new Image("res/AsteroidShip.png");
		missileImage = new Image("res/Missile.png");




		if(input.isKeyDown(Input.KEY_UP))
		{
			shipY -= 1;
			m1.setMissileY(shipY);
			m2.setMissileY(shipY);
		}
		if(input.isKeyDown(Input.KEY_DOWN))
		{
			shipY += 1;
			m1.setMissileY(shipY);
			m2.setMissileY(shipY);
		}
		if(input.isKeyDown(Input.KEY_LEFT))
		{	
			shipX -= 1;
			m1.setMissileX(shipX);
			m2.setMissileX(shipX);
		}	
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			shipX += 1;
			m1.setMissileX(shipX);
			m2.setMissileX(shipX);
		}
		if(input.isKeyDown(Input.KEY_G))
		{
			//			System.out.println(shipY);
			//			System.out.println(shipX);
			asteroidY = 200;
		}

		if(input.isKeyPressed(Input.KEY_SPACE))
		{
			missileCounter++;
			missileY1 = m1.getMissileY();
			missileX1 = m1.getMissileX();
			missileY2 = m2.getMissileY();
			missileX2 = m2.getMissileX();			

			//			System.out.println(missileY1);
			//			System.out.println(missileY2);
			//if(ast.getY() == missileY1)

			if(missileCounter %2 == 0)
			{
				if(shot1 == false)
				{
					shot1 = true;
				}
			}

			if(missileCounter %2 == 1)
			{
				if(shot2 == false)
				{
					shot2 = true;
				}
			}
		}
		if(missileY1 == 0)
			shot1 = false;
		if(missileY2 == 0)
			shot2 = false;
		if(shot1 == true)
		{
			missileY1 -= 1;
		}

		if(shot2 == true)
		{
			missileY2 -= 1;
		}

		if(asteroidY != 0)
		{
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			asteroidY += 1;
		}
		if(asteroidY == 699)
		{
			asteroidY = 50;
			asteroidRandX = rand.nextInt(700);
		}


		if(shipX == 0)
			shipX = 698;
		if(shipX == 699)
			shipX = 1;
		if(shipY == 20)
			shipY = 21;
		if(shipY == 660)
			shipY = 659;
	}
	public void addMissiles() throws SlickException{
		i=0;
		x=shipX;
		y=shipY;
		while(i < list.size())
		{
			Missile m = new Missile();
			list.add(m);
			i++;
		}
	}
	public int getID()
	{
		return 1;
	}


	public int randomX()
	{
		// max = 699
		int ranX = 0;
		Random ran = new Random();
		ranX = ran.nextInt(699);
		return ranX;
	}

	public int randomY()
	{
		// max = 220
		int ranY = 0;
		Random ran = new Random();
		ranY = ran.nextInt(220);
		return ranY;
	}
}

