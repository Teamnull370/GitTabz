package com.teamnull.thatgoodgood.gittabz;

/**
 * Created by Sean Cullen on 4/23/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Chronometer;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CanvasActivity extends AppCompatActivity {

    private Canvas view;



    // variables for the delay timer
    TextView text;
    private static final String FORMAT = "%02d:%02d:%02d";
    int seconds , minutes;



    int homecount, awaycount, minutes2, seconds2;
    TextView home, away;
    Button stop, start, reset, addhome, subhome, addaway, subaway;
    TextView time;
    public boolean running;

    private SeekBar seekBar;
    private Handler durationHandler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Created", "Canvas Activity started");

        setContentView(R.layout.activity_canvas);
        Log.d("SET", "Content View Set");



        Intent intent = getIntent();
        ArrayList<ArrayNode> list = intent.getParcelableArrayListExtra("listy");

        if( list != null) {
            ((Canvas) findViewById(R.id.canvas)).setList(list);
        }

        view = (Canvas) findViewById(R.id.canvas);
        view.set_pause(false);
        text = (TextView)findViewById(R.id.delay_timer);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax((int) view.duration());
        seekBar.setClickable(false);
        durationHandler.postDelayed(updateSeekBarTime, 100);

//        Toolbar mytoolbar = (Toolbar)findViewById(R.id.my_toolbar);
        // designate the Toolbar as the action bar for an Activity
//        setSupportActionBar(mytoolbar);
        // Add the "Up" button to the Canvas Activity
//        if (getSupportActionBar() != null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().hide();
//        }




        FloatingActionButton play_button = (FloatingActionButton) findViewById(R.id.play);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !((Canvas) findViewById(R.id.canvas)).pausetacular() ) {
                    view.pause_music();
                    running = false;
                    //getSupportActionBar().show();
                }
                else {
                    reverseTimer(3, text);
                    // Log.d("OnClick", "Resuming music");
                    //getSupportActionBar().hide();
                }
            }
        });


        FloatingActionButton rewind_button = (FloatingActionButton) findViewById(R.id.rewind);
        rewind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.rewind_music();
                durationHandler.postDelayed(updateSeekBarTime, 100);
            }
        });


        FloatingActionButton ff_button = (FloatingActionButton) findViewById(R.id.fast_forward);
        ff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.fast_forward_music();
                durationHandler.postDelayed(updateSeekBarTime, 100);
            }
        });

    }

    // Delay timer to start after the user clicks the play button
    public void reverseTimer(int Seconds,final TextView text) {

        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                text.setText(String.format("%02d", seconds));
            }

            public void onFinish() {
                text.setText("");
                view.play_music();
                durationHandler.postDelayed(updateSeekBarTime, 100);

            }
        }.start();
    }


    // Update the Seek Bar as the song progresses
    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {
            seekBar.setProgress((int) view.current_position());
            double timeRemaining = view.duration() - view.current_position();
            ((TextView) findViewById(R.id.songDuration)).setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes((long) view.current_position()),
                    TimeUnit.MILLISECONDS.toSeconds((long) view.current_position()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) view.current_position()))));

            ((TextView) findViewById(R.id.songRemaining)).setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining),
                    TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));

            durationHandler.postDelayed(this, 100);
        }
    };





    @Override
    protected void onStop() {
        super.onStop();
        view.stop_music();
    }
}
