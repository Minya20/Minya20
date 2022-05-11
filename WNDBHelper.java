package com.example.project_01;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class WNDBHelper extends SQLiteOpenHelper {
    private String DB_NAME = "WrongNote";
    private String TABLE_NAME = "wrong_note";
    String sql = "";

    public WNDBHelper(Context context){
        super(context, "WrongNote", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int i = 0; i < 45; i++) {
            sql += ", problem_" + Integer.toString(i+1) + " INTEGER";
        }
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (wn_code VARCHAR(20) PRIMARY KEY, sel_subject VARCHAR(1), exam_length INTEGER " + sql + ");");
    }

    //코드, 선택과목, 문제길이

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

