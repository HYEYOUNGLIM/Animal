package Game.miniMap.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniMap.canvas.MiroCanvas;

public class MiroWord {

	private static Image img;
	private int x;
	private int y;
	private boolean isCorrect;
	private int width = 60;
	private int height = 60;
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	static {
		try {
			img = ImageIO.read(new File("res/miroWordP.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MiroWord() {
		this(0, 0, true);
	}

	public MiroWord(int x, int y, boolean isCorrect) {
		this.x = x;
		this.y = y;
		this.isCorrect = isCorrect;
	}

	public void paint(Graphics g , int i) {
		g.drawImage(img,x,y,x+width,y+height,width*i,0,width+width*i,height, MiroCanvas.instance);

	}

	public boolean isSelect(int x, int y) {

		int w = this.width;
		int h = this.height;
		int x2 = this.x + w;
		int y2 = this.y + h;

		if ((this.x < x && x < x2) && (this.y < y && y < y2)) 
			if (isCorrect) 
				return true;
			//else
				//life--;
		return false;
	}
	
	public void move(int x, int y) {

		
		this.x = x+this.x;
		this.y = y+this.y;
		
		setX(this.x);
		setY(this.y);
		
		
	}

	public void update() {
		//if()
		setY(getY() - 1);
		//paint(g);
	}

}
