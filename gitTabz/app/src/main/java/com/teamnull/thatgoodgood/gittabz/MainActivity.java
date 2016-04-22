package com.teamnull.thatgoodgood.gittabz;

import java.util.ArrayList;
import java.util.Objects;

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
import com.teamnull.thatgoodgood.gittabz.ArrayNode;
//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

public class MainActivity extends AppCompatActivity{
    Canvas theView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<ArrayNode> listy = new ArrayList<>();
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
        theView = new Canvas(this, listy);
        setContentView(theView);
        //theView.setOnTouchListener(this);
        //theView.invalidate();

    }

}
