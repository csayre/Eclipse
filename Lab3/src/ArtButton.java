import javax.swing.JButton;

/**
 * @author ChrisSayre
 * @version Feb 17, 2014
 * @file ArtButton.java
 */

import java.util.Random;

public class ArtButton extends JButton{

	private int colorCode;
	private int colorCodePrv;

	public ArtButton()
	{
		Random rand = new Random();
		this.colorCode = rand.nextInt(7);
		this.colorCodePrv = colorCode;
	}

	public int getColorCode() {
		Random rand = new Random();
		this.colorCode = rand.nextInt(7);
		return colorCode;
	}

	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}
	public int getColorCodePrv()
	{
		return colorCodePrv;
	}
	public void setColorCodePrv(int color)
	{
		this.colorCodePrv = color;
	}
}
