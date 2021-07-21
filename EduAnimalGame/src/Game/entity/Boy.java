package Game.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.miniMap.canvas.MiroCanvas;

public class Boy {

   public static Boy instance;
   private static Image img;
   private int x;
   private int y;
   private static int width = 60;
   private static int height = 100;

   // 애니메이션을 위한 변수
   private int vx;
   private int vy;
   private double dx;
   private double dy;

   private int movIndex = 0;
   private int speed = 3;
   private int walkTempo = 6;

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   private BoyReachListner reachListner; // RainLetter 받았을 때

   static {
      try {
         img = ImageIO.read(new File("res/boy.png"));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void setReachListner(BoyReachListner reachListner) {
      this.reachListner = reachListner;
   }

   public Boy() {
      instance = this;
   }

   public Boy(int x, int y) {
      this.x = x;
      this.y = y;
      dx = x;
      dy = y;
   }
   public void move(double x, double y) {

      this.dx = x;
      this.dy = y;
      

   }

   public void paint(Graphics g) {

      g.drawImage(img, x, y-10, x + width, y-10 + height, 0, 0, 0 + width, 0 + height, MiroCanvas.instance);

   }

   public void update() {

	   if(dx-2 < x && x < dx+2)
		   x+=2;
	   else if(dy!=y)
		   y+=2;
     
     
   }

}