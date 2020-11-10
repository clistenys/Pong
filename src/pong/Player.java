package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player
{
	public boolean right, left;
	public int x, y, width, height;
	
	public Player(int x, int y)
	{
		this.x = x;
		this.y = y;
		width = 40;
		height = 10;
	}
	
	//Aqui fica toda a �gica do jogo
	public void tick()
	{
		if(right)
		{
			x+=2;
		}
		else if(left)
		{
			x-=2;
		}
		
		//Detectando colis�es
		if(x+width > Game.WIDTH)
		{
			x = Game.WIDTH - width;
		}
		if(x < 0)
		{
			x = 0;
		}
	}
	
	//Aqui fica o que se refere � renderiza��o
	public void render(Graphics graphics)
	{
		graphics.setColor(Color.blue);
		graphics.fillRect((int)x, (int)y, width, height);
	}

}
