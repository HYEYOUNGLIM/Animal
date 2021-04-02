package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Game.miniGame1.canvas.MiniGame1Canvas;

public class Letter {

	// Letter 안에 Letter[] 넣어서 +vx,+vy 충돌비교
	// 1. NaN
	// 2. 랜덤값 영역 - > 떨림 - > 충돌한 글자 + 자기자신 방향?
	// 3. 갈 곳이 없을때 (글자들 사이에 있을 경우 무한루프) -> 쓰레드 -> 어차피 동기화해야함 -> 의미X - > 제한을 둔다? 

	private static Image img;
	private static Letter[] compareLetters;
	private int idx;
	//private int col;

	private double x;
	private double y;
	private static double width;
	private static double height;

	// 애니메이션을 위한 변수
	private double vx;
	private double vy;
	private double dx;
	private double dy;


	//private int movIndex = 0;
	private int timeoutForMoving = 1;

	//private int walkTempo = 6;
	private int speed = 3;

	private static Random rand;
	LetterMoveListener letterMoveListener;

	static {
		try {
			img = ImageIO.read(new File("res/img/miniGame1Canvas/kor3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int letterCnt = LetterBox.getLetterCnt();
		compareLetters = new Letter[letterCnt];

		for (int i = 0; i < letterCnt; i++)
			compareLetters[i] = new Letter();

		width = img.getWidth(null) / 10;
		height = img.getHeight(null);

		int w = (int) (LetterBox.instance.getWidth() - width);
		int h = (int) (LetterBox.instance.getHeight() - height);
		rand = new Random();
		for (int i = 0; i < letterCnt; i++) {
			int idx = rand.nextInt(letterCnt);
			int x = rand.nextInt(w);
			int y = rand.nextInt(h);
			compareLetters[i].x = x;
			compareLetters[i].y = y;
			compareLetters[i].idx = idx;
			for (int j = 0; j < i; j++) {
				if ((compareLetters[j].idx == idx)
						|| ((compareLetters[j].x - width < x && x < compareLetters[j].x + width)
								&& (compareLetters[j].y - height < y && y < compareLetters[j].y + height))) {
					i--;
					break;
				}

			}
		}
	}

	public Letter() {

	}

	public Letter(int i) {
		this.x = compareLetters[i].x;
		this.y = compareLetters[i].y;
		this.idx = compareLetters[i].idx;
	}

	public void paint(Graphics g) {

		int x = (int) (this.x);
		int y = (int) (this.y);

		int width = (int) this.width;
		int height = (int) this.height;

		int offsexX = idx * width;
		g.drawImage(img, x, y, x + width, y + height, offsexX, 0, offsexX + width, height, MiniGame1Canvas.instance);

	}

	public void move(double x, double y) {

		
		dx = x;
		dy = y;

//		if (Double.isNaN(dx)) {
//			dx = this.x + 1;
//			System.out.println("DX NaN");
//
//		}
//
//		if (Double.isNaN(dy)) {
//			dy = this.y + 1;
//			System.out.println("DY NaN");
//		}

		// System.out.println("move 호출");
//		 동일한 속도로 이동하는 단위벡터
		double w = x - this.x;
		double h = y - this.y;
		
//		if(w==0)
//			w=1;
//		if(h==0)
//			h=1;
		
		double d = Math.sqrt(w * w + h * h);

		vx = w / d * speed;
		vy = h / d * speed;

//		if (Double.isNaN(vx)) {
//			vx = rand.nextInt(3);
//			//vx= w / 1 * speed;
//
//			System.out.println("VX : NaN");
//
//		}
//
//		if (Double.isNaN(vy)) {
//			//vy=h / 1 * speed;
//
//			vy = rand.nextInt(3);
//			System.out.println("VY : NaN");
//		}

//		if (w > 0) {
//			if (h > 0) {
//
//			} else if (h < 0) {
//
//			}
//
//		}
//
//		else if (w < 0) {
//			if (h > 0) {
//
//			} else if (h < 0) {
//
//			}
//
//		}

//
//		if (Double.isNaN(vx)) {
//			System.out.println(idx + "NAN");;
//		}
//		if (Double.isNaN(vy)) {
//			System.out.println(idx+"NAN");
//		}
//		 동일한 시간내에 이동하는 단위벡터
//		 vx = (this.dx - this.x) / 15;
//		 vy = (this.dy - this.y) / 15;

	}

	public int getIdx() {

		return idx;
	}

	public static double getWidth() {
		return width;
	}

	public static double getHeight() {
		return height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void update() {
		timeoutForMoving--;
		int w = (int) (LetterBox.instance.getWidth() - width);
		int h = (int) (LetterBox.instance.getHeight() - height);

		if (timeoutForMoving == 0) {
			int x = rand.nextInt(w);
			int y = rand.nextInt(h);
			move(x, y);
			timeoutForMoving = rand.nextInt(500)+800;
		}

//		if (checkCollision()) {
//			
//			if(compareLetters[col].dx -compareLetters[col].x >0)
//				compareLetters[col].x-=10;
//			if(compareLetters[col].dx -compareLetters[col].x <0)
//				compareLetters[col].x+=10;
//			if(compareLetters[col].dy -compareLetters[col].y >0)
//				compareLetters[col].y-=10;
//			if(compareLetters[col].dy -compareLetters[col].y >0)
//				compareLetters[col].y+=10;
//			if(dx-x>0) 
//				x-=10;
//				
//			if(dx-x<0)
//				x+=10;
//			
//			if(dy-y>0) 
//				y-=10;
//			
//			if(dy-y<0)
//				y+=10;

//			compareLetters[col].x +=10;

//			vx=0;
//			vy=0;
//			move(x-20,y-20);
//			x-=20;
//			y-=20;
//			compareLetters[col].move(x+20, x+20);
//			timeoutForMoving = 120;

		// }

		if (this.x > w || this.y > h || this.x < 0 || this.y < 0) {
			
			letterMoveListener.onMove();
//			int x = rand.nextInt(w);
//			int y = rand.nextInt(h);
//			move(x,y);
		}

//		if (checkCollision(this.x, this.y)) {
//			double x1;
//			double y1;
//			double x2;
//			double y2;
//			int i = 0;
//			do {
//				x1 = this.x;
//				y1 = this.y;
//
//				if (x1 > compareLetters[col].x) {
//					if(x1>=w)
//						x1=w-1;
//					else
//						x1 = rand.nextInt((int) w - (int) x1 + 1) + x1;
////					if(x1<=0)
////						x1=1;
////					else
////						
//
//				}
//
//				else if (x1 < compareLetters[col].x) {
////					if(x1==w)
////						x1=w-1;
////					else
//					if (x1 <= 0)
//						x1 = 0;
//					else
//						x1 = rand.nextInt((int) x1 + 1);
//
//				}
//
//				if (y1 > compareLetters[col].y) {
////					if(y1<=0)
////						y1=1;
////					else
//					if (y1 >= h)
//						y1 = h-1;
//					else
//						y1 = rand.nextInt((int) h - (int) y1 + 1) + y1;
//
//				}
//
//				else if (y1 < compareLetters[col].y) {
////					if(y1==h)
////						y1=h-1;
////					else
//					if (y1 <= 0)
//						y1 = 0;
//					else
//						y1 = rand.nextInt((int) y1 + 1);
//
//				}
//
//					move(x1, y1);
//				System.out.println(idx);
//				i++;
//				if (i > 20) {
//					i = 0;
//					break;
//				}
//
//			} while (checkCollision(x1 + vx, y1 + vy));

			// if(x+vx y+vy 충돌시 다시 랜덤 move)
//			compareLetters[col].x = compareLetters[col].x+vx;
//			compareLetters[col].y = compareLetters[col].y+vy;
//		}

		this.x += vx;
		this.y += vy;

	}

//	public boolean checkCollision(double x, double y) {
//		for (int i = 0; i < compareLetters.length; i++) {
//			if (idx != compareLetters[i].idx) {
//				if (((compareLetters[i].x - width < x && x < compareLetters[i].x + width)
//						&& (compareLetters[i].y - height < y && y < compareLetters[i].y + height))) {
//
//					col = compareLetters[i].idx;
//					System.out.println("충돌 idx : " + col);
//
//					return true; // 충돌
//				}
//
//			}
//		}
//		return false;
//
//	}

	public static Letter[] getCompareLetters() {
		return compareLetters;
	}

	public void setLetterMoveListener(LetterMoveListener letterMoveListener) {
		this.letterMoveListener = letterMoveListener;
	}

	public int check(int x, int y) {
		if((this.x<x && x<this.x+width) &&
				(this.y<y && y<this.y+height))
			return 1;
		return 0;
	}

}
