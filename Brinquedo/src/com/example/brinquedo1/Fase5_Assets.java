package com.example.brinquedo1;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase5_Assets extends Scene{

	Bitmap[] geometricFigures = new Bitmap[8];
	ImageManager img;
	Random rnd;
	Paint paint;
	int larg;
	int alt;
	int X;
	int Y;
	Rect[] rect = new Rect[4];

	int[] HeightBitmap=new int[4];
	int[] WidthBitmap = new int[4];
	Rect[] rectColor = new Rect[4];

	public Fase5_Assets(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("onca-02.png");
		geometricFigures[1] = img.ImageManager("zebra-04.png");
		geometricFigures[2] = img.ImageManager("Rino.png");
		geometricFigures[3] = img.ImageManager("cervo-03.png");
		geometricFigures[4] = img.ImageManager("oncaCor-05.png");
		geometricFigures[5] = img.ImageManager("zebra-07.png");
		geometricFigures[6] = img.ImageManager("rinoCor.png");
		geometricFigures[7] = img.ImageManager("cervoCor-06.png");
		rect[0] = new Rect();
		rect[1] = new Rect();
		rect[2] = new Rect();
		rect[3] = new Rect();
		rectColor[0] = new Rect();
		rectColor[1] = new Rect();
		rectColor[2] = new Rect();
		rectColor[3] = new Rect();

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
	
		

		for(int i =0; i<rect.length;i++){
			WidthBitmap[i] = geometricFigures[i+4].getWidth()*((int)(9 * this.alt / 40)-(int)(0.5 *this.alt / 40))/geometricFigures[i+4].getHeight();
		}
		for(int i =0; i<rectColor.length;i++){
			HeightBitmap[i] = geometricFigures[i].getHeight()*((int) (15 * this.larg / 40)-(int) (10 * this.larg / 40))/geometricFigures[i].getWidth();
		}
		
		
		
		rect[0].set((int)(3.5*this.larg / 40 - WidthBitmap[0]/2),(int)(0.5 *this.alt / 40), (int)(3.5*this.larg / 40 +WidthBitmap[0]/2),
				(int) (9 * this.alt / 40));
		WidthBitmap[1] = geometricFigures[5].getWidth()*((int)(19 * this.alt / 40)-(int)(9.5 *this.alt / 40))/geometricFigures[5].getHeight();

		rect[1].set((int)(3.5*this.larg / 40 - WidthBitmap[1]/2), (int)(9.5*this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[1]/2),
				(int) (19 * this.alt / 40));
		rect[2].set((int)(3.5*this.larg / 40 - WidthBitmap[2]/2), (int)(19.5 * this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[2]/2),
				(int) (28 * this.alt / 40));
		WidthBitmap[3] = geometricFigures[7].getWidth()*((int)(38 * this.alt / 40)-(int)(28.5 *this.alt / 40))/geometricFigures[7].getHeight();

		rect[3].set((int)(3.5*this.larg / 40 - WidthBitmap[3]/2), (int) (28.5 * this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[3]/2),
				(int) (38 * this.alt / 40));
		HeightBitmap[0] = geometricFigures[0].getHeight()*((int) (16 * this.larg / 40)-(int) (10 * this.larg / 40))/geometricFigures[0].getWidth();

		rectColor[0].set((int) (10 * this.larg / 40), 7 * this.alt / 8-HeightBitmap[0],
				(int) (16 * this.larg / 40), 7 * this.alt / 8);

		rectColor[1].set((int) (17 * this.larg / 40), 7 * this.alt / 8-HeightBitmap[1],
				(int) (22 * this.larg / 40), 7 * this.alt / 8);
		HeightBitmap[2] = geometricFigures[2].getHeight()*((int) (30 * this.larg / 40)-(int) (24 * this.larg / 40))/geometricFigures[2].getWidth();

		rectColor[2].set((int) (24f * this.larg / 40), 7 * this.alt / 8-HeightBitmap[2],
				(int) (30 * this.larg / 40), 7 * this.alt / 8);
		HeightBitmap[3] = geometricFigures[3].getHeight()*((int) (37.5 * this.larg / 40)-(int) (33 * this.larg / 40))/geometricFigures[3].getWidth();

		rectColor[3].set((int) (33 * this.larg / 40), 7 * this.alt / 8-HeightBitmap[3],
				(int) (37.5 * this.larg / 40), 7 * this.alt / 8);
		
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
				
				geometricFigures[i]=geometricFigures[i+4];
				}

	public void setRectInicial(Rect rec) {
		for (int i = 0; i < rect.length; i++) {
			if (rect[i] == rec && i != 0) {

				rect[i].set((int)(3.5*this.larg / 40 - WidthBitmap[i]/2), ((i *10)+1)* this.alt / 40, (int)(3.5*this.larg / 40 + WidthBitmap[i]/2),
						(int) (((i *10)+8) * this.alt / 40));
			}
			if (rect[i] == rec && i == 0) {
				rect[i].set((int)(3.5*this.larg / 40 - WidthBitmap[i]/2), i*10+2*this.alt / 40, (int)(3.5*this.larg / 40 + WidthBitmap[i]/2),
						(int) (9 * this.alt / 40));

			}
			if(rect[i]==rec){
				if(i==0){
					rect[0].set((int)(3.5*this.larg / 40 - WidthBitmap[0]/2),(int)(0.5 *this.alt / 40), (int)(3.5*this.larg / 40 +WidthBitmap[0]/2),
							(int) (9 * this.alt / 40));
					
				}
				if(i==1){
					
					rect[1].set((int)(3.5*this.larg / 40 - WidthBitmap[1]/2), (int)(9.5*this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[1]/2),
							(int) (19 * this.alt / 40));
					
				}
				if(i==2){
					rect[2].set((int)(3.5*this.larg / 40 - WidthBitmap[2]/2), (int)(19.5 * this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[2]/2),
							(int) (28 * this.alt / 40));
				
				}
				if(i==3){
					
					rect[3].set((int)(3.5*this.larg / 40 - WidthBitmap[3]/2), (int) (28.5 * this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[3]/2),
							(int) (38 * this.alt / 40));
				}
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

			canvas.drawBitmap(geometricFigures[i+4], null, rect[i], paint);
		}
		

	}
}