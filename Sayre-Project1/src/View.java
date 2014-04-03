import java.util.Scanner;


public class View {

	private int row;
	private int col;
	private int choice;

	public View()
	{
		this.row = 0;
		this.col = 0;
		this.choice = 0;
	}

	public void displayMenu()
	{
		System.out.println("Minesweeper");
		System.out.println("The game is over when all of the squares have been uncovered.");
		System.out.println("If you hit a mine the game is over!");
		System.out.println("Select from the following options.");
		System.out.println("1. Set grid size");
		System.out.println("2. Quit");
		this.getInput();
	}

	public void getInput()
	{

		Scanner keyboard = new Scanner(System.in);
		this.choice = keyboard.nextInt();
		if (this.choice == 1)
		{
			System.out.println("Enter the number of columns.");
			int colI = keyboard.nextInt();
			System.out.println("Enter the number of rows");
			int rowI = keyboard.nextInt();
			if(rowI > 100 || rowI < 4 || colI > 100 || colI < 4)
			{
				System.out.println("Please enter a row or Col less that 100 or greater than 4");
				this.displayMenu();
			}
			else
			{
				this.setCol(colI);
				this.setRow(rowI);
				DisplayBoard board = new DisplayBoard(this.row , this.col);
				board.createBoard(this.row, this.col);
				board.printMines();
				boolean game = false;
				do{
					int a = this.getRow(rowI);
					int b = this.getCol(colI);
					game = board.checkChoice(a,b,rowI, colI);
				}while(game == false);

			}
		}
		else if (this.choice == 2)
		{
			System.out.println("Good Bye");
		}
		else
		{
			System.out.println("You have entered an incorrect choice. Try again!");
			this.displayMenu();
		}
		keyboard.close();
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}



	public int getRow(int x)
	{
		int row = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the row that you would like to select.");
		row = keyboard.nextInt();
		if(row > x)
		{
			System.out.println("This is an incorrect choice.");
			System.out.println("Enter the row that you would like to select.");
			row = keyboard.nextInt();
		}
		//keyboard.close();
		return row;
	}

	public int getCol(int y)
	{
		int col = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the col that you would like to select.");
		col = keyboard.nextInt();
		if(col > y)
		{
			System.out.println("This is an incorrect choice.");
			System.out.println("Enter the col that you would like to select.");
			col = keyboard.nextInt();
		}
		//keyboard.close();
		return col;
	}

}
