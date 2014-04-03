import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



/**
 * @author csayre
 * @version Feb 26, 2014
 * @file View.java
 */

@SuppressWarnings("serial")
public class View extends JFrame {

	/**
	 * sets up the frame dim
	 */
	public static final int FRAMEHEIGHT = 500;
	public static final int FRAMEWIDTH = 500;

	/**
	 * properties of view
	 */
	private MineButton button;
	private MineButton mines[][];	
	private JPanel playArea;
	private int numMines;
	private int row;
	private int col;
	private int life;
	private int totMine;
	private final double CHANCE_OF_MINE =  .156;

	/** 
	 * set up undo and redo stack
	 * 
	 */

	private Stack<JButton> undo;
	private Stack<JButton> redo;

	/**
	 * Constructor for the View class loads and displays the frame
	 * @param _row row from the controller
	 * @param _col col from the controller
	 * 
	 */

	public View(int _row, int _col, int _life){
		//this.setLayout(null;
		undo = new Stack<JButton>();
		redo = new Stack<JButton>();
		this.row = _row;
		this.col = _col;
		this.life = _life;
		playArea = new JPanel();
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		playArea.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		playArea.setLocation(0, 0);
		//this.addRedo();
		playArea.setLayout(new GridLayout(this.row, this.col));
		this.mines = new MineButton[this.row][this.col];
		this.populateGrid();
		this.makeMine();
		this.add(playArea);
		this.setVisible(true);
	}
	
	/**
	 * method to add the redo button with Actionhandler
	 */

	public void addRedo()
	{
		Button button_1 = new Button("Undo");
		button_1.addActionListener(new ActionListener(){
			/**this method performs the action event associated with this button**/
			public void actionPerformed(ActionEvent e) {
				redo.add(undo.peek());
				JButton button = (MineButton) new JButton();
				((MineButton) button).setClickable(true);
				button.setText("^");
				undo.pop();

			}
		});
		playArea.add(button_1);
		button_1.setVisible(true);
	}
	
	/**
	 * method to add Undo button
	 */
	
	public void addUndo()
	{
		Button button_1 = new Button("Undo");
		button_1.addActionListener(new ActionListener(){
			/**this method performs the action event associated with this button**/
			public void actionPerformed(ActionEvent e) {
				
				redo.pop();

			}
		});
		playArea.add(button_1);
		button_1.setVisible(true);
	}

	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * Populates the Grid with buttons
	 * 
	 */

	private void populateGrid()
	{
		for(int col = 0; col < mines.length ; col ++)
		{
			for (int row = 0; row < mines[col].length; row++)
			{
				MineButton button1 = new MineButton();
				button1.setOpaque(true);
				button1.setBackground(Color.white);
				button1.setText("^");
				button1.addMouseListener(new mineButtonHandler());
				this.mines[row][col] = button1;
				playArea.add(this.mines[row][col]);
			}
			System.out.println();
		}
	}

	/**
	 * Makes mines
	 * 
	 */
	private void makeMine()
	{
		Random rand = new Random();
		numMines = (int)(row * col * CHANCE_OF_MINE);
		int count = 0;
		int x, y;
		this.totMine = numMines;

		while (count < numMines)
		{
			x = rand.nextInt(row);
			y = rand.nextInt(col);

			if (!(mines[x][y].isMine()))
			{
				mines[x][y].setMine(true);
				count++;
			}
		}
		this.printMines();
	}

	/**
	 * Prints mines to the console - debugging only
	 * 
	 */

	public void printMines()
	{
		for(int col = 0; col < mines.length ; col ++)
		{
			for (int row = 0; row < mines[col].length; row++)
			{
				System.out.print(mines[row][col].isMine() + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Checks around the mines
	 * 
	 * @param button
	 * @return the number of mines
	 */

	private void runCheck(JButton button) {
		// TODO Auto-generated method stub

		int mc = 0;
		for (int i=0; i<row; i++) 
		{ 
			mc = 0;
			for (int j=0; j<col; j++) 
			{
				if (mines[i][j].isMine()){
					mines[i][j].setMineCount(0);
				}
				else
				{
					mc = 0;
					//count the number of neighbors that are mines
					for (int x=-1; x<2; x++) 
					{
						for (int y=-1; y<2; y++) 
						{
							if (valid(i,j,x,y))
							{
								if (mines[i+x][j+y].isMine())
								{
									mc++;
								}
							}
						}
					}
					mines[i][j].setMineCount(mc);
				}
			}

		}
	}

	/**
	 * helper method for checks
	 * 
	 * @param i
	 * @param j
	 * @param x
	 * @param y
	 * @return boolean
	 */

	private boolean valid(int i, int j, int x, int y)
	{
		boolean result = true;
		if ((x==0) && (y==0))
			result = false;
		else if (((i+x)<0) || ((i+x)>=row))
			result = false;
		else if (((j+y)<0) || ((j+y)>=col))
			result = false;

		return result;
	}

	
	public void checkWin()
	{
		int inc = 0;
		for(int col = 0; col < mines.length ; col ++)
		{
			for (int row = 0; row < mines[col].length; row++)
			{
				if(mines[row][col].isFlagged() == true)
				{
					inc++;
				}
			}
		}
		if(inc == totMine)
		{
			JOptionPane.showMessageDialog(null, "You Win");
			System.exit(0);
		}
	}

	/**
	 * Event handler
	 * listens for mouse events. 
	 * 
	 */
	private class mineButtonHandler implements MouseListener
	{
		

		

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton button = (JButton) e.getSource();

			if(((MineButton) button).isClickable() && ((MineButton) button).isMine() == false)
			{
				runCheck(button);
				int test = ((MineButton) button).getMineCount();
				String count = String.valueOf(test);
				undo.add(button);
				((MineButton) button).setClickable(false);
				button.setText(count);
			}

			if(((MineButton) button).isClickable() && ((MineButton) button).isMine() == true)
			{
				button.setText("*");
				setLife(getLife() - 1);
				undo.add(button);
				((MineButton) button).setClickable(false);
				if(getLife() == 0)
				{
					System.out.println("Game Over! Your out of lives!");
					System.exit(0);
				}
			}

			if (SwingUtilities.isRightMouseButton(e) || e.isControlDown())
			{
				System.out.println("flagged");
				((MineButton) button).setFlagged(true);
				button.setText("F");
				checkWin();
			}


		}
		/**
		 * methods that must be implemented but are not needed. 
		 */

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		/*@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}*/


	}
}



