
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.awt.Graphics;


public class Space extends JFrame
{
	private static final int FRAME_HEIGHT = 700;
	private static final int FRAME_WIDTH = 700;
	
	private JFrame frame = new JFrame();
	private JPanel playArea = new JPanel();
	
	private Ship spaceShip = new Ship();

	Polygon poly = new Polygon();
	
	
	
	private Graphics g;
	
	public Space()
	{
		playArea.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		playArea.setLocation(0, 0);
		playArea.setLayout(null);
		
		frame.add(playArea);
		frame.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void drawShip(Graphics g)
	{
		g.drawPolygon(spaceShip.getxPoly(), spaceShip.getyPoly(), spaceShip.getxPoly().length);
	}
	
}
