package com.teamnull.thatgoodgood.gittabz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.app.ActionBar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.lang.reflect.Array;

//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

public class MainActivity extends AppCompatActivity {
    float newX;
    //float newY;
    Canvas theView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theView = new Canvas(this, newX);
        setContentView(R.layout.activity_main);
        //theView.setOnTouchListener(this);
        //theView.invalidate();

        Toolbar mytoolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),
                        "Setting...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_up:
                Toast.makeText(getApplicationContext(),
                        "Up...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_down:
                Toast.makeText(getApplicationContext(),
                        "Down...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_other:
                Toast.makeText(getApplicationContext(),
                        "Other...",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "Unknown...",
                        Toast.LENGTH_SHORT).show();
                break;

        }
        return false;
    }
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
