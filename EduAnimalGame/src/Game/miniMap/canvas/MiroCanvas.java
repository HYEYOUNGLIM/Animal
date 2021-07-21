package Game.miniMap.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.GameFrame;
import Game.Animal.Canvas.GameCanvas;
import Game.introPage.canvas.IntroCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;
import Game.miniMap.entity.Boy;
import Game.miniMap.entity.CorrectPicture;
import Game.miniMap.entity.Life;
import Game.miniMap.entity.miro1.MiroBg1;
import Game.miniMap.entity.miro1.MiroWord1;
import Game.miniMap.entity.miro1.Picture1;
import Game.miniMap.entity.miro2.MiroBg2;
import Game.miniMap.entity.miro2.MiroWord2;
import Game.miniMap.entity.miro2.Picture2;
import Game.miniMap.entity.miro3.MiroBg3;
import Game.miniMap.entity.miro3.MiroWord3;
import Game.miniMap.entity.miro3.Picture3;

public class MiroCanvas extends Canvas {

   public static MiroCanvas instance;
   private int count;

   private MiroBg1 miro;
   private MiroBg2 miro2;
   private MiroBg3 miro3;

   private MiroWord1[] wordArray;
   private MiroWord2[] wordArray2;
   private MiroWord3[] wordArray3;
   private Boy boy;
   private Picture1 picture;
   private Picture2 picture2;
   private Picture3 picture3;
   private Life[] life;
   private int lifeCnt;
   private CorrectPicture correctPicture;
   private boolean visible = false;

   private int idx = GameCanvas.problemIdx;
   private boolean playThread = true;

   public MiroCanvas() {
      instance = this;
      // wordArray3= new MiroWord3[9];
      life = new Life[10];
      correctPicture = new CorrectPicture(500, 150);
      lifeCnt = MiniGame1Canvas.getLifeCnt();
      // idx = ;
      if (idx == 0 || idx == 2 || idx == 6) {
         miro = new MiroBg1(0, 0);
         boy = new Boy(700, 50);
         wordArray = new MiroWord1[5];
         picture = new Picture1(20, 130);
         for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = new MiroWord1(i);
         }
      }

      else if (idx == 3 || idx == 5 || idx == 7 || idx == 8) {
         miro2 = new MiroBg2(0, 0);
         boy = new Boy(500, 50);
         wordArray2 = new MiroWord2[7];
         picture2 = new Picture2(950, 400);
         for (int i = 0; i < wordArray2.length; i++) {
            wordArray2[i] = new MiroWord2(i);
         }
      } else if (idx == 1 || idx == 4 || idx == 9) {
         miro3 = new MiroBg3(0, 0);
         boy = new Boy(750, 50);
         wordArray3 = new MiroWord3[9];
         picture3 = new Picture3(100, 0);
         for (int i = 0; i < wordArray3.length; i++) {
            wordArray3[i] = new MiroWord3(i);
         }
      }

      for (int i = 0; i < life.length; i++) {
         life[i] = new Life(900 + 60 * i, 30);
      }

      addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            double x = e.getX();
            double y = e.getY();

            //// 한글자 동물 미로 나오는 조건문
            if (idx == 0 || idx == 2 || idx == 6) {
               if (wordArray[1].getOrder() == count && wordArray[1].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 1;

               }

               if (wordArray[0].getOrder() == count && wordArray[0].isSelect(x, y)) {
                  lifeCnt--;
                  wordArray[0].play("res/sound/wrong.wav");
               }

               if (wordArray[2].getOrder() == count && wordArray[2].isSelect(x, y)) {
                  count = 2;
                  boy.move(x, y);
                  wordArray[2].setX(105);
                  wordArray[2].setY(377);
               }

               if (wordArray[3] != null) {
                  if (wordArray[3].getOrder() == count && wordArray[3].isSelect(x, y)) {
                     boy.move(x, y);
                     count = 3;
                     lifeCnt++;
                     wordArray[3] = null;
                  }
               }
               if (wordArray[4] != null) {
                  if (wordArray[4].getOrder() == count && wordArray[4].isSelect(x, y)) {
                     boy.move(x, y);
                     count = 4;
                     lifeCnt++;
                     wordArray[4] = null;
                  }
               }
               if (picture.getOrder() == count && picture.isSelect(x, y)) {
                  boy.move(x, y);

               }

            }

            // 두글자 동물 미로 나오는 조건문
            else if (idx == 3 || idx == 5 || idx == 7 || idx == 8) {
               if (wordArray2[0].getOrder() == count && wordArray2[0].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 1;

               }
               if (wordArray2[1] != null) {
                  if (wordArray2[1].getOrder() == count && wordArray2[1].isSelect(x, y)) {
                     boy.move(x, y);
                     lifeCnt++;
                     count = 2;
                     wordArray2[1] = null;
                  }
               }

               if (wordArray2[2].getOrder() == count && wordArray2[2].isSelect(x, y)) {
                  lifeCnt--;
                  wordArray2[2].play("res/sound/wrong.wav");
               }

               if (wordArray2[3].getOrder() == count && wordArray2[3].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 3;
                  wordArray2[3].setX(1030);// 이거 좌표값 찍어줘보기
                  wordArray2[3].setY(650);

               }
               if (wordArray2[4] != null) {
                  if (wordArray2[4].getOrder() == count && wordArray2[4].isSelect(x, y)) {
                     boy.move(x, y);
                     count = 4;
                     lifeCnt++;
                     wordArray2[4] = null;
                  }
               }
               if (wordArray2[5].getOrder() == count && wordArray2[5].isSelect(x, y)) {
                  lifeCnt--;
                  wordArray2[5].play("res/sound/wrong.wav");
               }
               if (wordArray2[6].getOrder() == count && wordArray2[6].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 5;
                  wordArray2[6].setX(1080);// 이거 좌표값 찍어줘보기
                  wordArray2[6].setY(650);
               }

               if (picture2.getOrder() == count && picture2.isSelect(x, y)) {
                  boy.move(x, y);

               }

            }

