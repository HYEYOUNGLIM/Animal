package Game.Animal.Canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Game.GameFrame;
import Game.Animal.Entity.Animal;
import Game.Animal.Entity.BackGround;
import Game.Animal.Entity.GameButton;
import Game.Animal.Entity.InfoBox;
import Game.Animal.Entity.UserCharacter;
import Game.introPage.canvas.IntroCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;

public class GameCanvas extends Canvas {

	public static GameCanvas instance;
	public static Animal[] animals;
	public static Animal currentAnimal;
	public static int[] animalIdx = new int[10];
	public static int animalSaveCnt = 0;

	public static int[] moveX = { 750, 500, 1000, 180, 900, 950, 600, 1050, 700, 400 };
	public static int[] moveY = { 400, 480, 300, 500, 200, 550, 300, 200, 150, 150 };
	public static String[] animalSrc = { "res/img/gameCanvasAnimal/dog.png", "res/img/gameCanvasAnimal/cat.png",
			"res/img/gameCanvasAnimal/horse.png", "res/img/gameCanvasAnimal/duck.png",
			"res/img/gameCanvasAnimal/tiger.png", "res/img/gameCanvasAnimal/lion.png",
			"res/img/gameCanvasAnimal/chicken.png", "res/img/gameCanvasAnimal/wolf.png",
			"res/img/gameCanvasAnimal/pig.png", "res/img/gameCanvasAnimal/monkey.png" };
	private boolean threadStatus = true;
	private BackGround background;
	private UserCharacter user;
	private GameButton backBtn;

	private String src;
	private int animalCnt;
	private InfoBox infoBox;

	public static int problemIdx;

	public GameCanvas() {
		instance = this;

		background = new BackGround();
		user = new UserCharacter(100, 650);
		backBtn = new GameButton(10, 10, 120, 120, "res/img/gameCanvasAnimal/backbtn.png");

		animalCnt = 10;
		animals = new Animal[animalCnt];
		animals[0] = new Animal(0, "개", moveX[0], moveY[0], "res/img/gameCanvasAnimal/dogBlack.png",
				"res/sound/dog.wav", 2);
		animals[1] = new Animal(1, "고양이", moveX[1], moveY[1], "res/img/gameCanvasAnimal/catBlack.png",
				"res/sound/cat.wav", 15);
		animals[2] = new Animal(2, "말", moveX[2], moveY[2], "res/img/gameCanvasAnimal/horseBlack.png",
				"res/sound/horse.wav", 1);
		animals[3] = new Animal(3, "오리", moveX[3], moveY[3], "res/img/gameCanvasAnimal/duckBlack.png",
				"res/sound/duck.wav", 6);
		animals[4] = new Animal(4, "호랑이", moveX[4], moveY[4], "res/img/gameCanvasAnimal/tigerBlack.png",
				"res/sound/tiger.wav", 20);
		animals[5] = new Animal(5, "사자", moveX[5], moveY[5], "res/img/gameCanvasAnimal/lionBlack.png",
				"res/sound/lion.wav", 8);
		animals[6] = new Animal(6, "닭", moveX[6], moveY[6], "res/img/gameCanvasAnimal/chickenBlack.png",
				"res/sound/chicken.wav", 3);
		animals[7] = new Animal(7, "늑대", moveX[7], moveY[7], "res/img/gameCanvasAnimal/wolfBlack.png",
				"res/sound/wolf.wav", 10);
		animals[8] = new Animal(8, "돼지", moveX[8], moveY[8], "res/img/gameCanvasAnimal/pigBlack.png",
				"res/sound/pig.wav", 12);
		animals[9] = new Animal(9, "원숭이", moveX[9], moveY[9], "res/img/gameCanvasAnimal/monkeyBlack.png",
				"res/sound/monkey.wav", 4);
		src = "";
		infoBox = new InfoBox(331, 552, "res/img/gameCanvasAnimal/infoBox.png");

		animalIdx = GameCanvas.getSaveIdx();

		for (int i = 0; i < animalSaveCnt; i++) {
			int index = animalIdx[i];
			animals[index].setImg(animalSrc[index]);
		}

//		for (int j = 0; j < animalCnt - 1; j++) {
//			for (int i = 0; i < animalCnt; i++)
//				if (this.animalIdx[j] == this.animals[i].getIdx())
//					animals[i].setImg(animalSrc[i]);
//		}

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				for (int i = 0; i < animalCnt; i++) {
					if (animals[i].isSelected(x, y)) {
						currentAnimal = animals[i];
						src = currentAnimal.getSoundSrc();
						currentAnimal.bark(src);
						int input = JOptionPane.showConfirmDialog(GameCanvas.this

								, currentAnimal.getAnimalName() + "선택되었어요~ 게임을 시작할까요??", "동물 선택",
								JOptionPane.OK_CANCEL_OPTION);
						if (input == JOptionPane.OK_OPTION) {
							problemIdx = currentAnimal.getIdx();
							try {
								// threadStatus = false;
								GameFrame.instance.switchCanvas(GameCanvas.this, MiniGame1Canvas.class);

							} catch (InstantiationException e2) {
								e2.printStackTrace();
							} catch (IllegalAccessException e2) {
								e2.printStackTrace();
							}
						}
					}
				}
				if (backBtn.contains(x, y)) {
					try {
						threadStatus = false;
						GameFrame.instance.switchCanvas(GameCanvas.this, IntroCanvas.class);
					} catch (InstantiationException e2) {
						e2.printStackTrace();
					} catch (IllegalAccessException e2) {
						e2.printStackTrace();
					}
				}

			}
		});

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = this.createImage(this.getWidth(), this.getHeight());
		Graphics bg = buf.getGraphics();

		background.paint(bg);
		user.paint(bg);

		for (int i = 0; i < animalCnt; i++)
			animals[i].paint(bg);

		backBtn.paint(bg);
		infoBox.paint(bg);
