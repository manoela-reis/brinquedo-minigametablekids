package com.nave.shapesafari;

import com.Gerenciadores.ElMatador;
import com.Gerenciadores.Killable;
import com.Gerenciadores.SceneManager;
import com.Gerenciadores.SoundManager;
import com.Telas_Selecao.Menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	public static final String TAG = "quadros";

	public Menu menu ;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(TAG, "on create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		Thread processo = new Thread();

		SceneManager.processo = processo;

		 menu = new Menu(this, SceneManager.processo);
		
		 setContentView(menu);
	}

	protected void onPause() {
		SoundManager.getInstance().StopAllSongs();
		menu.killMeSoftly();
		// killMeSoftly();
		super.onPause();
	}

	protected void onResume() {
		SoundManager.getInstance().StopAllSongs();
		if (SceneManager.sound) {
			SoundManager.getInstance().playSound(R.raw.musicmenu, "MusicMenu",
					true, this);
		}
		if(menu!=null){
			menu.ativar();
			Log.i("ooi", "tchaaaaau");
		}
		super.onResume();
	}
	

	protected void OnDestroy() {
		SoundManager.getInstance().StopAllSongs();
		// killMeSoftly();
		super.onDestroy();
	}

	public void killMeSoftly() {

		ElMatador.getInstance().killThenAll();

		finish();

	}

}