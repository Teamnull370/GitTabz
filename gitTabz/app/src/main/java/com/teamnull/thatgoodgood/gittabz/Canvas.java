package com.teamnull.thatgoodgood.gittabz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Jonathon on 3/31/2016.
 * ALL THE COOL PAINT STUFF DONE BY DANNY CUZ HE BE COOL AND SHIT
 */

public class Canvas extends View {

    Bitmap ball;
    float changingx;
    float xLocation;
    float yLocation;
    boolean isTouched;

    public Canvas(Context context, float newXLocation) {
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        changingx = getWidth();
        xLocation = newXLocation;
        isTouched = true;
    }

    Paint p = new Paint();
    Paint q = new Paint();
    Paint r = new Paint();

    @Override
    protected void onDraw(android.graphics.Canvas canvas){
        super.onDraw(canvas);
        r.setStyle(Paint.Style.FILL);
        r.setStrokeWidth(2);
        r.setColor(Color.RED);

        q.setStrokeWidth(5);
        q.setStyle(Paint.Style.STROKE);
        //q.setColor(Color.BLACK);
        q.setShader(new LinearGradient(0, 0, 0, canvas.getWidth(), Color.RED, Color.BLUE, Shader.TileMode.MIRROR));

        p.setStrokeWidth(2);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.TRANSPARENT);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);

        //This creates the white background
        canvas.drawColor(Color.WHITE);

       //This is the underlying red rectangle
        canvas.drawRect(canvas.getWidth() / 8, 0, canvas.getWidth() / 8 + 55, canvas.getHeight(), r);

        //These are all of the circles
        canvas.drawCircle(xLocation-50, canvas.getHeight() / 8, 25, p);
        canvas.drawCircle(xLocation-200, canvas.getHeight() / 8 * 2, 25, p);
        canvas.drawCircle(xLocation, canvas.getHeight() / 8 * 3, 25, p);
        canvas.drawCircle(xLocation-1000, canvas.getHeight() / 8 * 4, 25, p);
        canvas.drawCircle(xLocation-2000, canvas.getHeight() / 8 * 5, 25, p);
        canvas.drawCircle(xLocation, canvas.getHeight() / 8 * 6, 25, p);

        //This is the Transparent rectangle that goes over the red one.
        canvas.drawRect(canvas.getWidth() / 8, 0, canvas.getWidth() / 8 + 55, canvas.getHeight(), p);

        //The bar lines the notes will go on
        canvas.drawLine(0, canvas.getHeight() / 8,canvas.getWidth(), canvas.getHeight() / 8, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 2,canvas.getWidth(), canvas.getHeight()/8 * 2, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 3, canvas.getWidth(), canvas.getHeight()/8 * 3, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 4, canvas.getWidth(), canvas.getHeight()/8 * 4, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 5, canvas.getWidth(), canvas.getHeight() / 8 * 5, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 6,canvas.getWidth() , canvas.getHeight()/8 * 6, q);

        //Variable calculates change in x. Higher the # faster the circles move
        if(isTouched) {
            if (xLocation > 0) {
                xLocation -= 5;
            } else {
                xLocation = canvas.getWidth();
            }
            //Infinite loop so circles keep moving
            invalidate();
        }
    }
    public boolean onTouchEvent (MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isTouched = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                xLocation = event.getRawX();
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                isTouched = true;
                invalidate();
                return true;
        }
        return false;
    }
}

