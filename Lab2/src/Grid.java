import java.util.Random;


public class Grid 
{
	private final int ROW = 25;
	private final int COL = 25;

	private Character[][] grid;

	private double MINE_CHANCE = .156;


	public Grid()
	{
		this.grid = new Character[this.ROW][this.COL];

		for (int row = 0; row < this.grid.length; ++row)
		{
			for (int col = 0; col < this.grid[row].length; ++col)
			{
				grid[row][col] = '^';
				//grid[5][5] = '7';
			}
		}
	}
	public void printGrid()
	{
		for (int row = 0; row < this.grid.length; ++row)
		{
			for (int col = 0; col < this.grid[row].length; ++col)
			{
				System.out.print(grid[row][col] + "/t");
			}
			System.out.println();
		}
	}
	public void setMines()
	{
		Random rand = new Random();
		int param = this.ROW * this.COL;
		int numOfMines = (int) (param * MINE_CHANCE);
		int mineCount = 0;
		int row = 0;
		int col = 0;

		while (mineCount < numOfMines)
		{
			row = rand.nextInt(this.ROW);
			col = rand.nextInt(this.COL);

			if (!(grid[row][col] == '*'))
			{
				grid[row][col] = '*';
				mineCount++;
			}
			//System.out.println(mineCount);
		}
	}


	public void showMines()
	{
		this.findCornerMines();
		this.findEdge();
		this.findSideEdge();
		this.findMinesMain();

	}
	public void findMinesMain()
	{
		int mines = 0;
		int row = 0;
		int col = 0;
		for (row = 1; row < this.grid.length-1; ++row)
		{

			for (col = 1; col < this.grid[row].length-1; ++col)
			{		
				mines = 0;
				if (this.grid[row][col] == '^')
				{
					if (this.grid[row+1][col] == '*')
						++mines;
					//^Bottom Middle

					if (this.grid[row+1][col+1] == '*')
						++mines;
					//^Bottom Right

					if (this.grid[row+1][col-1] == '*')
						++mines;
					//^Bottom Left

					if (this.grid[row][col+1] == '*')
						++mines;
					//^Middle Right

					if (this.grid[row][col-1] == '*')
						++mines;
					//^Middle Left

					if (this.grid[row-1][col-1] == '*')
						++mines;
					//^Top Left

					if (this.grid[row-1][col] == '*')
						++mines;
					//^Top Middle

					if (this.grid[row-1][col+1] == '*')
						++mines;
					//^Top Right

				}
				this.mineAsgn(mines, row, col);
			}

		}


	}

	public void findCornerMines()
	{
		for (int row = 0; row < this.grid.length; ++row)
		{

			for ( int col = 0; col < this.grid[row].length; ++col)
			{		
				int mines = 0;
				//				System.out.println("ROW: " + row);
				//				System.out.println("COL: "+ col);
				if (row == 0 && col == 0 )
				{
					if (this.grid[row][col] == '^')
					{

						if (this.grid[row+1][col] == '*')
							++mines;
						if (this.grid[row][col+1] == '*')
							++mines;
						if (this.grid[row+1][col+1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}

				if (row == 0 && col == 24)
				{
					if (this.grid[row][col] == '^')
					{
						mines = 0;
						if (this.grid[row+1][col] == '*')
							++mines;
						if (this.grid[row][col-1] == '*')
							++mines;
						if (this.grid[row+1][col-1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}
				if (row == 24 && col == 0)
				{
					if (this.grid[row][col] == '^')
					{
						mines = 0;
						if (this.grid[row-1][col] == '*')
							++mines;
						if (this.grid[row-1][col+1] == '*')
							++mines;
						if (this.grid[row][col+1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}
				if (row == 24 && col == 24)
				{
					if (this.grid[row][col] == '^')
					{
						mines = 0;
						if (this.grid[row-1][col] == '*')
							++mines;
						if (this.grid[row-1][col-1] == '*')
							++mines;
						if (this.grid[row][col-1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}

			}
		}
	}

	public void findEdge()
	{
		for (int row = 0; row < this.grid.length; ++row)
		{
			for ( int col = 1; col < this.grid[row].length - 1; ++col)
			{		
				int mines = 0;
				if (row == 0)
				{
					if (this.grid[row][col] == '^')
					{

						if (this.grid[row+1][col] == '*')
							++mines;
						if (this.grid[row][col+1] == '*')
							++mines;
						if (this.grid[row+1][col+1] == '*')
							++mines;
						if (this.grid[row+1][col-1] == '*')
							++mines;
						if (this.grid[row][col-1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}
				if (row == 24)
				{
					if (this.grid[row][col] == '^')
					{
						if (this.grid[row-1][col] == '*')
							++mines;
						if (this.grid[row][col-1] == '*')
							++mines;
						if (this.grid[row-1][col-1] == '*')
							++mines;
						if (this.grid[row-1][col+1] == '*')
							++mines;
						if (this.grid[row][col+1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}
			}
		}
	}

	public void findSideEdge()
	{
		for (int row = 1; row < this.grid.length - 1; ++row)
		{
			for ( int col = 0; col < this.grid[row].length; ++col)
			{		
				//System.out.println(col);
				int mines = 0;
				if (col == 0)
				{
					if (this.grid[row][col] == '^')
					{

						if (this.grid[row - 1][col] == '*')
							++mines;
						if (this.grid[row][col+1] == '*')
							++mines;
						if (this.grid[row+1][col+1] == '*')
							++mines;
						if (this.grid[row - 1][col] == '*')
							++mines;
						if (this.grid[row - 1 ][col + 1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}
				if (col == 24)
				{
					if (this.grid[row][col] == '^')
					{
						if (this.grid[row + 1][col] == '*')
							++mines;
						if (this.grid[row][col-1] == '*')
							++mines;
						if (this.grid[row-1][col-1] == '*')
							++mines;
						if (this.grid[row + 1][col] == '*')
							++mines;
						if (this.grid[row + 1 ][col - 1] == '*')
							++mines;
						this.mineAsgn(mines, row, col);
					}
				}
			}
		}
	}
	

	public void mineAsgn(int mines, int row, int col)
	{
		if(mines == 0 && this.grid[row][col] != '*')
			this.grid[row][col] = ' ';
		if(mines == 1)
			this.grid[row][col] = '1';
		if(mines == 2)
			this.grid[row][col] = '2';
		if(mines == 3)
			this.grid[row][col] = '3';
		if(mines == 4)
			this.grid[row][col] = '4';
		if(mines == 5)
			this.grid[row][col] = '5'; 
		if(mines == 6)
			this.grid[row][col] = '6';
		if(mines == 7)
			this.grid[row][col] = '7';
		if(mines == 8)
			this.grid[row][col] = '8';
	}

	public String toString()
	{
		String print = "";
		for (int row = 0; row < this.grid.length; ++row)
		{
			for (int col = 0; col < this.grid[row].length; ++col)
			{
				print = print + this.grid[row][col] + "\t";
			}
			print = print + "\n";
		}

		return print;
	}
}