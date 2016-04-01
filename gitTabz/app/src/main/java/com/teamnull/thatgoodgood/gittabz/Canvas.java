package com.teamnull.thatgoodgood.gittabz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Jonathon on 3/31/2016.
 */

public class Canvas extends View {

    Bitmap ball;
    float changingy;

    public Canvas(Context context) {
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        changingy = 0;
    }

    Paint p = new Paint();

    @Override
    protected void onDraw(android.graphics.Canvas canvas){
        super.onDraw(canvas);
        p.setStrokeWidth(2);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.TRANSPARENT);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);

        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(canvas.getWidth()/4, changingy, 25, p);

        canvas.drawBitmap(ball, (canvas.getWidth() / 2), changingy, null);
        if (changingy < canvas.getHeight()) {
            changingy += 10;
        } else {
            changingy = 0;
        }

        invalidate();
    }
}

