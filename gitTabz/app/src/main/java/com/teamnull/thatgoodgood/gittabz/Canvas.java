package com.teamnull.thatgoodgood.gittabz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;


/**
 * Created by Jonathon on 3/31/2016.
 */
public class Canvas extends View {

    Bitmap ball;


    public Canvas(Context context) {
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(ball, (canvas.getWidth()/2), canvas.getHeight()/2, null);


    }

}
