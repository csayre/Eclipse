
import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MyView extends JFrame
{
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;

	private JButton colorButton;
	private int colorCode;
	private JPanel grid;
	private JButton view[][];
	
	public MyView()
	{
		this.setLayout(null);
		grid = new JPanel();
		this.view = new JButton[5][5];
		
		grid.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		grid.setLocation(0,0);
		grid.setLayout(new GridLayout(3, 3));
		

//		colorButton = new JButton();
//		colorButton.setOpaque(true);
//		colorButton.setLocation(225, 100);
//		colorButton.setBackground(Color.white);
//		//colorButton.setLocation(100, 100);
//		colorCode = 0;
//		colorButton.setSize(50, 50);
//		colorButton.addActionListener( new colorButtonHandler() );
//		grid.add(colorButton);
		
		this.populateGrid();
		
		//this.add(grid);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void populateGrid()
	{
		for(int col = 0; col < 3; col ++)
		{
			for (int row = 0; row < 3; row++)
			{
				ArtButton colorButton1 = new ArtButton();
				colorButton1.setOpaque(true);
				colorButton1.setBackground(Color.white);
				colorCode = 0;
				colorButton1.addActionListener(new colorButtonHandler());
				this.view[row][col] = colorButton1;
				grid.add(this.view[row][col]);
				this.add(grid);
			}
		}
	}
	
	private class colorButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			Random rand = new Random();
			int color = rand.nextInt(7);
			ArtButton refClick = (ArtButton) arg0.getSource();
			color = refClick.getColorCode();
			//color = (color + 1) % 4;
			if (color == 0 && refClick.getColorCodePrv() != 0)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.yellow);
			}
			else if (color == 1 && refClick.getColorCodePrv() != 1)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.green);
			}
			else if (color == 2 && refClick.getColorCodePrv() != 2)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.red);
			}
			else if (color == 3 && refClick.getColorCodePrv() != 3)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.blue);
			}
			else if (color == 4 && refClick.getColorCodePrv() != 4)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.black);
			}
			else if (color == 5 && refClick.getColorCodePrv() != 5)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.orange);
			}
			else if (color == 6 && refClick.getColorCodePrv() != 6)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.cyan);
			}
			else if (color == 7 && refClick.getColorCodePrv() != 7)
			{
				refClick.setColorCodePrv(color);
				refClick.setBackground(Color.pink);
			}
			

			grid.paintImmediately(grid.getVisibleRect());
		}
	}
}

