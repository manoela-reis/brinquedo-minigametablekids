package com.example.brinquedo1;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase2_Assets extends Scene{

	Bitmap[] geometricFigures = new Bitmap[7];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	Rect[] rect = new Rect[3];

	Rect[] rectColor = new Rect[3];

	public Fase2_Assets(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("passaroEdit.png");
		geometricFigures[1] = img.ImageManager("girafaEdit.png");
		geometricFigures[2] = img.ImageManager("avestruzEdit.png");
		geometricFigures[3] = img.ImageManager("passaroCorEdit.png");
		geometricFigures[4] = img.ImageManager("girafaCor.png");
		geometricFigures[5] = img.ImageManager("avestruzCorEdit.png");
		geometricFigures[6] = geometricFigures[3];
		rect[0] = new Rect();
		rect[1] = new Rect();
		rect[2] = new Rect();
		rectColor[0] = new Rect();
		rectColor[1] = new Rect();
		rectColor[2] = new Rect();

	}

	public Bitmap[] figuras() {
		return geometricFigures;
	}

	public void Variar(int sort) {

		geometricFigures[6] = geometricFigures[sort];
	}

	public void setconfig(int larg, int Alt, Paint paint) {
		this.larg = larg;
		this.alt = Alt;
		this.paint=paint;
		rect[0].set(this.larg / 40, this.alt / 30, this.larg / 6,
				(int) (1.5f * this.alt / 6));
		rect[1].set(this.larg / 40, this.alt / 3, this.larg / 6,
				(int) (3.5f * this.alt / 6));
		rect[2].set(this.larg / 40, 2 * this.alt / 3, this.larg / 6,
				(int) (5.5f * this.alt / 6));
		rectColor[0].set((int) (6 * this.larg / 20), 5 * this.alt / 8,
				(int) (9.5 * this.larg / 20), 7 * this.alt / 8);

		rectColor[1].set((int) (10.9f * this.larg / 20), 5 * this.alt / 8,
				(int) (14.5f * this.larg / 20), 7 * this.alt / 8);

		rectColor[2].set((int) (15f * this.larg / 20), 5 * this.alt / 8,
				(int) (18.5f * this.larg / 20), 7 * this.alt / 8);
	}

	public void setXY(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public Rect[] getRect() {
		return rect;
	}

	public Rect[] getRectColor() {
		return rectColor;
	}

	public void colidiu(Rect rect, Rect rectcolor,int i) {
		
				rect.set(rectcolor);
				
				geometricFigures[i]=geometricFigures[i+3];
				}

	public void setRectInicial(Rect rec) {
		for (int i = 0; i < rect.length; i++) {
			if (rect[i] == rec && i != 0) {

				rect[i].set(this.larg / 40, i * this.alt / 3, this.larg / 6,
						(int) ((i * 2 + 1.5f) * this.alt / 6));
			}
			if (rect[i] == rec && i == 0) {
				rect[i].set(this.larg / 40, this.alt / 30, this.larg / 6,
						(int) ((i * 2 + 1.5f) * this.alt / 6));

			}

		}

	}

	public void setRect(Rect i) {

		i.set((int) (X - i.width() / 2), (int) (Y - i.height() / 2),
				(int) (X + i.width() / 2), (int) (Y + i.height() / 2));

	}

	public void Draw(Canvas canvas) {

		for(int i=0;i<rect.length;i++){

			canvas.drawBitmap(geometricFigures[i], null, rectColor[i], paint);

			canvas.drawBitmap(geometricFigures[i+3], null, rect[i], paint);
		}
		

	}
}
