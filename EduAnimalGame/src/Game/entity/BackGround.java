package Game.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	private int width;
	private int height;
	
	private static Image img;
	
	static {
		try {
			img = ImageIO.read(new File("res/mini1background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BackGround() {
		this(0,0);
	}
	
	public BackGround(double x, double y) {
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	public void paint(Graphics g) {

		g.drawImage(img, 0,0,null);
	
		
	}

}
