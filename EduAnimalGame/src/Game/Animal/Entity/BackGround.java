package Game.Animal.Entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GameFrame;

public class BackGround {

	private Image img;

	public BackGround() {


		try {
			img = ImageIO.read(new File("res/img/gameCanvasAnimal/animalBookBg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, GameFrame.instance);
	}

	

}
