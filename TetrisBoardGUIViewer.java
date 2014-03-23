//CS201 Tetris
//Nicole Fella

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

public class TetrisBoardGUIViewer extends JComponent 
{
	private TetrisBoard board;

	/**
	* Constructor assign parameter tetris board to this instance field of the board
	**/
	public TetrisBoardGUIViewer(TetrisBoard b)
	{
		//assign the parameter to the instance field of the board
		this.board = b;

		//paint the screen
		repaint();
	}

	/** 
	* Compute the best block size for the current width and height
	**/
	private int computeBlockSize()
	{
		//return arbitrary block size value
		return 30;
	}

	/**
	* Paint the game. Referenced API for Graphics (http://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html)
	**/
	public void paint(Graphics g)
	{
		//create an outline for the game, which is calculated by the blocksize
		paintBoardOutline(g, computeBlockSize());
		
		//paint the blocks for the board by walking across board array and checking coordinates (i,j)
		for (int i=0; i<this.board.getNumRows(); i++)
		{
			for (int j=0; j<this.board.getNumCols(); j++)
			{
				//if there is a block, paint a block
				if (this.board.hasBlock(i, j) == true)
					paintBlock(g, i, j, computeBlockSize());
			}
		}
	}

	/**
	* Paint the block at grid row, grid col
	**/
	private void paintBlock(Graphics g, int row, int col, int blockSize)
	{
		//set colors
		g.setColor(Color.BLACK);
		//draw a rectangle where row*blockSize and col*blockSize are coordinate outlines of block
		g.drawRect(col*blockSize, row*blockSize, blockSize, blockSize);
		
		
		//set colors
		g.setColor(Color.MAGENTA);
		//fill the rectangle in
		g.fillRect(col*blockSize, row*blockSize, blockSize, blockSize);
	}

	/**
	* creates an outline for the board
	**/
	private void paintBoardOutline(Graphics g, int blockSize)
	{
		//set color
		g.setColor(Color.BLACK);
		//draw rectangle of the board outline, where numRows*blockSize and numCols*blockSize gives board dimension lengths
		g.drawRect(0, 0, this.board.getNumCols()*blockSize, this.board.getNumRows()*blockSize);
	}
}