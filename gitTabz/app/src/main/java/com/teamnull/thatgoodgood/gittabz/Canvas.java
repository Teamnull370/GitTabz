package com.teamnull.thatgoodgood.gittabz;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Jonathon on 3/31/2016.
 * ALL THE COOL PAINT STUFF DONE BY DANNY CUZ HE BE COOL AND SHIT
 */



public class Canvas extends View implements Debug{
    MediaPlayer music;

    Paint p = new Paint();
    Paint q = new Paint();
    Paint r = new Paint();
    Paint num = new Paint();
    Paint w = new Paint();

    private TextView chordText;
    float s1;
    float s2;
    float s3;
    float s4;
    float s5;
    float s6;
    int offset;
    float width;
    int stringSpace;
    int time;
    int x;
    int k;
    int start;
    double timestart, timeend;
    boolean isTouched;
    boolean isPaused;
    String curr;
    String prev;

    Integer pos;
    int iter;// this is the counter used bellow
    Integer beatTime;

    public ArrayList<Chord> listy;
    public ArrayList<Circle> circles;
    public ArrayList<Circle> onScreen;
    public ArrayList<Circle> offScreen;
    private GestureDetectorCompat mDetector;
    int startX;
    int endX;

    Random rand;

    boolean night_mode;


    private TextView songName, songDuration;
    private HitTestListener listener;
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
    public void Destroy() {
        listy.clear();
        circles.clear();
        onScreen.clear();


    }

    public void setCurr( String c) {
        curr = c;
    }

    public void setPrev( String p) {
        prev = p;
    }


    public void setHitTestListener (HitTestListener listener) {
        this.listener = listener;
    }

    private void init(Context context) {
        //do stuff that was in your original constructor...
        music = MediaPlayer.create(context, R.raw.song);
        s1 = getWidth();
        stringSpace = getHeight() / 8;
        x = 1000;
        k = 1000;
        s1 = 100;

        iter=0;
        beatTime=0;

        s1 = 500;
        s2 = 1000;
        s3 = 1500;
        s4 = 2000;
        s5 = 2500;
        s6 = 3000;
        isTouched = true;
        circles = new ArrayList<>();
        onScreen = new ArrayList<>();
        offScreen = new ArrayList<>();
        offset = 0;
        time = music.getDuration();
        start = music.getCurrentPosition();

        // float-type interpretations for the Seek Bar
        timeend = music.getDuration();
        timestart = music.getCurrentPosition();
        curr = "fuck";
        prev = "you";
        rand = new Random(0); // TODO use Random() for random seed



        Canvas canvas = this;

        r.setStyle(Paint.Style.FILL);
        r.setStrokeWidth(2);
        r.setShader(new LinearGradient(0, 0, 0, canvas.getHeight(), Color.BLUE, Color.RED, Shader.TileMode.MIRROR));

        //Paint settings for the number draw
        num.setColor(Color.BLACK);
        num.setTextSize(38f);
        num.setStrokeWidth(4);
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



    }




    public void setList(ArrayList<Chord> list){
        listy = list;
    }



    public void pause_music() {
        music.pause();
        isPaused = true;
        isTouched = false;
    }

    public void play_music() {
        music.start();
        isPaused = false;
        isTouched = true;
        timestart = music.getCurrentPosition();
    }

    // Stop the music
    public void stop_music() {
        music.stop();
        isPaused = false;
        isTouched = true;
    }

    // Rewind the music by 15 seconds
    public void rewind_music() {
        music.seekTo(start -= 15000);
    }

    // Fast-forward the music by 15 seconds
    public void fast_forward_music() {
        music.seekTo(start += 15000);
    }

    public boolean pausetacular()   {
        return isPaused;
    }

    public void set_pause(boolean pause_state) {
        isPaused = pause_state;
    }
    public double duration() {
        return timeend;
    }

    public double current_position() {
        timestart = music.getCurrentPosition();
        return timestart;
    }

