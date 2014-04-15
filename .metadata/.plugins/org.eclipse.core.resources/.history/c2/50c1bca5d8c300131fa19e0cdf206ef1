import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author ChrisSayre
 * @version Mar 20, 2014
 * @file ObjectView.java
 */


public class ObjectView {

	//constants to represent the frame width and height
	//notice that they are public
	public static final int FRAMEHEIGHT = 800;
	public static final int FRAMEWIDTH = 600;
	private static final int STEPS = 500;
	private static final int DELAY = 20;
	private int numItemsOnScreen = 3;

	//graphical objects declared at class level
	private JFrame frame = new JFrame();	
	private JPanel actionPanel = new JPanel();
	private JPanel playArea = new JPanel();

	//create display object
	ArrayList<PictureObject> picList;

	/**
	 * ObjectView Constructor. Sets up display board. 
	 * @throws InterruptedException
	 */

	public ObjectView() throws InterruptedException
	{
		//this.addStart();
		this.picList = new ArrayList<PictureObject>();
		this.delay();
		frame.setLayout(null);
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
		this.loop();
	}

	/**
	 * Button listener. Checks for mouse entered and mouse Clicked events. 
	 *
	 */


	private class buttonListener implements MouseListener
	{


		public void mouseClicked(MouseEvent e) {
			PictureObject temp = (PictureObject) e.getSource();
			if(temp.getCollisionCount() <= 0)
			{
				temp.setAlive(false);
				playArea.remove(temp);
				numItemsOnScreen--;
			}
			else
			{
				int collision = temp.getCollisionCount();
				temp.setCollisionCount(collision - 1);
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {


		}

		@Override
		public void mouseReleased(MouseEvent e) {


		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * creates images adds to board. Private helper class. 
	 */

	private void addStart()
	{
		ImageIcon ballImg = new ImageIcon("ball.png");
		picList.add(new PictureObject(ballImg));
		picList.get(0).addMouseListener(new buttonListener());
		picList.get(0).setX(200);
		picList.get(0).setY(100);
		picList.get(0).setAlive(true);
		playArea.add(picList.get(0));

		ImageIcon ballImg1 = new ImageIcon("apple.jpeg");
		picList.add(new PictureObject(ballImg1));
		picList.get(1).addMouseListener(new buttonListener());
		picList.get(1).setX(300);
		picList.get(1).setY(10);
		picList.get(1).setAlive(true);
		playArea.add(picList.get(1));

		ImageIcon ballImg2 = new ImageIcon("black.jpeg");
		picList.add(new PictureObject(ballImg2));
		picList.get(2).addMouseListener(new buttonListener());
		picList.get(2).setX(400);
		picList.get(2).setY(300);
		picList.get(2).setAlive(true);
		playArea.add(picList.get(2));
	}

	/** 
	 * private helper method that contains loop to run the bouncing.
	 */

	private void loop()
	{
		this.addStart();
		while(true)
		{
			this.bounce();
			if(numItemsOnScreen == 0)
			{
				JOptionPane.showMessageDialog(playArea, "You Win");
				System.exit(0);
			}
		}
	}

	/**
	 * delay method. Puts thread to sleep for a specified time. 
	 * @throws InterruptedException
	 */

	private void delay() throws InterruptedException
	{
		Thread.sleep(20);
	}

	/**
	 * Bounce method. Moves the picture around the board. 
	 * @param picObj
	 */

	public void bounce()
	{
		//System.out.println(picObj);
		try
		{
			for(PictureObject a : picList)
			{
				this.collisionCheck();
				if(a.isAlive() == true)
					a.bounceBall();
				//sleep the thread to slow down the movement
				Thread.sleep(DELAY);
				if (bounceX(a)) {
					a.setDx(a.getDx() * -1);
				}
				if (bounceY(a)) {
					a.setDy(a.getDy() * -1);
				}
			}
			playArea.paintImmediately(playArea.getVisibleRect());
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

	private boolean bounceX(PictureObject picObj){
		if (picObj.getX() <= 0) {
			return true;
		}
		else if ((picObj.getX() + picObj.getWidth()) >= playArea.getWidth()) {
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
	private boolean bounceY(PictureObject picObj){
		if (picObj.getY() <= 0) {
			return true;
		}
		else if ((picObj.getY() + picObj.getHeight() + 20) >= playArea.getHeight()) {
			return true;
		}
		return false;
	}

	/** 
	 * helper method to check for collision. IF there is a collision calls reverse. 
	 */

	private void collisionCheck()
	{

		for(int outer = 0; outer< picList.size(); outer++)
		{
			for(int i = outer + 1; i < picList.size(); i++)
			{
				if(picList.get(outer).getBounds().intersects(picList.get(i).getBounds()) && picList.get(outer).isAlive() == true && picList.get(i).isAlive() == true)
				{
					int tempCol = 0;
					tempCol = picList.get(outer).getCollisionCount() - 1;
					picList.get(outer).setCollisionCount(tempCol);
					if(tempCol <= 0)
					{
						playArea.remove(picList.get(outer));
						picList.get(outer).setAlive(false);
						this.numItemsOnScreen--;
					}
					tempCol = 0;
					tempCol = picList.get(i).getCollisionCount() - 1;
					if(tempCol <= 0)
					{
						playArea.remove(picList.get(i));
						picList.get(i).setAlive(false);
						this.numItemsOnScreen--;
					}
					picList.get(i).setCollisionCount(tempCol);
					picList.get(outer).reverse();
					picList.get(i).reverse();
				}
			}
		}
	}


}
