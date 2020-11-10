package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball
{
	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 2.2;
	
	public Ball(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		RandomAngle();
	}
	
	public void tick()
	{
		//Definindo colisões com os limites laterais
		if(x + (dx*speed) + width >= Game.WIDTH)
		{
			dx *= -1;
		}
		else if(x + (dx*speed) < 0)
		{
			dx *= -1;
		}
		
		//Definindo pontuação e colisões com limites verticais
		if(y >= Game.HEIGHT)
		{
			//Ponto do Inimigo
			System.out.println("Ponto do Inimigo!");
			//Coneça uma nova partida
			new Game();
			return;
		}
		else if(y < 0)
		{
			//Ponto do Jogador
			System.out.println("Ponto nosso!!!");
			//Coneça uma nova partida
			new Game();
			return;
		}

		//Criando colisor para Ball
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)), width, height);
		//Criando colisor para Player e Eenemy
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		//Detectando colisões entre entidades
		if(bounds.intersects(boundsPlayer))
		{
			//Muda de angulo ao colidir com algo
			RandomAngle();
			//Muda a diração da bola
			if(dy > 0)
				dy*= -1;
		}
		else if(bounds.intersects(boundsEnemy))
		{
			//Muda de angulo ao colidir com algo
			RandomAngle();
			//Muda a diração da bola
			if(dy < 0)
				dy*= -1;
		}
		
		x += dx * speed;
		y += dy * speed;
	}
	
	public void render(Graphics graphics)
	{
		graphics.setColor(Color.yellow);
		graphics.fillRect((int)x, (int)y, width, height);
	}
	
	public void RandomAngle()
	{
		//O angulo será algo entre 45 e 75 graus que a bola vai ter
		int angle = new Random().nextInt(120-45)+45;
				
		//Gera um angulo aleatorio para Ball
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
}
