package com.teamnull.thatgoodgood.gittabz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.RelativeLayout;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;
import android.view.GestureDetector.OnDoubleTapListener;
import static android.util.Log.d;
import static java.lang.Float.toString;
import android.support.v4.view.GestureDetectorCompat;

/**
 * Created by Jonathon on 3/31/2016.
 * ALL THE COOL PAINT STUFF DONE BY DANNY CUZ HE BE COOL AND SHIT
 */

class Circle {
    public float ln;
    public float ex;
    public float fr;

    public Circle(float x, int line, int fret) {
        ex = x;
        ln = line;
        fr = fret;

    }
        public void setX(float ex) { this.ex = ex; }
        public float getX(){return ex; }
        public void setLn(int ln) { this.ln = ln;}
        public float getLn() { return ln; }
        public void setFret(int fr) { this.fr = fr; }
        public float getFret() { return fr; }
}



public class Canvas extends View{
    MediaPlayer music;
    float s1;
    float s2;
    float s3;
    float s4;
    float s5;
    float s6;
    float width;
    int stringSpace;
    int time;
    int start;
    boolean isTouched;
    public ArrayList<ArrayNode> listy;
    public ArrayList<Circle> circles;
    private GestureDetectorCompat mDetector;
    int startX;
    int endX;


    boolean isPaused;



    public Canvas(Context context){
        super(context);
        init(context);
    }


    public Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Canvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        //do stuff that was in your original constructor...

        music = MediaPlayer.create(context, R.raw.song);
        s1 = getWidth();
        stringSpace = getHeight() / 8;
        s1 = 100;
        s2 = 1000;
        s3 = 1500;
        s4 = 2000;
        s5 = 2500;
        s6 = 3000;
        isTouched = true;
        circles = new ArrayList<>();
        time = music.getDuration();
        start = music.getCurrentPosition();
    }


    Paint p = new Paint();
    Paint q = new Paint();
    Paint r = new Paint();
    Paint num = new Paint();
    Paint w = new Paint();



    public void setList(ArrayList<ArrayNode> list){
        listy = list;
    }



    public void pause_music() {
        music.pause();
        isPaused = true;
        isTouched = false;
        // Log.d("PAUSE", "Pause function");
    }
    public void play_music() {
        music.start();
        isPaused = false;
        isTouched = true;
        // Log.d("PLAY", "Play function");
    }
    public void rewind_music() {
        music.seekTo(start -= 15000);
        s1 -= 200;
        // Log.d("REWIND", "Rewind function");
    }
    public void fast_forward_music() {
        music.seekTo(start += 15000);
        s1 += 200;
        // Log.d("FF", "Fast-Forward function");
    }
    public boolean pausetacular()   {
        return isPaused;
    }
    public void set_pause(boolean pause_state) {
        isPaused = pause_state;
    }


    @Override
    protected void onDraw(final android.graphics.Canvas canvas){


        if( !isPaused)
            music.start();
        // mDetector = new GestureDetectorCompat(this,this);
        super.onDraw(canvas);

        width = canvas.getWidth();
        r.setStyle(Paint.Style.FILL);
        r.setStrokeWidth(2);
        r.setShader(new LinearGradient(0, 0, 0, canvas.getHeight(), Color.BLUE, Color.RED, Shader.TileMode.MIRROR));

        //Paint settings for the number draw
        num.setColor(Color.BLACK);
        num.setTextSize(32f);
        num.setAntiAlias(true);
        num.setTextAlign(Paint.Align.CENTER);
        num.setStyle(Paint.Style.FILL);

        //Paint for the white-fill circle the number will go on
        w.setStyle(Paint.Style.FILL);
        w.setColor(Color.WHITE);

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
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight() / 8 - 55, canvas.getWidth() / 8 + 55, canvas.getHeight() / 8 * 6 + 55, r);

        ////////////The Beginging of the end/////////////////////


        //drawOne one = new drawOne(s1, true);





        ///////////THe End of the end///////////////

        //The bar lines the notes will go on
        canvas.drawLine(0, canvas.getHeight() / 8, canvas.getWidth(), canvas.getHeight() / 8, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 2, canvas.getWidth(), canvas.getHeight() / 8 * 2, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 3, canvas.getWidth(), canvas.getHeight() / 8 * 3, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 4, canvas.getWidth(), canvas.getHeight() / 8 * 4, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 5, canvas.getWidth(), canvas.getHeight() / 8 * 5, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 6, canvas.getWidth(), canvas.getHeight() / 8 * 6, q);


