package Telas_Selecao;

import com.example.brinquedo1.MainActivity;

import ETAPA1.Fase2_Assets;
import Gerenciadores.ImageManager;
import Gerenciadores.SceneManager;
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
	private Bitmap[] etapa01 = new Bitmap[18];

	private Rect recBackground = new Rect();
	private Rect[] Etapa1 = new Rect[9];
	private Rect[] Etapa2 = new Rect[9];
	int larg;
	int alt;
	private ImageManager picture;
	Paint paint;
	View fase01;
	Activity activity;
	private Fase2_Assets asset;
	private static int positionX;
	private static int positionY;

	int[] alturaideal = new int[18];

	public EscolherEtapa(Context context) {
		super(context);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		picture = new ImageManager(context);
		paint = new Paint();

		activity = (Activity) context;

		background = picture.ImageManager("cenario_SelecaoFases.png");

		for (int i = 1; i <= etapa01.length; i++) {
			etapa01[i - 1] = picture.ImageManager("bot_" + i + ".png");

		}
		for (int i = 0; i < Etapa2.length; i++) {

			Etapa1[i] = new Rect();
			Etapa2[i] = new Rect();

		}

		// TODO Auto-generated constructor stub
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		recBackground.set(0, 0, getWidth(), getHeight());
		setConfig(getWidth(), getHeight(), paint);

	}

	public void setConfig(int larg, int Alt, Paint paint) {
		this.larg = larg;
		this.alt = Alt;
		this.paint = paint;
		for (int i = 0; i < Etapa1.length; i++) {
			alturaideal[i] = etapa01[i].getWidth()
					* (alt / 4 - (int) (0.3 * alt / 4))
					/ etapa01[i].getHeight();
		}
		for (int i = 0; i < Etapa1.length; i++) {

			Etapa1[i]
					.set((i+1)*larg/9, (int) (0.3 * alt / 4), (i+1)*larg/9+alturaideal[i], alt / 4);

		}

	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		canvas.drawBitmap(background, null, recBackground, paint);
		for (int i = 0; i < Etapa1.length; i++) {

			canvas.drawBitmap(etapa01[i], null, Etapa1[i], paint);

		}
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
			/*if (rectEtapa01.contains(a, b)) {
				Log.i(MainActivity.TAG, "Escolheu a Etapa1!! ");
				SceneManager.Setup((Activity) super.getContext(), 1);
			}

			// Etapa 2
			if (rectEtapa02.contains(a, b)) {
				Log.i(MainActivity.TAG, "Escolheu a etapa2 !! ");
				SceneManager.Setup((Activity) super.getContext(), 2);
			}*/

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