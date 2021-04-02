package Game.miniMap.entity.miro2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Game.Animal.Canvas.GameCanvas;
import Game.miniMap.canvas.MiroCanvas;

public class MiroWord2 {

	private static Image img;
	private double x;
	private double y;
	// private boolean isCorrect;
	private int width = 60;
	private int height = 60;
	// private int arrayIndex = 0;
	// private static int startIdx = 0;
	private int order = 0;
	private static int idx = GameCanvas.problemIdx;
	// private int type;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	static {

		if (idx == 0) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroDog.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else if (idx == 1) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroCat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (idx == 2) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroHorse.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 3) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroDuck.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 4) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroTiger.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 5) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroLion.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 6) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroChicken.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 7) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroWolf.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 8) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroPig.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (idx == 9) {

			try {
				img = ImageIO.read(new File("res/img/miroCanvas/miroArrayWord/miroMonkey.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public MiroWord2() {
		this(0);
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public MiroWord2(int i) {
		if (i == 0) {
			this.x = 485;
			this.y = 140;
			this.order = 0;
		} else if (i == 1) {
			this.x = 926;
			this.y = 151;
			this.order = 1;
		} else if (i == 2) {
			this.x = 1125;
			this.y = 151;
			this.order = 2;
		} else if (i == 3) {
			this.x = 938;
			this.y = 318;
			this.order = 2;
		} else if (i == 4) {
			this.x = 789;
			this.y = 326;
			this.order = 3;
		} else if (i == 5) {
			this.x = 121;
			this.y = 326;
			this.order = 4;
		} else if (i == 6) {
			this.x = 769;
			this.y = 564;
			this.order = 4;
		}
		// (490,151)
		// (926,151)
		// (1125,151)
		// (938,318)
		// (789,326)
		// (121,326)
		// (769,564)
	}

	public void paint(Graphics g, int i) {

		int w = this.width;
		int h = this.height;

		g.drawImage(img, (int) x, (int) y, (int) x + w, (int) y + h, w * i, 0, w + w * i, h, MiroCanvas.instance);

	}

	public boolean isSelect(double x, double y) {

		int w = this.width;
		int h = this.height;
		double x2 = this.x + w;
		double y2 = this.y + h;

		if ((this.x < x && x < x2) && (this.y < y && y < y2))
			return true;
		return false;
	}

//	public void update() {
//	}
//
//	
//	public void remove() {
//		
//		
//	}

	public void play(String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
