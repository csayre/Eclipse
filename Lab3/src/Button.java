import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Button extends JFrame
{
	public static final int FRAMEHEIGHT = 250;
	public static final int FRAMEWIDTH = 250;
	
	private JButton colorButton;
	private int colorCode;
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
		
		colorButton = new JButton();
		colorButton.setOpaque(true);
		colorButton.setLocation(25,25);
		colorButton.setBackground(Color.white);
		colorCode = 0;
		colorButton.setSize(50,50);
		colorButton.addActionListener( new colorButtonHandler() );
		playArea.add(colorButton);
		
		this.add(playArea);
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setResizable(false);
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class colorButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}