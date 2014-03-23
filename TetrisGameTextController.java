//CS201 Tetris
//Nicole Fella

//imports
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TetrisGameTextController
{
	private TetrisGame game;

	private TetrisGameTextView view;

	/**
	* Constructor. Instantiates an instance of the game. 
	* Creates a view specific to this game.
	**/
	public TetrisGameTextController()
	{
		//instantiate an instance of the Tetris Game
		this.game = new TetrisGame();
		//instantiate an instance of the Tetris Game Text View for this instance field of game
		this.view = new TetrisGameTextView(this.game);
		
		//print out initial view of the game
		refreshDisplay();
		
		//take in user input
		readInput();
	}


	/** 
	* Take user input (r, l, d, z, x) and attempt moves within the game.
	* r: right(static int 3), l: left(static int 4), d: down(static int 5), 
	* z: cw(static int 2), x: ccw(static int 1)
	**/
	private void moveEntered(String move)
	{
		//if the user selects r (right)
		if (move.equals("r"))
			this.game.attemptMove(3);
		//if the user selects l (left)
		else if (move.equals("l"))
			this.game.attemptMove(4);
		//if the user selects d (down)
		else if (move.equals("d"))
			this.game.attemptMove(5);
		//if the user selects z (cw)
		else if (move.equals("z"))
			this.game.attemptMove(2);
		//if the user selects x (ccw)
		else if (move.equals("x"))
			this.game.attemptMove(1);
		//otherwise, display "No... enter 'r, l, d, x, or z'"
		else
			System.out.println("No...enter 'r, l, d, x, or z'");
	}

	/**
	* Get input from the user, looping until the user types "Quit."
	* User prompted to enter input from different method
	* Helpful to think about interactive sum code (used as reference)
	**/
	private void readInput()
	{
		//wrap input stream read from the user
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//try catch statement
		try
		{
			//create String variable line
			String line;
			
			//do while statement (complete while the user does not enter 'Quit')
			do
			{
				//read line from user input
				line = in.readLine();
				
				//take the user input and use it in the moveEntered method
				moveEntered(line);
				
				//update display 
				refreshDisplay();
				
			} while((!line.equals("Quit")));
		}
		//catch I/O Exception
		catch (IOException ioe)
		{
			//tell exception to print its error log
			ioe.printStackTrace();
		}
		
		//refresh display after input read and processed
		refreshDisplay();
	}

	/**
	* Print text this instance field of view of game
	**/
	private void refreshDisplay()
	{
		//print out the display to the console
		System.out.println(this.view.getView());
		
		//prompt the user for input
		System.out.println("Please enter move (l,r,d,z,x) or type 'Quit' to end.");
	}
	
	/** 
	* Start the game! Initialize TetrisGameTextController
	**/
	public static void main(String[] args)
	{
		new TetrisGameTextController();
	}

}