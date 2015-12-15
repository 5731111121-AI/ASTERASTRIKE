package utility;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioUtility {
	
	private static MediaPlayer mp;

	public static void playMusic(String music) {
		URL musicURL = AudioUtility.class.getClassLoader().getResource(music);
		mp = new MediaPlayer(new Media(musicURL.toString()));
		mp.setVolume(0);
		mp.play();
	}

	public static MediaPlayer getMediaPlayer() {
		return mp;
	}
}
