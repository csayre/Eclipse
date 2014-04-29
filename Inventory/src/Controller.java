import java.util.Scanner;

/**
 * @author csayre
 * @version Mar 11, 2014
 * @file Controller.java
 */


public class Controller {

	public void start() {
		// TODO Auto-generated method stub
		int upperBound = 0;
		int lowerBound = 0;
		View start = new View();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the lowest Asset tag.");
		lowerBound = keyboard.nextInt();
		System.out.println("Please enter the highest Asset tag.");
		upperBound = keyboard.nextInt();
		start.randomNumberGenerator(upperBound, lowerBound);
		
	}

}
