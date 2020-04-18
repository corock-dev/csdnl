package com.example.week5_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    Button insertBtn;
    Button selectBtn;
    Button updateBtn;
    Button deleteBtn;
    ListView list;
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertBtn = (Button) findViewById(R.id.insert_btn);
        selectBtn = (Button) findViewById(R.id.select_btn);
        updateBtn = (Button) findViewById(R.id.update_btn);
        deleteBtn = (Button) findViewById(R.id.delete_btn);
        list = (ListView) findViewById(R.id.list);

        helper = new DBHelper(MainActivity.this, "person.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();

                values.put("name", "이제훈");
                values.put("id", 201824638);
                values.put("address", "부산광역시");
                db.insert("Student", null, values);
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.query("Student", null, null, null, null, null, null, null);

                SimpleCursorAdapter adapter = null;
                adapter = new SimpleCursorAdapter(
                        MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        c,
                        new String[]{"name", "id", "address"},
                        new int[]{android.R.id.text1, android.R.id.text2}, 0);

                ListView list = (ListView) findViewById(R.id.list);
                list.setAdapter(adapter);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues newValues = new ContentValues();
                newValues.put("id", 123456789);

                db.update("student", newValues, "name=?", new String[]{"이도훈"});
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("Student", "name=?", new String[]{"홍길동"});
            }
        });
    }

}
