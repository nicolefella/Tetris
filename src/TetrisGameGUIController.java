//CS201 Tetris
//Nicole Fella

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TetrisGameGUIController extends JPanel implements KeyListener
{
	public static int DEFAULT_DROP_RATE = 1000;

	private int dropRate;

	private TetrisGame game;

	private Timer gameTimer;

	private JLabel labelLines;

	private JLabel tetrisesLabel;

	private TetrisBoardGUIViewer view;

	/**
	* Constructor
	**/
	public TetrisGameGUIController(boolean keysFromApplet)
	{
		//need to call the superclass constructor with a new border layout as the parameter
		super(new BorderLayout());

		//create a new instance of the game and assign it to this instance field called game
		game = new TetrisGame();
		
		//set the drop rate to the static variable DEFAULT_DROP_RATE
		dropRate = DEFAULT_DROP_RATE;
		
		//create the view
		createView();
		
		//create the score
		createScore();
		
		//refresh the display
		refreshDisplay();		
		
		//create timer
		setupTimer();

		//add key listener if keys from applet is false (which it will be for GUI Command line version)
		if (keysFromApplet == false)
			{
				//realized that keys would not work unless they are in focus
				//referenced this website to learn about setFocusable (http://www.leepoint.net/notes-java/GUI-lowlevel/keyboard/keyboard.html)
				setFocusable(true);
				//important to add a key listener to this or else no keys would be referenced
				addKeyListener(this);
			}
	}

	/**
	 * Instantiate new view to this instance field view for Tetris to be placed on Center of pane
	 */
	private void createView()
	{
		this.view = new TetrisBoardGUIViewer(this.game.getTetrisBoard());
		//assign the view to be on the pane in the Center
		add(this.view, "Center");

		//add the score panel to the view
		add(createScore(), "North");
	}
	
	/**
	 * Create a score panel to be placed on north of pane
	 */
	private JPanel createScore()
	{
		//create JPanel to hold the score
		JPanel scorePanel = new JPanel();

		///create new JPanel to hold the lines cleared and labelLines
		JPanel linesPanel = new JPanel();
		linesPanel.add(new JLabel("Lines Cleared: "), "West");
		this.labelLines = new JLabel("0");
		linesPanel.add(this.labelLines, "East");

		//create new JPanel to hold the tetrises cleared and the tetrises label
		JPanel tetrisesPanel = new JPanel();
		tetrisesPanel.add(new JLabel("Tetrises Cleared: "), "West");
		this.tetrisesLabel = new JLabel("0");
		tetrisesPanel.add(this.tetrisesLabel, "East");
		
		//add two panels to the score panel
		scorePanel.add(linesPanel, "North");
		scorePanel.add(tetrisesPanel, "South");

		//return the score panel to the method
		return scorePanel;
	}

	/**
	 * Refresh Display will handle the repainting and the updating of Lines Cleared and Tetrises Cleared
	 */
	public void refreshDisplay()
	{
		//create integer for the number of lines cleared
		int currentClearedLines = this.game.getNumLines();
		
		//update the label to contain the current cleared lines
		this.labelLines.setText(Integer.toString(currentClearedLines));
		
		//create integer for number of tetrises cleared
		int currentClearedTetrises = this.game.getNumTetrises();
		
		//update the label to contain the current cleared tetrises
		this.tetrisesLabel.setText(Integer.toString(currentClearedTetrises));
		
		//repaint
		repaint();
	}
	
	/**
	 * Set up the game timer
	 * Referenced API (http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html)
	 */
	public void setupTimer()
	{
		//create a new timer and assign it to the instance field gameTimer
		this.gameTimer = new Timer(this.dropRate, new ActionListener()
		{
			//action performed will refresh the display
			public void actionPerformed(ActionEvent e)
			{
				//need to make the drop rate relevant and make the piece move down
				TetrisGameGUIController.this.game.attemptMove(5);

				//remember to always refresh the display
				TetrisGameGUIController.this.refreshDisplay();
			}
		});
		
		//start the game timer of this instance field
		this.gameTimer.start();
	}
	
	/**
	* Handle the key released event -- not relevant 
	**/
	public void keyReleased(KeyEvent e)
	{

	}

	/**
	* Handle the key typed event -- not relevant
	**/
	public void keyTyped(KeyEvent e)
	{

	}

	/**
	* Handle the key pressed event -- used lab4 with keyEvent to simulate correct methodology
	**/
	public void keyPressed(KeyEvent e)
	{
		// different behavior depending on which key was released
        switch( e.getKeyCode() )
        {
        	//case for CCW (x)
        	case KeyEvent.VK_X:
        		this.game.attemptMove(1);
        		break;
       		//case for CW (z)
        	case KeyEvent.VK_Z:
        		this.game.attemptMove(2);
        		break;
       		//case for right (r)
        	case KeyEvent.VK_R:
        		this.game.attemptMove(3);
        		break;
        	//case for left (l)
        	case KeyEvent.VK_L:
        		this.game.attemptMove(4);
        		break;
        	//case for down (d)
        	case KeyEvent.VK_D:
        		this.game.attemptMove(5);
        		break;
        	default:
        		System.out.println("KEY RELEASED: " + e.getKeyCode() );
        }

        //don't forget to continually repaint and refresh the display
        refreshDisplay();
	}
	

}