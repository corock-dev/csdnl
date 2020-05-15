package com.example.week5;

public class JNIClass {
    static {
        System.loadLibrary("jniExample");
    }

    public native String getNumString(String str, int num);

    private String callback(String str, int num) {
        return str + ": " + num;
    }
}