//        //These are all of the circles
//        canvas.drawCircle(s1, canvas.getHeight() / 8 * listy.get(0).getString(), 25, p);
//        canvas.drawCircle(s2, canvas.getHeight() / 8 * listy.get(1).getString(), 25, p);
//        canvas.drawCircle(s3, canvas.getHeight() / 8 * listy.get(2).getString(), 25, p);
//        canvas.drawCircle(s4, canvas.getHeight() / 8 * listy.get(3).getString(), 25, p);
//        canvas.drawCircle(s5, canvas.getHeight() / 8 * listy.get(4).getString(), 25, p);
//        canvas.drawCircle(s6, canvas.getHeight() / 8 * listy.get(5).getString(), 25, p);


        for(int i = 0; i <= listy.size()-1; i++) {
            float c = (float)i * 12;
            circles.add(new Circle(canvas.getWidth(), canvas.getHeight() / 8 * listy.get(i).getString(), listy.get(i).getFret()));
            canvas.drawCircle( s1 + c -30 /*- circles.get(i).getX()*/, circles.get(i).getLn(), 25, p);
            //White circle
            canvas.drawCircle( s1 + c - 30 /*- circles.get(i).getX()*/, circles.get(i).getLn(), 24, w);
            //Number
            canvas.drawText(String.valueOf(listy.get(i).fretNumber), s1 + c - 30 /*- circles.get(i).getX()*/, circles.get(i).getLn() + 10, num);
        }

//        //White circle
//        canvas.drawCircle(s1, canvas.getHeight() / 8, 24, w);
//        canvas.drawCircle(s2, canvas.getHeight() / 8 * 2, 24, w);
//        canvas.drawCircle(s3, canvas.getHeight() / 8 * 3, 24, w);
//        canvas.drawCircle(s4, canvas.getHeight() / 8 * 4, 24, w);
//        canvas.drawCircle(s5, canvas.getHeight() / 8 * 5, 24, w);
//        canvas.drawCircle(s6, canvas.getHeight() / 8 * 6, 24, w);

        //Number printer
//        canvas.drawText(String.valueOf(listy.get(0).fretNumber), s1, canvas.getHeight() / 8 + 10, num);
//        canvas.drawText(String.valueOf(listy.get(1).fretNumber), s2, canvas.getHeight() / 8 * listy.get(1).getString() + 10, num);
//        canvas.drawText(String.valueOf(listy.get(2).fretNumber), s3, canvas.getHeight() / 8 * 3 + 10, num);
//        canvas.drawText(String.valueOf(listy.get(3).fretNumber), s4, canvas.getHeight() / 8 * 4 + 10, num);
//        canvas.drawText(String.valueOf(listy.get(4).fretNumber), s5, canvas.getHeight() / 8 * 5 + 10, num);
//        canvas.drawText(String.valueOf(listy.get(5).fretNumber), s6, canvas.getHeight() / 8 * 6 + 10, num);

        //This is the Transparent rectangle that goes over the red one.
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight() / 8 - 55, canvas.getWidth() / 8 + 55, canvas.getHeight() / 8 * 6 + 55, p);



        //Standard play with collision detection
        if(isTouched) {
            if (s1 > 0) {
                s1 -= 5;
            } else {
                s1 = canvas.getWidth();
                invalidate();
            }

            if (s2 > 0) {
                s2 -= 5;
            } else {s2 = canvas.getWidth();
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
                endX = (int) event.getRawX();

                if ((endX - startX) > 0) {
                    // RIGHT
                    s1 += 25;
                    s2 += 25;
                    s3 += 25;
                    s4 += 25;
                    s5 += 25;
                    s6 += 25;
                    music.seekTo(start -= 500);
                }
                if ((endX - startX) < 0) {
                    // LEFT
                    s1 -= 25;
                    s2 -= 25;
                    s3 -= 25;
                    s4 -= 25;
                    s5 -= 25;
                    s6 -= 25;
                    music.seekTo(start += 500);
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

