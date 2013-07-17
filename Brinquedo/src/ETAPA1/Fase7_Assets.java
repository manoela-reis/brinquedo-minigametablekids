package ETAPA1;

import java.util.Random;

import com.example.brinquedo1.Scene;


import Gerenciadores.ImageManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Fase7_Assets extends Scene{

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

	public Fase7_Assets(Context context) {

		// int current = rnd.nextInt(3);
		img = new ImageManager(context);

		geometricFigures[0] = img.ImageManager("girafaEdit.png");
		geometricFigures[1] = img.ImageManager("cervo-03.png");
		geometricFigures[2] = img.ImageManager("zebra-04.png");
		geometricFigures[3] = img.ImageManager("avestruzEdit.png");
		geometricFigures[4] = img.ImageManager("girafaCor.png");
		geometricFigures[5] = img.ImageManager("cervoCor-06.png");
		geometricFigures[6] = img.ImageManager("zebra-07.png");
		geometricFigures[7] = img.ImageManager("avestruzCorEdit.png");
		rect[0] = new Rect();
		rect[1] = new Rect();
		rect[2] = new Rect();
		rect[3]=new Rect();
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
			WidthBitmap[i] = geometricFigures[i+4].getWidth()*((int)(10 * this.alt / 40)-( this.alt / 40))/geometricFigures[i+4].getHeight();
		}
		for(int i =0; i<rectColor.length;i++){
			HeightBitmap[i] = geometricFigures[i].getHeight()*((int) (14 * this.larg / 40)-(int) (10 * this.larg / 40))/geometricFigures[i].getWidth();
		}
		
		
		
		rect[0].set((int)(3.5*this.larg / 40 - WidthBitmap[0]/2), this.alt / 40, (int)(3.5*this.larg / 40 +WidthBitmap[0]/2),
				(int) (10 * this.alt / 40));
		rect[1].set((int)(3.5*this.larg / 40 - WidthBitmap[1]/2), (int)(10.5*this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[1]/2),
				(int) (19.5 * this.alt / 40));
		rect[2].set((int)(3.5*this.larg / 40 - WidthBitmap[2]/2), 20 * this.alt / 40, (int)(3.5*this.larg / 40 + WidthBitmap[2]/2),
				(int) (29 * this.alt / 40));
		rect[3].set((int)(3.5*this.larg / 40 - WidthBitmap[3]/2), (int)(30.5 * this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[3]/2),
				(int) (39.5 * this.alt / 40));

		rectColor[0].set((int) (10 * this.larg / 40), 7 * this.alt / 8-HeightBitmap[0],
				(int) (14 * this.larg / 40), 7 * this.alt / 8);

		rectColor[1].set((int) (18 * this.larg / 40), 7 * this.alt / 8-HeightBitmap[1],
				(int) (22 * this.larg / 40), 7 * this.alt / 8);

		HeightBitmap[2]= geometricFigures[2].getHeight()*((int) (32 * this.larg / 40)-(int) (27 * this.larg / 40))/geometricFigures[2].getWidth();

		rectColor[2].set((int) (27f * this.larg / 40), 7 * this.alt / 8-HeightBitmap[2],
				(int) (32 * this.larg / 40), 7 * this.alt / 8);
HeightBitmap[3]= geometricFigures[3].getHeight()*((int) (37 * this.larg / 40)-(int) (34 * this.larg / 40))/geometricFigures[3].getWidth();

		rectColor[3].set((int) (34 * this.larg / 40), 7 * this.alt / 8-HeightBitmap[3],
				(int) (37 * this.larg / 40), 7 * this.alt / 8);
		
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
			if(rec== rect[i]){
			if(i==0){
				
				rect[0].set((int)(3.5*this.larg / 40 - WidthBitmap[0]/2), this.alt / 40, (int)(3.5*this.larg / 40 +WidthBitmap[0]/2),
						(int) (10 * this.alt / 40));
			}
			if(i==1){
				rect[1].set((int)(3.5*this.larg / 40 - WidthBitmap[1]/2), (int)(10.5*this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[1]/2),
						(int) (19.5 * this.alt / 40));
			}
			if(i==2){
				rect[2].set((int)(3.5*this.larg / 40 - WidthBitmap[2]/2), 20 * this.alt / 40, (int)(3.5*this.larg / 40 + WidthBitmap[2]/2),
						(int) (29 * this.alt / 40));
			}
			if(i==3){
				rect[3].set((int)(3.5*this.larg / 40 - WidthBitmap[3]/2), (int)(30.5 * this.alt / 40), (int)(3.5*this.larg / 40 + WidthBitmap[3]/2),
						(int) (39.5 * this.alt / 40));
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
