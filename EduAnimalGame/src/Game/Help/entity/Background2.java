package Game.Help.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import Game.Help.Canvas.HelpCanvas;

public class Background2 {
	private int x;
	private int y;
	private Image img;	
	private String imgSrc;

//	static {
//		try {
//			img = ImageIO.read(new File("res/1.jpg"));
//		} catch (IOException e) {		
//			e.printStackTrace();
//		}
//	}
	public Background2() {
		this(0, 0);
	}

	public Background2(int x, int y) {//배경음악 백그라운드 초기화시 생성
		this.x = x;
		this.y = y;
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage(imgSrc);

	}	

	public void paint(Graphics g) {
		
		g.drawImage(img, x, y, HelpCanvas.instance);

	}
	
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage(imgSrc);			
		
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
}
