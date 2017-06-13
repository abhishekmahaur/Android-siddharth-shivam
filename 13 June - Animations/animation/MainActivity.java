package com.bmpl.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;

    Animation animation;

    //Frame animation
    //AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.startButton);

        animation = AnimationUtils.loadAnimation(this, R.anim.fade_in_animation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.startAnimation(animation);
            }
        });

        //imageView.setBackgroundResource(R.drawable.frame_animation);

        //animationDrawable = (AnimationDrawable) imageView.getBackground();

        //play
        //animationDrawable.start();

    }
}
