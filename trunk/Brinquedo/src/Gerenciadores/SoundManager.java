package Gerenciadores;

import java.io.IOException;
import java.util.HashMap;

import com.example.brinquedo1.R;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;

public class SoundManager {

	private String TAG = "Sound Manager";

	// private AudioManager audioManager;
	private static HashMap<String, MediaPlayer> songs;
	private static SoundManager instance;

	private SoundManager() {
		this.songs = new HashMap<String, MediaPlayer>();
	}

	public static SoundManager getInstance() {
		if (instance == null) {

			instance = new SoundManager();

		}

		return instance;
	}

	public void playSound(final int source, String name, boolean isLooping,
			Context context) {

			if (!songs.containsValue(name)) {

				final MediaPlayer mp = MediaPlayer.create(context, source);
				mp.setLooping(isLooping);

				songs.put(name, mp);

			}
		
		try {
				songs.get(name).start();

			

		} catch (Exception e) {
			songs.get(name).stop();
			Log.i(TAG, "Erro no som");
		}

	}

	public void StopSong(String name) {
		try {
			this.songs.get(name).stop();
			this.songs.remove(name);
			Log.i("SOUNDMANAGER", "STOP");
		} catch (Exception e) {

		}
	}

	public void StopAllSongs() {
		for (MediaPlayer currentAudio : songs.values()) {
			currentAudio.stop();
			songs.remove(currentAudio);

		}

	}

	public void PauseAllSongs() {
		for (MediaPlayer currentAudio : songs.values()) {
			currentAudio.stop();
			songs.get(currentAudio).pause();
		}

	}

	public void PauseSong(String name) {
		try {
			this.songs.get(name).pause();
		} catch (Exception e) {

		}
	}
}