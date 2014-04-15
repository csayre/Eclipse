import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author ChrisSayre
 *
 */
public class View {
	
	//constants to represent the frame width and height
		//notice that they are public
		public static final int FRAMEHEIGHT = 800;
		public static final int FRAMEWIDTH = 600;

		//graphical objects declared at class level
		private JFrame frame = new JFrame();	
		private JPanel actionPanel = new JPanel();
		private JPanel playArea = new JPanel();
		private JButton test;
		
		public View()
		{
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
			test = new JButton();
			
			actionPanel.add(test);
			
			
		}

}