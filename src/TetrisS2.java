//CS201 Tetris
//Nicole Fella

/** 
* TetrisS2 represents one of the Tetris S Shapes
**/
public class TetrisS2 extends TetrisPiece
{
	/** 
	* Constructor 
	**/
	public TetrisS2()
	{
		//create array pieceCode to hold 3D array of 4 by 4 by 4 (rotation, row, col)
		//must create this new boolean array because you cannot hardcode initialize an already declared array
		boolean[][][] pieceCode = 
			{
				//rotation 1
				{ 
					{false, false, false, false}, 
					{false, false, false, false},
					{true,  true,  false, false},
					{false, true,  true,  false}
				},
						
				//rotation2
				{
					{false, false, false, false},
					{false, true,  false, false},
					{true,  true,  false, false},
					{true,  false, false, false}
				},
				
				//rotation 3
				{ 
					{false, false, false, false},
					{false, false, false, false},
					{true,  true,  false, false},
					{false, true,  true,  false}
				},	
					
				//rotation 4
				{ 
					{false, false, false, false},
					{false, false, true,  false},
					{false, true,  true,  false},
					{false, true,  false, false}
				}
			};
			
		//assign pieceCode to current instance field of filledSquares
		this.filledSquares = pieceCode;	
	}
}