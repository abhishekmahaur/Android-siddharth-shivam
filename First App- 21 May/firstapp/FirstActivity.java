package com.bmpl.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    Button button;

    @Override   //Predefined and override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//we are calling the predefined functionality of this method
        setContentView(R.layout.activity_first);//bind our xml file with java file
        //R--> Predefined class--> R.java-->keeps track of everything which we create--> R.class
        //R assigns Id--> int to every directory

        //step-1:
        button = (Button) findViewById(R.id.clickHereButton);

        //step-2: Attach Listener
        //anonymous-->no name of class,  no name of that object
        button.setOnClickListener(new View.OnClickListener() {
            @Override   //handler
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"Welcome in Android", Toast.LENGTH_LONG).show();
            }
        });
    }
}