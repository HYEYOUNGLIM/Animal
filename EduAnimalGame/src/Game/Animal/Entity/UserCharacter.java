package Game.Animal.Entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GameFrame;

public class UserCharacter {
	private double x;
	private double y;

	private int width;
	private int height;

	private Image img;
	
	private int moveIndex = -1;
	private int speed = 3;
	private int walkTempo = 6;
	private int timeoutForMoving = 120;

	public UserCharacter() {
		this(0, 0);
	}

	public UserCharacter(double x, double y) {
		
		try {
			img = ImageIO.read(new File("res/img/gameCanvasAnimal/boy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.x = x;
		this.y = y;

		width = 64;
		height = 96;
	}

	public void paint(Graphics g) {

		int w = this.width;
		int h = this.height;

		int x1 = (int) this.x - width / 2;
		int y1 = (int) this.y - height / 2;

		int x2 = x1 + w;
		int y2 = y1 + h;

		int offsetX = w * moveIndex;
		
		if (walkTempo == 0) {
			moveIndex++;
			moveIndex = moveIndex % 4;

			walkTempo = 3;
		} else
			walkTempo--;

		g.drawImage(img, x1, y1, x1 + w, y1 + h, 0 + offsetX, 0, w + offsetX, h, GameFrame.instance);
	}
}
