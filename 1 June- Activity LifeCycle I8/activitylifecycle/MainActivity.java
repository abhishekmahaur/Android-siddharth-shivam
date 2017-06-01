package com.bmpl.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"inside onCreate()");
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG,"inside onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"inside onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"inside onDestroy()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"inside onPause()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"inside onResume()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"inside onRestart()");
    }
}
