package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Button btnOnce = (Button) findViewById(R.id.btn_once);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);

        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        intent.putExtra("info", "201824638 이제훈");

        final PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 100, intent, 0);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        btnOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, sender);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                am.cancel(sender);
            }
        });
    }
}
