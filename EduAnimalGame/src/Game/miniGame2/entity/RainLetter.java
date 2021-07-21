package Game.miniGame2.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Game.miniGame2.canvas.MiniGame2Canvas;

public class RainLetter {
	
	private static Image img;
	private double x;
	private double y;
	
	private int idx;
	
	private double width;
	private double height;
	

	private int speed = 2;
	private Random rand;

	RainLetterListener listener;

	
	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame2Canvas/mini2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public RainLetter() {
		this(0);
	}

	public RainLetter(int idx) {
//		width = img.getWidth(null)/10;
//		height = img.getHeight(null);
//		rand = new Random();
//		this.x = rand.nextInt((int) (1000-width));
//		this.y = 0;
//		this.idx =rand.nextInt(10);
		this(null);
	}


	
	public RainLetter(Boy boy) {
		double boyX = boy.getX();
		double boyWidth = boy.getWidth();
		width = img.getWidth(null)/10;
		height = img.getHeight(null);
		rand = new Random();
		
		
		// ÃÖ´ñ°ª 1000-width - > 980;
		// ÃÖ¼Ú°ª boyX-200-width - > 600;
		
		// boyX +width - > 810
		// ratter x + width - > 610;
		this.y = 0;
		this.idx =rand.nextInt(10);
		
		if(boyX <= 150+width) {
			this.x = rand.nextInt((int)boyX+(int)boyWidth+150);
		}
		else if(boyX+boyWidth >= 1000-150-width) {
			int max = (int) (GameBox.instance.getWidth() - this.width);
			int min = (int) (boyX-150-width);
			this.x = rand.nextInt(max-min+1)+min;
		}
		else {
			int max = (int) (boyX+boyWidth+150);
			int min = (int) (boyX-150-width);
			this.x = rand.nextInt(max-min+1)+min;
		}
		speed = rand.nextInt(7)+1;
		
		
	}

	public void paint(Graphics g) {
		int x = (int) this.x;
		int y = (int) this.y;
		int width = (int)this.width;
		int height = (int)this.height;
		
		int offsexX = idx * width;
		g.drawImage(img, x, y, x+width, y+height, offsexX, 0, offsexX + width, height, MiniGame2Canvas.instance);
		
	}

	public void update() {		

		this.y+=1*speed;
		if(y >= 750-height) {
			if(listener != null)
				listener.onOut(this);
		}
	}

	public void setListener(RainLetterListener listener) {
		this.listener = listener;
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

	public int getIdx() {
		return idx;
	}
	
	


	

}
