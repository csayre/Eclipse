

public class DisplayBoard {

	private final double EASY_CHANCE_OF_MINE = .156;
	private MinesweeperCell[][] playArea;
	private int row;
	private int col;
	private int numberOfCells;
	private int numberOfMines;

	public DisplayBoard(int _row, int _col)
	{
		this.row = _row;
		this.col = _col;
		this.numberOfCells = this.col * this.row;
		this.numberOfMines = (int) (numberOfCells * EASY_CHANCE_OF_MINE);
		this.playArea = new MinesweeperCell[this.row][this.col];
		for (int row = 0; row < this.playArea.length; ++row)
		{
			for (int col = 0; col < this.playArea[row].length; ++col)
			{
				this.playArea[row][col] = new MinesweeperCell();

			}
		}
	}
	public void mineAsgn(int mines, int row, int col)
	{
		if(mines == 0)
			this.playArea[row][col].setValue(' ');
		else if(mines == 1)
			this.playArea[row][col].setValue('1');
		else if(mines == 2)
			this.playArea[row][col].setValue('2');
		else if(mines == 3)
			this.playArea[row][col].setValue('3');
		else if(mines == 4)
			this.playArea[row][col].setValue('4');
		else if(mines == 5)
			this.playArea[row][col].setValue('5'); 
		else if(mines == 6)
			this.playArea[row][col].setValue('6');
		else if(mines == 7)
			this.playArea[row][col].setValue('7');
		else if(mines == 8)
			this.playArea[row][col].setValue('8');
	}

	public void createBoard(int x, int y)
	{
		System.out.println(x + " "+ y);
		for (int row = 0; row < this.playArea.length; ++row)
		{
			for (int col = 0; col < this.playArea[row].length; ++col)
			{
				this.playArea[row][col] = new MinesweeperCell();

			}

		}
		this.populateMines();
	}

	public void populateMines()
	{
		this.numberOfCells = this.col * this.row;
		this.numberOfMines = (int) (numberOfCells * EASY_CHANCE_OF_MINE);
		int numMines = 0;
		while(numMines < numberOfMines)
		{
			for (int row = 0; row < this.playArea.length; ++row)
			{
				for (int col = 0; col < this.playArea[row].length; ++col)
				{
					this.playArea[row][col].generateMines();
					if(this.playArea[row][col].getIsMine() == true)
					{
						numMines++;
					}
				}
			}
		}
	}

	public MinesweeperCell[][] getPlayArea() {
		return playArea;
	}


	public void setPlayArea(MinesweeperCell[][] playArea) {
		this.playArea = playArea;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public int getNumberOfCells() {
		return numberOfCells;
	}


	public void setNumberOfCells(int numberOfCells) {
		this.numberOfCells = numberOfCells;
	}


	public int getNumberOfMines() {
		return numberOfMines;
	}


	public void setNumberOfMines(int numberOfMines) {
		this.numberOfMines = numberOfMines;
	}


	public void printMines()
	{
		for (int row = 0; row < this.playArea.length; ++row)
		{
			for (int col = 0; col < this.playArea[row].length; ++col)
			{
				System.out.print(playArea[row][col].getValue() + "\t");
				//				System.out.print(playArea[row][col].getIsMine() + "\t");
			}
			System.out.println();
		}
	}

	public String toString()
	{
		String print = "";
		for (int row = 0; row < this.playArea.length; ++row)
		{
			for (int col = 0; col < this.playArea[row].length; ++col)
			{
				print = print + this.playArea[row][col] + "\t";
			}
			print = print + "\n";
		}

		return print;
	}



	public boolean checkChoice(int row, int col, int maxRow, int maxCol) 
	{
		boolean mineFound = false;
		int mines = 0;
		if(this.playArea[row][col].getIsMine()==true)
		{
			System.out.println("GAME OVER");
			mineFound = true;
		}
		else if(row == 0 && col == 0)
		{
			if (this.playArea[row+1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col+1].getIsMine() == true)
				++mines;
			System.out.println(mines);
			this.mineAsgn(mines, row, col);
		}
		else if(row == 0 && col == maxRow - 1)
		{
			if (this.playArea[row+1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col-1].getIsMine() == true)
				++mines;
			this.mineAsgn(mines, row, col);
		}
		else if (row == maxCol - 1 && col == 0)
		{
				if (this.playArea[row-1][col].getIsMine() == true)
					++mines;
				if (this.playArea[row-1][col+1].getIsMine() == true)
					++mines;
				if (this.playArea[row][col+1].getIsMine() == true)
					++mines;
				this.mineAsgn(mines, row, col);
		}
		else if (row == maxRow -1 && col == 0)
		{
			if (this.playArea[row-1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row-1][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row][col-1].getIsMine() == true)
				++mines;
			this.mineAsgn(mines, row, col);
		}
		else if(row == 0)
		{
			if (this.playArea[row+1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row][col-1].getIsMine() == true)
				++mines;
			this.mineAsgn(mines, row, col);
		}
		else if(row == maxRow - 1)
		{
			if (this.playArea[row - 1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row - 1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row - 1 ][col + 1].getIsMine() == true)
				++mines;
			this.mineAsgn(mines, row, col);
		}
		else if(col == 0)
		{
			if (this.playArea[row - 1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row - 1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row - 1 ][col + 1].getIsMine() == true)
				++mines;
			this.mineAsgn(mines, row, col);
		}
		else if (row == maxRow - 1)
		{
			if (this.playArea[row + 1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row-1][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row + 1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row + 1 ][col - 1].getIsMine() == true)
				++mines;
			this.mineAsgn(mines, row, col);
		}
		else if (row != 0 || row > maxRow - 1 && col != 0 || row > maxCol - 1 )
		{
			if (this.playArea[row+1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row+1][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row][col+1].getIsMine() == true)
				++mines;
			if (this.playArea[row][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row-1][col-1].getIsMine() == true)
				++mines;
			if (this.playArea[row-1][col].getIsMine() == true)
				++mines;
			if (this.playArea[row-1][col+1].getIsMine() == true)
				++mines;
			//System.out.println(mines);
			this.mineAsgn(mines, row, col);
			
		}
		this.printMines();
		return mineFound;
	}
}
