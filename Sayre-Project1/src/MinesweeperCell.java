/**
 * MinesweeperCell.java
 * @author csayre
 * @version 1.0
 * @date Jan 28, 2014
 */

import java.util.Random;

public class MinesweeperCell {
	
	public boolean isMine;
	private final char CARROT = '^';
	private char value;

	MinesweeperCell()
	{
		this.isMine = false;
		this.value = '^';
	}
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public MinesweeperCell generateMines()
	{
		MinesweeperCell cell = new MinesweeperCell();
		Random bool = new Random();
		
		this.isMine = bool.nextBoolean();
		
		return cell;
		
	}
	
	
	public char getCarrot ()
	{
		return CARROT;
	}
	
	public boolean getIsMine() {
		return isMine;
	}



	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}



	public String toString()
	{
		return "Is Mine: " + this.isMine;
	}

	public boolean isMine() {
		// TODO Auto-generated method stub
		return isMine;
	}

	

}
