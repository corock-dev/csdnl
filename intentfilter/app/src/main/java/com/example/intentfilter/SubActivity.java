package com.example.intentfilter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    public EditText eText;
    public Button submitBtn;
    public Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("학번 출력").setMessage(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
