package Game.miniMap.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import Game.entity.BoyReachListner;
import Game.miniMap.canvas.MiroCanvas;
import Game.miniMap.entity.miro1.Picture1;

public class Boy {

	private Picture1 picture;

	public static Boy instance;
	private static Image img;
	private double x;
	private double y;
	private int width = 256;
	private int height = 384;
	private final int right = 3;
	private final int left = 2;
	private final int up = 1;
	private final int down = 0;

	// 애니메이션을 위한 변수
	private double vx;
	private double vy;
	private double dx;
	private double dy;

	private int movIndex = 0;
	private int speed = 1;
	private int walkTempo = 6;

	public int getMovIndex() {
		return movIndex;
	}

	public void setMovIndex(int movIndex) {
		this.movIndex = movIndex;
	}

	public int getWalkTempo() {
		return walkTempo;
	}

	public void setWalkTempo(int walkTempo) {
		this.walkTempo = walkTempo;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

//   private BoyReachListner reachListner;

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	static {
		try {
			img = ImageIO.read(new File("res/img/miroCanvas/boy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//   public void setReachListner(BoyReachListner reachListner) {
//      this.reachListner = reachListner;
//   }

	public Boy() {

		this(0, 0);
		instance = this;
	}

	public Boy(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void move(double x, double y) {

		this.dx = x;
		this.dy = y;

	}

	public void paint(Graphics g) {

		int w = this.width / 4;
		int h = this.height / 4;
		double x1 = this.x - w / 2;
		double y1 = this.y - h / 2;
		int direct = 0; // j를 방향이라는 영어변수로 바꿔주기

		if (dx != 0 || dy != 0) {
			if (dx != 0) {
				if (dx > x) {
					direct = right;// final로 바꾸기 right
				}
				if (dx < x) {
					direct = left;// final로 바꾸기 left
				}
			}
			if (dy != 0) {
				if (dy < y) {
					direct = up;// final로 바꾸기 up
				}
				if (dy > y) {
					direct = down;// final로 바꾸기 down
				}
			}
			if (walkTempo == 0) {
				movIndex++;
				movIndex = movIndex % 4;

				walkTempo = 6;
			} else
				walkTempo--;
		}

		int offsetX = movIndex * w;

		g.drawImage(img, (int) x1, (int) y1, (int) x1 + w, (int) y1 + h, 0 + offsetX, h * direct, 0 + w + offsetX,
				h + direct * h, MiroCanvas.instance);

		setWalkTempo(walkTempo);
		setMovIndex(movIndex);

	}

//   public boolean aaa() {
//      int picX_min = (int) picture.getX();
//      int picY_min = (int) picture.getY();
//      int picX_max = picX_min + picture.getWidth();
//      int picY_max = picY_min + picture.getHeight();
//      if((picX_min < x && x < picX_max) && (picY_min < x && x <
//             picY_max)) {
//         return true;
//      }
//      
//      return false;
//   }

	public void update() {

		if (dx != 0) {
			if (dx > x) {
				this.x = x + speed;
			}

			else if (dx < x) {
				this.x = x - speed;
			}

		}

		if (dx == x) {
			// setDx(dx);
			dx = 0;
		}
		if (dy != 0) {
			if (dy > y) {
				this.y = y + speed;
			}

			else if (dy < y) {
				this.y = y - speed;
			}

		}
		if (dy == y) {
			// setDy(dy);
			dy = 0;

		}

	}

}