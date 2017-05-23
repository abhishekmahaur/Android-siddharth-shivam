package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, salaryEditText;
    Button submitButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//binding of xml file with java file

        //xml view with java file
        name = (EditText) findViewById(R.id.nameEditText);

    }
}
