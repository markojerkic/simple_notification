package com.markojerkic.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/*
    Built by Marko Jerkic 2017
    Visit markojerkic.com/how-to-build-a-notification-in-android for more information

    markojerkic.com
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finds the button declared in the activity_main.xml
        Button mButton = (Button) findViewById(R.id.button);

        //sets what will the app do when the button is pressed
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calls the sendNotification() method
                sendNotification();
            }
        });
    }

    public void sendNotification() {

        //builds the basic notification
        NotificationCompat.Builder mNotification =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_info_outline_white_24px)
                        .setContentTitle("First Notificaion")
                        .setContentText("Hi!");

        //sets the sound, vibration and other things to
        //your device's defaults
        mNotification.setDefaults(Notification.DEFAULT_ALL);

        NotificationManager mNotfMng =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //sends the notification
        mNotfMng.notify(001, mNotification.build());
    }
}
