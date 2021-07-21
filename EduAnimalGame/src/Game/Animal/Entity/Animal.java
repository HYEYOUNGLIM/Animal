package Game.Animal.Entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Game.Animal.Canvas.GameCanvas;

public class Animal {
	private double x;
	private double y;

	private int width;
	private int height;

	private int moveIndex = 0;

	private Image img;

	private int idx;
	private String soundSrc;
	private String imgSrc;
	private AudioInputStream ais;
	private Clip clip;
	private String animalName;
	private int walkTempo = 4;
	private int speed;
	// private boolean selected = false;
	public Animal() {
		this(0, "", 0, 0, "", "",0);
	}

	public Animal(int idx, String animalName, double x, double y, String imgSrc, String soundSrc, int speed) {

		
		try {
			img = ImageIO.read(new File(imgSrc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ais = AudioSystem.getAudioInputStream(new File(soundSrc));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			// clip.start();s
			// if ( loop) clip.loop(-1);

			// Loop 값이true면 사운드재생을무한반복시킵니다.

			// false면 한번만재생시킵니다.

		} catch (Exception e) {

			e.printStackTrace();

		}

		width = 87;
		height = 120;

		this.x = x;
		this.y = y;

		this.idx = idx;
		this.soundSrc = soundSrc;
		this.imgSrc = imgSrc;
		this.animalName = animalName;
		this.speed = speed;
	}

	public void setImg(String imgSrc) {
		try {
			img = ImageIO.read(new File(imgSrc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void paint(Graphics g) {

		int w = (int) this.width;
		int h = (int) this.height;

		int x1 = (int) this.x - width / 2;
		int y1 = (int) this.y - height / 2;

		int x2 = x1 + w;
		int y2 = y1 + h;

		if (walkTempo == 0) {
			moveIndex = moveIndex % 4;
			moveIndex++;

			walkTempo = speed;
		} else
			walkTempo--;

		if (moveIndex == 4)
			moveIndex = moveIndex % 4;

		int offsetX = moveIndex * w;

		g.drawImage(img, x1, y1, x2 + 30, y2 + 30, 0 + offsetX, 0, w + offsetX, h, GameCanvas.instance);
//		if (selected) {
//			double x = UserCharacter.instance.getX() + 90;
//			double y = UserCharacter.instance.getY();
//			
//			g.drawImage(img, (int)x, (int)y, x2, y2, 0 + offsetX, 0, w + offsetX, h, GameCanvas.instance);
//		}

//		int w = this.width;
//		int h = this.height;
//
//		int x1 = (int) this.x - width / 2;
//		int y1 = (int) this.y - height / 2;
//
//		g.drawImage(img, x1, y1, x1 + w+60, y1 + h+60, 0, 0, w, h, GameCanvas.instance);
	}

	public void bark(String src) {
		clip.setMicrosecondPosition(0);
		clip.start();

	}

	public void move(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public boolean isSelected(double x, double y) {
		if ((this.x - width / 2 <= x && x <= this.x + width / 2)
				&& (this.y - height / 2 <= y && y <= this.y + height / 2))
			return true;

		return false;
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

	public String getSoundSrc() {
		return soundSrc;
	}

	public void setSoundSrc(String soundSrc) {
		this.soundSrc = soundSrc;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getAnimalName() {
		return animalName;
	}

//	public void setSelected(boolean selected) {
//		this.selected = selected;
//	}
	
	

}
