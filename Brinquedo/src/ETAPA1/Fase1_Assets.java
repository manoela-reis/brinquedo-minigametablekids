package ETAPA1;

import java.util.Random;

import com.example.brinquedo1.Scene;
import com.example.brinquedo1.Sprite;

import Gerenciadores.ImageManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

public class Fase1_Assets extends Scene {

	Bitmap[] geometricFigures = new Bitmap[6];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	int[] HeightBitmap = new int[3];
	int[] WidthBitmap = new int[3];
	Rect[] rect = new Rect[3];
	int points=0;

	Rect[] rectColor = new Rect[3];

	// Rect[] rectWhite = new Rect[3];

	public Fase1_Assets(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("hipo.png");
		geometricFigures[1] = img.ImageManager("macaco.png");
		geometricFigures[2] = img.ImageManager("leao.png");
		geometricFigures[3] = img.ImageManager("hipoCor.png");
		geometricFigures[4] = img.ImageManager("macacoCor.png");
		geometricFigures[5] = img.ImageManager("leaoCor.png");

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
					* ((int) (8 * this.alt / 30) - (this.alt / 30))
					/ geometricFigures[i + 3].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (18.2f * this.larg / 20) - (int) (15 * this.larg / 20))
					/ geometricFigures[i].getWidth();
		}

		rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
				2 * this.alt / 30,
				(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
				(int) (9 * this.alt / 30));
		rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
				11 * this.alt / 30,
				(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
				(int) (18 * this.alt / 30));
		rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
				21 * this.alt / 30,
				(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
				(int) (28 * this.alt / 30));

		rectColor[0].set((int) (6 * this.larg / 20),
				(int) (4.9f * this.alt / 8), (int) (9.2 * this.larg / 20),
				(int) (4.9f * this.alt / 8) + HeightBitmap[0]);

		rectColor[1].set((int) (10.9f * this.larg / 20),
				(int) (4.9f * this.alt / 8), (int) (14.2 * this.larg / 20),
				(int) (4.9f * this.alt / 8) + HeightBitmap[1]);

		rectColor[2].set((int) (15f * this.larg / 20),
				(int) (4.9f * this.alt / 8), (int) (18.2 * this.larg / 20),
				(int) (4.9f * this.alt / 8) + HeightBitmap[2]);

	}

	public void setconfig(int larg, int Alt, Paint paint) {
		this.larg = larg;
		this.alt = Alt;
		this.paint = paint;

		for (int i = 0; i < rect.length; i++) {
			WidthBitmap[i] = geometricFigures[i + 3].getWidth()
					* ((int) (8 * this.alt / 30) - (this.alt / 30))
					/ geometricFigures[i + 3].getHeight();
		}
		for (int i = 0; i < rectColor.length; i++) {
			HeightBitmap[i] = geometricFigures[i].getHeight()
					* ((int) (18.2f * this.larg / 20) - (int) (15 * this.larg / 20))
					/ geometricFigures[i].getWidth();
		}

		if (!rect[0].isEmpty()) {

			rect[0].set((int) (3.5 * this.larg / 40 - WidthBitmap[0] / 2),
					2 * this.alt / 30,
					(int) (3.5 * this.larg / 40 + WidthBitmap[0] / 2),
					(int) (9 * this.alt / 30));
		}
		if (!rect[1].isEmpty()) {

			rect[1].set((int) (3.5 * this.larg / 40 - WidthBitmap[1] / 2),
					11 * this.alt / 30,
					(int) (3.5 * this.larg / 40 + WidthBitmap[1] / 2),
					(int) (18 * this.alt / 30));
		}
		if (!rect[2].isEmpty()) {

			rect[2].set((int) (3.5 * this.larg / 40 - WidthBitmap[2] / 2),
					21 * this.alt / 30,
					(int) (3.5 * this.larg / 40 + WidthBitmap[2] / 2),
					(int) (28 * this.alt / 30));
		}

		rectColor[0].set((int) (6 * this.larg / 20),
				(int) (4.9f * this.alt / 8), (int) (9.2 * this.larg / 20),
				(int) (4.9f * this.alt / 8) + HeightBitmap[0]);

		rectColor[1].set((int) (10.9f * this.larg / 20),
				(int) (4.9f * this.alt / 8), (int) (14.2 * this.larg / 20),
				(int) (4.9f * this.alt / 8) + HeightBitmap[1]);

		rectColor[2].set((int) (15f * this.larg / 20),
				(int) (4.9f * this.alt / 8), (int) (18.2 * this.larg / 20),
				(int) (4.9f * this.alt / 8) + HeightBitmap[2]);

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
				if (rect[i] == rec && i != 0) {

					rect[i].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[i] / 2),
							((i * 10) + 1) * this.alt / 30,
							(int) (3.5 * this.larg / 40 + WidthBitmap[i] / 2),
							(int) (((i * 10) + 8) * this.alt / 30));
				}
				if (rect[i] == rec && i == 0) {
					rect[i].set(
							(int) (3.5 * this.larg / 40 - WidthBitmap[i] / 2),
							i * 10 + 2 * this.alt / 30,
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
