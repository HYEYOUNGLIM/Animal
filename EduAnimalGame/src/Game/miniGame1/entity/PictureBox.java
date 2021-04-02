package Game.miniGame1.entity;

import java.awt.Graphics;
import java.util.Random;

import Game.Animal.Canvas.GameCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;

public class PictureBox {
	
	public static PictureBox instance;
	
	private double x = 1000;
	private double y = 0;
	private double width;
	private double height;
	private static Picture[] pictures;
	private static int pictureCnt = 10;
	private Picture problemPicture;
	private Random rand;
	
	public PictureBox() {
		this(280,600);
	}

	public PictureBox(double width, double height) {
		instance = this;
		this.width = width;
		this.height = height;
		pictures = new Picture[pictureCnt];
		for(int i=0; i<pictures.length; i++)
			pictures[i] = new Picture(i);
		rand = new Random();
		int problemIdx = GameCanvas.problemIdx;
		problemPicture = pictures[problemIdx];
	}

	public void paint(Graphics g) {

		problemPicture.paint(g);
		
	}

	public static int getPictureCnt() {
		return pictureCnt;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}
	
	
	
	

	
}
