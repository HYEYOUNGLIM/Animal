package Game.miniGame2.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame2.canvas.MiniGame2Canvas;

public class Left {

	private double x;
	private double y;

	private static Image img;
	private double width;
	private double height;

	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame2Canvas/left.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Left() {
		// TODO Auto-generated constructor stub
	}

	public Left(double x, double y) {
		this.x = x;
		this.y = y;
		width = img.getWidth(null);
		height = img.getHeight(null);
	}

	public void paint(Graphics g) {

		int x = (int) this.x;
		int y = (int) this.y;
		int width = (int) this.width;
		int height = (int) this.height;

		g.drawImage(img, x, y, x + width, y + height, 0, 0, width, height, MiniGame2Canvas.instance);

	}

	public boolean check(double x, double y) {
		if ((this.x <= x && x <= this.x + width) && (this.y <= y && y <= this.y + height))
			return true;
		return false;
	}
}
