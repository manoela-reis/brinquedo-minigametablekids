package com.ETAPA2;

import java.util.Random;

import com.Gerenciadores.ImageManager;
import com.nave.shapesafari.Scene;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase6_Assets_ETAPA2 extends Scene {

	Bitmap[] geometricFigures = new Bitmap[7];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	Rect[] rect = new Rect[3];
	int points = 0;
	int[] HeightBitmap = new int[3];
	int[] WidthBitmap = new int[3];
	Rect[] rectColor = new Rect[3];

	public Fase6_Assets_ETAPA2(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("fase 1.2 passaro.png");
		geometricFigures[1] = img.ImageManager("fase 1.2 girafa.png");
		geometricFigures[2] = img.ImageManager("fase 6.2 tigre.png");
		geometricFigures[3] = img.ImageManager("passaroCorEdit.png");
		geometricFigures[4] = img.ImageManager("girafaCor.png");
		geometricFigures[5] = img.ImageManager("oncaCor-05.png");
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

	public void setconf(int larg, int Alt) {
		this.larg = larg;
		this.alt = Alt;
		this.paint = paint;
		for (int i = 0; i < rect.length; i++) {
			WidthBitmap[i] = geometricFigures[i].getWidth()
					* ((int) (8 * this.alt / 30) - (this.alt / 30))
					/ geometricFigures[i].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (18.2f * this.larg / 20) - (int) (15 * this.larg / 20))
					/ geometricFigures[i].getWidth();
		}

		WidthBitmap[1] = geometricFigures[1].getWidth()
				* ((int) (10 * this.alt / 30) - (this.alt / 30))
				/ geometricFigures[1].getHeight();

		rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
				2 * this.alt / 30,
				(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
				(int) (10 * this.alt / 30));

		WidthBitmap[2] = geometricFigures[2].getWidth()
				* ((int) (20 * this.alt / 30) - (11 * this.alt / 30))
				/ geometricFigures[2].getHeight();

		rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
				11 * this.alt / 30,
				(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
				(int) (20 * this.alt / 30));
		rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
				21 * this.alt / 30,
				(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
				(int) (28 * this.alt / 30));
		HeightBitmap[0] = geometricFigures[0].getHeight()
				* ((int) (8.9 * this.larg / 20) - (int) (6.7 * this.larg / 20))
				/ geometricFigures[0].getWidth();

		rectColor[0].set((int) (6.7 * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[0], (int) (8.9 * this.larg / 20),
				7 * this.alt / 8);
		HeightBitmap[1] = geometricFigures[1].getHeight()
				* ((int) (11.9 * this.larg / 20) - (int) (10.2 * this.larg / 20))
				/ geometricFigures[1].getWidth();

		rectColor[1].set((int) (10.7f * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[1], (int) (12.4 * this.larg / 20),
				7 * this.alt / 8);

		rectColor[2].set((int) (15f * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[2], (int) (18.2f * this.larg / 20),
				7 * this.alt / 8);
	}

	public void setconfig(int larg, int Alt, Paint paint) {
		this.larg = larg;
		this.alt = Alt;
		this.paint = paint;
		for (int i = 0; i < rect.length; i++) {
			WidthBitmap[i] = geometricFigures[i].getWidth()
					* ((int) (8 * this.alt / 30) - (this.alt / 30))
					/ geometricFigures[i].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (18.2f * this.larg / 20) - (int) (15 * this.larg / 20))
					/ geometricFigures[i].getWidth();
		}

		WidthBitmap[1] = geometricFigures[1].getWidth()
				* ((int) (10 * this.alt / 30) - (this.alt / 30))
				/ geometricFigures[1].getHeight();
		if (!rect[1].isEmpty()) {

			rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
					2 * this.alt / 30,
					(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
					(int) (10 * this.alt / 30));
		}

		WidthBitmap[2] = geometricFigures[2].getWidth()
				* ((int) (20 * this.alt / 30) - (11 * this.alt / 30))
				/ geometricFigures[2].getHeight();
		if (!rect[2].isEmpty()) {

			rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
					11 * this.alt / 30,
					(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
					(int) (20 * this.alt / 30));
		}
		if (!rect[0].isEmpty()) {

			rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
					21 * this.alt / 30,
					(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
					(int) (28 * this.alt / 30));
		}
		HeightBitmap[0] = geometricFigures[0].getHeight()
				* ((int) (8.9 * this.larg / 20) - (int) (6.7 * this.larg / 20))
				/ geometricFigures[0].getWidth();

		rectColor[0].set((int) (6.7 * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[0], (int) (8.9 * this.larg / 20),
				7 * this.alt / 8);
		HeightBitmap[1] = geometricFigures[1].getHeight()
				* ((int) (11.9 * this.larg / 20) - (int) (10.2 * this.larg / 20))
				/ geometricFigures[1].getWidth();

		rectColor[1].set((int) (10.7f * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[1], (int) (12.4 * this.larg / 20),
				7 * this.alt / 8);

		rectColor[2].set((int) (15f * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[2], (int) (18.2f * this.larg / 20),
				7 * this.alt / 8);
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

	public int getPoint() {
		return points;
	}

	public void colidiu(Rect rect, Rect rectcolor, int i) {

		for (int p = 0; p < this.rect.length; p++) {
			if (this.rect[p] == rect) {
				this.rect[p].setEmpty();
			}
		}

		points++;
		geometricFigures[i] = geometricFigures[i + 3];
	}

	public void setRectInicial(Rect rec) {
		for (int i = 0; i < rect.length; i++) {
			if (!rect[i].isEmpty()) {
				if (rect[i] == rec) {
					if (i == 0) {

						rect[0].set(
								(int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
								21 * this.alt / 30,
								(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
								(int) (28 * this.alt / 30));
					}
					if (i == 1) {
						rect[1].set(
								(int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
								2 * this.alt / 30,
								(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
								(int) (10 * this.alt / 30));

					}
					if (i == 2) {

						rect[2].set(
								(int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
								11 * this.alt / 30,
								(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
								(int) (20 * this.alt / 30));
					}

				}
			}

		}

	}

	public void setRect(Rect i) {

		i.set((int) (X - i.width() / 2), (int) (Y - i.height() / 2),
				(int) (X + i.width() / 2), (int) (Y + i.height() / 2));

	}

	public void Draw(Canvas canvas) {

		for (int i = 0; i < rect.length; i++) {

			canvas.drawBitmap(geometricFigures[i], null, rectColor[i], paint);
		}
		
		for (int i = 0; i < rect.length; i++)
		{
			canvas.drawBitmap(geometricFigures[i + 3], null, rect[i], paint);
		}

	}
}
