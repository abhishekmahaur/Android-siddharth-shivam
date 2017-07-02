package com.bmpl.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button simpleNotification, bigNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleNotification = (Button)findViewById(R.id.button1);
        bigNotification = (Button)findViewById(R.id.button2);

        simpleNotification.setOnClickListener(this);
        bigNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                displaySimpleNotification();
                break;

            case R.id.button2:
                displayBigStyleSimpleNotification();
                break;
        }
    }

    private void displaySimpleNotification(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.notification_icon);
        builder.setContentTitle("My notification");
        builder.setContentText("Hello android");

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //
         manager.notify(1,builder.build());

    }

    private void displayBigStyleSimpleNotification()
    {

        //Lollipop
        String message = "This is the example of big style notification. This is supported in Android 4.1 version";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.noti_icon);
        builder.setContentTitle("Notification");
        builder.setContentText("Ping");
        builder.setDefaults(Notification.DEFAULT_ALL);//vibration , sound, light
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(message));
        builder.addAction(R.drawable.add_icon,"Add",null);
        builder.addAction(R.drawable.dialog_close,"Close",null);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(2,builder.build());
    }
}
