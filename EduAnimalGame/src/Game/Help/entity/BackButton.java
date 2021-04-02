package Game.Help.entity;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackButton extends Button {
	
	private int x;
	private int y;
	private Image img;
	private int width;
	private int height;
	private String imgSrc;
	private boolean bgm;
	

	public BackButton() {
		this(0,0,0,0);
	}
		
	public BackButton(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.img = tk.getImage("res/back.png");
		bgm = true;
	}
	
	@Override
	public void paint(Graphics g) {
		int x1 = width;
		int y1 = height;
		int x2 = x1+x;
		int y2 = y1+y;	
		
		g.drawImage(img, x, y, x2, y2, 0, 0, width, height,  null);
		
	}
	
	public boolean isSelected(double x, double y) {
		int w = getWidth();  //크기222   
		int h = getHeight(); //크기261		
		int x1 = getX();   //좌표500
		int y1 = getY();  //좌표500
		int x2 = x1+w/2;      
		int y2 = y1+h/2;
		 
		//(500 <= 500 && 500<=722) && (500<=500 && 500<=761)
		if((x1<x && x<x2) && (y1<y && y<y2)) 
			return true;
				
		return false;		
	}
	
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.img = tk.getImage(imgSrc);
		
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
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
	
	public void Play(String fileName, boolean loop) {
	      try {
	         AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
	         Clip clip = AudioSystem.getClip();
	         clip.stop();
	         clip.open(ais);
	         clip.start();
	         if (loop)
	            clip.loop(-1);
	         // Loop 값이true면 사운드재생을무한반복시킵니다.
	         // false면 한번만재생시킵니다.
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	
	
		
}
