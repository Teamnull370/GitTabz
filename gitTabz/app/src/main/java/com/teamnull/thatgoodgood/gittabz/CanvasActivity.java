package com.teamnull.thatgoodgood.gittabz;

/**
 * Created by Sean Cullen on 4/23/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Created", "Canvas Activity started");

        setContentView(R.layout.activity_canvas);
        Log.d("SET", "Content View Set");

        text = (TextView)findViewById(R.id.delay_timer);

        Intent intent = getIntent();
        ArrayList<ArrayNode> list = intent.getParcelableArrayListExtra("listy");

        if( list != null) {
            ((Canvas) findViewById(R.id.canvas)).setList(list);
        }

        view = (Canvas) findViewById(R.id.canvas);
        view.set_pause(false);

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
                    //getSupportActionBar().show();
                }
                else {
                    reverseTimer(3, text);
                    //getSupportActionBar().hide();
                }
            }
        });


        FloatingActionButton rewind_button = (FloatingActionButton) findViewById(R.id.rewind);
        rewind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.rewind_music();
            }
        });


        FloatingActionButton ff_button = (FloatingActionButton) findViewById(R.id.fast_forward);
        ff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.fast_forward_music();
            }
        });

    }

    /* public void onLongPress(MotionEvent event) {
        this.setContentView(R.layout.toolbar);
    }*/


    public void reverseTimer(int Seconds,final TextView text) {

        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                text.setText("TIME : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                text.setText("");
                view.play_music();
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        view.stop_music();
    }
}
