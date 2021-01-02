package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backwardButton, playButton, pauseButton, forwardButton;
    private MediaPlayer mediaPlayer;
    private TextView titleTextView;
    private TextView durationTextView;
    private int finalTime;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backwardButton = (ImageButton) findViewById(R.id.backwardButtonId);
        playButton = (ImageButton) findViewById(R.id.playButtonId);
        pauseButton = (ImageButton) findViewById(R.id.pauseButtonId);
        forwardButton = (ImageButton) findViewById(R.id.forwardButtonId);


        mediaPlayer = MediaPlayer.create(this, R.raw.charlie_puth_how_long);
        mediaPlayer = MediaPlayer.create(this, R.raw.attention_charlie_puth);
        mediaPlayer = MediaPlayer.create(this, R.raw.charlie_puth_we_do_not_talk_anymore_feat_selena_gomez);


        backwardButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.backwardButtonId){

            if (mediaPlayer != null){

                mediaPlayer.start();
                Toast.makeText(MainActivity.this,"Backward Song Played",Toast.LENGTH_SHORT).show();
            }


        }


        if (v.getId() == R.id.playButtonId){

            if (mediaPlayer != null){

                mediaPlayer.start();
                int duration = mediaPlayer.getDuration();
                Toast.makeText(MainActivity.this,"Song Played",Toast.LENGTH_SHORT).show();
            }


        }


        if (v.getId() == R.id.pauseButtonId){

            if (mediaPlayer != null){

                mediaPlayer.pause();
                Toast.makeText(MainActivity.this,"Song Paused",Toast.LENGTH_SHORT).show();
            }


        }


        if (v.getId() == R.id.forwardButtonId){


            if (mediaPlayer != null){

                mediaPlayer.start();
                Toast.makeText(MainActivity.this,"Forward Song Played",Toast.LENGTH_SHORT).show();
            }


        }


    }


    @SuppressLint("DefaultLocale")
    public void showDetail(){

        int[] songName = new int[0];
        int count = 0;
        titleTextView.setText(songName[count]);
        finalTime =mediaPlayer.getDuration();
        durationTextView.setText(String.format("%d; %d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime)-
                TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                        finalTime)))

        );


    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()){

            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }

        super.onDestroy();
    }
}