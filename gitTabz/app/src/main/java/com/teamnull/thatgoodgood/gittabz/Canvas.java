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
    float s1;
    float s2;
    float s3;
    float s4;
    float s5;
    float s6;
    float temp;
    float width;
    float yLocation;
    boolean isTouched;

    public Canvas(Context context, float newS1) {
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);

        s1 = getWidth();
        s1 = 500;
        s2 = 1000;
        s3 = 2000;
        s4 = 3000;
        s5 = 2000;
        s6 = 3000;
        isTouched = true;
    }

    Paint p = new Paint();
    Paint q = new Paint();
    Paint r = new Paint();

    @Override
    protected void onDraw(android.graphics.Canvas canvas){
        super.onDraw(canvas);
        width = canvas.getWidth();
        r.setStyle(Paint.Style.FILL);
        r.setStrokeWidth(2);
        r.setShader(new LinearGradient(0, 0, 0, canvas.getHeight(), Color.BLUE, Color.RED, Shader.TileMode.MIRROR));

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
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight()/8 -55, canvas.getWidth() / 8 + 55, canvas.getHeight()/8 * 6 + 55, r);

        //These are all of the circles
        canvas.drawCircle(s1, canvas.getHeight() / 8, 25, p);
        canvas.drawCircle(s2, canvas.getHeight() / 8 * 2, 25, p);
        canvas.drawCircle(s3, canvas.getHeight() / 8 * 3, 25, p);
        canvas.drawCircle(s4, canvas.getHeight() / 8 * 4, 25, p);
        canvas.drawCircle(s5, canvas.getHeight() / 8 * 5, 25, p);
        canvas.drawCircle(s6, canvas.getHeight() / 8 * 6, 25, p);

        //This is the Transparent rectangle that goes over the red one.
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight()/8 -55, canvas.getWidth() / 8 + 55, canvas.getHeight()/8 * 6 + 55, p);

        //The bar lines the notes will go on
        canvas.drawLine(0, canvas.getHeight() / 8,canvas.getWidth(), canvas.getHeight() / 8, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 2,canvas.getWidth(), canvas.getHeight()/8 * 2, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 3, canvas.getWidth(), canvas.getHeight()/8 * 3, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 4, canvas.getWidth(), canvas.getHeight()/8 * 4, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 5, canvas.getWidth(), canvas.getHeight() / 8 * 5, q);
        canvas.drawLine(0, canvas.getHeight()/8 * 6,canvas.getWidth() , canvas.getHeight()/8 * 6, q);

        if( s1 > canvas.getClipBounds().right )
            s1 = temp;
        //Variable calculates change in x. Higher the # faster the circles move
        if(isTouched) {
            if (s1 > 0) {
                s1 -= 5;
            } else {
                s1 = canvas.getWidth();
                invalidate();
            }

            if (s2 > 0) {
                s2 -= 5;
            } else {
                s2 = canvas.getWidth();
                invalidate();
            }

            if (s3 > 0) {
                s3 -= 5;
            } else {
                s3 = canvas.getWidth();
                invalidate();
            }

            if (s4 > 0) {
                s4 -= 5;
            } else {
                s4 = canvas.getWidth();
                invalidate();
            }

            if (s5 > 0) {
                s5 -= 5;
            } else {
                s5 = canvas.getWidth();
                invalidate();
            }

            if (s6 > 0) {
                s6 -= 5;
            } else {
                s6 = canvas.getWidth();
                invalidate();
            }

            //Infinite loop so circles keep moving
            invalidate();
        }
    }
    public boolean onTouchEvent (MotionEvent event) {


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                isTouched = false;
                //temp = event.getRawX();
                return true;
            case MotionEvent.ACTION_MOVE:
                //if( event.getRawX() < temp ) {
                   temp = event.getX();
                   /*
                    if(s1 == width) {
                        s1 = 0;
                        invalidate();
                    }
                    else if( s1 == 0 ) {
                        s1 = width -1;
                        invalidate();
                    }
                    */
                    //s2 -=  temp;
                    //s3 -= temp;
                    //s4 -= temp;
                    //s5 -= temp;
                    //s6 -= temp;
                    invalidate();
                    //return true;
                //}
                /*
                else if( event.getRawX() > temp ) {
                    s1 += event.getRawX();
                    s2 += event.getRawX();
                    s3 += event.getRawX();
                    s4 += event.getRawX();
                    s5 += event.getRawX();
                    s6 += event.getRawX();
                    invalidate();
                    //return true;
                }
                */
                return true;
            case MotionEvent.ACTION_UP:
                isTouched = true;
                temp = 0;
                invalidate();
                return true;
        }
        return false;
    }
}

