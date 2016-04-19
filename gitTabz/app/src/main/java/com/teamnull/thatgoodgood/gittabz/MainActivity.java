package com.teamnull.thatgoodgood.gittabz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

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
