import javax.swing.JOptionPane;

/**
 * @author csayre
 * @version Feb 26, 2014
 * @file Controller.java
 */

public class Controller {

	/**
	 * sets up final ints for lives
	 */
	private final int EASY_NUM_LIVES = 5;
	private final int MED_NUM_LIVES = 3;
	private final int HARD_NUM_LIVES = 1;

	/**
	 * properties of the controller
	 */

	private int row;
	private int col;
	private int life;
	private JOptionPane display;

	/**
	 * constructor for  controller
	 * 
	 */

	public Controller()
	{
		this.row = 4;
		this.col = 4;
		this.life = 1;
	}	

	/**
	 * used to run the game. 
	 * 
	 */

	public void startGame() {
		
		//prompt user for data if user hits cancel game exits w/o execption
		try
		{
			String input = JOptionPane.showInputDialog("Enter difficulty 1 = 1 life, 2 = 3 Lives, 3 = 5 Lives");
			int life1 = Integer.parseInt(input);
			this.life = this.life(life1);
			checkLife(life);
			String rowInput = JOptionPane.showInputDialog("Enter Number of rows");
			this.row = Integer.parseInt(rowInput);
			this.checkRow(row);
			String colInput = JOptionPane.showInputDialog("Enter Number of cols");
			this.col = Integer.parseInt(colInput);
			this.checkCol(col);
		}
		catch(Exception NumberFormatException)
		{
			System.out.println("Exit");
			System.exit(0);
		}
		View game = new View(row, col, life);
	}

	/**
	 * Checks to see if the parameters for row, col, and life are in correct bounds.
	 * @param col
	 * @param life
	 */

	public void checkLife(int life)
	{
		if(life < 1 || life > 3)
		{
			String input = JOptionPane.showInputDialog("Enter difficulty 1 = 1 life, 2 = 3 Lives, 3 = 5 Lives");
			int life1 = Integer.parseInt(input);
			this.life = this.life(life1);

		}
	}

	/**
	 * checks row for correct parameters
	 * @param row
	 */
	public void checkRow(int row)
	{
		if(row < 4 || row > 25)
		{
			String rowInput = JOptionPane.showInputDialog("Enter Number of rows");
			this.row = Integer.parseInt(rowInput);
		}
	}

	/**
	 * checks col for correct parameters
	 * @param col
	 */

	public void checkCol(int col)
	{
		if(col < 4 || col > 25)
		{
			String colInput = JOptionPane.showInputDialog("Enter Number of cols");
			this.col = Integer.parseInt(colInput);
		}
	}
	
	/**
	 * sets life based on @param
	 * 
	 * @param life1
	 * @return
	 */

	public int life(int life1)
	{
		int numLives = 0;
		if(life1 == 3)
			numLives = 5;
		else if (life1 == 2)
			numLives = 3;
		else if (life1 == 1)
			numLives = 1;

		return numLives;
	}

}