//		item.paint(bg);
//		item2.paint(bg);
		g.drawImage(buf, 0, 0, this);

	}

//	public void Play(String fileName, boolean loop) {
//		try {
//			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
//			Clip clip = AudioSystem.getClip();
//			clip.stop();
//			clip.open(ais);
//			clip.start();
//			if (loop)
//				clip.loop(-1);
//
//			// Loop 값이true면 사운드재생을무한반복시킵니다.
//
//			// false면 한번만재생시킵니다.
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//	}

	public void start() {

		Runnable sub = new Runnable() {

			@Override
			// 새로운 main 함수
			public void run() {

				while (threadStatus) {

					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};
		Thread th = new Thread(sub);
		th.start();
	}

	public Animal[] getAnimals() {
		return animals;
	}

	public void setAnimals(Animal[] animals) {
		this.animals = animals;
	}

	public static void setSaveIdx(int problemIdx) {
		
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("res/animalIdx.txt",true);
				PrintStream out = new PrintStream(fos,true,"UTF-8");
				out.print(problemIdx);
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//		animalIdx[animalSaveCnt]=problemIdx;
//		animalSaveCnt++;
	}

	public static int[] getSaveIdx() {
		int[] temp = null;
		try {
			FileInputStream fis = new FileInputStream("res/animalIdx.txt");
			Scanner scan = new Scanner(fis);
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] tokens = line.split("");
				int[] idxs = new int[tokens.length];
				for(int i=0; i<tokens.length; i++)
					idxs[i] = Integer.parseInt(tokens[i]);
				temp = idxs;
				animalSaveCnt = tokens.length;
				
			}
			scan.close();
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

}
/*
 * @Override
 * 
 * public boolean mouseDown(Event evt, int x, int y) {
 * 
 * if (monkey.isSelected(x, y)) monkey.bark("sound/monkey.wav"); if
 * (duck.isSelected(x, y)) duck.bark("sound/duck.wav"); if (cat.isSelected(x,
 * y)) cat.bark("sound/cat.wav"); if (dog.isSelected(x, y))
 * dog.bark("sound/dog.wav"); if (chicken.isSelected(x, y))
 * chicken.bark("sound/chicken.wav"); if (horse.isSelected(x, y))
 * horse.bark("sound/horse.wav"); if (pig.isSelected(x, y))
 * pig.bark("sound/pig.wav"); if (tiger.isSelected(x, y))
 * tiger.bark("sound/tiger.wav"); if (wolf.isSelected(x, y))
 * wolf.bark("sound/wolf.wav");
 * 
 * System.out.println("x: " + x + "y: " + y);
 * 
 * // System.out.printf("%d  %d\n", x, y); return super.mouseDown(evt, x, y); }
 */

// animals[0].bark("sound/monkey.wav");
// else if (animals[1].isSelected(x, y))
// animals[1].bark("sound/duck.wav");
// else if (cat.isSelected(x, y))
// cat.bark("sound/cat.wav");
// else if (dog.isSelected(x, y))
// dog.bark("sound/dog.wav");
// else if (chicken.isSelected(x, y))
// chicken.bark("sound/chicken.wav");
// else if (horse.isSelected(x, y))
// horse.bark("sound/horse.wav");
// else if (pig.isSelected(x, y))
// pig.bark("sound/pig.wav");
// else if (tiger.isSelected(x, y))
// tiger.bark("sound/tiger.wav");
// else if (wolf.isSelected(x, y))
// wolf.bark("sound/wolf.wav");
// duck.paint(bg);
// cat.paint(bg);
// dog.paint(bg);
// chicken.paint(bg);
// horse.paint(bg);
// pig.paint(bg);
// tiger.paint(bg);
// wolf.paint(bg);
// monkey.paint(bg);
// lion.paint(bg);
