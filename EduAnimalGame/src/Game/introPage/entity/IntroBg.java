package Game.introPage.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.introPage.canvas.IntroCanvas;


public class IntroBg {
   

   private static Image img;

   static {
      try {
         img = ImageIO.read(new File("res/img/introCanvas/introBg2.png"));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public IntroBg() {
   }

   
   public void paint(Graphics g) {

      g.drawImage(img, 0,0, IntroCanvas.instance);

   }

   public void update() {
   

   }

//   @Override
//   public Image getImage() {
//      return img;
//   }

}