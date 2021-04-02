package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame1.canvas.MiniGame1Canvas;

public class TimeOutGage {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private static Image img;
	
	TimeOutGageListener listener;
	
//	private double vx;
//	private double dx;
	
	private int timeIdx = 760*2;
	
	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame1Canvas/timeOutGage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TimeOutGage() {
		this(0,0);
	}
	
	public TimeOutGage(double x, double y) {
		this.x = x+180;
		this.y = y;
		width = img.getWidth(null);
		height = img.getHeight(null);
//		dx = width;
		
//		vx = timeIdx/Math.sqrt(dx*dx);
	}

	public void paint(Graphics g) {
		int x = (int) this.x-45;
		int y = (int) (this.y+(TimeOutBox.getInstance().getHeight()-height)/2)+10;
		int width = (int) this.width;
		int height = (int) this.height;
		g.drawImage(img, x, y, x+width, y+height, 
				0, 0, width, height, MiniGame1Canvas.instance);
	}

	public void update() {
	
		if(timeIdx > 0 ) {
			timeIdx--;
			width -=0.5;
			
		}
		
		else if(timeIdx == 0) {
			listener.timeOutBoxListener();
//			MiniGame1Canvas.setLifeCnt(MiniGame1Canvas.getLifeCnt()-1);
			timeIdx = 500*2;
			width = 500;
		}
			
		
		
		
	}

	public void setListener(TimeOutGageListener listener) {
		this.listener = listener;
	}

	
	


}
