package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationSomthings();
            }
        });
    }

    public void NotificationSomthings() {
        Bitmap mLargeIconForNoti =
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_stat_name);

        PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
            0,
            new Intent(getApplicationContext(), MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder =
            new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon((R.drawable.ic_stat_name))
                .setContentTitle("Notification by 201824638 이제훈")
                .setContentText("학번: 201824638 / 이름: 이제훈")
                .setTicker("상태바 한줄 메시지")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(mLargeIconForNoti)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(contentIntent);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1234, builder.build());
    }
}
