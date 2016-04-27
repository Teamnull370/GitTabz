package com.teamnull.thatgoodgood.gittabz;

/**
 * Created by Sean Cullen on 4/23/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CanvasActivity extends AppCompatActivity {

    private Canvas view;

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

        // ((Canvas) findViewById(R.id.canvas))

        view = (Canvas) findViewById(R.id.canvas);

        ((Canvas) findViewById(R.id.canvas)).set_pause(false);

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
                    ((Canvas) findViewById(R.id.canvas)).pause_music();
                    //getSupportActionBar().show();
                }
                else {
                    ((Canvas) findViewById(R.id.canvas)).play_music();
                    //getSupportActionBar().hide();
                }
            }
        });


        FloatingActionButton rewind_button = (FloatingActionButton) findViewById(R.id.rewind);
        rewind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Canvas) findViewById(R.id.canvas)).rewind_music();
            }
        });


        FloatingActionButton ff_button = (FloatingActionButton) findViewById(R.id.fast_forward);
        ff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Canvas) findViewById(R.id.canvas)).fast_forward_music();
            }
        });

        // music.seekTo(start-15000);
        // music.seekTo(start-30000);

    }

    /* public void onLongPress(MotionEvent event) {
        this.setContentView(R.layout.toolbar);
    }*/

}
