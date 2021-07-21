package Game.Help.Canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.GameFrame;
import Game.Help.entity.BackButton;
import Game.Help.entity.Background2;
import Game.introPage.canvas.IntroCanvas;

public class HelpCanvas extends Canvas{
	
	public static HelpCanvas instance;
	private BackButton nextButton;
	private BackButton backButton;
	private BackButton homeButton;
	private BackButton[] button;
	
	private Background2 helpImg;	
	private String[] imgSrc;
	private String[] buttonSrc;
	private int onPress;
	public HelpCanvas() {
		instance = this;
		button = new BackButton[3];
		imgSrc = new String[] {"res/img/helpCanvas/page.png", "res/img/helpCanvas/page2.png", "res/img/helpCanvas/page3.png", 
							  "res/img/helpCanvas/page4.png", "res/img/helpCanvas/page5.png", "res/img/helpCanvas/page6.png", "res/img/helpCanvas/page7.png"}; 		
		buttonSrc = new String[] {"res/img/helpCanvas/back.png", "res/img/helpCanvas/home.png", "res/img/helpCanvas/next.png"};
		helpImg = new Background2();
		helpImg.setImgSrc(imgSrc[0]);
		backButton = new BackButton();
		nextButton = new BackButton();
		homeButton = new BackButton();
		button[0] = backButton;
		button[1] = homeButton;
		button[2] = nextButton;
		for(int i=0; i<3; i++) {
			button[i].setImgSrc(buttonSrc[i]);
			button[i].setX(10+(i*120));
			button[i].setY(10);
			button[i].setWidth(200);
			button[i].setHeight(200);
		}
//		backButton.setImgSrc("res/back.png");
//		backButton.setX(10);
//		backButton.setY(10);
//		backButton.setWidth(200);
//		backButton.setHeight(200);
//		nextButton.setImgSrc("res/next.png");
//		nextButton.setX(250);
//		nextButton.setY(10);
//		nextButton.setWidth(200);
//		nextButton.setHeight(200);
//		homeButton.setImgSrc("res/home.png");
//		homeButton.setX(130);
//		homeButton.setY(10);
//		homeButton.setWidth(200);
//		homeButton.setHeight(200);
		
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {				
				int x = e.getX();
				int y = e.getY();
				
				if(nextButton.isSelected(x, y)) {
					if(0 <= onPress && onPress <6) {
						helpImg.setImgSrc(imgSrc[onPress+1]);
						nextButton.Play("res/sound/button.wav", false);
						onPress++;
					} 
				}//if end				
				if(backButton.isSelected(x, y)) {
					if(1 <= onPress && onPress <= 6 ) {
						helpImg.setImgSrc(imgSrc[onPress-1]);
						backButton.Play("res/sound/button.wav", false);
						onPress--;
					} else
						System.out.println("泥� �럹�씠吏� �엯�땲�떎.");
				}//if end	
				if(homeButton.isSelected(x, y)) {
					System.out.println("�솃踰꾪듉");
					homeButton.Play("res/sound/home.wav", false);
						try {
							GameFrame.instance.switchCanvas(HelpCanvas.this, IntroCanvas.class);
						} catch (InstantiationException e2) {
							e2.printStackTrace();
						} catch (IllegalAccessException e2) {
							e2.printStackTrace();
						}
				}//if end
			};
		});//Listener end		
	}// constructor end
	
				
//					if(onPress <= 0 )
//						System.out.println("泥� �럹�씠吏� �엯�땲�떎.");
//					else if(1 <= onPress && onPress <= 3 ) {
//						helpImg.setImgSrc(imgSrc[onPress-1]);
//						backButton.Play("sound/backButton.wav", false);
//						onPress--;
//					}									

	@Override
	public void update(Graphics g) {
		paint(g);	
	}
	
	@Override
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), this.getHeight());
		Graphics bg = buf.getGraphics();
		helpImg.paint(bg);
//		backButton.paint(bg);
//		nextButton.paint(bg);
//		homeButton.paint(bg);
		for(int i=0; i<3; i++) {
			button[i].paint(bg);
		}		
		repaint();
		g.drawImage(buf, 0, 0, null);		
	}
}