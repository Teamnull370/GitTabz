package com.teamnull.thatgoodgood.gittabz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//NOT SURE ABOUT ALL THIS CRAP BUT HERE SHE IS IN ALL HER GLORY

public class MainActivity extends AppCompatActivity {

    MyCanvas theView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theView = new MyCanvas(this);
        setContentView(theView);





    }

}
