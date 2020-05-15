package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 멤버변수 선언
    JNIClass jni;
    Button call;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JNIClass 생성
        jni = new JNIClass();

        // 컴포넌트 바인딩
        call = (Button) findViewById(R.id.jniCall_btn);
        tv = (TextView) findViewById(R.id.jni_txt);

        // 버튼 클릭 이벤트 정의
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(jni.getNumString("Native Method 호출", 1));
            }
        });
    }
}
