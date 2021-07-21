package Game.miniGame2.entity;

import java.awt.Graphics;
import java.util.Random;

import Game.Animal.Canvas.GameCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;

public class GameBox {

	public static GameBox instance;
	private Boy boy;
	private RainLetter[] rainLetters;
	private int rainLetterCnt = 0;

	private double width;
	private double height;
	
	private Random rand;
	
	private int timeForMoving = 30;
	GameBoxListener listener;
	public GameBox() {
		this(1000,750);
	}
	public GameBox(double width, double height) {
		rand = new Random();
		this.width = width;
		this.height = height;
		instance = this;
		boy = new Boy();
		boy.setListener(new BoyEatListener() {
			
			@Override
			public void onEat(RainLetter rainLetter) {
				rainLetter.listener.onOut(rainLetter);
				
				int idx = rainLetter.getIdx();
		
				listener.onCheck(idx);
				
			}
		});
		rainLetters = new RainLetter[100];
		
	}
	public void paint(Graphics g) {
		boy.paint(g);
		for(int i=0; i<rainLetterCnt; i++)
			rainLetters[i].paint(g);
	}

	public void update() {
		timeForMoving--;
		boy.update();
		for(int i=0; i<rainLetterCnt; i++)
			rainLetters[i].update();
		if(timeForMoving==0) {
			RainLetter rainLetter = new RainLetter(boy);
			rainLetter.setListener(new RainLetterListener() {
				
				@Override
				public void onOut(RainLetter rainLetter) {
					int idx = 0;
					for(int i=0; i<rainLetterCnt; i++) {
						if(rainLetters[i] == rainLetter) {
							idx = i;
							break;
						}
					}
					
					for(int i = 0; i<rainLetterCnt-idx-1; i++) {
						rainLetters[idx+i] = rainLetters[idx+i+1];
					}
					rainLetterCnt--;	
				}
			});
			rainLetters[rainLetterCnt++]= rainLetter;
			timeForMoving = rand.nextInt(100)+60;
		}
		for(int i=0; i<rainLetterCnt; i++) {
			boy.checkEatLetter(rainLetters[i]);
		}
		
//		double boyX = boy.getX();
//		double boyY = boy.getY();
//		double boyWidth = boy.getWidth();
//		double boyHeight = boy.getHeight();
//		for(int i =0; i< rainLetterCnt; i++) {
//			
//		}
		
		
	}

	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void moveBoy(double x, double y) {
		boy.move(x,y);
		
	}

	public void setListener(GameBoxListener listener) {
		this.listener = listener;
	}
	public void stopBoy() {
		boy.stop();
		
	}
	
	
	
	

}
