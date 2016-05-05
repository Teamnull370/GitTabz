package com.teamnull.thatgoodgood.gittabz;


import java.util.ArrayList;
import java.util.Objects;

import android.media.MediaPlayer;
import android.content.Intent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import android.view.View.OnTouchListener;
import android.widget.MediaController;

import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


import com.teamnull.thatgoodgood.gittabz.ArrayNode;
//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

public class MainActivity extends AppCompatActivity implements Debug{

    Button button;
    private GestureDetector gestures;

//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

    Canvas theView;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<ArrayNode> listy = new ArrayList<>();
        ArrayList<Chord> chordList;

        tReader tab = new tReader();
       //tab.read("/Users/student/Desktop/repo/ThatGoodGood/gitTabz/app/src/main/java/com/teamnull/thatgoodgood/gittabz/guitar_test.txt");

        InputStream is = getResources().openRawResource(R.raw.guitar_test);
        tab.read(is);
        tab.parse();
        tab.parseData();

        chordList = tab.chordList();



        //tab.parseMLength();
       // tab.parse();


        listy.add(new ArrayNode(1, 17));
        listy.add(new ArrayNode(1, 22));
        listy.add(new ArrayNode(2, 12));
        listy.add(new ArrayNode(4, 17));
        listy.add(new ArrayNode(3, 15));
        listy.add(new ArrayNode(4, 14));
        listy.add(new ArrayNode(5, 15));
        listy.add(new ArrayNode(6, 14));
        listy.add(new ArrayNode(1, 7));
        listy.add(new ArrayNode(2, 2));
        listy.add(new ArrayNode(3, 5));
        listy.add(new ArrayNode(4, 4));
        listy.add(new ArrayNode(5, 5));
        listy.add(new ArrayNode(6, 1));


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar mytoolbar = (Toolbar)findViewById(R.id.my_toolbar);


        // designate the Toolbar as the action bar for an Activity
        setSupportActionBar(mytoolbar);
/*
        // adds the "Up" button to the toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
*/


        // Begin streaming tabz when the user clicks on the button
        button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to the canvas activity
                Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("listy", listy);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    // Display the Options Menu
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
                Intent search = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(search);
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),
                        "Settings...",
                        Toast.LENGTH_SHORT).show();
                // Switch to the settings activity
                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
                break;
/*
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
*/
            case R.id.action_ball:
                Toast.makeText(getApplicationContext(),
                        "Feeling Ballsey?",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_other:
                // switch to the easter Bernie Activity
                Intent bernie = new Intent(MainActivity.this, BernieActivity.class);
                startActivity(bernie);
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

