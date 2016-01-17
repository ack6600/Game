package world;

public class BlockPosition {
	private int blockPosX;
	private int blockPosY;
	public BlockPosition(int x, int y)
	{
		blockPosX = x;
		blockPosY = y;
	}
	public int getPosX()
	{
		return blockPosX;
	}
	public int getPosY()
	{
		return blockPosY;
	}

}
