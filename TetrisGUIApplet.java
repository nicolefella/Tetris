//CS201 Tetris
//Nicole Fella

import java.applet.Applet;

/**
* This is the applet GUI version of Tetris
**/
public class TetrisGUIApplet extends Applet
{
	private TetrisGameGUIController controller;

	/**
	* Constructor
	**/
	public TetrisGUIApplet()
	{
		//assign a new TetrisGameGUIController instance to the instance field above
		this.controller = new TetrisGameGUIController(true);

		//add key listener
		addKeyListener(this.controller);

		//set listener in focus
		setFocusable(true);
	}

	/**
	* Special method to be invoked when applet is created.
	* this overrides the start class in java.applet.Applet
	**/
	public void start()
	{
		new TetrisGUIApplet();
	}
}