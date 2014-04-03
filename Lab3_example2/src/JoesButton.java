import java.awt.*;
import javax.swing.*;

/*****
 *
 *  This is an ugly little example that shows how you might create and use a grid of buttons
 *
 */
public class JoesButton extends JButton {
	
	//a private int attribute to represent the colorCode
	private int colorCode;
	
	/***
	 *
	 * constructor for the JoesButton class
	 *
	 */
	public JoesButton()
	{
		super();
		colorCode = 0;
		//this.addActionListener(this);
	}//end constructor
	
	/***
	 *
	 * The changeColor method updates the colorCode attribute and changes the color
	 * of this button appropriately
	 *
	 */
	public void changeColor()
	{
		colorCode = (colorCode + 1) % 4;
		switch (colorCode) {
            case 1:  this.setBackground(Color.green);
				break;
            case 2:  this.setBackground(Color.blue);
				break;
            case 3:  this.setBackground(Color.yellow);
				break;
            default: this.setBackground(Color.white);
				break;
		}//end switch
	}//end changeColor method
		
}//end class
