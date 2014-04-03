/**
 * This code is taken from the book "Java Software Structures. Designing and Using Data Structures"
 * @author Jonny Pine
 * @version 1.0
 */
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {
	
	/** constant for addition symbol */
	  private final char ADD = '+';
	  /** constant for subtraction symbol */
	  private final char SUBTRACT = '-';
	  /** constant for multiplication symbol */
	  private final char MULTIPLY = '*';
	  /** constant for division symbol */
	  private final char DIVISION = '/';
	  /** the stack */
	  private Stack<Float> st; 
		
	  /**
	   * Sets up this evaluator by creating a new stack.
	   */
		public Postfix(){
			st = new Stack<Float>();
		}
		 /**
		   * Evaluates the specified postfix expression. If an operand is
		   * encountered, it is pushed onto the stack. If an operator is
		   * encountered, two operands are popped, the operation is
		   * evaluated, and the result is pushed onto the stack.
		   * @param expr String representation of a postfix expression
		   * @return float value of the given expression
		   */
		public float evaluate(String expr){
			float op1, op2, result = 0; 
			String token; 
			StringTokenizer tokenizer = new StringTokenizer(expr);
			
			while(tokenizer.hasMoreTokens()){
				token = tokenizer.nextToken();
				
				if(isOperator(token)){
					op2 = (st.pop()).intValue();
					op1 = (st.pop()).intValue();
					result = evalSingleOp(token.charAt(0), op1, op2);
					st.push(new Float(result));
				}
				else
					st.push(new Float(Float.parseFloat(token)));
					
				
			}
			return result;
		}
		/**
		   * Determines if the specified token is an operator.
		   * @param token String representing a single token
		   * @return boolean true if token is operator
		   */
		private boolean isOperator(String token){
			return(token.equals("+") || token.equals("-") ||
				   token.equals("*") || token.equals("/") );
		}
		 /**
		   * Performs float evaluation on a single expression consisting of 
		   * the specified operator and operands.
		   * @param operation operation to be performed
		   * @param op1 the first operand
		   * @param op2 the second operand
		   * @return float value of the expression
		   */
		private float evalSingleOp(char operation, float op1, float op2){
			float result = 0;
			switch(operation){
			case ADD:
					result = op1+op2;
					break;
			case SUBTRACT:
					result = op1-op2;
					break;
			case MULTIPLY:
					result = op1*op2;
					break;
			case DIVISION:
					result = op1/op2;
					break;
			}
		return result;
		}
 }