            else if (idx == 1 || idx == 4 || idx == 9) {
               if (wordArray3[0].getOrder() == count && wordArray3[0].isSelect(x, y)) {
                  lifeCnt--;
                  wordArray3[0].play("res/sound/wrong.wav");
               }
               if (wordArray3[1].getOrder() == count && wordArray3[1].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 1;

               }

               if (wordArray3[2].getOrder() == count && wordArray3[2].isSelect(x, y)) {
                  count = 2;
                  boy.move(x, y);
                  wordArray3[2].setX(140);
                  wordArray3[2].setY(250);
               }

               if (wordArray3[3] != null) {
                  if (wordArray3[3].getOrder() == count && wordArray3[3].isSelect(x, y)) {
                     boy.move(x, y);
                     count = 3;
                     lifeCnt++;
                     wordArray3[3] = null;
                  }
               }
               if (wordArray3[4].getOrder() == count && wordArray3[4].isSelect(x, y)) {
                  wordArray3[4].play("res/sound/wrong.wav");
                  lifeCnt--;
               }

               if (wordArray3[5].getOrder() == count && wordArray3[5].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 4;
                  wordArray3[5].setX(185);
                  wordArray3[5].setY(250);

               }
               if (wordArray3[6].getOrder() == count && wordArray3[6].isSelect(x, y)) {
                  wordArray3[6].play("res/sound/wrong.wav");
                  lifeCnt--;

               }
               if (wordArray3[7].getOrder() == count && wordArray3[7].isSelect(x, y)) {
                  boy.move(x, y);
                  count = 5;
                  wordArray3[7].setX(230);
                  wordArray3[7].setY(250);

               }
               if (wordArray3[8] != null) {
                  if (wordArray3[8].getOrder() == count && wordArray3[8].isSelect(x, y)) {
                     boy.move(x, y);
                     count = 6;
                     lifeCnt++;
                     wordArray3[8] = null;
                  }

               }
               if (picture3.getOrder() == count && picture3.isSelect(x, y)) {
                  boy.move(x, y);

               }
            }

         }

      });

   }

   public void start() {
      
      new Thread(new Runnable() {

         @Override
         public void run() {
            while (playThread) {
               boy.update();

               int boyX = (int) boy.getX();
               int boyY = (int) boy.getY();
               int picX_min = 0;
               int picY_min = 0;
               int picX_max = 0;
               int picY_max = 0;
               if (idx == 0 || idx == 2 || idx == 6) {
                  picX_min = (int) picture.getX();
                  picY_min = (int) picture.getY();
                  picX_max = picX_min + picture.getWidth();
                  picY_max = picY_min + picture.getHeight();
               } else if (idx == 3 || idx == 5 || idx == 7 || idx == 8) {
                  picX_min = (int) picture2.getX();
                  picY_min = (int) picture2.getY();
                  picX_max = picX_min + picture2.getWidth();
                  picY_max = picY_min + picture2.getHeight();
               } else if (idx == 1 || idx == 4 || idx == 9) {
                  picX_min = (int) picture3.getX();
                  picY_min = (int) picture3.getY();
                  picX_max = picX_min + picture3.getWidth();
                  picY_max = picY_min + picture3.getHeight();
               }

               if ((picX_min < boyX && boyX < picX_max) && (picY_min < boyY && boyY < picY_max)) {
                  visible = true;
                  

               }
               repaint();

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

      if (idx == 0 || idx == 2 || idx == 6) {
         miro.paint(bg);

         picture.paint(bg);
         for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] != null) {
               wordArray[i].paint(bg, i);
            }

         }

      } else if (idx == 3 || idx == 5 || idx == 7 || idx == 8) {
         miro2.paint(bg);

         picture2.paint(bg);
         for (int i = 0; i < wordArray2.length; i++) {
            if (wordArray2[i] != null) {
               wordArray2[i].paint(bg, i);
            }

         }
      } else if (idx == 1 || idx == 4 || idx == 9) {
         miro3.paint(bg);

         picture3.paint(bg);
         for (int i = 0; i < wordArray3.length; i++) {
            if (wordArray3[i] != null) {
               wordArray3[i].paint(bg, i);
            }
         }
      }

      boy.paint(bg);

      if (visible) {
         correctPicture.paint(bg);
      }
      for (int i = 0; i < lifeCnt; i++) {
         life[i].paint(bg);
      }

      g.drawImage(buf, 0, 0, this);
      if (visible) {
          try {
        	 correctPicture.play("res/sound/clap1.wav");
             Thread.sleep(4000);
             playThread = false;
        
             GameCanvas.setSaveIdx(GameCanvas.problemIdx);
             try {
             GameFrame.instance.switchCanvas(MiroCanvas.this, IntroCanvas.class);
          } catch (InstantiationException | IllegalAccessException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
          } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
          
       }      
   }

   @Override
   public void update(Graphics g) {
      paint(g);
   }

}