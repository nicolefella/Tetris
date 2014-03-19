//CS201 Tetris
//Nicole Fella

/*
* The TetrisBoard class represents a model: a board on which Tetris is played.
* It maintains the grid and the pieces on it.
**/
public class TetrisBoard
{
	//the board consists of a 2D array
	private boolean[][] board;

	//grid position is an array of two indexes (row & col)
	private int[] currentGridPosition;
	
	private TetrisPiece currentPiece;
	
	static int NUM_COLS = 10;
	
	static int NUM_ROWS = 18;
	

	/**
	* Constructor sets up the board.
	**/
	public TetrisBoard()
	{
		//initialize the board
		initBoard();
		//initialize the current grid position 
		initCurrentGP();
		//add a new piece to the board
		addNewPiece();
	}

	/**
	* initializes the board
	**/
	private void initBoard()
	{
		//initialize a new board of boolean array (NUM_ROWS by NUM_COLS)
		this.board = new boolean[NUM_ROWS][NUM_COLS];
		
		//initialize each box in grid for board to be false because no boxes filled
		for (int i=0; i<board.length; i++)
		{
			for (int j=0; j<board[0].length; j++)
			{
				board[i][j] = false;
			}
		}
	}

	/**
	* Initialize an int array of length two 
	* to keep track of the grid position of the current piece (row, col)
	**/
	private void initCurrentGP()
	{
		//initialize int array of length two
		currentGridPosition = new int[2];
		
		//initialize currentGP to have coordinates (0,0)
		currentGridPosition[0] = 0;
		currentGridPosition[1] = 0;
	}

	/**
	* Add a new random Tetris piece to the board at grid position (0,3)
	**/
	public void addNewPiece()
	{
		//generate a random number to decide between which piece to pick
		int randNum = (int)(Math.random()*7);
		
		//if else statements for different pieces possible
		if (randNum<1)
			this.currentPiece = new TetrisL1();
		else if (randNum<2)
			this.currentPiece = new TetrisL2();
		else if (randNum<3)
			this.currentPiece = new TetrisS1();
		else if (randNum<4)
			this.currentPiece = new TetrisS2();
		else if (randNum<5)
			this.currentPiece = new TetrisSquare();
		else if (randNum<6)
			this.currentPiece = new TetrisStick();
		else
			this.currentPiece = new TetrisT();
		
		//set grid position for current piece (0,3)
		currentGridPosition[0] = 0;
		currentGridPosition[1] = 3;
	}

