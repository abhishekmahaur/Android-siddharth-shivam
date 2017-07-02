package com.bmpl.sensoraccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetection shakeDetection;//custom class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        shakeDetection = new ShakeDetection();
        shakeDetection.setOnShakeListener(new ShakeDetection.OnShakeListener() {

            @Override
            public void onShake(int count) {

                handleShakeEvent(count);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(shakeDetection, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause()
    {
        mSensorManager.unregisterListener(shakeDetection);
        super.onPause();
    }

    public void handleShakeEvent(int count){
        Toast.makeText(MainActivity.this," Phone shaked " + count,Toast.LENGTH_SHORT).show();
    }
}