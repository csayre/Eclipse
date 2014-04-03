import javax.swing.*;

/**
 * @author csayre
 * @version Feb 26, 2014
 * @file MineButton.java
 */

@SuppressWarnings("serial")
public class MineButton extends JButton {


	private boolean isMine;
	private boolean isFlagged;
	private char carrot;
	private int mineCount;
	private boolean isClickable;
	
	/**
	 * constructor for Minebutton
	 */
	
	public MineButton()
	{
		this.isMine = false;
		this.isClickable = true;
		this.isFlagged = false;
		this.carrot = '^';
		this.mineCount = 0;
	}

	/**
	 * @return the isMine
	 */
	public boolean isMine() {
		return isMine;
	}

	/**
	 * @return the isFlagged
	 */
	public boolean isFlagged() {
		return isFlagged;
	}

	/**
	 * @param isFlagged the isFlagged to set
	 */
	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	/**
	 * @param isMine the isMine to set
	 */
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	/**
	 * @return the carrot
	 */
	public char getCarrot() {
		return carrot;
	}

	/**
	 * @param carrot the carrot to set
	 */
	public void setCarrot(char carrot) {
		this.carrot = carrot;
	}

	/**
	 * @return the mineCount
	 */
	public int getMineCount() {
		return mineCount;
	}

	/**
	 * @param mineCount the mineCount to set
	 */
	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}
	

	/**
	 * @return the isClickable
	 */
	public boolean isClickable() {
		return isClickable;
	}

	/**
	 * @param isClickable the isClickable to set
	 */
	public void setClickable(boolean isClickable) {
		this.isClickable = isClickable;
	}

	

}
