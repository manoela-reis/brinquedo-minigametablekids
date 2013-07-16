package com.example.brinquedo1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class EscolherEtapa extends View implements Runnable {
	private Bitmap background;
	private Bitmap etapa01;
	private Bitmap etapa02;
	
	private Rect recBackground = new Rect();
	private Rect rectEtapa01 = new Rect();
	private Rect rectEtapa02 = new Rect();
	
	private ImageManager picture;
	Paint paint;
	View fase01;
	Activity activity;
	private Fase2_Assets asset;
	private static int positionX;
	private static int positionY;

	public EscolherEtapa(Context context) {
		super(context);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		picture = new ImageManager(context);
		paint = new Paint();

		activity = (Activity) context;

		background = picture.ImageManager("fundoEscolhaEtapa.png");
		etapa01 = picture.ImageManager("MenuFasesEtapa1.png");
		etapa02 = picture.ImageManager("MenuFasesEtapa2.png");

		// TODO Auto-generated constructor stub
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	
		recBackground.set(0, 0, getWidth(), getHeight());
		rectEtapa01.set(0, (int)(getHeight()/6), getWidth()/2,  (int)(getHeight()/1.2f));
		rectEtapa02.set(getWidth()/2, (int)(getHeight()/6), getWidth(),  (int)(getHeight()/1.2f));
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		canvas.drawBitmap(background, null, recBackground, paint);
		canvas.drawBitmap(etapa01, null, rectEtapa01, paint);
		canvas.drawBitmap(etapa02, null, rectEtapa02, paint);
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i(MainActivity.TAG, "Entrou no action down");
		}

		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.i(MainActivity.TAG, "Entrou no action move");
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			Log.i(MainActivity.TAG, "Entrou no action up");
			int a = (int) event.getX();
			int b = (int) event.getY();

			// Etapa 1
			if (rectEtapa01.contains(a, b)) {
				Log.i(MainActivity.TAG, "Escolheu a Etapa1!! ");
				SceneManager.Setup((Activity)super.getContext());				
			}
			
			// Etapa 2
			if (rectEtapa02.contains(a, b)) {
				Log.i(MainActivity.TAG, "Escolheu a etapa2 !! ");
				SceneManager.Setup((Activity)super.getContext());				
			}
		
		}

		return super.onTouchEvent(event);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1);
			}

			catch (Exception e) {
				Log.e("Deu erro", "Quem sabe mete o pe");
			}

			postInvalidate();
		}
		// TODO Auto-generated method stub
	}

}