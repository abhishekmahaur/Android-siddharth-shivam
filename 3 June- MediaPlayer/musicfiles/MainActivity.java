package com.bmpl.musicfiles;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play, pause, stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.playButton);
        pause = (Button)findViewById(R.id.pauseButton);
        stop = (Button)findViewById(R.id.stopButton);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.playButton:

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                } else {

                    mediaPlayer.start();
                }

                /*if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.song);
                    mediaPlayer.start();
                } else {
                    mediaPlayer.start();
                }*/
                break;

            case R.id.pauseButton:
                mediaPlayer.pause();
                break;

            case R.id.stopButton:
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                break;
        }
    }
}