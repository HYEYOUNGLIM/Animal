package Game.Animal.Entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Animal.Canvas.GameCanvas;

public class InfoBox {
	private double x;
	private double y;

	private int width;
	private int height;

	private String src;
	private Image img;

	public InfoBox() {

	}

	public InfoBox(double x, double y, String src) {

		try {
			img = ImageIO.read(new File(src));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.width = 578;
		this.height = 167;

		this.x = x;
		this.y = y;

		this.src = src;

	}

	public void paint(Graphics g) {

		
		g.drawImage(img, (int)this.x, (int)this.y, GameCanvas.instance);
	}
}