    @Override
    protected void onDraw(final android.graphics.Canvas canvas) {
        super.onDraw(canvas);

        Context cont = getContext();

        if (!isPaused) {
            music.start();
            music.getCurrentPosition();
        }

        Log.d("music time", String.valueOf(music.getCurrentPosition()));

        //TODO need to implement a sum of beats since pause.


        super.onDraw(canvas);





        q.setStrokeWidth(5);
        q.setStyle(Paint.Style.STROKE);

        //q.setColor(Color.BLACK);
        q.setShader(new LinearGradient(0, 0, 0, canvas.getWidth(), Color.RED, Color.BLUE, Shader.TileMode.MIRROR));

        width = canvas.getWidth();



        //This creates the white background
        canvas.drawColor(Color.DKGRAY);
        //This is the underlying red rectangle
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight() / 8 - 55, canvas.getWidth() / 8 + 55, canvas.getHeight() / 8 * 6 + 55, r);
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight() / 8 - 55, canvas.getWidth() / 8 + 55, canvas.getHeight() / 8 * 6 + 55, p);


        //The bar lines the notes will go on
        canvas.drawLine(0, canvas.getHeight() / 8, canvas.getWidth(), canvas.getHeight() / 8, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 2, canvas.getWidth(), canvas.getHeight() / 8 * 2, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 3, canvas.getWidth(), canvas.getHeight() / 8 * 3, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 4, canvas.getWidth(), canvas.getHeight() / 8 * 4, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 5, canvas.getWidth(), canvas.getHeight() / 8 * 5, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 6, canvas.getWidth(), canvas.getHeight() / 8 * 6, q);

        pos = music.getCurrentPosition();

        //for (int i = 0; i <= listy.size() - 1; i++) {
        //circles.add(new Circle(canvas.getWidth(), canvas.getHeight() / 8 * listy.get(i).getString(), listy.get(i).getFret(), pos + 2000));
        //  if (circles.get(i).tim <= pos && pos <= circles.get(i).tim + leeway) {

        //TODO needs more work

        if (beatTime <= pos - 15 || beatTime <= pos + 15) {
            iter++;

            if (iter < listy.size()) {
                Integer time = beatDelay(listy.get(iter).getBeat());
                beatTime += time;

                for (int j = 1; j < 7; j++) {
                    if (!listy.get(iter).getString(j).getFret().equals(-1)) {
                        onScreen.add(new Circle(canvas.getWidth(), canvas.getHeight() / 8 * listy.get(iter).getString(j).getStrng(), listy.get(iter).getString(j).getFret(), pos, listy.get(iter).getChord()));
                        onScreen.get(onScreen.size() - 1).setChord(listy.get(iter).getChord());
                    }
                }
            }
        }

        for (int i = onScreen.size() - 1; i >= 0; i--) {
            onScreen.get(i).draw(canvas, p, w, num, music.getCurrentPosition(), offset);

            if (onScreen.get(i).getPosition(music.getCurrentPosition()) - offset < canvas.getWidth() / 8 + 25 &&
                    onScreen.get(i).getPosition(music.getCurrentPosition()) - offset < canvas.getWidth() / 8 - 25 ) {
                if(listener != null) {
                        listener.onHitTest(onScreen.get(i).getChord());
                    break;
                }
            }
        }

        //This is the Transparent rectangle that goes over the red one.
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight() / 8 - 55, canvas.getWidth() / 8 + 55, canvas.getHeight() / 8 * 6 + 55, p);


        for (int i = onScreen.size() - 1; i >= 0; i--) {
            onScreen.get(i).draw(canvas, p, w, num, music.getCurrentPosition(), offset);
                if (onScreen.get(i).getPosition(music.getCurrentPosition()) - offset < canvas.getWidth() / 8 + 40 &&
                        onScreen.get(i).getPosition(music.getCurrentPosition()) - offset < canvas.getWidth() / 8) {
                    Log.d("shit", curr);

                    if (listener != null) {
                        listener.onHitTest(onScreen.get(i).getChord());
                        break;
                    }

                }
            }

        invalidate();
    }


    public Integer beatDelay(Integer bt){
        int whole=1000;
        if(bt == 1){
           return whole;
        }else if(bt == 2){
            return (int)(whole/2);
        }else if(bt == 3){
            return (int)(whole/4);
        }else if(bt == 4){
            return (int)(whole/8);
        }else return 1000;

    }

    public boolean onTouchEvent (MotionEvent event) {
        int pos =  music.getCurrentPosition();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                isTouched = false;

                startX = (int) event.getRawX();

                return true;
            case MotionEvent.ACTION_MOVE:
                endX = (int) event.getRawX();

                if ((endX - startX) > 0) {
                    // Re-wind
                    music.seekTo(music.getCurrentPosition() - 100);
                }

                if ((endX - startX) < 0) {
                    //Fast-forward
                    music.seekTo(music.getCurrentPosition() + 100);
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

