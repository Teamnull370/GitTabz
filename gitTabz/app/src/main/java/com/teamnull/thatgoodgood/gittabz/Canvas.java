package com.teamnull.thatgoodgood.gittabz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.RelativeLayout;

import static android.util.Log.d;
import static java.lang.Float.toString;

/**
 * Created by Jonathon on 3/31/2016.
 * ALL THE COOL PAINT STUFF DONE BY DANNY CUZ HE BE COOL AND SHIT
 */

public class Canvas extends View {

    float s1;
    float s2;
    float s3;
    float s4;
    float s5;
    float s6;
    float width;
    boolean isTouched;

    ///  prob delete this shit////
    int startX;
    int endX;

    public Canvas(Context context) {
        super(context);

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


        //Standard play with collision detection
        if(isTouched) {
            if (s1 > 0) {
                //Log.d("S1 isTouched", Float.toString(s1));
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

        }

        //Collision detection during play
        if(!isTouched) {
            if (s1 > canvas.getClipBounds().right) {
                s1 = 0;
            } else if (s1 < canvas.getClipBounds().left) {
                s1 = canvas.getWidth() - 1;
            }

            if (s2 > canvas.getClipBounds().right) {
                s2 = 0;
            } else if (s2 < canvas.getClipBounds().left) {
                s2 = canvas.getWidth() - 1;
            }

            if (s3 > canvas.getClipBounds().right) {
                s3 = 0;
            } else if (s3 < canvas.getClipBounds().left) {
                s3 = canvas.getWidth() - 1;
            }

            if (s4 > canvas.getClipBounds().right) {
                s4 = 0;
            } else if (s4 < canvas.getClipBounds().left) {
                s4 = canvas.getWidth() - 1;
            }

            if (s5 > canvas.getClipBounds().right) {
                s5 = 0;
            } else if (s5 < canvas.getClipBounds().left) {
                s5 = canvas.getWidth() - 1;
            }

            if (s6 > canvas.getClipBounds().right) {
                s6 = 0;
            } else if (s6 < canvas.getClipBounds().left) {
                s6 = canvas.getWidth() - 1;
            }
        }
        invalidate();
    }

    public boolean onTouchEvent (MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                isTouched = false;

                startX = (int) event.getRawX();

                return true;
            case MotionEvent.ACTION_MOVE:
                endX= (int)event.getRawX();

                if( (endX - startX)  > 0 ) {
                    // RIGHT
                    s1 += 25;
                    s2 += 25;
                    s3 += 25;
                    s4 += 25;
                    s5 += 25;
                    s6 += 25;

                }
                if( (endX - startX) < 0) {
                    // LEFT
                    s1 -= 25;
                    s2 -= 25;
                    s3 -= 25;
                    s4 -= 25;
                    s5 -= 25;
                    s6 -= 25;

                }

                startX = (int) event.getRawX();

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

