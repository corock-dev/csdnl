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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 멤버변수 선언
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

        // 컴포넌트 참조를 위해 바인딩
        insertBtn = (Button) findViewById(R.id.insert_btn);
        selectBtn = (Button) findViewById(R.id.select_btn);
        updateBtn = (Button) findViewById(R.id.update_btn);
        deleteBtn = (Button) findViewById(R.id.delete_btn);
        list = (ListView) findViewById(R.id.list);

        // 데이터베이스 Helper 생성
        helper = new DBHelper(MainActivity.this, "person.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        // INSERT 버튼 클릭 이벤트 설정
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * ContentValues 클래스
                 * values 인스턴스 생성 및 DB에 넣을 데이터 선언
                 */
                ContentValues values = new ContentValues();

                values.put("name", "이제훈");
                values.put("id", 201824638);
                values.put("address", "부산광역시");

                // key: value 값을 values를 DBHelper로 전달 후 INSERT 문 실행
                db.insert("Student", null, values);

                Toast.makeText(MainActivity.this, "INSERT 완료: " + values, Toast.LENGTH_SHORT).show();
            }
        });

        // SELECT 버튼 클릭 이벤트 설정
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Cursor
                 * 커서는 DB에서 한 Row를 참조할 수 있게 도와주는 인터페이스
                 * 검색 결과가 많을 때는 특정 행으로 인덱싱 가능
                 */
                Cursor c = db.query("Student", null, null, null, null, null, null, null);

                SimpleCursorAdapter adapter = null;

                // 어댑터 생성 및 데이터 설정 환경 구성
                adapter = new SimpleCursorAdapter(
                        MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        c,
                        new String[]{"name", "id", "address"},
                        new int[]{android.R.id.text1, android.R.id.text2}, 0
                );

                // ListView에 만든 어댑터 연결
                ListView list = (ListView) findViewById(R.id.list);
                list.setAdapter(adapter);
            }
        });

        // UPDATE 버튼 클릭 이벤트 설정
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues newValues = new ContentValues();
                // 기존 학번(id)를 123456789로 변경
                newValues.put("id", 123456789);

                /**
                 * @param String[] whereArgs new String[] {name} 형태로 WHERE 조건문 사용
                 */
                db.update("Student", newValues, "name=?", new String[]{"이제훈"});
            }
        });

        // DELETE 버튼 클릭 이벤트 설정
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DB TABLE을 Student로 생성했지만 student로 인자 값을 넘겨줘도 가능하므로 대소문자 구별 없음
                db.delete("student", "name=?", new String[]{"이제훈"});
            }
        });
    }

}
