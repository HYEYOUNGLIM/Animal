package Game.miniGame1.entity;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WrongSound {

	private static Clip clip;
	
	static {
		AudioInputStream ais = null;
		try {
			ais = AudioSystem.getAudioInputStream(new File("res/sound/wrong.wav"));
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
	public WrongSound() {
		
	}

	public void start() {
		clip.setMicrosecondPosition(0);
		clip.start();
		
	}
}
