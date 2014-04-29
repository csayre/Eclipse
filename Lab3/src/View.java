import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame
{
	public static final int FRAMEHEIGHT = 500;
	public static final int FRAMEWIDTH = 500;

	private JButton colorButton;
	private int colorCode;
	private JButton textButton;
	private int textCode;
	private JPanel playArea;
	
	/**
	 * Constructor for the View class loads and displays the frame
	 */
	public View(){
		this.setLayout( null);
		playArea = new JPanel();
		
		playArea.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		playArea.setLocation(0, 0);
		playArea.setLayout(null);
		
		colorButton = new JButton();
		colorButton.setOpaque(true);
		colorButton.setLocation(225, 100);
		colorButton.setBackground(Color.white);
		colorCode = 0;
		colorButton.setSize(50, 50);
		colorButton.addActionListener( new colorButtonHandler() );
		playArea.add(colorButton);
		
		textButton = new JButton();
		textButton.setLocation(225, 300);
		textButton.setSize(50, 50);
		textButton.setText("R");
		textButton.addActionListener( new textButtonHandler() );
		playArea.add(textButton);
		
		this.add(playArea);
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setResizable(false);
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * private inner class colorButtonHandler provides the action listener for the color button
	 */
	
	private class colorButtonHandler implements ActionListener{
		
		/**
		 * This method handles the tasks of changing the color of the button
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){ 
			
			//change the color of the color button to the next color
			colorCode = (colorCode + 1) % 4;
			if (colorCode == 0)
				colorButton.setBackground(Color.white);
			else if (colorCode == 1)
				colorButton.setBackground(Color.blue);
			else if (colorCode == 2)
				colorButton.setBackground(Color.green);
			else if (colorCode == 3)
				colorButton.setBackground(Color.black);
			
			//redraw the playArea panel to show the new color
			playArea.paintImmediately(playArea.getVisibleRect());
		}
	}

	/**
	 * private inner class textButtonHandler provides the action listener for the text button
	 */
	
	private class textButtonHandler implements ActionListener{
		
		/**
		 * This method handles the tasks of changing the text of the button
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){ 
			
			//change the text of the text button to the next character
			if (textButton.getText().equals("R"))
				textButton.setText("U");
			else {
				textButton.setText("R");
			}

			
			//redraw the playArea panel to show the new color
			playArea.paintImmediately(playArea.getVisibleRect());
		}
	}
	
	
}
