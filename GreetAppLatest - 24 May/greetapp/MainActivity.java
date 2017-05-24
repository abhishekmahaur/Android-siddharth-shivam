package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name, salaryEditText;
    Button submitButton, cancelButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//binding of xml file with java file

        //xml view with java file
        name = (EditText) findViewById(R.id.nameEditText);
        salaryEditText = (EditText) findViewById(R.id.salartEditText);

        submitButton = (Button)findViewById(R.id.submitButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);

        textView = (TextView)findViewById(R.id.resultTextView);

        //anonymous way
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//handler
                String userName = name.getText().toString();
                String salary = salaryEditText.getText().toString();

                textView.setText(userName + "\n" + salary);
            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name.setText("");
                //salaryEditText.setText("");
                textView.setText("");
            }
        });
    }
}
