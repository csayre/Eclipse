
/**
 * This class contains all the code to make up the GUI for the postfix expression calculator 
 * @author Jonny Pine
 * @version 1.0
 */

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.*; 

public class projTwoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldInput;
	private JTextField textFieldOutput;
	
	private Postfix evaluate;
	/**
	 * Create the frame.
	 */
	public projTwoFrame() {
		evaluate = new Postfix();
		 /**setting up the layout of the content pane**/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{88, 86, 41, 39, 30, 86, 0};
		gbl_contentPane.rowHeights = new int[]{22, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		/**this sets up the label "postfix expression"**/
		JLabel lblPostfixExpression = new JLabel("Postfix Expression");
		lblPostfixExpression.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPostfixExpression = new GridBagConstraints();
		gbc_lblPostfixExpression.anchor = GridBagConstraints.WEST;
		gbc_lblPostfixExpression.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostfixExpression.gridx = 0;
		gbc_lblPostfixExpression.gridy = 0;
		contentPane.add(lblPostfixExpression, gbc_lblPostfixExpression);
		
		/**this input field**/
		textFieldInput = new JTextField();
		GridBagConstraints gbc_textFieldInput = new GridBagConstraints();
		gbc_textFieldInput.anchor = GridBagConstraints.WEST;
		gbc_textFieldInput.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldInput.gridx = 1;
		gbc_textFieldInput.gridy = 0;
		
		textFieldInput.addKeyListener(new KeyListener(){
			/**this method associated with this key listener clears the text in the output box**/
			public void keyPressed(KeyEvent arg0) {
				textFieldOutput.setText("");
			}
			public void keyReleased(KeyEvent arg0) {
				// required method
			}
			public void keyTyped(KeyEvent arg0) {
				// required method				
			}
			
		});
		contentPane.add(textFieldInput, gbc_textFieldInput);
		textFieldInput.setColumns(10);
		
		Button button_1 = new Button("Solve");
		button_1.addActionListener(new ActionListener(){
			/**this method preforms the action event associated with this button**/
			public void actionPerformed(ActionEvent e) {
				try{
				String expr = (textFieldInput.getText());
				textFieldOutput.setText(String.valueOf(evaluate.evaluate(expr)));	
				}
				catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Your input is incorrectly typed");
				}
				
			}
	});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 0;
		contentPane.add(button_1, gbc_button_1);
		
		/**creates a jlabel with the word result**/
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 0, 5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 1;
		contentPane.add(lblResult, gbc_lblResult);
		
		textFieldOutput = new JTextField();
		
		/**this defines the output field**/
		GridBagConstraints gbc_textFieldOutput = new GridBagConstraints();
		gbc_textFieldOutput.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldOutput.anchor = GridBagConstraints.WEST;
		gbc_textFieldOutput.gridx = 1;
		gbc_textFieldOutput.gridy = 1;
		textFieldOutput.setEditable(false);
		contentPane.add(textFieldOutput, gbc_textFieldOutput);
		textFieldOutput.setColumns(10);
		
		/**this adds an action listened to the button**/
		Button button = new Button("Clear");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				textFieldInput.setText("");
				textFieldOutput.setText("");
			}
		});
		/**this specifications for the clear button**/
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		contentPane.add(button, gbc_button);
	}
	
	/**
	 * The method for actually running the class and setting the visibility to true
	 **/
	public void run() {
		projTwoFrame frame = new projTwoFrame();
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
