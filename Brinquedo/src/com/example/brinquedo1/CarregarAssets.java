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

	}

	public void setXY(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public void Draw(Canvas canvas) {

		canvas.drawBitmap(geometricFigures[0], 0, 0, paint);
		canvas.drawBitmap(geometricFigures[1], larg / 3, 0, paint);
		canvas.drawBitmap(geometricFigures[2], larg - 100, 0, paint);

		// Imagem que ficará na parte de baixo (figura geométrica em PB).
		if (geometricFigures[6] != null)
			canvas.drawBitmap(geometricFigures[6], X, Y, paint);

	}
}
