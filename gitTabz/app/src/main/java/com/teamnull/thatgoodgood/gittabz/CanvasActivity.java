package com.teamnull.thatgoodgood.gittabz;

/**
 * Created by Sean Cullen on 4/23/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CanvasActivity extends AppCompatActivity {

    private Canvas view;



    // variables for the delay timer
    TextView text;

    private SeekBar seekBar;
    private Handler durationHandler = new Handler();
    private TextView chord;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Log.d("Created", "Canvas Activity started");

        setContentView(R.layout.activity_canvas);
        // Log.d("SET", "Content View Set");

        Intent intent = getIntent();
        ArrayList<Chord> list = intent.getParcelableArrayListExtra("chordList");
        view = (Canvas) findViewById(R.id.canvas);

        if( list != null) {
            view.setList(list);
        }

        view.set_pause(false);
        text = (TextView)findViewById(R.id.delay_timer);
        chord = (TextView)findViewById(R.id.chord);

        view.setHitTestListener(new HitTestListener() {
            @Override
            public void onHitTest(String item) {

                Log.d("new hit", item);
                chord.setText(item);

                /*
                String thing=new String();
                if(item != null && !item.isEmpty()) {
                    chord.setText(item);
                    thing = item;
                    Log.d("new hit", item);

                } else {
                    chord.setText(thing);
                    Log.d("new hit 1", thing);

                }
                */
            }
        });

        // Set up the Seek Bar
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax((int) view.duration());
        seekBar.setClickable(false);
        durationHandler.postDelayed(updateSeekBarTime, 100);

        // OnClick Listener to process clicks on the play/pause button
        FloatingActionButton play_button = (FloatingActionButton) findViewById(R.id.play);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !view.pausetacular() ) {
                    view.pause_music();
                    //getSupportActionBar().show();
                }
                else {
                    reverseTimer(3, text);
                    // Log.d("OnClick", "Resuming music");
                    //getSupportActionBar().hide();
                }
            }
        });

        // OnClick Listener to process clicks on the rewind button
        FloatingActionButton rewind_button = (FloatingActionButton) findViewById(R.id.rewind);
        rewind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.rewind_music();
                durationHandler.postDelayed(updateSeekBarTime, 100);
            }
        });

        // OnClick Listener to process clicks on the fast-forward button
        FloatingActionButton ff_button = (FloatingActionButton) findViewById(R.id.fast_forward);
        ff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.fast_forward_music();
                durationHandler.postDelayed(updateSeekBarTime, 100);
            }
        });

    }





    // Delay timer to start after the user clicks the play button
    public void reverseTimer(int Seconds,final TextView text) {

        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            // Each time the timer decrements
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                seconds = seconds % 60;
                text.setText(String.format("%02d", seconds));
            }

            // When the timer hits zero
            public void onFinish() {
                text.setText("");
                view.play_music();
                // Update the Seek Bar when
                durationHandler.postDelayed(updateSeekBarTime, 100);

            }
        }.start();
    }





    // Update the Seek Bar and the timers as the song progresses
    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {
            // Update the Seek Bar
            seekBar.setProgress((int) view.current_position());
            double timeRemaining = view.duration() - view.current_position();

            // Display the count-up timer in mm:ss
            ((TextView) findViewById(R.id.songDuration)).setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes((long) view.current_position()),
                    TimeUnit.MILLISECONDS.toSeconds((long) view.current_position()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) view.current_position()))));

            // Display the count-down timer in mm:ss
            ((TextView) findViewById(R.id.songRemaining)).setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining),
                    TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));

            // Update the progress of the Seek Bar
            durationHandler.postDelayed(this, 100);
        }
    };





    @Override
    protected void onStop() {
        // Stop the music when the user exits the activity
        super.onStop();
        view.stop_music();
    }
}
