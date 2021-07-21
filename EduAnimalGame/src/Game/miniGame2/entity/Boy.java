package Game.miniGame2.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame2.canvas.MiniGame2Canvas;

public class Boy {

	private static Image img;
	private double x;
	private double y;

	private double width;
	private double height;

	private int speed = 4;

	final private int LEFT = 0;
	final private int RIGHT = 1;

	private boolean EAST = false;
	private boolean WEST = false;

	BoyEatListener listener;

	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame2Canvas/boy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boy() {
		width = img.getWidth(null);
		height = img.getHeight(null);
		this.x = GameBox.instance.getWidth() / 2 - width / 2;
		this.y = GameBox.instance.getHeight() - height;
	}

	public void paint(Graphics g) {
		int x = (int) this.x;
		int y = (int) this.y;
		int width = (int) this.width;
		int height = (int) this.height;
		g.drawImage(img, x, y, x + width, y + height, 0, 0, width, height, MiniGame2Canvas.instance);

	}

	public void update() {
		double gameBoxWidth = GameBox.instance.getWidth();

		if (x <= 0)
			this.x = 0;
		if (x >= gameBoxWidth - width)
			this.x = gameBoxWidth - width;

		if (EAST)
			this.x += 1 * speed;

		else if (WEST) {
			this.x -= 1 * speed;
		}

	}

	public void move(double x, double y) {
		if (x < this.x) {
			WEST = true;
			EAST = false;

		} else if (x > this.x + width && x <= GameBox.instance.getWidth()) {

			EAST = true;
			WEST = false;

		}
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

	public double getHeight() {
		return height;
	}

	public void checkEatLetter(RainLetter rainLetter) {
		double rainLetterX = rainLetter.getX();
		double rainLetterY = rainLetter.getY();
		double rainLetterWidth = rainLetter.getWidth();
		double rainLetterHeight = rainLetter.getHeight();
		if (((rainLetterY + rainLetterHeight > y)
				&& (rainLetterX + rainLetterWidth > x && x + width > rainLetterX + rainLetterWidth))
				|| ((rainLetterY + rainLetterHeight > y) && (x + width > rainLetterX && rainLetterX > x))) {
			
			if (listener != null) {
				listener.onEat(rainLetter);
			}

		}

	}

	public void setListener(BoyEatListener listener) {
		this.listener = listener;
	}

	public void stop() {
		EAST = false;
		WEST = false;

	}

}
