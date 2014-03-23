//CS201 Tetris
//Nicole Fella

/**
* TetrisStick represents the Tetris stick shape
**/
public class TetrisStick extends TetrisPiece
{
	/**
	* Constructor 
	**/
	public TetrisStick()
	{
		//create array pieceCode to hold 3D array of 4 by 4 by 4 (rotation, row, col)
		//must create this new boolean array because you cannot hardcode initialize an already declared array
		boolean[][][] pieceCode = 
			{
				//rotation 1
				{ 
					{false, false, false, false}, 
					{false, false, false, false},
					{false, false, false, false},
					{true,  true,  true,  true}
				},
						
				//rotation2
				{
					{false, true,  false, false},
					{false, true,  false, false},
					{false, true,  false, false},
					{false, true,  false, false}
				},
						
				//rotation 3
				{ 
					{false, false, false, false},
					{false, false, false, false},
					{false, false, false, false},
					{true,  true,  true,  true}
				},	
			
				//rotation 4
				{ 
					{false, false, true,  false},
					{false, false, true,  false},
					{false, false, true,  false},
					{false, false, true,  false}
				}
			};
		
		//assign pieceCode to current instance field of filledSquares
		this.filledSquares = pieceCode;	
	}
}