package com.example.brinquedo1;

import Gerenciadores.ElMatador;

import Gerenciadores.SceneManager;
import Gerenciadores.SoundManager;
import Gerenciadores.Killable;
import com.Telas_Selecao.EscolherEtapa;
import com.Telas_Selecao.Menu;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.nave.shapesafari.R;

public class GameActivity extends Activity implements Killable {
	public static final String TAG = "quadros";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(TAG, "on create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		
		SceneManager.scene = new Fase02(this, SceneManager.carregar,
				SceneManager.processo);
		

		setContentView(SceneManager.scene);

	}

	protected void onPause() {
		SoundManager.getInstance().StopAllSongs();
		SceneManager.scene.killMeSoftly();
		// killMeSoftly();
		super.onPause();
	}

	protected void onResume() {
		SoundManager.getInstance().StopAllSongs();

		if (SceneManager.sound == true) {
			if (SceneManager.scene != null) {
				if(!SceneManager.scene.Vitoria){
				SoundManager.getInstance().playSound(R.raw.musicgame, "Game",
						true, this);
				}else{
					SoundManager.getInstance().playSound(R.raw.musicvitoria,
							"VitoriaSound", false, this);
				}
			}
		}
		if(SceneManager.scene!=null){
			SceneManager.scene.ativar();
			Log.i("ooi", "tchaaaaau");
		}

		super.onResume();
	}

	protected void OnDestroy() {
		SoundManager.getInstance().StopAllSongs();
		SceneManager.scene = null;
		// killMeSoftly();
		super.onDestroy();
	}
	  public void onBackPressed() {
          this.finish();
          if(SceneManager.scene.Vitoria){
          

          SceneManager.activity.finish();
          }
          }
	public void killMeSoftly() {

		ElMatador.getInstance().killThenAll();

		finish();

	}
}