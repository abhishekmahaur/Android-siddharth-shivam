package com.bmpl.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private InstallUninstallReceiver installUninstallReceiver;
    private CustomBroadcastReceivers customBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerLocalButton = (Button)findViewById(R.id.button);
        Button unregisterLocalButton = (Button)findViewById(R.id.button2);
        Button registerSystemButton = (Button)findViewById(R.id.button3);
        Button unregisterSystemButton = (Button)findViewById(R.id.button4);
        Button sendLocalBroadcastButton = (Button)findViewById(R.id.button5);

        registerLocalButton.setOnClickListener(this);
        unregisterLocalButton.setOnClickListener(this);
        registerSystemButton.setOnClickListener(this);
        unregisterSystemButton.setOnClickListener(this);
        sendLocalBroadcastButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.button:
                registerLocalBroadcast();
                break;

            case R.id.button2:
                unregisterLocalBroadcast();
                break;

            case R.id.button3:
                registerSystemBroadcast();
                break;

            case R.id.button4:
                unregisterSystemBroadcast();
                break;

            case R.id.button5:
                sendLocalBroadcast();
                break;
        }
    }

    private void registerLocalBroadcast(){
        customBroadcastReceiver = new CustomBroadcastReceivers();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("custom.broadcast");
        LocalBroadcastManager.getInstance(this).registerReceiver(customBroadcastReceiver, intentFilter);
    }

    private void unregisterLocalBroadcast(){
        if(customBroadcastReceiver!=null){
            LocalBroadcastManager.getInstance(this).unregisterReceiver(customBroadcastReceiver);
            customBroadcastReceiver = null;
        }
    }

    private void sendLocalBroadcast(){
        Intent intent = new Intent();
        intent.setAction("custom.broadcast");
        intent.putExtra("message","This is Local Broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void registerSystemBroadcast(){

        installUninstallReceiver = new InstallUninstallReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);  // app update
        registerReceiver(installUninstallReceiver, intentFilter);
    }

    private void unregisterSystemBroadcast(){
        if(installUninstallReceiver!=null){
            unregisterReceiver(installUninstallReceiver);
            installUninstallReceiver = null;
        }
    }
}
