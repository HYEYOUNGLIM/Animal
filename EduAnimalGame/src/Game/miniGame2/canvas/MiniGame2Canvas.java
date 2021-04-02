package Game.miniGame2.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.GameFrame;
import Game.Animal.Canvas.GameCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;
import Game.miniGame1.entity.AnswerImg;
import Game.miniGame1.entity.PictureBox;
import Game.miniGame1.entity.WrongSound;
import Game.miniGame2.entity.BackGround;
import Game.miniGame2.entity.GameBox;
import Game.miniGame2.entity.GameBoxListener;
import Game.miniGame2.entity.GameStartImg;
import Game.miniGame2.entity.Left;
import Game.miniGame2.entity.LifeBox;
import Game.miniGame2.entity.Right;
import Game.miniMap.canvas.MiroCanvas;

public class MiniGame2Canvas extends Canvas {
	public static Canvas instance;
	private GameBox gameBox;
	private BackGround backGround;
	private LifeBox lifeBox;
	private PictureBox pircutreBox;
	private Right right;
	private Left left;
	private GameStartImg gameStartImg;
	private static int startIdx;
	
	private WrongSound wrongSound;

	private AnswerImg answerImg;
	private boolean playThread = true;
	public MiniGame2Canvas() {
		startIdx=0;
		instance = this;
		backGround = new BackGround();
		wrongSound = new WrongSound();
		int problemIdx =GameCanvas.problemIdx;
		answerImg = new AnswerImg(problemIdx);
		gameBox = new GameBox();
		gameBox.setListener(new GameBoxListener() {
			
			@Override
			public void onCheck(int index) {
				if(problemIdx == index) {
					answerImg.setVisible();
					answerImg.bark();
				}
				else {
					wrongSound.start();
					MiniGame1Canvas.setLifeCnt(MiniGame1Canvas.getLifeCnt()-1);
				}
				
			}
		});
		lifeBox = new LifeBox(300, 150);
		pircutreBox = new PictureBox();
		right = new Right(1000-85,750-83);
		left = new Left(0,750-83);
		gameStartImg = new GameStartImg();
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				gameBox.stopBoy();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				double x = e.getX();
				double y = e.getY();
				gameBox.moveBoy(x,y);
					
				
			}
			
		});
//		addKeyListener(new KeyAdapter() {
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int key = e.getKeyCode();
//				gameBox.moveBoy(key);
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				gameBox.moveBoy(0);
//			}
//		});
		
		
	}
	


	public void start() {

		// 람다
		Runnable sub = () -> {
			while (playThread) {
				if (startIdx <= 3) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
					
					
				else {

					gameBox.update();
				}
				repaint();
				if (startIdx == 3) {
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startIdx++;
				}
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

		backGround.paint(bg);
		
		gameBox.paint(bg);
		lifeBox.paint(bg);
		pircutreBox.paint(bg);
		right.paint(bg);
		left.paint(bg);
		if (startIdx <= 3) {
			gameStartImg.paint(bg);
		}
		if (answerImg.visible()) {
			answerImg.paint(bg);
		}
		g.drawImage(buf, 0, 0, this);
		if (answerImg.visible()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				playThread = false;
				GameFrame.instance.switchCanvas(MiniGame2Canvas.this, MiroCanvas.class);
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}



	public static int getStartIdx() {
		
		return startIdx;
	}



	public static void setStartIdx(int startIdx) {
		MiniGame2Canvas.startIdx = startIdx;
		
	}


}
