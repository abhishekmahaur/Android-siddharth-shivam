package com.bmpl.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ArrayAdapter arrayAdapter;

    ListView listView;

    String values[] = {"Cupcake","Donut", "Eclair", "Froyo", "GingerBread", "HoneyComb",
                        "IceCream Sandwich", "JellyBean","Kitkat", "Lollipop",
                        "Marshmallow","Nougat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, values);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You clicked on="+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