	/**
	* Chekcs if placing the piece at grid position (row, col) 
	* with rotation  rot (values can be 0, 1, 2, 3) would cause 
	* a collision (i.e., if there would be a block on an already-filled grid square).
	* returns true if there would be a collision
	**/
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		//walk across tetris piece 2D array 
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				//compare tetris piece if filled with board boolean value
				if (piece.isFilled(rot, i, j) == true && board[gridRow+i][gridCol+j] == true)
					//if there is a filled piece for both the tetris piece 2D array and the board at that coordinate value
					return true;
			}
		}
		//otherwise, there is no collision, so return false
		return false;
	}

	/**
	* Checks if placing the piece at grid position (row, col) 
	* with the rotation rot (values can be 0, 90, 180, 270) would cause 
	* an out of bounds condition (i.e., if there would be a block falling off the board).
	* returns true if there would a bounding error
	**/
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		//walk across tetris piece 2D array
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				//compare tetris piece with board 
				if (piece.isFilled(rot, i, j) && ((gridCol<0 || (gridCol+j)>=NUM_COLS)) 
															|| (gridRow+i)>=NUM_ROWS)
					//if a filled piece is outside of the NUM_COLS or NUM_ROWS bounds
					return true;
			}
		}
		//otherwise, not out of bounds, so return false
		return false;
	}
	
	/**
	* Checks if placing the piece at grid position (row, col)
	* with the rotation rot (values can be 0, 1, 2, 3) is a valid move.
	* returns true if no collision or bound error
	**/
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		//moves are valid if detectOutOfBounds AND detectCollision are false
		if (detectOutOfBounds(piece, rot, gridRow, gridCol) == false 
				&& detectCollision(piece, rot, gridRow, gridCol) == false)
			return true;

		else
			return false;
	
	}

	/**
	* Check if there is a full line at the row.
	* returns TRUE if full
	**/
	private boolean fullLine(int row)
	{
		//check the indexes of a row (the columns)
		for (int j = 0 ; j<NUM_COLS; j++)
		{
			//easier to check if one false than if whole row true
			//so if there is one false index in board then return false
			if (this.board[row][j] == false)
				return false;
		}
		//otherwise (if the forloop is exited (no false values in board), return true
		return true;
	}

	/**
	* returns the current instance field of the board
	**/
	public boolean[][] getBoard()
	{
		return this.board;
	}

	/** 
	* returns the current instance field of the current coordinate
	**/
	public int[] getCurrentGridPosition()
	{
		//filler return value
		return this.currentGridPosition;
	}

	/**
	* returns the current instance field of the currentPiece
	**/
	public TetrisPiece getCurrentPiece()
	{
		return this.currentPiece;
	}

	/**
	* returns the numCols
	**/
	public int getNumCols()
	{
		//filler return value
		return NUM_COLS;
	}

	/**
	* returns the numRows
	**/
	public int getNumRows()
	{
		//filler return value
		return NUM_ROWS;
	}

	/**
	* detect if there is a block at spot (row,col)
	**/
	public boolean hasBlock(int row, int col)
	{
		//there is a block in the spot if the piece at that coordinate location has a block
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				if ((this.currentGridPosition[0] + i == row) && (this.currentGridPosition[1] + j == col) 
						&& (this.currentPiece.isFilled(this.currentPiece.getPieceRotation(), i, j)))
					return true;
			}
		}
		
		//return this.board[row][col];
		//if there is a true value in board boolean array, then return true
		if (this.board[row][col] == true)
			return true;
		//otherwise, there is no block at that coordinate position, so return false
		else
			return false;
	}

	/**
	* Update the board array to reflect the newly landed piece's filled squares
	* using the currentGridPosition values and the currentPiece's rotation value.
	**/
	public void landPiece()
	{
		//walk through piece 2D array and assign values to board array
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				//if there is a filled piece
				if (this.currentPiece.isFilled(this.currentPiece.getPieceRotation(), i, j))
				{
					//assign true (there is a block) to board boolean array
					this.board[currentGridPosition[0]+i][currentGridPosition[1]+j] = true;
				}
			}
		}
	}

	/**
	* Check if moving down is valid.
	* If so, move the current piece down.
	* returns TRUE if valid move was performed
	**/
	public boolean moveDown()
	{
		//check if moving down is a valid move
		if (validMove(this.currentPiece, this.currentPiece.getPieceRotation(), 
				this.currentGridPosition[0]+1, this.currentGridPosition[1]) == true)
		{
			//move the piece down and return true
			this.currentGridPosition[0] += 1;
			return true;
		}
		//otherwise moving down is not a valid move, so return false
		else
			return false;
	}

	/**
	* Check is moving left is valid.
	* If so, move the current piece left.
	* returns TRUE if valid move was performed
	**/
	public boolean moveLeft()
	{
		//check if moving left is a valid move
		if(validMove(this.currentPiece, this.currentPiece.getPieceRotation(), 
				this.currentGridPosition[0], this.currentGridPosition[1]-1) == true)
		{
			//move piece to the left and return true
			this.currentGridPosition[1] -= 1;
			return true;
		}
		//otherwise, moving left is not a valid move, so return false
		else
			return false;
	}

	/** 
	* Check if moving right is valid.
	* If so, move the current piece right.
	* returns TRUE if the valid move was performed
	**/
	public boolean moveRight()
	{
		//check if moving right is a valid move
		if(validMove(this.currentPiece, this.currentPiece.getPieceRotation(), 
				this.currentGridPosition[0], this.currentGridPosition[1]+1) == true)
		{
			//move current piece to the right and return true
			this.currentGridPosition[1] += 1;
			return true;
		}
		//otherwise, moving right is not a valid move, so return false
		else
			return false;
	}
	
	/**
	* Check if rotating counter clockwise is valid.
	* If so, rotate the current piece counter clockwise.
	* returns TRUE if valid move was performed
	**/
	public boolean rotateCCW()
	{
		//check if rotating counter clockwise is valid
		if(validMove(this.currentPiece, (this.currentPiece.getPieceRotation()-1 + 3) % 4, 
				this.currentGridPosition[0], this.currentGridPosition[1]) == true)
		{
			//rotate the current piece counterclockwise and return true
			this.currentPiece.rotateCCW();
			return true;
		}
		//otherwise, rotating is not a valid move, so return false
		return false;
	}

	/**
	* Check if rotating clockwise is value
	**/
	public boolean rotateCW()
	{
		//check if rotating counter clockwise is valid
		if(validMove(this.currentPiece, (this.currentPiece.getPieceRotation() + 1) % 4, 
				this.currentGridPosition[0], this.currentGridPosition[1]) == true)
		{
			//rotate the current piece clockwise and return true
			this.currentPiece.rotateCW();
			return true;
		}
		//otherwise, rotating is not a valid move, so return false
		return false;
	}

	/**
	* Detect and remove any lines formed.
	* returns the number of lines found
	**/
	public int numberOfFormedLines()
	{
		//create a local variable called numLinesFormed, to be returned later
		int numLinesFormed = 0; //initialize it to zero
		
		//go through lines and check if any lines are formed
		for (int i=0; i<NUM_ROWS; i++)
		{
			//if there is a full line
			if (fullLine(i) == true)
			{
				//update numLinesFormed and remove line
				numLinesFormed += 1;
				removeLine(i);
			}
		}
		
		//after all rows are checked, return number of lines formed
		return numLinesFormed;
	}

	/**
	* Remove the line at row in the model.
	* Shift all values for rows at a lower index to be at one row higher.
	* Make row 0 full of false values.
	**/
	private void removeLine(int row)
	{
		//for that row, make all indexes (all columns) empty (false) values
		for (int j=0; j<NUM_COLS; j++)
			this.board[row][j] = false;
		
		//walk across the rows of lower index
		for (int i=row; i>0; i--)
		{
			//and walk across the columns in each row
			for (int j=0; j<NUM_COLS; j++)
			{
				//shift all values for rows at a lower index to be one row higher 
				this.board[i][j] = this.board[i-1][j];
			}
		}
		
		//make row 0 full of false values
		for (int j=0; j<NUM_COLS; j++)
			this.board[0][j] = false;
	}

}