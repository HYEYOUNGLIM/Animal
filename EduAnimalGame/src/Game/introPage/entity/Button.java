package Game.introPage.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.introPage.canvas.IntroCanvas;

public class Button {
   
   private int x;
   private int y;
   private Image img;
   private int width; //버튼 너비 사이즈
   private int height;//버튼 높이 사이즈
   private String img1;
   
//   static {
//      try {
//         img = ImageIO.read(new File("res/introBg.png"));
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//   }

   public Button() {
      this(0,0,0,0,"");
   }
//   public Button(int x, int y) {
//      
//   }
   
   
   public Button(int x, int y, int width, int height,String string) {
      
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.img1 = string;//이미지 이거 어떻게 받아오지
   }
   
   public void paint(Graphics g) {
      // TODO Auto-generated method stub
      try {
         this.img = ImageIO.read(new File(img1));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      g.drawImage(img,x,y, IntroCanvas.instance);


   }
   
   public boolean contains(int x, int y) {
      if ((this.x - width < x && x < this.x + width)
            && (this.y - height < y && y < this.y + height ))
         return true;
      return false;
   }
}