import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*****
 *
 *  This is an ugly little example that shows how you might create and use a grid of buttons
 *
 */
public class View extends JFrame
{
	public static final int FRAMEHEIGHT = 500;
	public static final int FRAMEWIDTH = 500;

	private JoesButton[][] buttons;
	private int colorCode;
	private JButton resetButton;
	private JButton redButton;
	private JPanel playArea;
	private JPanel buttonPanel;
	
	/**
	 * Constructor for the View class loads and displays the frame
	 */
	public View(){
		playArea = new JPanel();
		buttonPanel = new JPanel();
		buttons = new JoesButton[5][5];
		
		//playArea.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		playArea.setLocation(0, 0);
		playArea.setLayout(new GridLayout(5,5));
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
			{
				buttons[i][j] = new JoesButton();
				buttons[i][j].setOpaque(true);
				buttons[i][j].setBackground(Color.white);
				buttons[i][j].addActionListener( new colorButtonHandler() );
				playArea.add(buttons[i][j]);
			}
		
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener( new resetButtonHandler() );
		buttonPanel.add(resetButton);
		
		redButton = new JButton("Red");
		redButton.addActionListener( new redButtonHandler() );
		buttonPanel.add(redButton);
		
		this.setLayout(new BorderLayout());
		this.add(playArea, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		//this.setResizable(false);
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * private inner class colorButtonHandler provides the action listener for the color buttons
	 */
	
	private class colorButtonHandler implements ActionListener{
		
		/**
		 * This method handles the tasks of changing the color of the button
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){ 
			
			//retrieve the button that was clicked
			JoesButton pressedButton = (JoesButton)(e.getSource());
			
			pressedButton.changeColor();
			
			//redraw the playArea panel to show the new color
			playArea.paintImmediately(playArea.getVisibleRect());
		}
	}

	/**
	 * private inner class resetButtonHandler provides the action listener for the reset button
	 */
	
	private class resetButtonHandler implements ActionListener{
		
		/**
		 * This method handles the tasks of changing the color all of the button
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){ 
			
			//change the color of the buttons to white
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 5; j++)
				{
					buttons[i][j].setBackground(Color.white);
				}
			

			
			//redraw the playArea panel to show the new colors
			playArea.paintImmediately(playArea.getVisibleRect());
		}
	}
	
	/**
	 * private inner class redButtonHandler provides the action listener for the red button
	 */
	
	private class redButtonHandler implements ActionListener{
		
		/**
		 * This method handles the tasks of changing the color of all of the buttons
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){ 
			
			//change the color of the buttons to red
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 5; j++)
				{
					buttons[i][j].setBackground(Color.red);
				}
			
			
			
			//redraw the playArea panel to show the new colors
			playArea.paintImmediately(playArea.getVisibleRect());
		}
	}
	
	
}
