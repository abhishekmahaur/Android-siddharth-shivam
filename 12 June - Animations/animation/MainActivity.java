package com.bmpl.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    //Frame animation
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setBackgroundResource(R.drawable.frame_animation);

        animationDrawable = (AnimationDrawable) imageView.getBackground();

        //play
        animationDrawable.start();

    }
}
