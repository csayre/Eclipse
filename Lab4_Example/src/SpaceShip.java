import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/*
 * Graphical User Interface for the SpaceShip example
 * creates and loads the frame using the Ship class
 *
 * @author Chase
 * @version 1.0
 */


public class SpaceShip {
	
	//constants to represent the frame width and height
	//notice that they are public
	public static final int FRAMEHEIGHT = 500;
	public static final int FRAMEWIDTH = 500;
	private static final int STEPS = 500;
	private static final int DELAY = 20;
	
	//graphical objects declared at class level
	private JFrame frame = new JFrame();
	private JPanel actionPanel = new JPanel();
	private JPanel playArea = new JPanel();
	private JButton btnNew = new JButton("Add Space Ship");
	private JButton movebtn = new JButton("Move it");
	private JButton bounce = new JButton("Bounce");

	
	//a single spaceship for use in the game 
	private Ship ship;
	
	/**
	 * Constructor for the SpaceShip class loads and displays the frame
	 */
	public SpaceShip(){
		frame.setLayout( null);
		btnNew.setLocation(150, 10);
		btnNew.setSize(50, 20);
		btnNew.addActionListener( new ButtonClickHandler() );
		movebtn.setLocation(220, 10);
		movebtn.setSize(50, 20);
		movebtn.addActionListener( new MoveButtonClickHandler() );
		bounce.setLocation(280, 10);
		bounce.setSize(50, 20);
		bounce.addActionListener(new BounceButtonHandler());
		actionPanel.setSize(FRAMEWIDTH, 40);
		actionPanel.setLocation(0, 0);
		playArea.setSize(FRAMEWIDTH, FRAMEHEIGHT - actionPanel.getHeight());
		playArea.setLocation(0, actionPanel.getHeight());
		playArea.setLayout(null);
		actionPanel.add(btnNew);
		actionPanel.add(movebtn);
		actionPanel.add(bounce);
		frame.add(actionPanel);
		frame.add(playArea);
		frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
	/**
	 * private inner class ButtonClickHandler provides the action listener for the Add Space Ship button
	 */
	
	private class ButtonClickHandler implements ActionListener{

		/**
		 * This method handles the tasks of creating a new space ship, adding it to the frame, 
		 * disabling the add button, and repainting the frame
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){ 
			
			//create initial ship object add to the playArea panel
			//note the use of the ImageIcon class loading an image from a file
			ImageIcon shipImage = new ImageIcon("spaceship.png");
			ship = new Ship(shipImage);
			playArea.add(ship);
			
			//disable the add button
			btnNew.setEnabled(false);
			
			//redraw the playArea panel to show the newly added ship
			//notice there is no need to specify dimensions here
			playArea.paintImmediately(playArea.getVisibleRect());
		}
	}
	
	/**
	 * private inner class MoveButtonClickHandler provides the action listener for the Move It button
	 */
	private class MoveButtonClickHandler implements ActionListener{

		/**
		 * This method calls the moveShip method of the ship object and then repaints the panel 
		 *
		 * @param e the action event handled by this method
		 */
		public void actionPerformed(ActionEvent e){
			
			//call the move method of the Ball class
			ship.moveShip();
			//redraw
			playArea.repaint();
		}
	}
	
	/**
	 * private inner class BounceButtonHandler provides the action listener for the Bounce button
	 */
	private class BounceButtonHandler implements ActionListener{
		
		/**
		 * This method calls the bounceShip method of the ship object and then repaints the panel 
		 *
		 * @param e the action event handled by this method
		 */
		public void actionPerformed(ActionEvent e){
			//you can adjust the speed of movement by changing these values
			int dx = 2;
			int dy = 3;
			try
			{
				for (int i = 1; i <= STEPS; i++)
				{
					ship.bounceShip(dx, dy);
					playArea.paintImmediately(playArea.getVisibleRect());
					
					//sleep the thread to slow down the movement
					Thread.sleep(DELAY);
					if (bounceX()) {
						dx = dx * -1;
					}
					if (bounceY()) {
						dy = dy * -1;
					}
				}
			}
			catch (InterruptedException f )
			{
			}		
		}
		
		/**
		 * This is a private helper method to determine if the ship needs to reverse course in the
		 * X dimension
		 *
		 * @return boolean representing whether or not the ship needs to bounce
		 */
		private boolean bounceX(){
			if (ship.getX() <= 0) {
				return true;
			}
			else if ((ship.getX() + ship.getWidth()) >= playArea.getWidth()) {
				return true;
			}
			return false;
		}
		
		/**
		 * This is a private helper method to determine if the ship needs to reverse course in the
		 * Y dimension
		 *
		 * @return boolean representing whether or not the ship needs to bounce
		 */
		private boolean bounceY(){
			if (ship.getY() <= 0) {
				return true;
			}
			else if ((ship.getY() + ship.getHeight() + 20) >= playArea.getHeight()) {
				return true;
			}
			return false;
		}
		
	}
}