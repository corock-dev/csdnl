package com.example.service;

import android.os.Handler;

public class ServiceThread extends Thread {
    Handler handler;
    boolean isRun = true;

    /**
     * ServiceThread
     * MyService에서 정의한 ServiceThread 핸들러를 넘겨 받아 초기화
     * @param handler
     */
    public ServiceThread(Handler handler) {
        this.handler = handler;
    }

    /**
     * stopForever
     * 이 함수가 호출되면 isRun flag 값을 false 처리하여 쓰레드 종료
     */
    public void stopForever() {
        synchronized (this) {
            this.isRun = false;
        }
    }

    public void run() {
        // 반복적으로 수행할 작업
        while (isRun) {
            handler.sendEmptyMessage(0);
            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
        }
    }
}
