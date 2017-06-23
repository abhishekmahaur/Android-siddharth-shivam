package com.bmpl.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class InstallUninstallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String packageName = intent.getData().getSchemeSpecificPart();
        //app installed
        if(intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)){
            Toast.makeText(context,"Installed " + packageName + " Called from Broadcast Receiver", Toast.LENGTH_LONG).show();
        }

        if(intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)){
            Toast.makeText(context,"Uninstalled " + packageName + " Called from Broadcast Receiver", Toast.LENGTH_LONG).show();
        }

        if(intent.getAction().equals(Intent.ACTION_PACKAGE_CHANGED)){
            Toast.makeText(context,"Updated " + packageName + " Called from Broadcast Receiver", Toast.LENGTH_LONG).show();
        }

    }
}
