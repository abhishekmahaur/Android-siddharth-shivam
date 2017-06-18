package com.bmpl.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, passwordEditText;
    Button saveButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        saveButton = (Button) findViewById(R.id.saveButton);

        resultTextView = (TextView)findViewById(R.id.resultTextView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("user_details", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameEditText.getText().toString());
                editor.putString("password", passwordEditText.getText().toString());
                editor.commit();

            }
        });

        readData();
    }

    void readData(){

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        String password = sharedPreferences.getString("password", null);

        resultTextView.setText(name + "\n" + password);
    }
}
