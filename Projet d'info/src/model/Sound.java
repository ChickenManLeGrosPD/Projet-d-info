package model;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import view.Window;

public class Sound {
	private static Sound SoundInstance;
	public Sound() {}
	public void play(String s) {
		new Thread() {
			public void run() {
				try {
					String path = "Sound/" + s + ".wav";
					File file = new File (path);
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(file));
					FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					// set the gain (between 0.0 and 1.0)
					double gain = 0.25;   
					float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
					gainControl.setValue(dB);
					clip.start();
					Thread.sleep(clip.getMicrosecondLength());
				}
				catch (Exception e) {}
			}
		}.start();
	}
	public static Sound getInstance() {
    	if (SoundInstance == null) {
    		SoundInstance = new Sound();
    	}
    	return SoundInstance;
	}
}