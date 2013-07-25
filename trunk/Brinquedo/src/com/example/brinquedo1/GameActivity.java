package com.example.brinquedo1;


import Gerenciadores.ElMatador;

import Gerenciadores.SceneManager;
import Gerenciadores.SoundManager;
import Gerenciadores.Killable;
import Telas_Selecao.EscolherEtapa;
import Telas_Selecao.Menu;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity implements Killable {
	public static final String TAG = "quadros";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(TAG, "on create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if(SceneManager.scene==null){
        SceneManager.scene = new Fase02(this, SceneManager.carregar);
        }
		setContentView(SceneManager.scene);
	}
	protected void onPause() 
    {
		
		SoundManager.getInstance().PauseSong("Game");
		SoundManager.getInstance().PauseSong("VitoriaSound");
		SceneManager.scene.killMeSoftly();
		//killMeSoftly();
		super.onPause();
    }
	
	public void onBackPressed() {
		this.finish();
		if(SceneManager.scene.Vitoria){
		

		SceneManager.activity.finish();
		}
		}
    protected void onResume()
    {
		SoundManager.getInstance().StopAllSongs();
		SceneManager.scene.ativo=true;
		if(SceneManager.sound && SceneManager.scene.Vitoria==false){

			SoundManager.getInstance().playSound(R.raw.musicgame, "Game",
					true, this);
			}
		if(SceneManager.sound && SceneManager.scene.Vitoria==true){

			SoundManager.getInstance().playSound(R.raw.musicvitoria, "VitoriaSound",
					true, this);
			}
    	super.onResume();
    }
	protected void OnDestroy()
	{
		SoundManager.getInstance().StopAllSongs();
		killMeSoftly();
		super.onDestroy();
	}
	


	public void killMeSoftly() {

		ElMatador.getInstance().killThenAll();

finish();
		
	}
}