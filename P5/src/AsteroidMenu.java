

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class AsteroidMenu extends BasicGameState
{
	Image ship;
	int shipX = 300;
	int shipY = 300;
	
	public String mouse = "No input yet!";
	
	public AsteroidMenu(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawString(mouse, 50, 50);
		
		g.drawString("ASTEROIDS", 320, 575);
		
		g.drawString("press enter", 310, 600);
		
//		g.drawRect(100, 100, 50, 50); //x, y, width, height
//		g.drawOval(200, 200, 100, 100); //x, y, width, height
		
		//Image ship = new Image("res/Asteroid-Ship.jpg");
		
		//g.drawImage(ship, shipX, shipY);
		
		
		
		
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{

		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mouse = "Mouse position x: " + xPos + " y: " + yPos;
		
		Input input = gc.getInput();
//		if((xPos > 75 && xPos < 175) && (yPos > 500 && yPos < 600))
//		{
//			if(input.isMouseButtonDown(0))
//				sbg.enterState(1);
//		}
		
		if(input.isKeyDown(Input.KEY_ENTER))
		{
			sbg.enterState(1);
		}
		
	}
	
	public int getID()
	{
		return 0;
	}
}