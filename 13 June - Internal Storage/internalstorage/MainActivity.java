package com.bmpl.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button saveButton, readButton;
    EditText nameEditText, salaryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button)findViewById(R.id.saveButton);
        readButton = (Button)findViewById(R.id.readButton);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        salaryEditText = (EditText)findViewById(R.id.salaryEditText);

        saveButton.setOnClickListener(this);
        readButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String name = nameEditText.getText().toString();
        String salary = salaryEditText.getText().toString();

        switch (view.getId()){
            case R.id.saveButton:

                //Internal Storage--> files data--> name of file, mode in which must be created

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("user_details", MODE_APPEND)));
                    bufferedWriter.write(name + "\n");
                    bufferedWriter.write(salary + "\n");



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;

            case R.id.readButton:



                break;
        }


    }
}
