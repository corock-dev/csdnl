package com.example.week5_sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @see <a href="https://developer.android.com/training/data-storage/sqlite>SQLite</a>
 */
public class DBHelper extends SQLiteOpenHelper {
    // super를 이용한 DBHelper 초기화
    public DBHelper(
        Context context,
        String name,
        SQLiteDatabase.CursorFactory factory,
        int version
    ) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL문 정의
        String sql =
            "CREATE TABLE IF NOT EXISTS Student (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT, " +
            "id INTEGER, " +
            "address TEXT);";

        // execSQL: SELECT 쿼리문을 제외하고 사용 가능
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // SQL문 정의
        String sql = "DROP TABLE IF EXISTS Student";

        // 쿼리 실행
        db.execSQL(sql);

        // 기존에 있는 Student 테이블 삭제 후 새로운 테이블 생성
        onCreate(db);
    }
}
