package com.nave.shapesafari;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class Scene {
	Bitmap[] geometricFigures = new Bitmap[7];

	Rect[] rect = new Rect[3];

	Rect[] rectColor = new Rect[3];
	int points;

	public Bitmap[] figuras() {
		return geometricFigures;
	}


	public void Variar(int sort) {
	}

	public void setconfig(int larg, int Alt, Paint paint) {
	}
	public void setconf(int larg, int Alt) {
	}
	
	public int getPoint() {
		return points;
	}

	public void setXY(int x, int y) {
	}
	public void update(long deltaTime) {
	}
	public Rect[] getRect() {
		return rect;
	}

	public Rect[] getRectColor() {
		return rectColor;
	}

	public void colidiu(Rect rect, Rect rectcolor, int i) {
	}

	public void setRectInicial(Rect rec) {
	}

	public void setRect(Rect i) {
	}

	public void Draw(Canvas canvas) {
	}

}
