package com.example.brinquedo1;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class CarregarAssets {

	Bitmap[] geometricFigures = new Bitmap[7];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	Rect[] rect = new Rect[3];

	public CarregarAssets(Context context, Paint paint) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("hipo.png");
		geometricFigures[1] = img.ImageManager("macaco.png");
		geometricFigures[2] = img.ImageManager("leao.png");
		geometricFigures[3] = img.ImageManager("hipoCor.png");
		geometricFigures[4] = img.ImageManager("macacoCor.png");
		geometricFigures[5] = img.ImageManager("leaoCor.png");
		geometricFigures[6] = geometricFigures[3];
		rect[0] = new Rect();
		rect[1] = new Rect();
		rect[2] = new Rect();

		this.paint = paint;

	}

	public Bitmap[] figuras() {
		return geometricFigures;
	}

	public void Variar(int sort) {

		geometricFigures[6] = geometricFigures[sort];
	}

	public void setconfig(int larg, int Alt) {
		this.larg = larg;
		this.alt = Alt;
		rect[0].set(this.larg / 40, this.alt / 30, this.larg / 6,
				(int) (1.5f * this.alt / 6));
		rect[1].set(this.larg / 40, this.alt / 3, this.larg / 6,
				(int) (3.5f * this.alt / 6));
		rect[2].set(this.larg / 40, 2 * this.alt / 3, this.larg / 6,
				(int) (5.5f * this.alt / 6));
	}

	public void setXY(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public Rect[] getRect() {
		return rect;
	}

	public void setRectInicial(Rect rec) {
		for (int i = 0; i < rect.length; i++) {
			if (rect[i] == rec && i!=0) {

				rect[i].set(this.larg / 40, i * this.alt / 3, this.larg / 6,
						(int) ((i * 2 + 1.5f) * this.alt / 6));
			}
			if(rect[i]==rec && i==0){
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

		canvas.drawBitmap(geometricFigures[3], null, rect[0], paint);
		canvas.drawBitmap(geometricFigures[4], null, rect[1], paint);

		canvas.drawBitmap(geometricFigures[5], null, rect[2], paint);

		// canvas.drawBitmap(geometricFigures[0], 0, 0, paint);
		// canvas.drawBitmap(geometricFigures[1], larg / 3, 0, paint);
		// canvas.drawBitmap(geometricFigures[2], larg - 100, 0, paint);

		// Imagem que ficará na parte de baixo (figura geométrica em PB).
		// if (geometricFigures[6] != null)
		// canvas.drawBitmap(geometricFigures[6], X, Y, paint);

	}
}
