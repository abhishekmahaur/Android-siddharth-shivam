package com.bmpl.showhideimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    boolean clicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(clicked){
                    imageView.setImageResource(R.drawable.images1);
                    button.setText("Hide Image");
                }
                else {
                    button.setText("Show Image");
                    imageView.setVisibility(View.INVISIBLE);

                }
                clicked = !clicked;
            }
        });

    }
}
