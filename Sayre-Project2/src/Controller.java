

/**
 * Controller class manages minesweepr
 *
 * @author Chase
 * @version 1.0
 */
public class Controller
{	
	/**
	 * The start method handles the game loop for minesweeper 
	 */
	public void start() throws java.lang.InterruptedException
	{		
		//create an instance of the View class
		View view = new View();
		
		//get the number of rows and columns from the view
		int r = view.getRows();
		int c = view.getCols();
		
		//create an instance of the Grid class
		Grid grid = new Grid(r, c);
		
		boolean done = false;
		int row, col;
		
		int count = 0;
		
		//game loop runs until either the player hits a mine or clears the board
		while (!(done))
		{
			System.out.println(grid);
			row = view.getRow(r);
			col = view.getCol(c);
			
			if (grid.newMove(row, col))
			{
				count++;
			}
				
			if (grid.checkMine(row,col))
			{
				done = true;
				view.display("Game Over - Mine Encountered");
			}
			else if (count >= (grid.cellCount()))
			{
				view.display("Game Over - Winner");
				done = true;
			}
		}
	}		
}