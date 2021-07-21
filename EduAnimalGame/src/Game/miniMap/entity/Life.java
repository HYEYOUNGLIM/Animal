package Game.miniMap.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniMap.canvas.MiroCanvas;

public class Life {
	
	private double x;
	private double y;
	private double width = 50;
	private double height = 50;
	private static Image img;
	//private int lifeCnt;
	
	static {
		try {
			img = ImageIO.read(new File("res/img/miroCanvas/heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Life() {
		this(0,0);
	}
	
	public Life(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	
	public void paint(Graphics g) {

		int w = (int) this.width;
		int h = (int) this.height;

		g.drawImage(img, (int)x, (int)y, (int)x + w, (int)y + h, 0, 0, w, h, MiroCanvas.instance);

	}

}
