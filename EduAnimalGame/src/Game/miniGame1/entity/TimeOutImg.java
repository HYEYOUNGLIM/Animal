package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame1.canvas.MiniGame1Canvas;

public class TimeOutImg {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private static Image img;
	
	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame1Canvas/timeOutImg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TimeOutImg() {
		this(0,0);
	}
	
	public TimeOutImg(double x, double y) {
		this.x = x;
		this.y = y;
		width = img.getWidth(null);
		height = img.getHeight(null);
	}

	public void paint(Graphics g) {
		int x = (int) this.x+50;
		int y = (int) (this.y+(TimeOutBox.getInstance().getHeight()-height)/2);
		int width = (int) this.width;
		int height = (int) this.height;
		g.drawImage(img, x, y, x+width, y+height, 
				0, 0, width, height, MiniGame1Canvas.instance);
	}

}
