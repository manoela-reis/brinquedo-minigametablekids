package com.nave.shapesafari;


import com.Gerenciadores.ElMatador;
import com.Gerenciadores.Killable;
import com.Gerenciadores.SceneManager;
import com.Gerenciadores.SoundManager;
import com.Telas_Selecao.EscolherEtapa;
import com.Telas_Selecao.Menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

        etapas = new EscolherEtapa(this, SceneManager.processo);
        
		setContentView(etapas);
		
	}
	
	protected void onPause() {
		SoundManager.getInstance().StopAllSongs();
		etapas.killMeSoftly();
		// killMeSoftly();
		super.onPause();
	}
	
	protected void onResume() {
		SoundManager.getInstance().StopAllSongs();

		if(SceneManager.sound){
		SoundManager.getInstance().playSound(R.raw.musicmenu, "MusicMenu",
				true, this);
		}
		if(etapas!=null){
			etapas.ativar();
			Log.i("ooi", "tchaaaaau");
		}
		super.onResume();
	}
	
	
	protected void OnDestroy()
	{
		SoundManager.getInstance().StopAllSongs();
		//killMeSoftly();
		super.onDestroy();
	}
	


	public void killMeSoftly() {

		ElMatador.getInstance().killThenAll();

finish();
		
	}
}