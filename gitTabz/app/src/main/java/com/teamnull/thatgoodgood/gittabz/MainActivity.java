package com.teamnull.thatgoodgood.gittabz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import android.media.ToneGenerator.*;

//import jp.kshoji.javax.sound.midi.MidiSystem.MidiSystemUtils;



public class MainActivity extends AppCompatActivity {
    float newX;
    //ArrayList<Object> listy;

    Canvas theView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  listy = new ArrayList<>();
        theView = new Canvas(this, newX);
        setContentView(theView);
        //theView.setOnTouchListener(this);
        //theView.invalidate();


    }
/*
    @Override
    public boolean onTouch( View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                newX = event.getRawX();
                theView.onDraw();
                return true;

        }
        return false;
    }
*/
}
