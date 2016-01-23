package world;

public class Ball {
	public boolean w;
	public boolean a;
	public boolean s;
	public boolean d;
	private int posX;
	private int posY;
	public Ball(int startPosX, int startPosY)
	{
		posX = startPosX;
		posY = startPosY;
	}
	public void moveBall()
	{
		if(w)
		{
			posY--;
		}
		if(a)
		{
			posX--;
		}
		if(s)
		{
			posY++;
		}
		if(d)
		{
			posX++;
		}
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}

}
