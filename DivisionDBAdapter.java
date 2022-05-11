package com.example.project_01;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.project_01.DivisionDBHelper;

import java.io.IOException;

public class DivisionDBAdapter {
    protected static final String TAG = "DDBAdapter";
    protected static String TABLE_NAME = "division";

    private final Context DContext;
    private SQLiteDatabase mDb;
    private DivisionDBHelper mDbHelper;
    private int length = 45;

    public DivisionDBAdapter(Context context){
        this.DContext = context;
        mDbHelper = new DivisionDBHelper(DContext);
    }

    public DivisionDBAdapter createDatabase() throws SQLException{
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

    public DivisionDBAdapter open() throws SQLException
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
            if(solvePick.substring(3,4).equals("m")){
                length = 30;
            };
            int gaNum = solvePick.length()-1;
            // 구분자 리스트
            int[] answers = new int[length];

            int stack = 0;

            Cursor mCur = mDb.rawQuery(sql, null);

            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {
                    if(mCur.getString(0).substring(0,4).equals(solvePick.substring(1,5))){
                        for(int i = 0; i<length; i++){
                            answers[i] = Integer.parseInt(mCur.getString(i+1));
                            stack++;
                        }
                        this.length = 0;
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

    public void setTableName(String TABLE_NAME){this.TABLE_NAME = TABLE_NAME;}

}

