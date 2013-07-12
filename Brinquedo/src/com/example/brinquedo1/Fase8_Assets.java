package com.example.brinquedo1;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase8_Assets extends Scene {

	Bitmap[] geometricFigures = new Bitmap[10];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	Rect[] rect = new Rect[5];

	Rect[] rectColor = new Rect[5];

	public Fase8_Assets(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("leao.png");
		geometricFigures[1] = img.ImageManager("elefante-02.png");
		geometricFigures[2] = img.ImageManager("macaco.png");
		geometricFigures[3] = img.ImageManager("girafaEdit.png");
		geometricFigures[4] = img.ImageManager("avestruzEdit.png");
		geometricFigures[5] = img.ImageManager("leaoCor.png");
		geometricFigures[6] = img.ImageManager("elefanteCor-06.png");
		geometricFigures[7] = img.ImageManager("macacoCor.png");
		geometricFigures[8] = img.ImageManager("girafaCor.png");
		geometricFigures[9] = img.ImageManager("avestruzCorEdit.png");
		rect[0] = new Rect();
		rect[1] = new Rect();
		rect[2] = new Rect();
		rect[3] = new Rect();
		rect[4] = new Rect();
		rectColor[0] = new Rect();
		rectColor[1] = new Rect();
		rectColor[2] = new Rect();
		rectColor[3] = new Rect();
		rectColor[4] = new Rect();

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
		this.paint = paint;
		rect[0].set(this.larg / 40, this.alt / 30, this.larg / 6,
				(int) (1.5f * this.alt / 6));
		rect[1].set(this.larg / 40, this.alt / 3, this.larg / 6,
				(int) (3.5f * this.alt / 6));
		rect[2].set(this.larg / 40, 2 * this.alt / 3, this.larg / 6,
				(int) (5.5f * this.alt / 6));
		rect[3].set(this.larg / 40, 2 * this.alt / 3, this.larg / 6,
				(int) (5.5f * this.alt / 6));
		rect[4].set(this.larg / 40, 2 * this.alt / 3, this.larg / 6,
				(int) (5.5f * this.alt / 6));
		rectColor[0].set((int) (6 * this.larg / 20), 5 * this.alt / 8,
				(int) (9.5 * this.larg / 20), 7 * this.alt / 8);

		rectColor[1].set((int) (10.9f * this.larg / 20), 5 * this.alt / 8,
				(int) (14.5f * this.larg / 20), 7 * this.alt / 8);

		rectColor[2].set((int) (15f * this.larg / 20), 5 * this.alt / 8,
				(int) (18.5f * this.larg / 20), 7 * this.alt / 8);

		rectColor[3].set((int) (15f * this.larg / 20), 5 * this.alt / 8,
				(int) (18.5f * this.larg / 20), 7 * this.alt / 8);
		rectColor[4].set((int) (15f * this.larg / 20), 5 * this.alt / 8,
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

	public void colidiu(Rect rect, Rect rectcolor, int i) {

		rect.set(rectcolor);

		geometricFigures[i] = geometricFigures[i + 3];
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

		for (int i = 0; i < rect.length; i++) {

			canvas.drawBitmap(geometricFigures[i], null, rectColor[i], paint);

			canvas.drawBitmap(geometricFigures[i + 3], null, rect[i], paint);
		}

	}
}
