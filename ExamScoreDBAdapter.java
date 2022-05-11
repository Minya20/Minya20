package com.example.project_01;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

public class ExamScoreDBAdapter {
    protected static final String TAG = "ExamScoreDBAdapter";
    protected static String TABLE_NAME = "score";

    private final Context ESContext;
    private SQLiteDatabase mDb;
    private ExamScoreDBHelper mDbHelper;
    private String targetExam = "a18k3";
    private int length = 45;

    public ExamScoreDBAdapter(Context context){
        this.ESContext = context;
        mDbHelper = new ExamScoreDBHelper(ESContext);
    }

    public ExamScoreDBAdapter createDatabase() throws SQLException{
        try{
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabaxse");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public ExamScoreDBAdapter open() throws SQLException
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
            int[] answers = new int[length];

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {
                    if(mCur.getString(0).equals(solvePick.substring(1,5))){
                        for(int i = 0; i<length; i++){
                            answers[i] = Integer.parseInt(mCur.getString(i+1));
                        }
                        length = 0;
                        return answers;
                    };
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

    public void setTargetExam (String exam) {this.targetExam = exam;}

    public void setTableName(String TABLE_NAME){this.TABLE_NAME = TABLE_NAME;}

}

