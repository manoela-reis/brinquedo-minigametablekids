package com.example.brinquedo1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
	int totalPoints = 3;
	int hitPoints = 0;
	Rect object_down;
	int[] order = new int[3];
	Rect[] areaObjectsUp = new Rect[3];
	private static int positionX;
	private static int positionY;
	private Canvas MyCanvas;
	private Random rnd = new Random();
	private int current;
	private int currentTime;
	ImageManager img;
	// Context context;
	CarregarAssets asset;
	Rect[] rects;
	Boolean movendo;
	Rect mov;

	public Fase02(Context context) {
		super(context);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);

		Backgrounds = new Bitmap[3];
		img = new ImageManager(context);
		paint = new Paint();

		paint.setColor(Color.BLACK);
		paint.setTextSize(20);

		asset = new CarregarAssets(context, paint);
		geometricFigures = asset.figuras();
		rects = asset.getRect();
		order[0] = current + 3;
		order[1] = 0;
		order[2] = 0;
		Backgrounds[0] = img.ImageManager("bgCongrats.bmp");
		Backgrounds[1] = img.ImageManager("bgGameOver.bmp");
		Backgrounds[2] = img.ImageManager("fundo.png");

		Thread processo = new Thread(this);
		processo.start();

		// TODO Auto-generated constructor stub
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		asset.setconfig(getWidth(), getHeight());

		positionX = (int) getWidth() / 2;
		positionY = (int) getHeight() / 2;
		asset.setXY(positionX, positionY);
		Back.set(0, 0, getWidth(), getHeight());
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		if (period != 0 && hitPoints != totalPoints) {
			MyCanvas = canvas;

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
			canvas.drawBitmap(Backgrounds[0], null, Back, paint);
			// SoundManager.getInstance().playSound(R.raw.acertei,
			// "MenuSound",true, super.getContext());
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
			if (currentTime == 0) {
				Log.i(MainActivity.TAG, "SHAKE !!!");
				int c = (int) event.getX();
				int d = (int) event.getY();

				// Testes de Colisão da imagem preto e branco de acordo com a
				// sua respectiva imagem colorida.

				if (movendo) {
					if (mov.contains(c, d)) {

						positionX = (int) event.getX();
						positionY = (int) event.getY();

						asset.setXY(positionX, positionY);

						asset.setRect(mov);

					} else {
						movendo = false;
						Log.i("ooi", "entrou no sssset");
						asset.setRectInicial(mov);
					}
				}

			}
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {

			movendo = false;
			if (mov != null)
				asset.setRectInicial(mov);
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

		if (currentTime != 0) {
			asset.geometricFigures[current] = asset.geometricFigures[6];
			positionX = getWidth() / 2;
			positionY = getHeight() / 2;
			if (currentTime - period >= 1) {

				// Verificação para não vir nenhuma figura geométrica repetida.
				while (current + 3 == order[0] || current + 3 == order[1]) {
					current = rnd.nextInt(3);
				}

				for (int i = 0; i < order.length; i++) {
					if (order[i] == 0) {
						order[i] = current + 3;
						break;
					}
				}
				asset.geometricFigures[6] = asset.geometricFigures[current + 3];

				// geometricFigures[6]=geometricFigures[current+3];

				asset.setXY(positionX, positionY);
				// asset.geometricFigures[6].eraseColor(VISIBLE);
				hitPoints++;
				currentTime = 0;
			}
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