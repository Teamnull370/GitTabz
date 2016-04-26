package com.teamnull.thatgoodgood.gittabz;

/**
 * Created by Sean Cullen on 4/23/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class CanvasActivity extends AppCompatActivity {

    private Canvas view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Created","Canvas Activity started");

        setContentView(R.layout.activity_canvas);
        Log.d("SET","Content View Set");
        // view = new Canvas(this);
        view = (Canvas) findViewById(R.id.canvas);
        // setContentView(R.layout.activity_canvas);
        Toolbar mytoolbar = (Toolbar)findViewById(R.id.my_toolbar);
        // designate the Toolbar as the action bar for an Activity
        setSupportActionBar(mytoolbar);

        // Add the "Up" button to the Canvas Activity
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


    }

    /* public void onLongPress(MotionEvent event) {
        this.setContentView(R.layout.toolbar);
    }*/

}
