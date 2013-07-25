package com.example.brinquedo1;


import Gerenciadores.ElMatador;

import Gerenciadores.SoundManager;
import Gerenciadores.Killable;
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

public class MainActivity extends Activity implements Killable {
	public static final String TAG = "quadros";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(TAG, "on create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        
		Menu menu = new Menu(this);
		setContentView(menu);
	}
	protected void onPause() 
    {
		SoundManager.getInstance().StopAllSongs();
		killMeSoftly();
		super.onPause();
    }
    protected void onResume()
    {
		SoundManager.getInstance().StopAllSongs();

		SoundManager.getInstance().playSound(R.raw.musicmenu, "MusicMenu",
				true, this);
    	super.onResume();
    }
	protected void OnDestroy()
	{
		SoundManager.getInstance().StopAllSongs();
		killMeSoftly();
		super.onDestroy();
	}
	
	public void onBackPressed() {
		


								killMeSoftly();
								SoundManager.getInstance().StopAllSongs();
								finish();
							
	}

	public void killMeSoftly() {

		ElMatador.getInstance().killThenAll();

System.exit(0);
		
	}
}