package Game.miniMap.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Game.entity.Boy;
import Game.miniMap.entity.MiroBg;
import Game.miniMap.entity.MiroWord;

public class MiroCanvas extends Canvas {

	public static MiroCanvas instance;

	private MiroBg miro;
	private MiroWord miroWord1;// �߸��� �ܾ�
	private MiroWord miroWord2;// ���� �ܾ�
	private MiroWord miroWord3;// �߸��� �ܾ�
	private MiroWord miroWord4;// ���� �ܾ�
	private MiroWord miroWord5;// �߸��� �ܾ�
	private MiroWord miroWord6;// ���� �ܾ�
	private MiroWord[] wordArray;
	private Boy boy;

	public MiroCanvas() {
		instance = this;

		miro = new MiroBg(0, 0);
		miroWord1 = new MiroWord(550, 150, true);
		miroWord2 = new MiroWord(850, 150, true);
		miroWord3 = new MiroWord(1100, 300, true);
		miroWord4 = new MiroWord(1100, 400, true);
		miroWord5 = new MiroWord(1100, 600, true);
		miroWord6 = new MiroWord(800, 600, true);
		boy = new Boy(670, 50);
		wordArray = new MiroWord[6];
		wordArray[0] = miroWord1;
		wordArray[1] = miroWord2;
		wordArray[2] = miroWord3;
		wordArray[3] = miroWord4;
		wordArray[4] = miroWord5;
		wordArray[5] = miroWord6;

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				int boy_x = boy.getX();
				int boy_y = boy.getY();
				
				int word_x = miroWord1.getX()-30;
				int word_y = boy.getY()-80;
				

//				for (int i = 0; i < wordArray.length; i++) {
//					if (wordArray[i].isSelect(x, y)) {

						// ���갪 ����
						if(wordArray[1].isSelect(x, y)) {
							boy.move(0, 70);
							
							//wordArray[1].move(word_x,word_y);
							repaint();
							
						}
						if(wordArray[2].isSelect(x, y)) {
							boy.move(100, 0);
							//wordArray[1].move(word_x,word_y);
							//System.out.println("�ι�° ��ư Ŭ��"+x+" "+y);
							repaint();
						}
						
						if(wordArray[3].isSelect(x, y)) {
							boy.move(200, 0);
							//wordArray[1].move(word_x,word_y);
							//System.out.println("����° ��ư Ŭ��");
							repaint();
						}
						
						//repaint();
//						boy.move(420, 0);
//						repaint();

						// ������� �����̰� �ϱ�
//					}
					// System.out.println(wordArray[i].isSelect(x, y));
//				}

			}
		});
	}

	public void start() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					boy.update();

					repaint();
					// -> Canvas.update() : ����� -> Canvas.paint(g) -> �ٽ� �׸���

					// System.out.println("repaint");

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	@Override
	public void paint(Graphics g) {

		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();

		miro.paint(bg);
//		miroWord.paint(bg);
//		miroWord2.paint(bg);
		for(int i = 0; i<wordArray.length; i++) {
			wordArray[i].paint(bg, i);
		}
		
		boy.paint(bg);

		g.drawImage(buf, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

}
