//CS201 Tetris
//Nicole Fella

/**
* TetrisBoardTextView creates a String view of a TetrisBoard
**/
public class TetrisGameTextView
{
	private TetrisGame game;

	/** 
	* Constructor requires the board to display
	**/
	public TetrisGameTextView(TetrisGame g)
	{
		//assign the parameter g to the game instance field
		this.game = g;
		
	}

	/**
	* Gets the view of the board. Must convert the board into a String, 
	* to be returned to the function. Use x to show a block.
	**/
	private String getBoardView()
	{
		//create a string for the board, and initialize it to contain nothing
		String boardText = "";
		//need to get board from this game, and assign it to board local variable
		TetrisBoard boardVar = this.game.getTetrisBoard();
		
		//create a top border for the game
		boardText += "-~-~-~-~-~";
		//put game on next line (see comment below for website used to reference how to do this)
		boardText += "\n";
		
		//walk across board 2D array 
		for (int i=0; i<boardVar.getNumRows(); i++)
		{
			for (int j=0; j<boardVar.getNumCols(); j++)
			{
				//if there is a block at the coordinates (i,j), denote with an x
				if (boardVar.hasBlock(i,j) == true)
					boardText += "x";
				//otherwise, there is not block so denote with a space
				else
					boardText += " ";
			}
			//I referenced this website (http://stackoverflow.com/questions/14534767/how-to-append-a-newline-to-stringbuilder)
			//to figure out how to get the rows of the board to appear on different lines
			boardText += "\n";
		}
		
		//create bottom border for the game
		boardText += "-~-~-~-~-~";
		
		//return the text for the board
		return boardText;
	}

	/**
	 * Gets the view of the piece once converted to a string.
	 * Must convert piece into String. 
	 * Use x to show a block. 
	 */
	private String getPieceView()
	{
		//create a string pieceText for the current piece, and initialize it to contain nothing 
		String pieceText = "";
		//need to get the current piece from this instance of the game
		TetrisPiece pieceVar = this.game.getTetrisBoard().getCurrentPiece();
		
		//walk across the piece array
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				//if there is a block at coordinates (i,j), denote with an x
				if (pieceVar.isFilled(pieceVar.getPieceRotation(), i, j))
					pieceText += "x";
				//otherwise, there is no block so denote wit a space
				else
					pieceText += " ";
			}
			pieceText += "\n";
		}
		
		return pieceText;
	}
	
	/** 
	* Get the current view as a String.
	* The board view will display
	* number of lines, number of tetrises, and the game.
	**/
	public String getView()
	{
		//create numLines display text as a String
		String numLinesDisplay = "Number of Lines: " + this.game.getNumLines();
		
		//create numTetrises display text as a String
		String numTetrisesDisplay = "Number of Tetrises: " + this.game.getNumTetrises();
		
		//call function to get the display of the board and store in string
		String boardDisplay = getBoardView();
		
		//call function to get piece text and store in a string
		String pieceDisplay = "Your piece looks like" + getPieceView();
		
		//concatenate the string and return it to the function
		return (numLinesDisplay + "\n" + numTetrisesDisplay + "\n" + boardDisplay + "\n" + pieceDisplay);
	}
}