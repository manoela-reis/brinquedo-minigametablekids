package com.example.brinquedo1;

import com.example.brinquedo1.MainActivity;

import Gerenciadores.ImageManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class Vitoria extends Scene
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
	
		picture = new ImageManager(context);
		paint = new Paint();


		paint.setColor(Color.BLACK);
		activity = (Activity) context;

		Log.i(TAG, "Entrou no construtor");
		creditos1[0] = picture.ImageManager("creditos1.png");
		background = picture.ImageManager("Vitoria.png");
		

		// TODO Auto-generated constructor stub
	}
	
	

	public void setconfig(int larg, int Alt, Paint paint) {
		
		rectCreditos1.set(0, 0,larg,Alt);
	}
	public void Draw(Canvas canvas) {

		
			canvas.drawBitmap(background, null, rectCreditos1, paint);
		
	}
}
