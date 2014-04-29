import java.util.Scanner;
import java.io.IOException;

/**
 * View class handles the user interface for minesweeper
 *
 * @author Chase
 * @version 1.0
 */
public class View
{	
	Scanner scan;
	
	/**
	 * The display method displays the given string to the user 
	 * @param result a string to be displayed
	 */
	public void display(String result)
	{
		System.out.println(result);
	}

	/**
	 * The getRows method gets the number of rows in this game 
	 * @return an int representing the number of rows
	 */
	public int getRows()
	{
		int result = 0;
		scan = new Scanner(System.in);
		do
		{
			//try-catch handles possible input exceptions
			try
			{
				System.out.println("Enter the number of rows (4-100)");
				result = scan.nextInt();
				if ((result < 4) || (result > 100))
					System.out.println("Number of rows must be between 4 and 100");
			}
			catch (Exception e) {
				scan.nextLine();
				System.out.println("Number of rows must be an integer between 4 and 100");
			}
		}
		while ((result < 4) || (result > 100));
		return result;
	}
	
	/**
	 * The getColss method gets the number of columns in this game 
	 * @return an int representing the number of columns
	 */
	public int getCols()
	{
		int result = 0;
		scan = new Scanner(System.in);
		do
		{
			//try-catch handles possible input exceptions
			try 
			{
				System.out.println("Enter the number of columns (4-100)");
				result = scan.nextInt();
				if ((result < 4) || (result > 100))
					System.out.println("Number of columns must be between 4 and 100");
			}
			catch (Exception e) {
				scan.nextLine();
				System.out.println("Number of columns must be an integer between 4 and 100");
			}
		}
		while ((result < 4) || (result > 100));
		return result;
	}
	
	/**
	 * The getRow method gets the row 
	 * @param maxRow the max value for a row
	 * @return an int representing the row
	 */
	public int getRow(int maxRow)
	{
		int result = -1;
		scan = new Scanner(System.in);
		do
		{
			//try-catch handles possible input exceptions
			try
			{
				System.out.println("Enter the row");
				result = scan.nextInt();
				if ((result < 0) || (result >= maxRow))
					System.out.println("Row must be between 0 and " + maxRow);
			}
			catch (Exception e) {
				scan.nextLine();
				System.out.println("Row must be an integer between 0 and " + maxRow);
			}
		}
		while ((result < 0) || (result >= maxRow));
		return result;
	}
	
	/**
	 * The getCol method gets the column 
	 * @param maxCol the max value for a column
	 * @return an int representing the column
	 */
	public int getCol(int maxCol)
	{
		int result = -1;
		scan = new Scanner(System.in);
		do
		{
			//try-catch handles possible input exceptions
			try
			{
				System.out.println("Enter the column");
				result = scan.nextInt();
				if ((result < 0) || (result >= maxCol))
					System.out.println("Column must be between 0 and " + maxCol);
			}
			catch (Exception e) {
				scan.nextLine();
				System.out.println("Column must be an integer between 0 and " + maxCol);
			}
		}
		while ((result < 0) || (result >= maxCol));
		return result;
	}
	
}