package Game.miniGame2.entity;

import java.awt.Graphics;

public class LifeBox {

	private static LifeBox instance;
	private double x = 980;
	private double y = 600;
	private double width;
	private double height;
	
	private Life life;
	
	public LifeBox() {
		this(280,150);
	}

	public LifeBox(double width, double height) {
		instance = this;
		this.width = width;
		this.height = height;
		life = new Life(x,y);
		
	}

	public void paint(Graphics g) {
		life.paint(g);
	}

	public static LifeBox getInstance() {
		return instance;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	
	
	
	
	
	
}
