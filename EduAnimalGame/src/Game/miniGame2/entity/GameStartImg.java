package Game.miniGame2.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniGame1.canvas.MiniGame1Canvas;
import Game.miniGame2.canvas.MiniGame2Canvas;

public class GameStartImg {
	
	private double x;
	private double y;
	
	private double width;
	private double height;
	
	private Image img;
	
	public GameStartImg() {
		try {
			img = ImageIO.read(new File("res/img/miniGame2Canvas/gameStartImg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = img.getWidth(null)/7;
		height = img.getHeight(null);
		x = (1280-width)/2;
		y = (750-height)/2;
//		x = (MiniGame1Canvas.instance.getWidth()-width)/2;
//		y = (MiniGame1Canvas.instance.getHeight()-height)/2;
	}

	public void paint(Graphics g) {
		
		int imgIdx = MiniGame2Canvas.getStartIdx();
		if(imgIdx<=2) {
			int x = (int) this.x;
			int y = (int) this.y;
			int width = (int) this.width;
			int height = (int) this.height;
			g.drawImage(img, x, y, x+width, y+height, imgIdx*width, 0, imgIdx*width+width, height, MiniGame2Canvas.instance);
			MiniGame2Canvas.setStartIdx(imgIdx+1);
		}
		
		else if(imgIdx==3){
			
			int width = (int) this.width*7;
			int height = (int) this.height;
			int x = (int) ((1280-width)/2)+50;
			int y = (int) ((750-height)/2);
			g.drawImage(img, x+60, y, x+width, y+height, imgIdx*(img.getWidth(null)/8)+40, 0,(img.getWidth(null)/8)+width, height, MiniGame1Canvas.instance);
			MiniGame1Canvas.setStartIdx(imgIdx+1);
		}
			
		
	}
	
	

}
