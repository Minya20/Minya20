package com.example.project_01;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SolveResult extends AppCompatActivity {
    public static final String TAG = "SolveResult";
    public static final String ROOT_DIR = "/data/data/com.example.test1/";
    public List<GradeCut> gradeCuts;

    Fragment solveListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solve_result);

        ImageView poseBtn, submitBtn, bookmarkBtn, toolbarMenu;

        //툴바 설정
        poseBtn = (ImageView) findViewById(R.id.poseBtn);
        submitBtn = (ImageView) findViewById(R.id.submitBtn);
        bookmarkBtn = (ImageView) findViewById(R.id.bookmarkBtn);
        toolbarMenu = (ImageView) findViewById(R.id.toolbar_menu);

        poseBtn.setVisibility(View.VISIBLE);
        submitBtn.setVisibility(View.GONE);
        bookmarkBtn.setVisibility(View.GONE);
        toolbarMenu.setVisibility(View.GONE);

        TextView solveResultSelSubTV = (TextView) findViewById(R.id.solveResultSelSubTV);

        //인텐트 전달받기
        Intent resultIntent = getIntent();


        //결과 확인창 연결
        TextView point, pointPer, grade, gradePer, basicSub, basicPer, selSubTV, selPer;

        point = (TextView) findViewById(R.id.point);
        pointPer = (TextView) findViewById(R.id.pointPer);
        grade = (TextView) findViewById(R.id.grade);
        gradePer = (TextView) findViewById(R.id.gradePer);
        basicSub = (TextView) findViewById(R.id.basicSub);
        basicPer = (TextView) findViewById(R.id.basicPer);
        selSubTV = (TextView) findViewById(R.id.selSub);
        selPer = (TextView) findViewById(R.id.selPer);
        Button getResultBtn = (Button) findViewById(R.id.getResultBtn);
        View resultBoard = (View) findViewById(R.id.resultBoard);


        //데이터베이스용
        WNDBHelper wNDBHelper;
        wNDBHelper = new WNDBHelper(getApplicationContext());
        final SQLiteDatabase[] sqlDB = new SQLiteDatabase[1];

        //받은정답, 실제정답, 문제 구분 데이터 가져오기.
        int[] givenAnswer = resultIntent.getIntArrayExtra("submitAnswer");
        int[] finalAns = resultIntent.getIntArrayExtra("finalAnswers");
        int[] division = resultIntent.getIntArrayExtra("division");
        String solvePick = resultIntent.getStringExtra("solvePick");
        int selSub = resultIntent.getIntExtra("selSub", 0);
        int[] examScore = resultIntent.getIntArrayExtra("examScore");

        //선택한 모의고사 표시 설정
        String subject;
        String examMon;

        if (solvePick.substring(3,4).equals("k")) subject = "국어";
        else if (solvePick.substring(3,4).equals("m")) subject = "수학";
        else subject = "영어";

        if(solvePick.substring(4).equals("1")) examMon = "11";
        else examMon = solvePick.substring(4);

        //선택한 문제 표시 텍스트뷰 설정
        TextView solvePickTV = (TextView) findViewById(R.id.solvePickTV);
        solvePickTV.setText("20" + solvePick.substring(1,3) + "년도 " + examMon + "월 " + subject);

        //선택과목 설정, 위의 subject 수정에 따라 조건 변경 후 설정
        String selSubStr = " ";
        if(subject.equals("국어")){
            switch (selSub){
                case 1:
                    selSubStr = "화법과작문";
                    break;
                case 2:
                    selSubStr = "언어와매체";
                    break;
            }

            //1: 미적분 2: 확률과 통계 3: 기하학
        }else if(subject.equals("수학")){
            switch (selSub){
                case 1:
                    selSubStr = "미적분";
                    break;
                case 2:
                    selSubStr = "확률과통계";
                    break;
                case 3:
                    selSubStr = "기하";
                    break;
            }
        }
        solveResultSelSubTV.setText("선택과목 : " + selSubStr);

        initLoadGCDB(solvePick);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.resultRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SolveResultAdapter adapter = new SolveResultAdapter(givenAnswer, finalAns);
        recyclerView.setAdapter(adapter);

        String finalSelSubStr = selSubStr;
        final int[] flag = new int[1];
        flag[0] = 0;
        getResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultBoard.getVisibility() == View.GONE) {
                    resultBoard.setVisibility(View.VISIBLE);
                    getResultBtn.setText("결과 숨기기");
                }
                else {
                    resultBoard.setVisibility(View.GONE);
                    getResultBtn.setText("결과 확인하기");
                }

                int totalPoint = 0, basicPoint = 0, selPoint = 0, basicPointW = 0, selPointW = 0;
                double weight = 1;
                String gradeNowStr = "a18k9";
                String percentile = "100";
                double scoreNow = 100;
                int mean = 0;

                int[] wrongNote = {0, 0, 0, 0, 0,0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0};

                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
                String getTime = simpleDateFormat.format(mDate);

                boolean[] wrongAnswer = adapter.getWrongAnswer();

                for(int i = 0; i < 45; i++){
                    if(wrongAnswer[i]) wrongNote[i] = 1;
                }

                //과목별 점수 계산
                for(int i = 0; i < givenAnswer.length; i++){
                    if(wrongAnswer[i]) {
                        if (division[i] < 3) basicPoint++;
                        else selPoint++;
                        totalPoint += examScore[i];
                    }else {
                        if (division[i] < 3) basicPointW++;
                        else selPointW++;
                    }
                }

                if(subject.equals("국어")) {
                    weight = 45 / givenAnswer.length;
                }
                else if(subject.equals("수학")){
                    weight = 30 / givenAnswer.length;
                }

                for(int i = 0; i < 8; i++){
                    if(Double.parseDouble(gradeCuts.get(i).r_score) > Math.round(totalPoint * weight) && scoreNow > Double.parseDouble(gradeCuts.get(i).r_score)){
                        percentile = gradeCuts.get(i).percentile;
                        gradeNowStr = gradeCuts.get(i).grade;
                        scoreNow = Double.parseDouble(gradeCuts.get(i).r_score);
                    }
                    if(mean < Integer.parseInt(gradeCuts.get(i).r_score)){
                        mean = Integer.parseInt(gradeCuts.get(i).r_score);
                    }
                }

                //ResultBoard 표출
                basicSub.setText(subject);
                selSubTV.setText(finalSelSubStr);
                basicPer.setText(Integer.toString(basicPoint) + " / " + Integer.toString(basicPointW + basicPoint));
                selPer.setText(Integer.toString(selPoint) + " / " + Integer.toString(selPointW + selPoint));

                point.setText(Double.toString(Math.round(totalPoint * weight)) + "점" );
                pointPer.setText(Integer.toString(basicPoint + selPoint) + " / " + Integer.toString(givenAnswer.length));

                if(subject.equals("국어")) basicSub.setText("독서, 문학");
                else if(subject.equals("수학")) basicSub.setText("수학 1, 2");
                else basicSub.setText("영어");

                grade.setText(gradeNowStr.substring(6,7) + "등급");
                gradePer.setText("약 "+ percentile + "%");

                if(flag[0] != 1) {
                    String sql = "";
                    sql += "'" + getTime + solvePick.substring(1, 5) + "'";
                    sql += ", '" + Integer.toString(selSub) + "'";
                    sql += ", '" + Integer.toString(givenAnswer.length) + "'";
                    for (int i = 0; i < 45; i++) {
                        sql += ", '" + wrongNote[i] + "'";
                    }

                    sqlDB[0] = wNDBHelper.getWritableDatabase();
                    sqlDB[0].execSQL("INSERT INTO wrong_note VALUES (" + sql + ");");
                    sqlDB[0].close();
                    Log.d(TAG, sql);
                    Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                }
                flag[0] = 1;
            }
        });
    }

    public void OnClickPoseBtn(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("메인으로").setMessage("메뉴 화면으로 나가시겠습니까?");

        builder.setPositiveButton("나가기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                //이전 스택 다날리는법 알면 수정할 것.
                Intent quitIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(quitIntent);
            }
        });

        builder.setNegativeButton("나중에", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                return;
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    //뒤로가기 버튼 눌렀을 때.
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("메인으로").setMessage("메뉴 화면으로 나가시겠습니까?");

        builder.setPositiveButton("나가기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                //이전 스택 다날리는법 알면 수정할 것.
                Intent quitIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(quitIntent);
            }
        });

        builder.setNegativeButton("나중에", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                return;
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void initialize(Context ctx){
        File folder = new File(ROOT_DIR + "DATABASES");
    }

    //등급컷 불러오기
    private void initLoadGCDB(String solvePick) {
        GradeCutDBAdapter mDbHelper = new GradeCutDBAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        gradeCuts = mDbHelper.getTableData(solvePick);

        mDbHelper.close();
    }


}