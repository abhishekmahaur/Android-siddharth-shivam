package com.bmpl.autocomtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    WebView webView;

    String data[]={"India", "Australia", "Pakistan", "USA", "South Africa"};


    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downcast();

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, data);


        autoCompleteTextView.setAdapter(arrayAdapter);

        webView.loadUrl("https://www.google.co.in/?gfe_rd=cr&ei=w980WZrPAuzs8Afu9pmADQ");

        webView.getSettings().setJavaScriptEnabled(true);

    }

    void downcast(){
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        webView = (WebView)findViewById(R.id.webView);

    }
}
