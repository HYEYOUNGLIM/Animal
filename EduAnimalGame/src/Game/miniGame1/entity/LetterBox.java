package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import Game.Animal.Canvas.GameCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;

public class LetterBox {
	
	public static LetterBox instance;
	private Letter[] letters;
	private static int letterCnt = 10;

	private double width;
	private double height;
	

	private Random rand;

	public LetterBox() {
		this(1000,600);
	}
	
	public LetterBox(double width, double height) {
		instance = this;
		rand = new Random();
	
		this.width = width;
		this.height = height;
		letters = new Letter[letterCnt];

		int w = (int) (LetterBox.instance.getWidth() - Letter.getWidth());
		int h = (int) (LetterBox.instance.getHeight() - Letter.getHeight());

		for(int i=0; i<letters.length; i++) {
			int index = i;
			letters[i] = Letter.getCompareLetters()[i];
			letters[i].setLetterMoveListener(new LetterMoveListener() {
				int x = rand.nextInt(w);
				int y = rand.nextInt(h);
				@Override
				public void onMove() {
					letters[index].move(x, y);
					//letters[index].update();
					
				}
			});
		}
	}

	public void paint(Graphics g) {
		int width = (int) this.width;
		int height = (int) this.height;
		//g.drawRect(0, 0, width, height);
		for(int i=0; i< letters.length; i++)
			letters[i].paint(g);
	}

	
	public void update() {
	
		for(int i=0; i<letters.length; i++) {
			letters[i].update();
//			for (int j = 0; j < i; j++) {
//				if (((letters[j].getX() - letters[j].getWidth() < letters[j].getX() && letters[j].getX() < letters[j].getX() + letters[j].getWidth())
//					&& (letters[j].getY() - letters[j].getHeight() < letters[j].getY() && letters[j].getY() < letters[j].getY() + letters[j].getHeight()))) {
//					i--;
//					break;
//				}
//			}
		}
//			for (int j = 0; j < letters.length; i++) {
//			
//			for (int j = 0; j < i; j++) {
//				if ((
//					(int)letters[j].getX()-letters[j] < x && x < (int)stars[j].getX()+weight) 
//					&&
//					(stars[j].getY()-height < y && y < (int)stars[j].getY()+height)) {
//					i--;
//					break;
//				}
//
//			}
//		}
		
		
		
		
	}
	


	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public static int getLetterCnt() {
		return letterCnt;
	}

	public int check(int x, int y) {
		if(x>width || x<0 || y>height || y<0)
			return 2;
		int problemIdx = GameCanvas.problemIdx;
		for(int i=0; i<letterCnt; i++) {
			if(letters[i].getIdx() == problemIdx) {
				return letters[i].check(x,y);
			}
		}
		return 2;
	}

	public void remove() {
		int[] temp = new int[letterCnt-1];
		int problemIdx = GameCanvas.problemIdx;
		int j=0;
		Letter[] tempLetter = new Letter[letterCnt-1];
		for(int i=0; i<letterCnt; i++) {
			if(letters[i].getIdx() != problemIdx) {
				temp[j] = i;
				j++;
			}
		}
		letterCnt--;
		int w = (int) (LetterBox.instance.getWidth() - Letter.getWidth());
		int h = (int) (LetterBox.instance.getHeight() - Letter.getHeight());
		for(int i=0; i<letterCnt; i++) {
			int idx = temp[i];
			tempLetter[i] = letters[idx];
			int index = i;
			tempLetter[i].letterMoveListener = (()->{
				int x= rand.nextInt(w);
				int y = rand.nextInt(h);
				tempLetter[index].move(x,y);
			});
		}
		letters = tempLetter;
		
	}

	
	

}
