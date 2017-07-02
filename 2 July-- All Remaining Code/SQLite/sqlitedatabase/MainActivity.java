package com.bmpl.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        DatabaseHandler db = new DatabaseHandler(this);

        //Contact--> POJO class(Pure Old Java Object)

        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ram", "921143533"));
        db.addContact(new Contact("Rohan", "91312229"));
        db.addContact(new Contact("Abhi", "9213332"));
        db.addContact(new Contact("sid", "92431222"));

        // Reading all contacts
        Log.d("Data: ", "All contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts)
        {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
            //textView.setText(log);
        }
    }
}