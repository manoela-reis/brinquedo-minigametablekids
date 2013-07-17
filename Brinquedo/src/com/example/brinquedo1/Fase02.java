package com.example.brinquedo1;

import java.util.Random;

import Gerenciadores.ImageManager;
import Gerenciadores.SceneManager;
import Gerenciadores.SoundManager;
import Gerenciadores.SceneManager.SCENE;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Fase02 extends View implements Runnable {

	private long time = 1;
	Bitmap[] geometricFigures = new Bitmap[7];
	Bitmap[] Backgrounds;
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

	public SoundManager sound;
	Context context;
	Rect[] rectsColor;

	public Fase02(Context context, Scene asset) {
		super(context);
		this.context = context;
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);

		sound = SoundManager.getInstance();
		SoundManager.getInstance().StopAllSongs();
		SoundManager.getInstance().playSound(R.raw.musicgame, "Game", true,
				context);
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

		Thread processo = new Thread(this);
		processo.start();

		// TODO Auto-generated constructor stub
	}

	public void setFase(Scene carreg) {
		this.asset = carreg;
		geometricFigures = asset.figuras();
		rects = asset.getRect();
		rectsColor = asset.getRectColor();
		asset.setconfig(getWidth(), getHeight(), paint);

		totalPoints = rectsColor.length;
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		asset.setconfig(getWidth(), getHeight(), paint);

		positionX = (int) getWidth() / 2;
		positionY = (int) getHeight() / 2;
		asset.setXY(positionX, positionY);
		Back.set(0, 0, getWidth(), getHeight());
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		if (hitPoints != totalPoints) {

			canvas.drawBitmap(Backgrounds[2], null, Back, paint);

			asset.Draw(canvas);
		}

		// Condição de derrota.
		if (period == 0) {
			// classe de derrota
			// canvas.drawBitmap(Backgrounds[1], null, Back, paint);
		}

		// Condição de vitória.
		if (hitPoints == totalPoints) {
			// classe de vitoria
			// canvas.drawBitmap(Backgrounds[0], null, Back, paint);
			SceneManager.ChangeScene(context);
			SoundManager.getInstance().playSound(R.raw.acerto, "sound", false,
					context);
			hitPoints = 0;
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
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
							rects[i].setEmpty();
							movendo = false;
							mov = null;
							hitPoints++;
							SoundManager.getInstance().playSound(R.raw.acerto,
									"MenuSound", false, context);

						} else {
							SoundManager.getInstance().playSound(R.raw.erro,
									"MenuSound", false, context);

						}
					}
				}
			}
			if (mov != null) {

				asset.setRectInicial(mov);

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

	}

	public void run() {
		while (true) {
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
}