package com.example.project_01;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

public class AnswerDBAdapter {
    protected static final String TAG = "AnswerDBAdapter";
    protected static String TABLE_NAME = "answer";

    private final Context AContext;
    private SQLiteDatabase mDb;
    private AnswerDBHelper mDbHelper;

    public AnswerDBAdapter(Context context){
        this.AContext = context;
        mDbHelper = new AnswerDBHelper(AContext);
    }

    public AnswerDBAdapter createDatabase() throws SQLException{
        try{
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public AnswerDBAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException){
            Log.e(TAG, "open >>" + mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close(){
        mDbHelper.close();
    }

    public int[] getTableData(String solvePick){
        try
        {
            String sql ="SELECT * FROM '" + TABLE_NAME + "'";

            // 정답 리스트
            int[] answers = new int[45];

            Cursor mCur = mDb.rawQuery(sql, null);

            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {
                    if(!solvePick.substring(2,3).equals("m")) {
                        if (mCur.getString(0).equals(solvePick.substring(1, 5))) {
                            for (int i = 0; i < 45; i++) {
                                answers[i] = Integer.parseInt(mCur.getString(i + 1));
                            }
                            return answers;
                        }
                        if (mCur.getString(0).equals(solvePick.substring(1, 5) + "b")) {
                            for (int i = 0; i < 30; i++) {
                                answers[i] = Integer.parseInt(mCur.getString(i + 1));
                            }
                            return answers;
                        }
                    }

                }
            }
            return answers;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    public void setTableName(String TABLE_NAME){this.TABLE_NAME = TABLE_NAME;}

}

