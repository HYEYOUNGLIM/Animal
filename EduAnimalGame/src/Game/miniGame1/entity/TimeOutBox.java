package Game.miniGame1.entity;

import java.awt.Graphics;

public class TimeOutBox {

	
	private static TimeOutBox instance;
	private double x = 0;
	private double y = 600;
	
	private double width;
	private double height;
	
	private TimeOutImg timeOutImg;
	private TimeOutGage timeOutGage;
	
	TimeOutBoxListener timeOutBoxListener;
	public TimeOutBox() {
		this(1000,150);
	}
	public TimeOutBox(double width, double height) {
		instance = this;
		this.width = width;
		this.height = height;
		timeOutImg = new TimeOutImg(x,y);
		timeOutGage = new TimeOutGage(x,y);
		timeOutGage.setListener(new TimeOutGageListener() {
			
			@Override
			public void timeOutBoxListener() {
				timeOutBoxListener.boxLife();
				
			}
		});
		
	}
	public void paint(Graphics g) {
		int width = (int) this.width;
		int height = (int) this.height;
		//g.drawRect(0, 600, width, height);
		timeOutImg.paint(g);
		timeOutGage.paint(g);
		
	}
	public void update() {
		timeOutGage.update();
		
	}
	public static TimeOutBox getInstance() {
		return instance;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setTimeOutBoxListener(TimeOutBoxListener timeOutBoxListener) {
		this.timeOutBoxListener = timeOutBoxListener;
	}
	
	
	
	
	
	
	
	
	


}
