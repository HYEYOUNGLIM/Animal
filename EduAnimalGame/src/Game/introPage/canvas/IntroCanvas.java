package Game.introPage.canvas;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.GameFrame;
import Game.Animal.Canvas.AnimalCanvas;
import Game.Animal.Canvas.GameCanvas;
import Game.Help.Canvas.HelpCanvas;
import Game.introPage.entity.Button;
import Game.introPage.entity.IntroBg;

public class IntroCanvas extends Canvas{

   public static IntroCanvas instance;

   private Button startBtn;
   private Button animalBookBtn;
   private Button helpBtn;
   private Button exitBtn;
   private static Image img;

   private IntroBg introBg;

   public IntroCanvas() {
      instance = this;
      introBg = new IntroBg();
      
      startBtn = new Button(520,400,250,70,"res/img/introCanvas/btn/startbtn.png");
      animalBookBtn = new Button(520,480,250,70,"res/img/introCanvas/btn/animalbookbtn.png");
      helpBtn = new Button(520,560,250,70,"res/img/introCanvas/btn/helpbtn.png");
      exitBtn= new Button(520,640,250,70,"res/img/introCanvas/btn/exitbtn.png");
      
      
      addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();

            //for (int i = 0; i < 2; i++) {
               if (startBtn.contains(x, y)) {// 프레임이 스위치하도록 해야한다.인터페이스 정의 방법X
                  try {
                     GameFrame.instance.switchCanvas(IntroCanvas.this, GameCanvas.class);
                  } catch (InstantiationException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  } catch (IllegalAccessException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
               //}
            }
               
               else if(animalBookBtn.contains(x, y)) {
                  try {
                     GameFrame.instance.switchCanvas(IntroCanvas.this, AnimalCanvas.class);
                  } catch (InstantiationException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  } catch (IllegalAccessException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
               }
               
               
               else if(helpBtn.contains(x, y)) {
                  try {
                     GameFrame.instance.switchCanvas(IntroCanvas.this, HelpCanvas.class);
                  } catch (InstantiationException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  } catch (IllegalAccessException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
               }
               
               
               else if(exitBtn.contains(x, y)) {
                  System.exit(0);
               }

         }
      });

   }

   @Override
   public void paint(Graphics g) {

      Image buf = this.createImage(this.getWidth(), getHeight());
      Graphics bg = buf.getGraphics();

      introBg.paint(bg);
      startBtn.paint(bg);
      animalBookBtn.paint(bg);
      helpBtn.paint(bg);
      exitBtn.paint(bg);

      g.drawImage(buf, 0, 0, this);//

   }

   @Override
   public void update(Graphics g) {

      paint(g);
   }

}