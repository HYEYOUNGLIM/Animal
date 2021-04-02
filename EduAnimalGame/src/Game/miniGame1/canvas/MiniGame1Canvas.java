package Game.miniGame1.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Game.GameFrame;
import Game.Animal.Canvas.GameCanvas;
import Game.miniGame1.entity.AnswerImg;
import Game.miniGame1.entity.BackGround;
import Game.miniGame1.entity.GameStartImg;
import Game.miniGame1.entity.LetterBox;
import Game.miniGame1.entity.LifeBox;
import Game.miniGame1.entity.PictureBox;
import Game.miniGame1.entity.TimeOutBox;
import Game.miniGame1.entity.TimeOutBoxListener;
import Game.miniGame1.entity.WrongSound;
import Game.miniGame2.canvas.MiniGame2Canvas;

public class MiniGame1Canvas extends Canvas {

	public static Canvas instance;
	private LetterBox letterBox; // LetterBox에게 영역을 위임
	private PictureBox pictureBox;
	private int problemIdx;
	private int problemCnt = 10;
	private Random rand;
	private BackGround backGround;
	private static int startIdx;
	private LifeBox lifeBox;
	private TimeOutBox timeOutBox;
	private static int lifeCnt;

	final private int WRONG = 0;
	final private int ANSWER = 1;

	private WrongSound wrongSound;

	private AnswerImg answerImg;

	private GameStartImg gameStartImg;
	
	private boolean playThread = true; 

	public MiniGame1Canvas() {
	
		instance = this;
		startIdx = 0;
		lifeCnt = 5;
		wrongSound = new WrongSound();
		rand = new Random();
		problemIdx = GameCanvas.problemIdx;
		answerImg = new AnswerImg(problemIdx);
		// answerImgs = new AnswerImg(problemIdx);
		letterBox = new LetterBox(1000, 600);
		backGround = new BackGround();
		pictureBox = new PictureBox(280, 600);
		lifeBox = new LifeBox(300, 150);

		gameStartImg = new GameStartImg();
		timeOutBox = new TimeOutBox(1000, 150);
		timeOutBox.setTimeOutBoxListener(new TimeOutBoxListener() {
			
			@Override
			public void boxLife() {
				lifeCnt--;
				
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int check = letterBox.check(x, y);
				switch (check) {
				case WRONG:
					wrongSound.start();
					lifeCnt--;
					break;
				case ANSWER:
					answerImg.setVisible();
					answerImg.bark();
					
					break;
				default:
					break;
				}
//				if(check) {
//					//letterBox.remove();
//					answerImg.setVisible();
//					repaint();
//				}
//				else {
////					System.out.println("틀렸습니다!");
//					
//				}

			}
		});
	}

	@Override
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), this.getHeight());
		Graphics bg = buf.getGraphics();

		backGround.paint(bg);

		letterBox.paint(bg);
		pictureBox.paint(bg);
		if (startIdx <= 3) {
			gameStartImg.paint(bg);
		}
		timeOutBox.paint(bg);
		lifeBox.paint(bg);

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
				GameFrame.instance.switchCanvas(MiniGame1Canvas.this, MiniGame2Canvas.class);
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}

	public void start() {

		// 람다
		Runnable sub = () -> {
			while (playThread) {
				

				if (startIdx <= 3)
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else {

					letterBox.update();
					timeOutBox.update();

				}
				// currentBoy.update();
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

//		Runnable sub = new Runnable() {
//			public void run() {
//				while (true) {
//					for (int i = 0; i < itemSize; i++)
//						items[i].update();
//					// currentBoy.update();
//					repaint();
//					try {
//						Thread.sleep(17); // 대략 60fps
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//
//			}
//		};
		Thread th = new Thread(sub);
		th.start();

	}

	

	public static void setLifeCnt(int lifeCnt) {
		MiniGame1Canvas.lifeCnt = lifeCnt;
	}

	

	public static int getStartIdx() {
		return startIdx;
	}

	public static void setStartIdx(int startIdx) {
		MiniGame1Canvas.startIdx = startIdx;
	}

	public static int getLifeCnt() {
		return lifeCnt;
	}

}
