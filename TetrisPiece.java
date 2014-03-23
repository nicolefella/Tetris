//CS201 Tetris
//Nicole Fella

/**
* The TetrisPiece class represents a piece made of 4 TetrisBlocks.
* It maintains 4 rotations (0 degrees, 90 degrees, 180 degrees, and 270 degrees),
* with each being a 4x4 grid with certain filled squares
**/
public abstract class TetrisPiece
{
	/**
	* 3 dimensional array maintaining which grid squares are filled first is rotation 
	* (index 0 -> 0 degrees, index 1-> 90 degrees, index 2-> 180 degrees, index 3-> 270 degrees)
	* second and third dimensions create 4x4 grid with true entries indicating a filled square
	**/
	protected boolean[][][] filledSquares;

	/**
	* Maintains the current rotation.
	* 0-> 0 degrees, 1-> 90 degrees, 2->180 degrees, 3-> 270 degrees
	**/
	protected int pieceRotation;

	/**
	* Constructor does nothing.
	**/
	public TetrisPiece()
	{

	}

	/** 
	* Get the rotation of this piece.
	* returns piece rotation as 0, 1, 2, or 3 (meaning 0, 90, 180 or 270 degrees respectively) 
	**/
	public int getPieceRotation()
	{
		return pieceRotation;
	}

	/** 
	* Checks if there is a TetrisBlock at the (row,col) position for the rotation rot
	* where rot is 0, 1, 2 or 3 (meaning 0, 90, 180, or 270 degrees, respectively)
	* returns true if there is a block in the position for that rotation
	**/
	public boolean isFilled (int rot, int row, int col)
	{
		//returns true if there is a block in the position for that rotation
		if(filledSquares[rot][row][col] == true)
			return true;
		//otherwise, there is no block in that position so return false
		else
			return false;
	}

	/** 
	* Rotate piece counter-clockwise by 90 degrees 
	**/
	public void rotateCCW()
	{
		//rotate piece --> subtract 1 to note ccw rotation (plus 4, then mod total by 4)
		pieceRotation = (pieceRotation - 1 + 4) % 4;
	}

	/**
	* Rotate piece clockwise 90 degrees
	**/
	public void rotateCW()
	{
		//rotate piece --> add 1 (then mod total by 4)
		pieceRotation = (pieceRotation + 1) % 4;
	}
}