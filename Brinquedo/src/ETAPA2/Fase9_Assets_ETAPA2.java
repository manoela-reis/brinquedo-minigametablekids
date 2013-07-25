package ETAPA2;

import java.util.Random;

import com.example.brinquedo1.Scene;


import Gerenciadores.ImageManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase9_Assets_ETAPA2 extends Scene {

	Bitmap[] geometricFigures = new Bitmap[10];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	Rect[] rect = new Rect[5];

	int[] HeightBitmap = new int[5];
	int[] WidthBitmap = new int[5];
	Rect[] rectColor = new Rect[5];

	public Fase9_Assets_ETAPA2(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("fase 4.2 avestruz.png");
		geometricFigures[1] = img.ImageManager("fase 2.2 javali.png");
		geometricFigures[2] = img.ImageManager("fase 2.2 rino.png");
		geometricFigures[3] = img.ImageManager("fase 3.2 leao.png");
		geometricFigures[4] = img.ImageManager("fase 4.2 macaco.png");
		geometricFigures[5] = img.ImageManager("avestruzCorEdit.png");
		geometricFigures[6] = img.ImageManager("javaliCor-05.png");
		geometricFigures[7] = img.ImageManager("rinoCor.png");
		geometricFigures[8] = img.ImageManager("leaoCor.png");
		geometricFigures[9] = img.ImageManager("macacoCor.png");
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

		for (int i = 0; i < rect.length; i++) {
			WidthBitmap[i] = geometricFigures[i + 5].getWidth()
					* ((int) (10 * this.alt / 50) - (this.alt / 50))
					/ geometricFigures[i + 5].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (17 * this.larg / 50) - (int) (10 * this.larg / 50))
					/ geometricFigures[i].getWidth();
		}

		rect[3].set((int) (3.5 * this.larg / 40 - WidthBitmap[3] / 2),
				this.alt / 50,
				(int) (3.5 * this.larg / 40 + WidthBitmap[3] / 2),
				(int) (10 * this.alt / 50));
		rect[4].set((int) (3.5 * this.larg / 40 - WidthBitmap[4] / 2),
				(int) (10.5 * this.alt / 50),
				(int) (3.5 * this.larg / 40 + WidthBitmap[4] / 2),
				(int) (19.5 * this.alt / 50));
		rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
				20 * this.alt / 50,
				(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
				(int) (29 * this.alt / 50));
		rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
				(int) (30.5 * this.alt / 50),
				(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
				(int) (39.5 * this.alt / 50));

		rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
				(int) (40 * this.alt / 50),
				(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
				(int) (49 * this.alt / 50));
		HeightBitmap[0] = geometricFigures[0].getHeight()
				* ((int) (17.5 * this.larg / 50) - (int) (14 * this.larg / 50))
				/ geometricFigures[0].getWidth();

		rectColor[0].set((int) (13 * this.larg / 50),
				(int) (7 * this.alt / 8 - HeightBitmap[0]),
				(int) (16.5 * this.larg / 50), (int) (7 * this.alt / 8));
		HeightBitmap[1] = geometricFigures[1].getHeight()
				* ((int) (26 * this.larg / 50) - (int) (20 * this.larg / 50))
				/ geometricFigures[1].getWidth();

		rectColor[1].set((int) 19 * this.larg / 50,
				(int) (7 * this.alt / 8 - HeightBitmap[1]),
				(int) (25 * this.larg / 50), (int) (7 * this.alt / 8));

		HeightBitmap[2] = geometricFigures[2].getHeight()
				* ((int) (34.5 * this.larg / 50) - (int) (27.5 * this.larg / 50))
				/ geometricFigures[2].getWidth();

		rectColor[2].set((int) (26.5 * this.larg / 50), 7 * this.alt / 8
				- HeightBitmap[2], (int) (33.5 * this.larg / 50),
				7 * this.alt / 8);
		HeightBitmap[3] = geometricFigures[3].getHeight()
				* ((int) (40 * this.larg / 50) - (int) (34 * this.larg / 50))
				/ geometricFigures[3].getWidth();

		rectColor[3].set((int) (35 * this.larg / 50),
				(int) (7 * this.alt / 8 - HeightBitmap[3]),
				(int) (41 * this.larg / 50), (int) (7 * this.alt / 8));
		HeightBitmap[4] = geometricFigures[4].getHeight()
				* ((int) (48 * this.larg / 50) - (int) (41.5 * this.larg / 50))
				/ geometricFigures[4].getWidth();

		rectColor[4].set((int) (41.5 * this.larg / 50), 7 * this.alt / 8
				- HeightBitmap[4], (int) (48 * this.larg / 50),
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

	public void colidiu(Rect rect, Rect rectcolor, int i) {

		rect.set(rectcolor);

		geometricFigures[i] = geometricFigures[i + 5];
	}

	public void setRectInicial(Rect rec) {
		for (int i = 0; i < rect.length; i++) {
			if (rec == rect[i]) {
				if (i == 0) {

					rect[0].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
							20 * this.alt / 50,
							(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
							(int) (29 * this.alt / 50));

				}
				if (i == 1) {
					rect[1].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
							(int) (30.5 * this.alt / 50),
							(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
							(int) (39.5 * this.alt / 50));

				}
				if (i == 2) {
					rect[2].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
							(int) (40 * this.alt / 50),
							(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
							(int) (49 * this.alt / 50));
				}
				if (i == 3) {
					rect[3].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[3] / 2),
							this.alt / 50,
							(int) (3.5 * this.larg / 40 + WidthBitmap[3] / 2),
							(int) (10 * this.alt / 50));
				}
				if (i == 4) {
					rect[4].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[4] / 2),
							(int) (10.5 * this.alt / 50),
							(int) (3.5 * this.larg / 40 + WidthBitmap[4] / 2),
							(int) (19.5 * this.alt / 50));
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

			canvas.drawBitmap(geometricFigures[i + 5], null, rect[i], paint);
		}

	}
}
