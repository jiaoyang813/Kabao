package com.oscar.kabaoapp.Common;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Oscar on 1/8/2018.
 */

public class ImageUtility {
    public static int[] scaleImage(int maxHeight, int maxWidth, int imageRid, ImageView image, View view)
    {
        int imageHeight = 0;
        int imageWdith = 0;
        final float scale = view.getResources().getDisplayMetrics().density;

        BitmapDrawable b = (BitmapDrawable) view.getResources().getDrawable(imageRid, view.getContext().getTheme());
        int actualHeight = b.getBitmap().getHeight();
        int actualWidth =  b.getBitmap().getWidth();

        if(actualWidth / (1.0 * actualHeight) * maxHeight > maxWidth )
        {
            imageWdith = maxWidth;
            imageHeight = (int) (actualHeight / (actualWidth * 1.0) * maxWidth);
        }else {
            imageHeight = maxHeight;
            imageWdith = (int)(actualWidth / (actualHeight * 1.0) * maxHeight);
        }

        int imageAdjustedHeight = (int)(imageHeight * scale);
        int imageAdjustedWdith = (int) (imageWdith * scale);

        image.getLayoutParams().height =imageAdjustedHeight;
        image.getLayoutParams().width =imageAdjustedWdith;

        int[] heightAndwidth = new int[2];
        heightAndwidth[0] = imageAdjustedHeight;
        heightAndwidth[1] =imageAdjustedWdith;
        return heightAndwidth;
    }

}
