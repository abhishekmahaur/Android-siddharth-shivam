package com.bmpl.wifi;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager =(WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        aSwitch = (Switch)findViewById(R.id.wifiSwitch);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!wifiManager.isWifiEnabled()){
                   wifiManager.setWifiEnabled(true);
                } else
                    {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

    }
}
