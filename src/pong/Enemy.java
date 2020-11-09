package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy
{
	public double x, y;
	public int width, height;
	
	public Enemy(int x, int y)
	{
		this.x = x;
		this.y = y;
		width = 40;
		height = 10;
	}
	
	public void tick()
	{
		this.x += (Game.ball.x - x  -6);
	}
	
	public void render(Graphics graphics)
	{
		graphics.setColor(Color.red);
		graphics.fillRect((int)x, (int)y, width, height);
	}
}
