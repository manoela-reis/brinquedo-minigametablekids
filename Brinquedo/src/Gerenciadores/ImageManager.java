package Gerenciadores;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

// Classe responsável pelo gerenciamento das imagens. 
public  class ImageManager  
{
        Bitmap bitmap;  
        int positionX;
        int positionY;
        Context context;
        private static HashMap<String,Bitmap> sBitmapCache = new HashMap<String,Bitmap>();

        public ImageManager (Context context){
        this.context=context;
        }
        
        // Método pra carregar imagem da pasta Assets.
        public  Bitmap ImageManager(String name) 
        {
                try 
                {
                	Bitmap mBitmap = sBitmapCache.get(name);
                	 
                    if (mBitmap == null) {
                        InputStream img = context.getAssets().open(name);
                        bitmap = BitmapFactory.decodeStream(img);
                        sBitmapCache.put(name, bitmap);
                    
                    }
                }
                
                catch (IOException e) 
                {
                        Log.e("fooi", "Erro carregando imagem");
                }
                return sBitmapCache.get(name);
        }
}
