package Game.miniGame1.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Game.miniGame1.canvas.MiniGame1Canvas;

public class AnswerImg {

	private Image img;
	private double width;
	private double height;
	private boolean visible = false;
	private Clip clip;
	
	
	
	
	public AnswerImg() {
		this(0);
	}
	public AnswerImg(int problemIdx) {
		if(problemIdx == 0) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/dog.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/dog.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		else if(problemIdx == 1) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/cat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/cat.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 2) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/horse.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/horse.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 3) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/duck.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/duck.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 4) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/tiger.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/tiger.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 5) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/lion.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/lion.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 6) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/chicken.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/chicken.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 7) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/wolf.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/wolf.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 8) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/pig.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/pig.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(problemIdx == 9) {
			try {
				img = ImageIO.read(new File("res/img/miniGameAnswer/monkey.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AudioInputStream ais = null;
			try {
				ais = AudioSystem.getAudioInputStream(new File("res/sound/monkey.wav"));
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	public void setVisible() {
		visible = true;
		
	}
	public boolean visible() {
		// TODO Auto-generated method stub
		return visible;
	}
	public void paint(Graphics g) {
		int x = (int) ((MiniGame1Canvas.instance.getWidth()-width)/2);
		int y = (int) ((MiniGame1Canvas.instance.getHeight()-height)/2);
		int width = (int) this.width;
		int height = (int) this.height;
		
		g.drawImage(img, x, y, x+width, y+height, 0, 0, width, height, MiniGame1Canvas.instance);
		
	}
	
	public void bark() {
		clip.start();
	}
	
}
