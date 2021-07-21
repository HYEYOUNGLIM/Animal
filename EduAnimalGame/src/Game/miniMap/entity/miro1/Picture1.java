package Game.miniMap.entity.miro1;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Animal.Canvas.GameCanvas;
import Game.miniMap.canvas.MiroCanvas;

public class Picture1 {

	private int width = 236;
	private int height = 300;
	private double x;
	private double y;
	private int order = 4;
	private int idx;
	

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	private static Image img;

	static {
		try {
			img = ImageIO.read(new File("res/img/miroCanvas/miroPictureTemp.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Picture1() {
		this(0,0);
	}

	public Picture1(double x, double y) {
		this.x = x;
		this.y = y;
		
		this.idx = GameCanvas.problemIdx;
	}

	public void paint(Graphics g) {

		int w = this.width;
		int h = this.height;

		g.drawImage(img, (int)x, (int)y, (int)x + w, (int)y + h, 0+idx*w, 0, 0 + w+idx*w, 0 + h, MiroCanvas.instance);

	}


	public boolean isSelect(double x, double y) {
		
		int w = this.width;
		int h = this.height;
		double x2 = this.x + w;
		double y2 = this.y + h;
		
		if ((this.x < x && x < x2) && (this.y < y && y < y2))
			return true;
		return false;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

}
