package com.example.project_01;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradeCutDBAdapter
{
    protected static final String TAG = "GradeCutDBAdapter";
    protected static final String TABLE_NAME = "grade";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private GradeCutDBHelper mDbHelper;
    private String solvePick;

    public GradeCutDBAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new GradeCutDBHelper(mContext);
    }

    public GradeCutDBAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public GradeCutDBAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    // TODO : grade 구분자를 명시해야함. 생성 규칙 - "시행년도" + "과목구분" + "시행월" 예)18K3M = 18년 3월 국어 모의고사
    public List getTableData(String solvePick)
    {
        //검색할 이름 구하기
        String selExam;
        if(solvePick.substring(4) == "1"){
            selExam = solvePick.substring(1,3) + solvePick.substring(3).toUpperCase() + "11";
        }else{
            selExam = solvePick.substring(1,3) + solvePick.substring(3,4).toUpperCase() + "0" + solvePick.substring(4);
        }

        try
        {
            String sql ="SELECT * FROM '" + TABLE_NAME + "'";

            // 모델 넣을 리스트 생성
            List grade_cutList = new ArrayList();

            GradeCut grade_cut = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {

                    grade_cut = new GradeCut();

                    if(mCur.getString(0).substring(0,5).equals(selExam)) {
                        grade_cut.setGrade(mCur.getString(0));
                        grade_cut.setRScore(mCur.getString(1));
                        grade_cut.setStScore(mCur.getString(2));
                        grade_cut.setPercentile(mCur.getString(3));

                        Log.d(TAG, mCur.getString(0));

                        // 리스트에 넣기
                        grade_cutList.add(grade_cut);
                    }
                }

            }
            return grade_cutList;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

}