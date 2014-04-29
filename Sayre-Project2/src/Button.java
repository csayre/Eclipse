import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * @author ChrisSayre
 * @version Feb 24, 2014
 * @file Button.java
 */


@SuppressWarnings("serial")
public class Button extends JFrame {

	public static final int FRAMEHEIGHT = 250;
	public static final int FRAMEWIDTH = 250;

	private JButton cell;
	private int count;
	private JButton textButton;
	private int textCode;
	private JPanel playArea;

	private Button()
	{
		this.setLayout(null);
		playArea = new JPanel();

		playArea.setSize(FRAMEWIDTH,FRAMEHEIGHT);
		playArea.setLocation(0,0);
		playArea.setLayout(null);

		cell = new JButton();
		cell.setOpaque(true);
		cell.setLocation(25,25);
		cell.setBackground(Color.white);
		count = 0;
		cell.setSize(50,50);
		cell.addActionListener( new textButtonHandler() );
		playArea.add(cell);

		this.add(playArea);
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setResizable(false);
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class textButtonHandler implements MouseListener, ActionListener{

		public void mouseClicked(MouseEvent e) {

			if(e.isControlDown() && e.getButton() == MouseEvent.BUTTON1)
			{
				if (textButton.getText().equals(" "))
					textButton.setText("?");
				else {
					textButton.setText(" ");
				}
			}
			if(e.getButton() == MouseEvent.BUTTON1)
			{
				if (textButton.getText().equals(" "))
					textButton.setText("F");
				else {
					textButton.setText(" ");
				}
			}
			else if(e.getButton() == MouseEvent.BUTTON2)
			{
				if (textButton.getText().equals(" "))
					textButton.setText("NUMBERS");
				else {
					textButton.setText(" ");
				}
			}
			playArea.paintImmediately(playArea.getVisibleRect());
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

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
	
	


