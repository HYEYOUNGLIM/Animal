package Game.miniMap.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Game.Animal.Canvas.GameCanvas;
import Game.miniMap.canvas.MiroCanvas;

public class CorrectPicture {

	private int width;
	private int height;
	private double x;
	private double y;
	private static Image img;
	private int idx;

	static {
		try {
			img = ImageIO.read(new File("res/img/miroCanvas/pictureCardArray.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public CorrectPicture() {
		this(0, 0);
	}

	public CorrectPicture(double x, double y) {
		this.x = x;
		this.y = y;

		this.width = 330;
		this.height = 480;
		this.idx = GameCanvas.problemIdx;
	}

	public void paint(Graphics g) {

		int w = this.width;
		int h = this.height;

		g.drawImage(img, (int)x, (int)y, (int)x + w, (int)y + h, 0+idx*w, 0, 0 + w+idx*w, 0 + h, MiroCanvas.instance);


	}
	
	public void play(String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
