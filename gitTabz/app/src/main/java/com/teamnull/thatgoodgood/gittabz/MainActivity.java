package com.teamnull.thatgoodgood.gittabz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

public class MainActivity extends AppCompatActivity {
    float newX;
    //float newY;
    Canvas theView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // theView = new Canvas(this, newX);
        theView = new Canvas(this, newX);
        setContentView(R.layout.activity_main);
        //theView.setOnTouchListener(this);
        //theView.invalidate();

        Toolbar mytoolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);

        // Begin streaming tabz when the user clicks on the button
        button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(theView);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(getApplicationContext(),
                        "Search...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),
                        "Settings...",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_up:
                Toast.makeText(getApplicationContext(),
                        "Previous verse",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_down:
                Toast.makeText(getApplicationContext(),
                        "Next Verse",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_ball:
                Toast.makeText(getApplicationContext(),
                        "Other...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_other:
                setContentView(R.layout.easter_egg);
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
