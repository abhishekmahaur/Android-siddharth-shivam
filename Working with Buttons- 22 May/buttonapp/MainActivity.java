package com.bmpl.buttonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit, cancel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R is predefined java class in android--> it is created for every project--> id maintain of everything

        //Step-1: Downcast
        submit = (Button) findViewById(R.id.submitButton);
        cancel = (Button) findViewById(R.id.cancelButton);

        textView = (TextView)findViewById(R.id.textView);

        //step-2: Attach Listener
        // anonymous class or interface
        /*submit.setOnClickListener(new View.OnClickListener() {//new classcons();
            @Override////step-3: Attach Handler
            public void onClick(View view) {
                textView.setText("Welcome in Android");
            }
        });*/


        /*cancel.setOnClickListener(new View.OnClickListener() {//new classcons();
            @Override////step-3: Attach Handler
            public void onClick(View view) {
                textView.setText("");
            }
        });*/

        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.submitButton:
                textView.setText("Welcome");
                break;

            case R.id.cancelButton:
                textView.setText("");
                break;

        }
    }
}