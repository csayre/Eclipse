/**
 * 
 */
package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * @author csayre
 *
 */
public class MainMenu extends StateBasedGame {

	public static final String name = "Asteroids!";
	public static int menu = 0;
	public static int play = 1;
	
	public MainMenu(String name)
	{
		super(name);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc)throws SlickException
	{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppGameContainer appgc;
		
		try
		{
			appgc = new AppGameContainer(new MainMenu(name));
			appgc.setDisplayMode(643, 360, false);
			appgc.start();
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
	}

}
