package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame1.canvas.MiniGame1Canvas;

public class Picture {
	
	private static Image img;
	private int idx;
	
	private static double width;
	private static double height;
	
	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame1Canvas/pictureAnimal.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = img.getWidth(null)/PictureBox.getPictureCnt();
		height = img.getHeight(null);
		
	}
	public Picture() {
		this(0);
	}
	public Picture(int idx) {
		this.idx = idx;
	}
	public void paint(Graphics g) {
		
		int x = (int) (PictureBox.instance.getX()+(PictureBox.instance.getWidth()-width)/2);
		int y = (int) (PictureBox.instance.getY()+50);
		
		int w = (int) width;
		int h = (int) height;
		
		int offSetX = idx*w;
		g.drawImage(img, x, y, x+w, y+h, 
				offSetX, 0, offSetX+w, h, MiniGame1Canvas.instance);
	}
	

}
