import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class BallView {

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


	//a single spaceship for use in the game 
	private Ball ball;

	/**
	 * Constructor for the SpaceShip class loads and displays the frame
	 */
	public BallView(){
		ImageIcon ballImg = new ImageIcon("ball.png");
		ball = new Ball(ballImg);
		ball.addMouseListener(new buttonListener());
		playArea.add(ball);
		frame.setLayout( null);
		actionPanel.setSize(FRAMEWIDTH, 40);
		actionPanel.setLocation(0, 0);
		playArea.setSize(FRAMEWIDTH, FRAMEHEIGHT - actionPanel.getHeight());
		playArea.setLocation(0, actionPanel.getHeight());
		playArea.setLayout(null);
		frame.add(actionPanel);
		frame.add(playArea);
		frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		frame.setResizable(false);
		frame.setVisible(true); 
		this.bounce();
		this.bounce();
		this.bounce();
	}
	
	private class buttonListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

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
			ball.moveBall();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public void bounce()
	{
		int dx = 2;
		int dy = 3;
		try
		{
			for (int i = 1; i <= STEPS; i++)
			{		
				ball.bounceBall(dx, dy);
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
	 * This is a private helper method to determine if the Ball needs to reverse course in the
	 * X dimension
	 * 
	 * @return
	 */

	private boolean bounceX(){
		if (ball.getX() <= 0) {
			return true;
		}
		else if ((ball.getX() + ball.getWidth()) >= playArea.getWidth()) {
			return true;
		}
		return false;
	}

	/**
	 * This is a private helper method to determine if the Ball needs to reverse course in the
	 * Y dimension
	 *
	 * @return boolean representing whether or not the Ball needs to bounce
	 */
	private boolean bounceY(){
		if (ball.getY() <= 0) {
			return true;
		}
		else if ((ball.getY() + ball.getHeight() + 20) >= playArea.getHeight()) {
			return true;
		}
		return false;
	}

}
