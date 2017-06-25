package com.bmpl.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

public class BackgroundService extends Service {

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this,
                 Settings.System.DEFAULT_RINGTONE_URI);

        //player.setLooping(true);

        player.start();
        return START_NOT_STICKY;//safest value return--> service stop
    }

    //service destroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
