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
    float changingx;
    public Canvas(Context context) {
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        changingx = 0;
    }

    Paint p = new Paint();
    Paint q = new Paint();
    @Override
    protected void onDraw(android.graphics.Canvas canvas){
        super.onDraw(canvas);
        q.setStrokeWidth(5);
        q.setStyle(Paint.Style.STROKE);
        q.setColor(Color.BLACK);
        p.setStrokeWidth(2);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.TRANSPARENT);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);

        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(changingx, canvas.getHeight() / 8, 25, p);
        canvas.drawCircle(changingx, canvas.getHeight() / 8 * 2, 25, p);
        canvas.drawCircle(changingx, canvas.getHeight() / 8 * 3, 25, p);
        canvas.drawCircle(changingx, canvas.getHeight() / 8 * 4, 25, p);
        canvas.drawCircle(changingx, canvas.getHeight() / 8 * 5, 25, p);
        canvas.drawCircle(changingx, canvas.getHeight() / 8 * 6, 25, p);

        canvas.drawLine(0, canvas.getHeight() / 8, canvas.getWidth(), canvas.getHeight() / 8, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 2, canvas.getWidth(), canvas.getHeight()/8 * 2, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 3, canvas.getWidth(), canvas.getHeight()/8 * 3, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 4, canvas.getWidth(), canvas.getHeight()/8 * 4, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 5, canvas.getWidth(), canvas.getHeight()/8 * 5, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 6, canvas.getWidth(), canvas.getHeight()/8 * 6, q);
        //canvas.drawBitmap(ball, (canvas.getWidth() / 2), changingx, null);

        if (changingx < canvas.getWidth()) {
            changingx += 5;
        } else {
            changingx = 0;
        }

        invalidate();
    }
}

