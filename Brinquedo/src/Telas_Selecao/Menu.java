package Telas_Selecao;

import com.example.brinquedo1.CreditosActivity;
import com.example.brinquedo1.EtapasActivity;
import com.example.brinquedo1.Fase02;
import com.example.brinquedo1.MainActivity;
import com.example.brinquedo1.R;
import com.example.brinquedo1.Sprite;
import ETAPA1.Fase2_Assets;
import Gerenciadores.ImageManager;
import Gerenciadores.Killable;
import Gerenciadores.SceneManager;
import Gerenciadores.SoundManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class Menu extends View implements Runnable, Killable {
	private Bitmap background;
	private Bitmap[] options;
	private Rect[] areaOptions;
	private ImageManager picture;
	Paint paint;
	private View creditosScene;
	Activity activity;
	private Rect Back = new Rect();
	Sprite spriteGirafa;
	Sprite spritePlay;
	Boolean setup = true;
	public boolean ativo = true;
	Sprite spriteConfig;
	public static long deltaTime;
	public long lastTimeCount;

	private long time = 1;
	int WidthBitmap;
	Bitmap zebra;
	Bitmap Setup;
	Thread processo;
	private Bitmap creditos;
	private Bitmap Som;
	private Bitmap SomOff;
	
	Boolean play=false;
	private Rect Creditos;
	private Rect Config;
	private Rect som;
	public SoundManager sound = SoundManager.getInstance();	
	private boolean boolSomOff = false;

	
	public Menu(Context context) {
		super(context);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		picture = new ImageManager(context);
		paint = new Paint();
		this.processo=processo;
		activity = (Activity) context;
		options = new Bitmap[3];
		areaOptions = new Rect[3];

		background = picture.ImageManager("cenario.png");
		options[0] = picture.ImageManager("Play.png");
		options[1] = picture.ImageManager("credits.png");
		options[2] = picture.ImageManager("quit.png");
		zebra = picture.ImageManager("zebra.png");
		Setup = picture.ImageManager("Setup.png");
		Som = picture.ImageManager("Som.png");
		creditos = picture.ImageManager("Creditos.png");
		SomOff = picture.ImageManager("SomOff.png");

		spriteGirafa = new Sprite(zebra, 60, 10);
		spritePlay = new Sprite(options[0], 2, 1);

		spriteConfig = new Sprite(Setup, 8, 8);
		this.spritePlay.Modificar(1);
		areaOptions[1] = new Rect();
		processo = new Thread(this);
		processo.start();
		
		// TODO Auto-generated constructor stub
	}

	public void start(){

		processo = new Thread(this);
		processo.start();
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		Back.set(0, 0, getWidth() + 2, getHeight());
		WidthBitmap = zebra.getWidth() / 60
				* ((int) ((getHeight()) - (int) (1.3 * getHeight() / 5)))
				/ zebra.getHeight();
		int WidthBitmapPlay = options[0].getWidth() / 2
				* ((int) ((6 * getHeight() / 8) - (int) (3 * getHeight() / 8)))
				/ options[0].getHeight();
		areaOptions[0] = new Rect(4 * getWidth() / 7, 3 * getHeight() / 8,
				(int) (4 * getWidth() / 7 + WidthBitmapPlay),
				(int) (6 * getHeight() / 8));
		int WidthBitmapSetup = Setup.getWidth()
				/ 8
				* ((int) ((7.8 * getHeight() / 8) - (int) (4.4 * getHeight() / 8)))
				/ Setup.getHeight();
		areaOptions[2] = new Rect(6 * getWidth() / 7,
				(int) (4.4 * getHeight() / 8),
				(int) (6 * getWidth() / 7 + WidthBitmapSetup),
				(int) (7.8 * getHeight() / 8));
		int HeightBitmapSom = Som.getHeight()

				* ((int) (6 * getWidth() / 7 + 6.4 * WidthBitmapSetup / 8) - (int) (6 * getWidth() / 7 + 1.6 * WidthBitmapSetup / 8))
				/ Som.getWidth();

		Creditos = new Rect(
				(int) (6 * getWidth() / 7 + 1.6 * WidthBitmapSetup / 8),
				(int) (6.1 * getHeight() / 8 - HeightBitmapSom - HeightBitmapSom / 8),
				(int) (6 * getWidth() / 7 + (int) (6.4 * WidthBitmapSetup / 8)),
				(int) (6.1 * getHeight() / 8) - HeightBitmapSom / 8);

		som = new Rect(
				(int) (6 * getWidth() / 7 + 1.6 * WidthBitmapSetup / 8),
				(int) (6.2 * getHeight() / 8),
				(int) (6 * getWidth() / 7 + (int) (6.4 * WidthBitmapSetup / 8)),
				(int) (6.2 * getHeight() / 8) + HeightBitmapSom);
		spriteConfig.Modificar(7);
		int HeighSetup = Som.getHeight()

				* ((int) (6 * getWidth() / 7 + WidthBitmapSetup) - (int) (6 * getWidth() / 7))
				/ Som.getWidth();
		Config = new Rect(6 * getWidth() / 7,
				(int) (7.8 * getHeight() / 8 - HeighSetup),
				(int) (6 * getWidth() / 7 + WidthBitmapSetup),
				(int) (7.8 * getHeight() / 8));
		areaOptions[1].set(getWidth() / 18, (int) (1.3 * getHeight() / 5),
				getWidth() / 18 + WidthBitmap, getHeight());
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		canvas.drawBitmap(background, null, Back, paint);
		this.spriteGirafa.Draw(canvas, areaOptions[1]);
		this.spritePlay.Draw(canvas, areaOptions[0]);
		this.spriteConfig.Draw(canvas, areaOptions[2]);
		if (!setup && !spriteConfig.status) {
			canvas.drawBitmap(creditos, null, Creditos, paint);

			canvas.drawBitmap(Som, null, som, paint);

		}
		
		if (boolSomOff == true)
		{
			canvas.drawBitmap(SomOff, null, som, paint);
			
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i(MainActivity.TAG, "Entrou no action down");
			int a = (int) event.getX();
			int b = (int) event.getY();

			if (Config.contains(a, b)) {
				Log.i(MainActivity.TAG, "Entrou no Play !! ");
				if (!spriteConfig.status && setup) {
					setup = false;
					spriteConfig.status = true;

				}
				if (!setup && !spriteConfig.status) {
					spriteConfig.status = true;
					setup = true;

				}

			}
			if (areaOptions[0].contains(a, b)) {
				Log.i(MainActivity.TAG, "Entrou no Play !! ");
				spritePlay.Modificar(0);
				play=true;
				
			

			}
			if (Creditos.contains(a, b)) 
			{
				Log.i(MainActivity.TAG, "Entrou no créditos !! ");
	//			SoundManager.getInstance().StopSong("MusicMenu");
				Intent mod = new Intent((Context)activity,CreditosActivity.class);
				activity.startActivity(mod);
			}
			
			if (som.contains(a, b)) 
			{
				if (Fase02.tocarSom == true)
				{
					Fase02.tocarSom = false;
					sound.StopAllSongs();	
					SceneManager.sound=false;
					boolSomOff = true;
				}
				
				else {
					SceneManager.sound=true;

					Fase02.tocarSom = true;
					SoundManager.getInstance().playSound(R.raw.musicmenu, "MusicMenu",
							true, super.getContext());
					boolSomOff = false;
				}
				
			}
		}

		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.i(MainActivity.TAG, "Entrou no action move");
			int a = (int) event.getX();
			int b = (int) event.getY();
		
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			Log.i(MainActivity.TAG, "Entrou no action up");
			int a = (int) event.getX();
			int b = (int) event.getY();

			// Play
			if(play){
			if (areaOptions[0].contains(a, b)) {
				Log.i(MainActivity.TAG, "Entrou no Play !! ");
				Intent mod = new Intent((Context)activity,EtapasActivity.class);
				activity.startActivity(mod);

			}else{
				spritePlay.Modificar(1);
			}
			play=false;
			}

		}

		return super.onTouchEvent(event);
	}

	public void run() {
		while (ativo) {
			try {
				Thread.sleep(time);

			}

			catch (Exception e) {
				Log.e("Deu erro", "Quem sabe mete o pe");
			}
			update();

			// this.sprite.Update(30);
			// Log.i("Update", "updateeeeeeee");
			postInvalidate();
		}
		// TODO Auto-generated method stub
	}

	public void update() {
		this.deltaTime = System.currentTimeMillis() - this.lastTimeCount;
		this.lastTimeCount = System.currentTimeMillis();

		this.spriteGirafa.Update(this.deltaTime);
		if (spriteConfig.status) {

			if (!setup) {
				spriteConfig.iniciar(deltaTime);
			} else {
				spriteConfig.Voltar(deltaTime);
			}
		}
		if(!play){
		spritePlay.Modificar(1);
		}

	}

	@Override
	public void killMeSoftly() {

		ativo = false;
		
	}

}