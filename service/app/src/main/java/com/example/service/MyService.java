package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    ServiceThread thread;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        myServiceHandler handler = new myServiceHandler();
        thread = new ServiceThread(handler);
        thread.start();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // 시간 차를 두고 실행하고 싶은 함수 호출
//                Toast.makeText(MyService.this, "201824638 이제훈", Toast.LENGTH_SHORT).show();
//            }
//        }, 3000);
        return START_STICKY;
    }

    public void onDestroy() {
        thread.stopForever();
        thread = null;
    }

    class myServiceHandler extends Handler {
        public void handleMessage(android.os.Message msg) {
            Toast.makeText(MyService.this, "201824638 이제훈", Toast.LENGTH_LONG).show();
        }
    }

    public MyService() {
    }


}
