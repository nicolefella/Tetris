//CS201 Tetris
//Nicole Fella

/**
* The TetrisGame class maintains a Tetris game
**/
public class TetrisGame
{
	/***
	 * These static instance variables are to be used in moveType function.
	 * They are given arbitrary integer values 
	 **/
	static int CCW = 1;
	static int CW = 2;
	static int RIGHT = 3;
	static int LEFT = 4;
	static int DOWN = 5;
	
	private int numLines;

	private int numTetrises;

	private TetrisBoard tetrisBoard;

	/**
	* Constructor. Initialize numLines and numTetrises. Instantiate board
	**/ 
	public TetrisGame()
	{
		//initialize numLines to 0 
		this.numLines = 0;
		//initialize numTetrises to 0
		this.numTetrises = 0;
		
		//instantiate tetris board
		this.tetrisBoard = new TetrisBoard();
	}

	/** 
	* Try to move the current piece with CCW, CW< RIGHT, LEFT, DOWN
	**/
	public void attemptMove(int moveType)
	{
		//attempt to move CCW
		if (moveType == 1)
			this.tetrisBoard.rotateCCW();
		//attempt to move CW
		if (moveType == 2)
			this.tetrisBoard.rotateCW();
		//attempt to move right
		if (moveType ==3)
			this.tetrisBoard.moveRight();
		//attempt to move left
		if (moveType == 4)
			this.tetrisBoard.moveLeft();
		//attempt to move down
		if (moveType == 5)
		{
			//if you cannot move down, end round
			if (!this.tetrisBoard.moveDown())// == false)
				endRound();
		}
		
	}

	/**
	* Performed when a piece cannot move down anymore (piece is landed)
	* Ends the round by checking for newly formed lines 
	* and adding a new piece.
	**/
	private void endRound()
	{
		//land the tetris piece on the board
		this.tetrisBoard.landPiece();
		
		//check if any lines are formed and assign to variable foundLines
		int foundLines = this.tetrisBoard.numberOfFormedLines();
		
		//update number of lines instance field
		this.numLines += foundLines;
		
		//update number of tetrises (if any)
		if (foundLines == 4)
			this.numTetrises += 1;
		
		//add new piece to the board
		this.tetrisBoard.addNewPiece();
	}

	/**
	* returns the this instance field of numLines
	**/
	public int getNumLines()
	{
		return this.numLines;
	}

	/**
	* returns this instance field of numTetrises
	**/
	public int getNumTetrises()
	{
		//filler return value
		return this.numTetrises;
	}

	/**
	* returns this instance field of TetrisBoard
	**/
	public TetrisBoard getTetrisBoard()
	{
		//filler return value
		return this.tetrisBoard;
	}
}
