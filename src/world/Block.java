package world;

public class Block {
	private BlockPosition position;
	public Block(int posX, int posY)
	{
		position = new BlockPosition(posX,posY);
	}
	public BlockPosition getBlockPos()
	{
		return position;
	}
	
}
