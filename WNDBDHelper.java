package com.example.project_01;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class WNDBDHelper extends SQLiteOpenHelper {
    private String DB_NAME = "WrongNote";
    private String TABLE_NAME = "wrong_note";
    String sql = "";

    public WNDBDHelper(Context context){
        super(context, "WrongNoteData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (wn_code VARCHAR(20) PRIMARY KEY, wrongcount INTEGER);");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

