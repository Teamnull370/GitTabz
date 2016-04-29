package com.teamnull.thatgoodgood.gittabz;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

public class MainActivity extends AppCompatActivity implements Debug{
    Canvas theView;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<ArrayNode> listy = new ArrayList<>();


        tReader tab = new tReader();
       //tab.read("/Users/student/Desktop/repo/ThatGoodGood/gitTabz/app/src/main/java/com/teamnull/thatgoodgood/gittabz/guitar_test.txt");

        InputStream is = getResources().openRawResource(R.raw.guitar_test);
        tab.read(is);
        tab.parse();
        tab.parseData();




        //tab.parseMLength();
       // tab.parse();


        listy.add(new ArrayNode(1, 17));
        listy.add(new ArrayNode(2, 12));
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
        sound = MediaPlayer.create(this, R.raw.song);
        theView = new Canvas(this, listy, sound);
        setContentView(theView);



    }

}
