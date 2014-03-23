//CS201 Tetris
//Nicole Fella

/**
* TetrisS1 represents one of the Tetris S Shapes
**/
public class TetrisS1 extends TetrisPiece
{
	/**
	* Constructor
	**/
	public TetrisS1()
	{
		//create array pieceCode to hold 3D array of 4 by 4 by 4 (rotation, row, col)
		//must create this new boolean array because you cannot hardcode initialize an already declared array
		boolean[][][] pieceCode = 
			{
				//rotation 1
				{ 
					{false, false, false, false}, 
					{false, false, false, false},
					{false, true,  true,  false},
					{true,  true,  false, false}
				},
				
				//rotation2
				{
					{false, false, false, false},
					{true,  false, false, false},
					{true,  true,  false, false},
					{false, true,  false, false}
				},
						
				//rotation 3
				{ 
					{false, false, false, false},
					{false, false, false, false},
					{false, true,  true,  false},
					{true,  true,  false, false}
				},	
					
				//rotation 4
				{ 
					{false, false, false, false},
					{false, true,  false, false},
					{false, true,  true,  false},
					{false, false, true,  false}
				}
			};
				
		//assign pieceCode to current instance field of filledSquares
		this.filledSquares = pieceCode;	
	}
}