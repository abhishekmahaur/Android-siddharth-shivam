package com.bmpl.switchingactivities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    EditText nameEditText, passwordEditText, emailEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);

        submitButton = (Button)findViewById(R.id.SubmitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {    //event listener
            @Override
            public void onClick(View view) {    //event handler
                //source and destination
                //String name = nameEditText.getText().toString();
                /*Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("name", nameEditText.getText().toString());
                startActivity(intent);*/

                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/*");
                    intent.putExtra(Intent.EXTRA_TEXT, "This is my data from switching app");
                    startActivity(intent);//search app--> true--> show apps or false
                }catch (ActivityNotFoundException e){
                    Toast.makeText(FirstActivity.this, "No activity to use this data", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(FirstActivity.this, "No App to support data", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}