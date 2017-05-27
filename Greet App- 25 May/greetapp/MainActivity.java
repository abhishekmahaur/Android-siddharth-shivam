package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

        submitButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        //anonymous way
        /*submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//handler
                String userName = name.getText().toString();
                String salary = salaryEditText.getText().toString();

                if(userName.trim().length()>0 && salary.trim().length()>0){
                    textView.setText(userName + "\n" + salary);
                    Toast.makeText(MainActivity.this,"Submitted", Toast.LENGTH_SHORT).show();
                }
                else {
                    textView.setText("Fill your details");
                }
            }
        });*/


/*        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name.setText("");
                //salaryEditText.setText("");
                textView.setText("");
            }
        });*/
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.submitButton:

                break;

            case R.id.cancelButton:

                break;
        }

    }
}
