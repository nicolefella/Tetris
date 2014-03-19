//CS201 Tetris
//Nicole Fella

import javax.swing.JFrame;

/**
* Command line version of the GUI Tetris game
**/
public class TetrisGameGUIApplication 
{
	/**
	* Constructor 
	**/
	public TetrisGameGUIApplication()
	{
		//create a JFrame
		JFrame tetrisFrame = new JFrame("Tetris! Enter move 'r, l, d, z, x'");
		
		//set the frame size -- found these values after playing around with the frame and the game border
		tetrisFrame.setSize(305,605);
		
		//add the GUI Game controller 
		tetrisFrame.add(new TetrisGameGUIController(false));
		
		//set close operation
		tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make frame visible
		tetrisFrame.setVisible(true);
	}
	
	/** 
	* Start the game!
	**/
	public static void main(String[] args)
	{
		new TetrisGameGUIApplication();

	}
}
