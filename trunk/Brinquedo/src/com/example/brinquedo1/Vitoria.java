package com.example.brinquedo1;

import com.example.brinquedo1.MainActivity;

import Gerenciadores.ImageManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class Vitoria extends View implements Runnable
{
	private Bitmap []creditos1 = new Bitmap[5];
	private Bitmap background;
	private Rect  rectCreditos1 = new Rect();
	private ImageManager picture;
	private Paint paint;
	private View fase01;
	private View menu;
	Activity activity;
	int counter = 0;
	int period = 0;
	String TAG = "Creditos";
	int pos = 0;
	
	public Vitoria(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager(context);
		paint = new Paint();

		activity = (Activity) context;

		Log.i(TAG, "Entrou no construtor");
		creditos1[0] = picture.ImageManager("creditos1.png");
		background = picture.ImageManager("Vitoria.png");
		
		Thread processo = new Thread(this);
		processo.start();

		// TODO Auto-generated constructor stub
	}
	
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{

		super.onSizeChanged(w, h, oldw, oldh);

//		rectCreditos1.set(getWidth()/15,0,getWidth(),getHeight());		
		rectCreditos1.set(0,0,getWidth(),getHeight());	
		
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		canvas.drawBitmap(background, null, rectCreditos1, paint);

}

	
	public boolean onTouchEvent(MotionEvent event) 
	{	
		if (event.getAction() == MotionEvent.ACTION_DOWN) 
		{
			Log.i(TAG, "Entrou no action down");
		}
		
		if (event.getAction() == MotionEvent.ACTION_MOVE) 
		{
			Log.i(TAG, "Entrou no action move");
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
			Log.i(TAG, "Entrou no action up");
			int a = (int)event.getX();
			int b = (int)event.getY();

		}
		
		return super.onTouchEvent(event);
	}
	public void update() {

		counter++;
		if (counter == 1000) 
		{
 			period += 1;
//			counter = 0;
			Log.i(TAG, "Tempo:" + period);
		}
		
		if (period == 4)
		{
			pos ++;
//			creditos1 = picture.ImageManager("tela_creditos");
//			menu = new EscolherEtapa(activity);
//			activity.setContentView(menu);
			counter = 0;
//			period = 0; 
		
		}
		
/*		if (pos == 5)
		{
			pos = 0;
		}*/
		
		
/*		if (period == 8)
		{
			menu = new Menu(super.getContext());
			activity.setContentView(menu);
			counter = 0;
			period = 0; 
		}*/
			
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1);
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
