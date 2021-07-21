package Game.miniGame3.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class MiniGame3Canvas extends Canvas {
	
	public static Canvas instance;
	public MiniGame3Canvas() {
		instance = this;
	}
	
	public void start() {

		// 람다
		Runnable sub = () -> {
			while (true) {
				//gameBox.update();
				repaint();
				try {
					Thread.sleep(17); // 대략 60fps
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread th = new Thread(sub);
		th.start();

	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), this.getHeight());
		Graphics bg = buf.getGraphics();

		
		g.drawImage(buf, 0, 0, this);
	}

}
