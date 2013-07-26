package ETAPA1;

import java.util.Random;

import com.example.brinquedo1.Scene;

import Gerenciadores.ImageManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase2_Assets extends Scene {

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

	public void setconf(int larg, int Alt) {
		this.larg = larg;
		this.alt = Alt;
		this.paint = paint;
		for (int i = 0; i < rect.length; i++) {
			WidthBitmap[i] = geometricFigures[i + 3].getWidth()
					* ((int) (9 * this.alt / 30) - (int) (this.alt / 30))
					/ geometricFigures[i + 3].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (12.8f * this.larg / 20) - (int) (11f * this.larg / 20))
					/ geometricFigures[i].getWidth();
		}

		rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
				(int) (this.alt / 30),
				(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
				(int) (9 * this.alt / 30));
		WidthBitmap[1] = geometricFigures[4].getWidth()
				* ((int) (19 * this.alt / 30) - (int) (9.5 * this.alt / 30))
				/ geometricFigures[4].getHeight();
		rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
				(int) (9.5 * this.alt / 30),
				(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
				(int) (19 * this.alt / 30));
		WidthBitmap[2] = geometricFigures[5].getWidth()
				* ((int) (19 * this.alt / 30) - (int) (9.5 * this.alt / 30))
				/ geometricFigures[5].getHeight();
		rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
				(int) (19.5 * this.alt / 30),
				(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
				(int) (29 * this.alt / 30));
		rectColor[0].set((int) (7 * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[0], (int) (8.8f * this.larg / 20),
				7 * this.alt / 8);

		rectColor[1].set((int) (11f * this.larg / 20), (int) (7 * this.alt / 8)
				- HeightBitmap[1], (int) (12.8 * this.larg / 20),
				7 * this.alt / 8);
		HeightBitmap[2] = geometricFigures[2].getHeight()
				* ((int) (17.4f * this.larg / 20) - (int) (15.9f * this.larg / 20))
				/ geometricFigures[2].getWidth();
		rectColor[2].set((int) (15.9f * this.larg / 20),
				(int) (7 * this.alt / 8) - HeightBitmap[2],
				(int) (17.4 * this.larg / 20), (int) (7 * this.alt / 8));
	}

	public void setconfig(int larg, int Alt, Paint paint) {
		this.larg = larg;
		this.alt = Alt;
		this.paint = paint;
		for (int i = 0; i < rect.length; i++) {
			WidthBitmap[i] = geometricFigures[i + 3].getWidth()
					* ((int) (9 * this.alt / 30) - (int) (this.alt / 30))
					/ geometricFigures[i + 3].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (12.8f * this.larg / 20) - (int) (11f * this.larg / 20))
					/ geometricFigures[i].getWidth();
		}
		if (!rect[0].isEmpty()) {

			rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
					(int) (this.alt / 30),
					(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
					(int) (9 * this.alt / 30));
		}
		WidthBitmap[1] = geometricFigures[4].getWidth()
				* ((int) (19 * this.alt / 30) - (int) (9.5 * this.alt / 30))
				/ geometricFigures[4].getHeight();
		if (!rect[1].isEmpty()) {

			rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
					(int) (9.5 * this.alt / 30),
					(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
					(int) (19 * this.alt / 30));
		}
		WidthBitmap[2] = geometricFigures[5].getWidth()
				* ((int) (19 * this.alt / 30) - (int) (9.5 * this.alt / 30))
				/ geometricFigures[5].getHeight();
		if (!rect[2].isEmpty()) {

			rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
					(int) (19.5 * this.alt / 30),
					(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
					(int) (29 * this.alt / 30));
		}
		rectColor[0].set((int) (7 * this.larg / 20), 7 * this.alt / 8
				- HeightBitmap[0], (int) (8.8f * this.larg / 20),
				7 * this.alt / 8);

		rectColor[1].set((int) (11f * this.larg / 20), (int) (7 * this.alt / 8)
				- HeightBitmap[1], (int) (12.8 * this.larg / 20),
				7 * this.alt / 8);
		HeightBitmap[2] = geometricFigures[2].getHeight()
				* ((int) (17.4f * this.larg / 20) - (int) (15.9f * this.larg / 20))
				/ geometricFigures[2].getWidth();
		rectColor[2].set((int) (15.9f * this.larg / 20),
				(int) (7 * this.alt / 8) - HeightBitmap[2],
				(int) (17.4 * this.larg / 20), (int) (7 * this.alt / 8));
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
		/*
		 * for (int i = 0; i < rect.length; i++) { if (rect[i] == rec && i != 0)
		 * {
		 * 
		 * rect[i].set(this.larg / 40, i * this.alt / 3, this.larg / 6, (int)
		 * ((i * 2 + 1.5f) * this.alt / 6)); } if (rect[i] == rec && i == 0) {
		 * rect[i].set(this.larg / 40, this.alt / 30, this.larg / 6, (int) ((i *
		 * 2 + 1.5f) * this.alt / 6));
		 * 
		 * } }
		 */

		for (int i = 0; i < rect.length; i++) {

			if (!rect[i].isEmpty()) {
				if (rect[i] == rec && i != 0) {

					rect[i].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[i] / 2),
							(int) (((i * 10) - 0.5) * this.alt / 30),
							(int) (3.5 * this.larg / 40 + WidthBitmap[i] / 2),
							(int) (((i * 10) + 9) * this.alt / 30));
				}
				if (rect[i] == rec && i == 0) {
					rect[i].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[i] / 2),
							this.alt / 30,
							(int) (3.5 * this.larg / 40 + WidthBitmap[i] / 2),
							(int) (9 * this.alt / 30));

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
