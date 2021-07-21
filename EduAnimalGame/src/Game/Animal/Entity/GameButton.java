package Game.Animal.Entity;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.introPage.canvas.IntroCanvas;

public class GameButton extends Button{

	private int x;
	private int y;

	private int width; 
	private int height;

	private Image img;
	private String img1;

//	static {
//		try {
//			img = ImageIO.read(new File("res/introBg.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public GameButton() {
		this(0, 0, 0, 0, "");
	}

	public GameButton(int x, int y, int width, int height, String string) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img1 = string;
	}

	public void paint(Graphics g) {

		try {
			this.img = ImageIO.read(new File(img1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, x, y, IntroCanvas.instance);

	}

	public boolean contains(int x, int y) {
		if ((this.x - width < x && x < this.x + width) && (this.y - height < y && y < this.y + height))
			return true;
		return false;
	}
}
