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

public class EtapasActivity extends Activity implements Killable {
	public static final String TAG = "quadros";
	EscolherEtapa etapas;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(TAG, "on create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if(etapas==null){
		etapas = new EscolherEtapa(this);
        }else{
        	etapas.start();
        }
		setContentView(etapas);
	}
	
	protected void onPause() {
		SoundManager.getInstance().PauseSong("MusicMenu");
		etapas.killMeSoftly();
		 //killMeSoftly();
		super.onPause();
	}
	
	protected void onResume() {
		//SoundManager.getInstance().StopAllSongs();
		etapas.ativo=true;
		if(SceneManager.sound){

		SoundManager.getInstance().playSound(R.raw.musicmenu, "MusicMenu",
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