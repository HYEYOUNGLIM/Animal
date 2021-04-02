package Game;


import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Game.Animal.Canvas.AnimalCanvas;
import Game.Animal.Canvas.GameCanvas;
import Game.Help.Canvas.HelpCanvas;
import Game.introPage.canvas.IntroCanvas;
import Game.miniGame1.canvas.MiniGame1Canvas;
import Game.miniGame2.canvas.MiniGame2Canvas;
import Game.miniMap.canvas.MiroCanvas;

public class GameFrame extends Frame {
	
	public static GameFrame instance;

	private IntroCanvas introCanvas;
	private MiniGame1Canvas miniGame1Canvas;
	private MiniGame2Canvas miniGame2Canvas;
	
	private MiroCanvas miroCanvas;
	private GameCanvas gameCanvas;
	private HelpCanvas helpCanvas;
	private AnimalCanvas animalCanvas;
	
	private static Clip introClip;
	private static Clip game1Clip;
	private static Clip game2Clip;
	private static Clip miroClip;
	private static Clip gameSol;
	
	
	
	static {
		 try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("res/sound/introsound.wav"));
			introClip = AudioSystem.getClip();
			
			introClip.open(ais);
			ais = AudioSystem.getAudioInputStream(new File("res/sound/game.wav"));
			game1Clip = AudioSystem.getClip();
			
			game1Clip.open(ais);
			ais = AudioSystem.getAudioInputStream(new File("res/sound/game2.wav"));
			game2Clip = AudioSystem.getClip();
			
			game2Clip.open(ais);
			ais = AudioSystem.getAudioInputStream(new File("res/sound/minimap.wav"));
			miroClip = AudioSystem.getClip();
			miroClip.open(ais);
			ais = AudioSystem.getAudioInputStream(new File("res/sound/minimap2.wav"));
			gameSol = AudioSystem.getClip();
			gameSol.open(ais);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
       
         
	}
	
	public GameFrame() {
		instance = this;
		GraphicsConfiguration gc = getGraphicsConfiguration();
		Rectangle bounds = gc.getBounds();
		this.setLocation(350 + bounds.x, 150 + bounds.y);
		setSize(1280+16, 750+39);
		Toolkit tk = Toolkit.getDefaultToolkit();
        Image cursorimage = tk.getImage("res/img/cursor.png");
        Point point = new Point();
        Cursor cursor = tk.createCustomCursor(cursorimage, point, "cursor");
        setCursor(cursor);
		introCanvas = new IntroCanvas();
		add(introCanvas);
		setVisible(true);
		
		introClip.setMicrosecondPosition(0);
		introClip.start();
		introClip.loop(-1);
		
		//play("res/sound/introsound.wav", true);

//		miroCanvas = new MiroCanvas();
//		add(miroCanvas);
//		setVisible(true);
//		miroCanvas.start();
	
//		miniGame1Canvas = new MiniGame1Canvas();
//		add(miniGame1Canvas);
//		setVisible(true);
//		miniGame1Canvas.setFocusable(true);
//		miniGame1Canvas.requestFocus();
//		miniGame1Canv=start();
		
//		miniGame2Canvas = new MiniGame2Canvas();
//		add(miniGame2Canvas);
//		setVisible(true);
//		miniGame2Canvas.setFocusable(true);
//		miniGame2Canvas.requestFocus();
//		miniGame2Canvas.start();
		
//		miroCanvas = new MiroCanvas();
//		add(miroCanvas);
//		setVisible(true);
//		miroCanvas.start();


		addWindowListener(new WindowAdapter(){  
	        public void windowClosing(WindowEvent e) {  
	            System.exit(0);
	        }  
	    });  
	}
	
	public void switchCanvas(Canvas oldCanvas, Class<? extends Canvas> newCanvas)
			throws InstantiationException, IllegalAccessException {

		//remove(oldCanvas);
		Canvas canvas = newCanvas.newInstance(); 
		if(canvas instanceof GameCanvas) {
			
			remove(oldCanvas);
			gameCanvas = (GameCanvas)canvas;
			add(gameCanvas);
			revalidate();
			gameCanvas.setFocusable(true);
			gameCanvas.requestFocus();
			gameCanvas.start();
		}
		
		else if(canvas instanceof MiniGame1Canvas) {
			introClip.setMicrosecondPosition(0);
			introClip.stop();
			game1Clip.loop(-1);
			game1Clip.start();
			remove(oldCanvas);
			miniGame1Canvas = (MiniGame1Canvas)canvas;
			add(miniGame1Canvas);
			revalidate();
			miniGame1Canvas.setFocusable(true);
			miniGame1Canvas.requestFocus();
			miniGame1Canvas.start();
		}
		
		else if(canvas instanceof MiniGame2Canvas) {
			
			game1Clip.setMicrosecondPosition(0);
			game1Clip.stop();
			game2Clip.loop(-1);
			game2Clip.start();
			
			remove(oldCanvas);
			miniGame2Canvas = (MiniGame2Canvas)canvas;
			add(miniGame2Canvas);
			revalidate();
			miniGame2Canvas.setFocusable(true);
			miniGame2Canvas.requestFocus();
			miniGame2Canvas.start();
		}
		
		else if(canvas instanceof MiroCanvas) {
			
			game2Clip.setMicrosecondPosition(0);
			game2Clip.stop();
			miroClip.loop(-1);
			miroClip.start();
			
			remove(oldCanvas);
			miroCanvas = (MiroCanvas)canvas;
			add(miroCanvas);
			revalidate();
			miroCanvas.setFocusable(true);
			miroCanvas.requestFocus();
			miroCanvas.start();
		}
		
		else if(canvas instanceof HelpCanvas) {
			introClip.setMicrosecondPosition(0);
			introClip.stop();
			gameSol.loop(-1);
			gameSol.start();
			
			remove(oldCanvas);
			helpCanvas = (HelpCanvas)canvas;
			add(helpCanvas);
			revalidate();
			helpCanvas.setFocusable(true);
			helpCanvas.requestFocus();
		}
		
		else if(canvas instanceof IntroCanvas) {
			gameSol.setMicrosecondPosition(0);
			gameSol.stop();
			miroClip.setMicrosecondPosition(0);
			miroClip.stop();
			introClip.loop(-1);
			introClip.start();
			remove(oldCanvas);
			introCanvas = (IntroCanvas)canvas;
			add(introCanvas);
			revalidate();
			introCanvas.setFocusable(true);
			introCanvas.requestFocus();
		}
		else if(canvas instanceof AnimalCanvas) {
			remove(oldCanvas);
			animalCanvas = (AnimalCanvas)canvas;
			add(animalCanvas);
			revalidate();
			animalCanvas.setFocusable(true);
			animalCanvas.requestFocus();
			animalCanvas.start();
		}
		
	}
	
 
        
     
	
	
//	public void play(String fileName, boolean loop) {
//	      try {
//	         AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
//	         
//	         Clip clip = AudioSystem.getClip();
//	         
//	         if (loop)
//		            clip.loop(-1);
//	        // clip.stop();
//	         clip.open(ais);
//	         
//	         clip.start();
//	        
//	         
//
//	         // Loop 값이true면 사운드재생을무한반복시킵니다.
//
//	         // false면 한번만재생시킵니다.
//
//	      } catch (Exception e) {
//
//	         e.printStackTrace();
//
//	      }
//	}

}
