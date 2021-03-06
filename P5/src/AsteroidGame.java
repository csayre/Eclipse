

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class AsteroidGame extends StateBasedGame
{
	public static final String gameName = "ASTEROIDS!";
	public static final int menuScreen = 0;
	public static final int playScreen = 1;
	
	
	public AsteroidGame(String gameName)
	{
		super(gameName);
		this.addState(new AsteroidMenu(menuScreen));
		this.addState(new AsteroidGameScreen(playScreen));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(menuScreen).init(gc, this);
		this.getState(playScreen).init(gc, this);
		this.enterState(menuScreen);
	}
	
	
	public static void main (String[] args)
	{
		AppGameContainer appgc;
		
		try
		{
			appgc = new AppGameContainer(new AsteroidGame(gameName));
			appgc.setDisplayMode(700, 700, false);
			appgc.start();
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
	}

}
