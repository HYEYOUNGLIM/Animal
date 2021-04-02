package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame1.canvas.MiniGame1Canvas;

public class Life {

	private double x;
	private double y;

	private static Image img;
	private double width;
	private double height;

	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame1Canvas/life.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Life() {
		this(0, 0);
	}

	public Life(double x, double y) {
		this.x = x;
		this.y = y;
		width = img.getWidth(null);
		height = img.getHeight(null);
	}

	public void paint(Graphics g) {

		int lifeCnt = MiniGame1Canvas.getLifeCnt();
		int space = 0;
		for (int i = 0; i < lifeCnt; i++) {
			int x = (int) (this.x + width*i)+space;
			int y = (int) (this.y + (LifeBox.getInstance().getHeight() - height) / 2);
			int width = (int) this.width;
			int height = (int) this.height;
			g.drawImage(img, x, y, x+width, y+height, 0, 0, width, height, MiniGame1Canvas.instance);
			space += 10;
		}

	}

}
