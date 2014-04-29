import java.util.Random;

/**
 * @author csayre
 * @version Mar 11, 2014
 * @file View.java
 */

public class View {

	public int randomNumberGenerator(int upperBound, int lowerBound)
	{
		int numberRtn = 0;
		Random number = new Random();
		numberRtn = number.nextInt();
		return numberRtn;
	}
	
	

}
