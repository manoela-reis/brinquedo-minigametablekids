package Telas_Selecao;

import com.example.brinquedo1.MainActivity;

import ETAPA1.Fase2_Assets;
import Gerenciadores.ElMatador;
import Gerenciadores.ImageManager;
import Gerenciadores.Killable;
import Gerenciadores.SceneManager;
import Gerenciadores.SoundManager;
import Gerenciadores.SceneManager.SCENE;
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

public class EscolherEtapa extends View implements Runnable, Killable {
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
	public boolean ativo = true;
	int[] alturaideal = new int[18];
	Thread processo;

	public EscolherEtapa(Context context) {
		super(context);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		picture = new ImageManager(context);
		paint = new Paint();

		
		activity = (Activity) context;
		ElMatador.getInstance().add(this);


		background = picture.ImageManager("cenario_SelecaoFases.png");

		for (int i = 1; i <= etapa01.length; i++) {
			etapa01[i - 1] = picture.ImageManager("bot_" + i + ".png");

		}
		for (int i = 0; i < Etapa2.length; i++) {

			Etapa1[i] = new Rect();
			Etapa2[i] = new Rect();

		}
		this.processo=processo;
		processo=new Thread(this);
		processo.start();
		// TODO Auto-generated constructor stub
	}
	public void start(){

		processo = new Thread(this);
		processo.start();
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
					* ((int) (2.3 * alt / 8) - (int) (0.5 * alt / 8))
					/ etapa01[i].getHeight();
		}
		for (int i = 9; i < etapa01.length; i++) {
			alturaideal[i] = etapa01[i].getWidth()
					* ((int) (2.3 * alt / 8) - (int) (0.5 * alt / 8))
					/ etapa01[i].getHeight();
		}
		for (int i = 0; i < 5; i++) {
			Etapa1[i].set((int) ((3.5 * i + 1) * larg / 18),
					(int) (0.5 * alt / 8),
					(int) ((3.5 * i + 1) * larg / 18 + alturaideal[i]),
					(int) (2.3 * alt / 8));
			Etapa2[i].set((int) ((3.5 * i + 1) * larg / 18),
					(int) (4 * alt / 8),
					(int) ((3.5 * i + 1) * larg / 18 + alturaideal[i + 9]),
					(int) (5.8 * alt / 8));

		}
		for (int p = 0; p < 4; p++) {
			Etapa1[8 - p].set((int) ((2.5 + p * 3.5) * larg / 18),
					(int) (2.2 * alt / 8),
					(int) ((2.5 + p * 3.5) * larg / 18 + alturaideal[p + 5]),
					(int) (4.0 * alt / 8));
			Etapa2[8 - p]
					.set((int) ((2.5 + (p * 3.5)) * larg / 18),
							(int) (6 * alt / 8), (int) ((2.5 + (p * 3.5))
									* larg / 18 + alturaideal[p + 14]),
							(int) (7.8 * alt / 8));

		}
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		canvas.drawBitmap(background, null, recBackground, paint);
		for (int i = 0; i < 5; i++) {

			canvas.drawBitmap(etapa01[i], null, Etapa1[i], paint);
			canvas.drawBitmap(etapa01[9 + i], null, Etapa2[i], paint);

		}
		for (int i = 0; i < 4; i++) {

			canvas.drawBitmap(etapa01[5 + i], null, Etapa1[i + 5], paint);

			canvas.drawBitmap(etapa01[2 * Etapa1.length - 5 + i], null,
					Etapa2[i + 5], paint);

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

			for (int i = 0; i < 5; i++) {
				if (Etapa1[i].contains(a, b)) {
					Log.i(MainActivity.TAG, "Escolheu a Etapa1!! ");
					SceneManager.Setup((Activity) super.getContext(), 1, i, processo);

				}
				if (Etapa2[i].contains(a, b)) {
					Log.i(MainActivity.TAG, "Escolheu a Etapa1!! ");
					SceneManager.Setup((Activity) super.getContext(), 2, i,processo);

				}
			}
			for (int i = 0; i < 4; i++) {
				if (Etapa1[5 + i].contains(a, b)) {
					Log.i(MainActivity.TAG, "Escolheu a Etapa1!! ");
					SceneManager.Setup((Activity) super.getContext(), 1, 5 + i,processo);

				}
				if (Etapa2[5 + i].contains(a, b)) {
					Log.i(MainActivity.TAG, "Escolheu a Etapa1!! ");
					SceneManager.Setup((Activity) super.getContext(), 2, 5 + i,processo);
					processo.stop();

				}
			}
			

		}

		return super.onTouchEvent(event);
	}
	
	public void run() {
		while (ativo) {
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

	@Override
	public void killMeSoftly() {

		ativo = false;
	}

}