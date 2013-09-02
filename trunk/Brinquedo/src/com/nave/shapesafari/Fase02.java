package com.nave.shapesafari;

import java.util.Random;

import com.Gerenciadores.ElMatador;
import com.Gerenciadores.ImageManager;
import com.Gerenciadores.Killable;
import com.Gerenciadores.SceneManager;
import com.Gerenciadores.SoundManager;
import com.Gerenciadores.SceneManager.SCENE;
import com.Telas_Selecao.EscolherEtapa;
import com.Telas_Selecao.Menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Fase02 extends View implements Runnable, Killable {

	private long time = 1;
	Bitmap[] geometricFigures = new Bitmap[7];
	Bitmap[] Backgrounds;
	public boolean ativo = true;
	int period = 60;
	int counter;
	private Paint paint;
	private Rect Back = new Rect();
	int totalPoints;
	int hitPoints = 0;
	Rect object_down;
	Rect[] areaObjectsUp = new Rect[3];
	private static int positionX;
	private static int positionY;
	ImageManager img;
	Scene asset;
	Rect[] rects;
	Boolean movendo;
	Rect mov;
	public Boolean Vitoria = false;

	public SoundManager sound = SoundManager.getInstance();
	Context context;
	Rect[] rectsColor;
	public static long deltaTime;
	public long lastTimeCount;
	Thread processo;

	public Fase02(Context context, Scene asset, Thread processo) {
		super(context);
		this.context = context;
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);

		this.processo = processo;
		ElMatador.getInstance().add(this);
		sound.StopAllSongs();

		Vitoria=SceneManager.Vitoria;
		if (SceneManager.sound == true) {
			if(!Vitoria){
				sound.playSound(R.raw.musicgame, "Game",
						true, context);
				}else{
					sound.playSound(R.raw.musicvitoria,
							"VitoriaSound", false, context);
				}		
			}
		hitPoints=asset.getPoint();
		Backgrounds = new Bitmap[3];
		img = new ImageManager(context);
		paint = new Paint();

		paint.setColor(Color.BLACK);
		paint.setTextSize(20);

		
		this.asset = asset;
		geometricFigures = asset.figuras();
		rects = asset.getRect();
		rectsColor = asset.getRectColor();
		totalPoints = rectsColor.length;
		Backgrounds[0] = img.ImageManager("bgCongrats.bmp");
		Backgrounds[1] = img.ImageManager("bgGameOver.bmp");
		Backgrounds[2] = img.ImageManager("fundo.png");

		processo = new Thread(this);
		processo.start();

		// TODO Auto-generated constructor stub
	}

	public void setFase(Scene carreg) {

		this.asset = carreg;
		asset.setconfig(getWidth(), getHeight(), paint);

		if (!Vitoria) {
			geometricFigures = asset.figuras();
			rects = asset.getRect();
			rectsColor = asset.getRectColor();
			asset.setconf(getWidth(), getHeight());

			totalPoints = rectsColor.length;
		}
	}
	
	
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		positionX = (int) getWidth() / 2;
		positionY = (int) getHeight() / 2;
		if (!Vitoria) {
			asset.setXY(positionX, positionY);
			asset.setconfig(getWidth(), getHeight(), paint);
		}
		Back.set(0, 0, getWidth(), getHeight());
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		if (!Vitoria) {
			canvas.drawBitmap(Backgrounds[2], null, Back, paint);
		}

		asset.Draw(canvas);

		// Condição de derrota.

		// Condição de vitória.

	}

	public boolean onTouchEvent(MotionEvent event) {
		if (!Vitoria) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				Log.i(MainActivity.TAG, "down baby down !! ");
				int c = (int) event.getX();
				int d = (int) event.getY();

				for (Rect a : rects) {
					if (a.contains(c, d)) {
						movendo = true;
						mov = a;
					}
				}
			}

			if (event.getAction() == MotionEvent.ACTION_MOVE) {

				Log.i(MainActivity.TAG, "SHAKE !!!");
				int c = (int) event.getX();
				int d = (int) event.getY();

				// Testes de Colisão da imagem preto e branco de acordo com a
				// sua respectiva imagem colorida.

				if (mov != null) {
					if (movendo) {
						positionX = (int) event.getX();
						positionY = (int) event.getY();

						asset.setXY(positionX, positionY);

						asset.setRect(mov);
					}

				}
			}

			if (event.getAction() == MotionEvent.ACTION_UP) {

				movendo = false;

				for (int i = 0; i < rectsColor.length; i++) {
					if (mov != null) {
						if (mov.contains((int) rectsColor[i].exactCenterX(),
								(int) rectsColor[i].exactCenterY())) {

							if (rects[i] == mov) {
								asset.colidiu(mov, rectsColor[i], i);
								//rects[i].setEmpty();
								movendo = false;
								mov = null;
								if (SceneManager.sound == true) {
									sound.playSound(R.raw.acerto, "acerto",
											false, context);
								}

								hitPoints++;
							} else {
								if (SceneManager.sound == true) {
									sound.playSound(R.raw.erro, "erro",
											false, context);
								}
							}
						}
					}
				}
				if (mov != null) {

					asset.setRectInicial(mov);

				}

			}

		}
			return super.onTouchEvent(event);
		
	}

	public void update() {
		if (period != 0) {
			counter++;
		}

		if (counter == 1000) {
			period -= 1;
			counter = 0;
		}
		if (hitPoints == totalPoints) {
			// classe de vitoria
			// canvas.drawBitmap(Backgrounds[0], null, Back, paint);
			hitPoints = 0;
			if (SceneManager.sound == true) {
				SoundManager.getInstance().playSound(R.raw.acerto, "sound",
						false, context);
			}
			try {
				Thread.sleep(1000);
			}

			catch (Exception e) {
				Log.e("Deu erro", "Quem sabe mete o pe");
			}
			
			SceneManager.ChangeScene(context);
			

			
		}

		
		asset.update(deltaTime);
		this.deltaTime = System.currentTimeMillis() - this.lastTimeCount;
		this.lastTimeCount = System.currentTimeMillis();

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
			postInvalidate();
		}
		// TODO Auto-generated method stub
	}


	public void killMeSoftly() {
		ativo = false;

	}
	public void ativar() {
		processo = new Thread(this);
		processo.start();

		ativo = true;

	}

}