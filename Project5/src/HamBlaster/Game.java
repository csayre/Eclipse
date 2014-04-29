package HamBlaster;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Game extends StateBasedGame
{
	public static final String gameName = "Ham Blaster!";
	public static final int menuScreen = 0;
	public static final int playScreen = 1;
	
	
	public Game(String gameName)
	{
		super(gameName);
		this.addState(new Menu(menuScreen));
		this.addState(new Play(playScreen));
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
			appgc = new AppGameContainer(new Game(gameName));
			appgc.setDisplayMode(400, 400, false);
			appgc.start();
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
	}

}
