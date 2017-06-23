package com.bmpl.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomBroadcastReceivers extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {

        if(intent.getAction().equals("custom.broadcast"))
        {
            String message = intent.getStringExtra("message");

            Toast.makeText(context,message, Toast.LENGTH_LONG).show();
        }
    }
}