//CS201 Tetris
//Nicole Fella

/**
* TetrisL2 represents one of the Tetris L Shapes
**/
public class TetrisL2 extends TetrisPiece
{
	/** 
	* Constructor
	**/
	public TetrisL2()
	{
		//create array pieceCode to hold 3D array of 4 by 4 by 4 (rotation, row, col)
		//must create this new boolean array because you cannot hardcode initialize an already declared array
		boolean[][][] pieceCode = 
			{
				//rotation 1
				{ 
					{false, false, false, false}, 
					{false, false, false, false},
					{false, false, true,  false},
					{true,  true,  true,  false}
				},
				
				//rotation2
				{
					{false, false, false, false},
					{true,  false, false, false},
					{true,  false, false, false},
					{true,  true,  false, false}
				},
				
				//rotation 3
				{ 
					{false, false, false, false},
					{false, false, false, false},
					{true,  true,  true,  false},
					{true,  false, false, false}
				},	
			
				//rotation 4
				{ 
					{false, false, false, false},
					{false, true,  true,  false},
					{false, false, true,  false},
					{false, false, true,  false}
				}
			};
				
		//assign pieceCode to current instance field of filledSquares
		this.filledSquares = pieceCode;	
	}
}