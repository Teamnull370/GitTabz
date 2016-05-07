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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Jonathon on 3/31/2016.
 * ALL THE COOL PAINT STUFF DONE BY DANNY CUZ HE BE COOL AND SHIT
 */

public class Canvas extends View implements Debug{
    MediaPlayer music;
    MediaPlayer claMedia;
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

    public void setNight_mode() {
        night_mode = true;
    }

    public void setDay_mode() {
        night_mode = false;
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

        //listy = list;
        //s1 = getWidth();
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

        rand = new Random(0); // TODO use Random() for random seed
    }


    Paint p = new Paint();
    Paint q = new Paint();
    Paint r = new Paint();
    Paint num = new Paint();
    Paint w = new Paint();



    public void setList(ArrayList<Chord> list){
        listy = list;
    }

    public void pause_music() {
        music.pause();
        isPaused = true;
        isTouched = false;
        // Log.d("PAUSE", "Pause function");
    }
    // Continue playing the music
    public void play_music() {
        music.start();
        isPaused = false;
        isTouched = true;
        // Log.d("PLAY_MUSIC1", "getting current position.");
        timestart = music.getCurrentPosition();
        // Log.d("PLAY_MUSIC", "got current position.");
    }
    // Stop the music
    public void stop_music() {
        music.stop();
        isPaused = false;
        isTouched = true;

        // Log.d("PLAY", "Play function");
    }
    // Rewind the music by 15 seconds
    public void rewind_music() {
        //start = music.getCurrentPosition();
        music.seekTo(start -= 15000);
        // Log.d("REWIND", "Rewind function");
    }
    // Fast-forward the music by 15 seconds
    public void fast_forward_music() {
        //start = music.getCurrentPosition();
        music.seekTo(start += 15000);
        // Log.d("FF", "Fast-Forward function");
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
    protected void onDraw(final android.graphics.Canvas canvas){
        Context cont = getContext();

        if( !isPaused) {
            music.start();
            music.getCurrentPosition();
            // Continue working with this and display the music playback time
        }
        Log.d("music time", String.valueOf(music.getCurrentPosition()));



        //TODO need to implement a sum of beats since pause.

        // mDetector = new GestureDetectorCompat(this,this);

//    @Override
//    protected void onDraw(android.graphics.Canvas canvas){
//        if(_startSound) {
//            music.start();
//        }

        super.onDraw(canvas);

        ///////////////All the paint Info//////////////////////////////////////////////////////////
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

        ////////////The Beginning of the end/////////////////////

        ////////////////////////////////////////////////////////////////////

        //////////////////////////

        //The bar lines the notes will go on
        canvas.drawLine(0, canvas.getHeight() / 8, canvas.getWidth(), canvas.getHeight() / 8, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 2, canvas.getWidth(), canvas.getHeight() / 8 * 2, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 3, canvas.getWidth(), canvas.getHeight() / 8 * 3, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 4, canvas.getWidth(), canvas.getHeight() / 8 * 4, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 5, canvas.getWidth(), canvas.getHeight() / 8 * 5, q);
        canvas.drawLine(0, canvas.getHeight() / 8 * 6, canvas.getWidth(), canvas.getHeight() / 8 * 6, q);

        int[] times = {800, 1200, 1600, 2000, 2400, 2800, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        int leeway = 20;
        pos =  music.getCurrentPosition();

        //for (int i = 0; i <= listy.size() - 1; i++) {
            //circles.add(new Circle(canvas.getWidth(), canvas.getHeight() / 8 * listy.get(i).getString(), listy.get(i).getFret(), pos + 2000));
          //  if (circles.get(i).tim <= pos && pos <= circles.get(i).tim + leeway) {



        //Log.d("these beats",beatTime.toString());
        //Log.d("song time", pos.toString());

        //TODO needs more work

        if (beatTime<=pos-15    ||  beatTime<=pos+15) {
            iter++;

            if(iter<listy.size()) {
                Integer time= beatDelay(listy.get(iter).getBeat());
                beatTime+=time;
                //onScreen.add(circles.get(i));
                //i = rand.nextInt(listy.size());

                //for(int i=0; i<listy.size();i++){
                for( int j =1; j<7; j++) {
                    if (!listy.get(iter).getString(j).getFret().equals(-1)) {
                        onScreen.add(new Circle(canvas.getWidth(), canvas.getHeight() / 8 * listy.get(iter).getString(j).getStrng(), listy.get(iter).getString(j).getFret(), pos));
                        onScreen.get(onScreen.size()).setChord(listy.get(iter).getChord());
                    }
                    }
                            //Log.d(listy.get(i).getString(j).getStrng().toString(), "is the string for that chord");
                        //Log.d(listy.get(i).getString(j).getFret().toString(),"is the fret for that string");


            }
                    //}



        }

            //}
        //}
        claMedia = MediaPlayer.create(cont, R.raw.ding);
        for(int i = onScreen.size() - 1; i >=0; i--) {
            onScreen.get(i).draw(canvas, p, w, num, music.getCurrentPosition(), offset);
//            System.out.print("");
            //    invalidate();
            if (onScreen.get(i).getPosition(music.getCurrentPosition()) - offset < canvas.getWidth() / 8) {
//
                 Toast.makeText(cont,
                         String.valueOf(onScreen.get(i).getChord()) ,
                         Toast.LENGTH_SHORT).show();
// &&
//                    onScreen.get(i).getPosition(music.getCurrentPosition()) - offset > canvas.getWidth() / 8 - 30) {
                //Log.d(onScreen.get(i).getPosition(music.getCurrentPosition()).toString(), "is loc");
                //offScreen.add(onScreen.remove(i));

//                try {
//                    claMedia.prepare();
//                    claMedia = MediaPlayer.create(cont, R.raw.ding);
//                } catch (Exception e) {
//                }
//                claMedia.start();
//
//                if (onScreen.get(i).getPosition(music.getCurrentPosition()) - offset < canvas.getWidth() / 8 - 55) {
//                    //Log.d(onScreen.get(i).getPosition(music.getCurrentPosition()).toString(), "is loc");
//                    //offScreen.add(onScreen.remove(i));
//                    claMedia.stop();
//                }

            }






        }
        //This is the Transparent rectangle that goes over the red one.
        canvas.drawRect(canvas.getWidth() / 8, canvas.getHeight() / 8 - 55, canvas.getWidth() / 8 + 55, canvas.getHeight() / 8 * 6 + 55, p);



        //Standard play with collision detection
//        if(isTouched) {
//            if (s1 > 0) {
//                s1 -= 5;
//            } else {
//                s1 = canvas.getWidth();
//                invalidate();
//            }
//
//            if (s2 > 0) {
//                s2 -= 5;
//            } else {s2 = canvas.getWidth();
//                invalidate();
//            }
//
//            if (s3 > 0) {
//                s3 -= 5;
//            } else {
//                s3 = canvas.getWidth();
//                invalidate();
//            }
//
//            if (s4 > 0) {
//                s4 -= 5;
//            } else {
//                s4 = canvas.getWidth();
//                invalidate();
//            }
//
//            if (s5 > 0) {
//                s5 -= 5;
//            } else {
//                s5 = canvas.getWidth();
//                invalidate();
//            }
//
//            if (s6 > 0) {
//                s6 -= 5;
//            } else {
//                s6 = canvas.getWidth();
//                invalidate();
//            }
//
//        }

        //Collision detection during play
//        if(!isTouched) {
//            if (s1 > canvas.getClipBounds().right) {
//                s1 = 0;
//            } else if (s1 < canvas.getClipBounds().left) {
//                s1 = canvas.getWidth() - 1;
//            }
//
//            if (s2 > canvas.getClipBounds().right) {
//                s2 = 0;
//            } else if (s2 < canvas.getClipBounds().left) {
//                s2 = canvas.getWidth() - 1;
//            }
//
//            if (s3 > canvas.getClipBounds().right) {
//                s3 = 0;
//            } else if (s3 < canvas.getClipBounds().left) {
//                s3 = canvas.getWidth() - 1;
//            }
//
//            if (s4 > canvas.getClipBounds().right) {
//                s4 = 0;
//            } else if (s4 < canvas.getClipBounds().left) {
//                s4 = canvas.getWidth() - 1;
//            }
//
//            if (s5 > canvas.getClipBounds().right) {
//                s5 = 0;
//            } else if (s5 < canvas.getClipBounds().left) {
//                s5 = canvas.getWidth() - 1;
//            }
//
//            if (s6 > canvas.getClipBounds().right) {
//                s6 = 0;
//            } else if (s6 < canvas.getClipBounds().left) {
//                s6 = canvas.getWidth() - 1;
//            }
//        }
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
                    // RIGHT
//                    offset += 25;
//                    s1 += 25;
//                    s2 += 25;
//                    s3 += 25;
//                    s4 += 25;
//                    s5 += 25;
//                    s6 += 25;
                    music.seekTo(music.getCurrentPosition() - 100);
                }
                if ((endX - startX) < 0) {
                    // LEFT
//                    offset -= 25;
//                    s1 -= 25;
//                    s2 -= 25;
//                    s3 -= 25;
//                    s4 -= 25;
//                    s5 -= 25;
//                    s6 -= 25;
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

