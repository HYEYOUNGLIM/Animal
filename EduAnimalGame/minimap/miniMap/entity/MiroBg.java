package Game.miniMap.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniMap.canvas.MiroCanvas;


public class MiroBg {
	
	private static Image img;
	private int x;
	private int y;
//	private int reachX;
//	private int reachY;
	
	
	static {
		try {
			img = ImageIO.read(new File("res/miro1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MiroBg() {
		this(0,0);
	}
	
	public MiroBg(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.drawImage(img,x,y, MiroCanvas.instance);

	}
	
	public void update(Graphics g) {
		paint(g);
	}

}
