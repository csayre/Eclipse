/**
 * 
 */
package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author csayre
 *
 */
public class Menu implements GameState {

	public Menu(int menu) {
		System.out.println(menu);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.MouseListener#mouseClicked(int, int, int, int)
	 */
	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.MouseListener#mouseDragged(int, int, int, int)
	 */
	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.MouseListener#mouseMoved(int, int, int, int)
	 */
	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.MouseListener#mousePressed(int, int, int)
	 */
	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.MouseListener#mouseReleased(int, int, int)
	 */
	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.MouseListener#mouseWheelMoved(int)
	 */
	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControlledInputReciever#inputEnded()
	 */
	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControlledInputReciever#inputStarted()
	 */
	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControlledInputReciever#isAcceptingInput()
	 */
	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControlledInputReciever#setInput(org.newdawn.slick.Input)
	 */
	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.KeyListener#keyPressed(int, char)
	 */
	@Override
	public void keyPressed(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.KeyListener#keyReleased(int, char)
	 */
	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerButtonPressed(int, int)
	 */
	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerButtonReleased(int, int)
	 */
	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerDownPressed(int)
	 */
	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerDownReleased(int)
	 */
	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerLeftPressed(int)
	 */
	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerLeftReleased(int)
	 */
	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerRightPressed(int)
	 */
	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerRightReleased(int)
	 */
	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerUpPressed(int)
	 */
	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.ControllerListener#controllerUpReleased(int)
	 */
	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#enter(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#leave(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

}
