package com.example.project_01;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;

import static android.view.View.GONE;

public class SolveBasic extends AppCompatActivity {
    public static final String TAG = "SolveBasic1";
    int target = 0;
    int[] answers;
    int[] finalAnswers;

    Context context;

    //TODO : answers, finalanswers 크기 맞춰서 보내기.(필수)
    //TODO : 주관식 예외처리하기
    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solve_basic);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);


        //Result로 가는 인텐트
        Intent resultIntent = new Intent(getApplicationContext(), SolveResult.class);

        //전달받은 인텐트 불러와서 사용
        Intent solveBasicIntent = getIntent();

        //사용되는 뷰 선언
        TextView basicProNum;
        ImageView problemView, poseBtn, submitBtn, bookmarkBtn, toolbarMenu, unBookMarkBtn;
        Button preBtn, nextBtn, continueBtn, quitBtn;
        ScrollView scroll;
        final View[] dialogView = {null};
        RadioGroup radioChoice;
        EditText edtJu;

        //뷰 id 연결
        problemView = (ImageView) findViewById(R.id.basicProblem);
        preBtn = (Button) findViewById(R.id.preBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        basicProNum = (TextView) findViewById(R.id.basicProNum);
        scroll = (ScrollView) findViewById(R.id.solveBasicScroll);
        poseBtn = (ImageView) findViewById(R.id.poseBtn);
        submitBtn = (ImageView) findViewById(R.id.submitBtn);
        bookmarkBtn = (ImageView) findViewById(R.id.bookmarkBtn);
        toolbarMenu = (ImageView) findViewById(R.id.toolbar_menu);
        unBookMarkBtn =  (ImageView) findViewById(R.id.unBookmarkBtn);
        radioChoice = (RadioGroup) findViewById(R.id.basicRadioGroup);
        edtJu = findViewById(R.id.juGwanSick);

        //툴바 설정
        poseBtn.setVisibility(View.VISIBLE);
        submitBtn.setVisibility(View.VISIBLE);
        bookmarkBtn.setVisibility(View.VISIBLE);
        toolbarMenu.setVisibility(GONE);

        //선택된 문제 코드 받음[PrimaryKey : id]
        String solvePick = solveBasicIntent.getStringExtra("solvePick");
        Log.d(TAG, solvePick + " : 선택된 문제");

        //문제 전체 코드 받기
        int[] division = initLoadDDB(solvePick);

        //선택과목 코드 받기
        int selSub = solveBasicIntent.getIntExtra("selSub", 0);

        //정답목록 불러오기
        int[] realAnswers = initLoadADB(solvePick);

        //문제 점수 불러오기
        int[] ExamScore = initLoadESDB(solvePick);

        //TODO : 동적으로 리스트의 크기가 변경되는 ArrayList로 문제목록 만들기 수학 데이터 받아올 때 수정.
        int roofCount;
        ArrayList<String> problemNam = new ArrayList<String>();
        ArrayList<Integer> finalAnswer = new ArrayList<Integer>() ;
        ArrayList<Integer> finalExamScore = new ArrayList<Integer>();

        if(solvePick.substring(3,4).equals("m")){
            roofCount = 30;
            Log.d(TAG, "수학 굿.");
        }else roofCount = 45;

        if(solvePick.substring(3,4).equals("k")) {
            for (int i = 0; i < roofCount; i++) {
                if (division[i] != selSub + 2) {
                    problemNam.add(solvePick + "m" + Integer.toString(i+1));
                    finalAnswer.add(realAnswers[i]);
                    finalExamScore.add(ExamScore[i]);
                }
            }
        }else if(solvePick.substring(3,4).equals("m")){
                if(selSub == 1) {
                    for (int i = 0; i < roofCount; i++){
                        if (division[i] < 5) {
                            problemNam.add(solvePick + "m" + Integer.toString(i+1));
                            finalAnswer.add(realAnswers[i]);
                            finalExamScore.add(ExamScore[i]);
                        }
                    }
                }else if(selSub == 2){
                    for (int i = 0; i < 30; i++) {
                        if (division[i] < 3 || division[i] == selSub + 3) {
                            problemNam.add(solvePick + "m" + Integer.toString(i+1));
                            finalAnswer.add(realAnswers[i]);
                            finalExamScore.add(ExamScore[i]);
                        }
                    }
                }else if(selSub == 3){
                    for (int i = 0; i < roofCount; i++) {
                        if(division[i] < 3 || division[i] == selSub + 3) {
                            problemNam.add(solvePick + "m" + Integer.toString(i+1));
                            finalAnswer.add(realAnswers[i]);
                            finalExamScore.add(ExamScore[i]);
                        }
                    }
                }
        }else for (int i = 0; i < roofCount; i++) problemNam.add(solvePick + "m" + Integer.toString(i));

        Log.d(TAG, "size" +Integer.toString(finalAnswer.size()));
        //배열리스트를 배열로 변환
        String[] problemName = problemNam.toArray(new String[0]);
        int[] finalAnswers = new int[finalAnswer.size()];
        int[] finalExamScores = new int[finalExamScore.size()];
        for(int i = 0; i < finalAnswer.size(); i++){
            finalAnswers[i] = finalAnswer.get(i);
            finalExamScores[i] = finalExamScore.get(i);
        }


        for(int i = 0; i < problemNam.size(); i++){
            Log.d(TAG, problemName[i]);
        }

        String format = ".png";

        AssetManager am = getResources().getAssets();

        //비트맵으로 변환된 이미지를 저장하는 ArrayList선언
        ArrayList<Bitmap> ProblemImgBm = new ArrayList<Bitmap>();
        InputStream is = null;

        Log.d(TAG ,solvePick + "/" + problemName[0]);

        try {
            is = am.open(solvePick + "/" + problemName[target] + format);
            int width = size.x;

            //비트맵으로 변환하여 이미지 표시
            Bitmap b = BitmapFactory.decodeStream(is);
            double bWidth = b.getWidth();
            double bHeight = b.getHeight();
            int height = size.y;
            double rate = width / bWidth;
            Log.d(TAG, "1 레이트 : " + Double.toString(width / bWidth));
            if(bHeight * rate < height) rate = 1;

            Log.d(TAG, "1 레이트 : " + Double.toString(rate));

            Bitmap resize_bitmap = Bitmap.createScaledBitmap(b, width, (int) Math.round(bHeight * rate), true);
            ProblemImgBm.add(resize_bitmap);
            problemView.setImageBitmap(ProblemImgBm.get(target));

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //문제 길이로 결정되는 정답을 담는 배열을 선언
        int[] answers = new int[problemName.length];
        for (int i = 0; i < problemName.length; i++) {
            answers[i] = 0;
            Log.d(TAG, Integer.toString(answers[i]));
        }

        boolean[] bookMark = {false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false, false};

        problemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preBtn.getVisibility() == View.VISIBLE) {
                    preBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setVisibility(View.INVISIBLE);
                } else {
                    preBtn.setVisibility(View.VISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        //alertdialog 생성
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView[0] = (View)View.inflate(SolveBasic.this, R.layout.submitdialog, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(SolveBasic.this);
                dlg.setView(dialogView[0]);

                final AlertDialog alertDialog = dlg.create();
                alertDialog.show();

                TextView alertText1 = alertDialog.findViewById(R.id.submittext1);
                TextView alertText2 = alertDialog.findViewById(R.id.submittext2);
                TextView alertText3 = alertDialog.findViewById(R.id.submittext3);
                TextView alertText4 = alertDialog.findViewById(R.id.submittext4);
                TextView alertText5 = alertDialog.findViewById(R.id.submittext5);

                //ㅇ알림창 관리
                boolean solveAll = false;
                int markst = 0;

                //선택한 문제
                //선택한 모의고사 표시 설정
                String subject;
                String examMon;

                if (solvePick.substring(3,4).equals("k")) subject = "국어";
                else if (solvePick.substring(3,4).equals("m")) subject = "수학";
                else subject = "영어";

                if(solvePick.substring(4).equals("1")) examMon = "11";
                else examMon = solvePick.substring(4);

                //선택한 문제 표시 텍스트뷰 설정
                alertText1.setText("20" + solvePick.substring(1,3) + "년도 " + examMon + "월 " + subject + " 모의고사");

                //풀지않은 문제 푼제관리
                for(int i = 0; i < problemNam.size(); i++){
                    if(answers[i] == 0){
                        alertText2.setText(alertText2.getText() + Integer.toString(i+1) + "번, ");
                        markst++;
                        if(markst > 5){
                            alertText2.setText(alertText2.getText() + ",,,");
                            break;
                        }
                    }
                }

                //모든 문제를 풀었을 때
                if(markst == 0){
                    alertText1.setText("");
                    alertText2.setText("");
                    alertText3.setText("모든 문제를 다 풀었습니다.");
                    alertText4.setText("");
                    alertText5.setText("");
                }

                Button continueBtn = alertDialog.findViewById(R.id.continueBtn);
                Button quitBtn = alertDialog.findViewById(R.id.quitBtn);

                continueBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "계속풀기", Toast.LENGTH_SHORT).show();
                    }
                });

                quitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent resultIntent = new Intent(getApplicationContext(), SolveResult.class);
                        goToResult(answers, finalAnswers, division, finalExamScores, solvePick, selSub);
                    }
                });

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        //북마크 설정
        bookmarkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 bookMark[target] = true;
                 bookmarkBtn.setVisibility(GONE);
                 unBookMarkBtn.setVisibility(View.VISIBLE);
            }
        });

        unBookMarkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookMark[target] = false;
                bookmarkBtn.setVisibility(View.VISIBLE);
                unBookMarkBtn.setVisibility(GONE);
            }
        });

        radioChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                try {
                    RadioButton chkRdo = (RadioButton) findViewById(checkedId);
                    answers[target] = Integer.parseInt(chkRdo.getText().toString());
                }catch (NullPointerException e){
                    Log.d(TAG, Integer.toString(checkedId));
                }
            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //InputStream 멤버변수로 설정
                InputStream is = null;
                RadioGroup radioChoice = (RadioGroup) findViewById(R.id.basicRadioGroup);
                radioChoice.clearCheck();

                Log.d(TAG, Integer.toString(division[target]) + "div");

                //체크된 라디오버튼 찾아 저장.
                if (target < problemNam.size() - 1) {
                    target++;
                    basicProNum.setText(Integer.toString(target + 1) + ".");

                    scroll.fullScroll(scroll.FOCUS_UP);

                    //target에 지정된 비트맵이 있을 경우 저장하고 표출하고 아닐 경우 그냥 표출.
                    try {
                        is = am.open(solvePick + "/" + problemName[target] + format);

                        //비트맵으로 변환하여 이미지 표시
                        int width = size.x;
                        Bitmap b = BitmapFactory.decodeStream(is);
                        double bWidth = b.getWidth();
                        double bHeight = b.getHeight();
                        int height = size.y;
                        double rate = width / bWidth;
                        Log.d(TAG, "레이트 : " + Double.toString(rate));
                        if (bHeight * rate < height) rate = 1;

                        Log.d(TAG, Double.toString(bHeight * rate) + " , " + Double.toString(height));

                        Bitmap resize_bitmap = Bitmap.createScaledBitmap(b, width, (int) Math.round(bHeight * rate), true);
                        ProblemImgBm.add(resize_bitmap);
                        problemView.setImageBitmap(ProblemImgBm.get(target));

                        is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Log.d(TAG, Integer.toString(target));

                    if (solvePick.substring(3, 4).equals("m") && problemName[target].length() > 7){
                        if (Integer.parseInt(problemName[target].substring(6, 8)) > 24) {
                            {
                                radioChoice.setVisibility(GONE);
                                edtJu.setVisibility(View.VISIBLE);
                                edtJu.setText("");
                                answers[target-1] = Integer.parseInt(edtJu.getText().toString());
                            }
                        } else {
                            radioChoice.setVisibility(View.VISIBLE);
                            edtJu.setVisibility(GONE);
                            edtJu.setText("");
                        }
                    }


                    //북마크 여부 판단
                    if(bookMark[target])
                    {
                        bookmarkBtn.setVisibility(GONE);
                        unBookMarkBtn.setVisibility(View.VISIBLE);
                    }else {
                        bookmarkBtn.setVisibility(View.VISIBLE);
                        unBookMarkBtn.setVisibility(GONE);
                    }


                    switch (answers[target]) {
                        case 1:
                            RadioButton chkRdo1 = (RadioButton) findViewById(R.id.basicSolveRdo1);
                            chkRdo1.setChecked(true);
                            break;
                        case 2:
                            RadioButton chkRdo2 = (RadioButton) findViewById(R.id.basicSolveRdo2);
                            chkRdo2.setChecked(true);
                            break;
                        case 3:
                            RadioButton chkRdo3 = (RadioButton) findViewById(R.id.basicSolveRdo3);
                            chkRdo3.setChecked(true);
                            break;
                        case 4:
                            RadioButton chkRdo4 = (RadioButton) findViewById(R.id.basicSolveRdo4);
                            chkRdo4.setChecked(true);
                            break;
                        case 5:
                            RadioButton chkRdo5 = (RadioButton) findViewById(R.id.basicSolveRdo5);
                            chkRdo5.setChecked(true);
                            break;
                    }
                } else {
                    bookmarkBtn.setImageResource(R.drawable.bookmark);
                    goToResult(answers, finalAnswers, division, finalExamScores, solvePick, selSub);
                }
            }
        });

        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //InputStream 멤버변수로 설정
                InputStream is = null;
                RadioGroup radioChoice = (RadioGroup) findViewById(R.id.basicRadioGroup);
                radioChoice.clearCheck();
                if (target > 0) {
                    target--;

                    basicProNum.setText(Integer.toString(target + 1) + ".");

                    scroll.fullScroll(scroll.FOCUS_UP);

                    //저장된 이미지 비트맵 표출.
                    problemView.setImageBitmap(ProblemImgBm.get(target));

                    Log.d(TAG, Integer.toString(answers[target]));

                    //북마크 여부 판단
                    if(bookMark[target])
                    {
                        bookmarkBtn.setVisibility(GONE);
                        unBookMarkBtn.setVisibility(View.VISIBLE);
                    }else {
                        bookmarkBtn.setVisibility(View.VISIBLE);
                        unBookMarkBtn.setVisibility(GONE);
                    }

                    switch (answers[target]) {
                        case 1:
                            RadioButton chkRdo1 = (RadioButton) findViewById(R.id.basicSolveRdo1);
                            chkRdo1.setChecked(true);
                            break;
                        case 2:
                            RadioButton chkRdo2 = (RadioButton) findViewById(R.id.basicSolveRdo2);
                            chkRdo2.setChecked(true);
                            break;
                        case 3:
                            RadioButton chkRdo3 = (RadioButton) findViewById(R.id.basicSolveRdo3);
                            chkRdo3.setChecked(true);
                            break;
                        case 4:
                            RadioButton chkRdo4 = (RadioButton) findViewById(R.id.basicSolveRdo4);
                            chkRdo4.setChecked(true);
                            break;
                        case 5:
                            RadioButton chkRdo5 = (RadioButton) findViewById(R.id.basicSolveRdo5);
                            chkRdo5.setChecked(true);
                            break;
                        default:
                            radioChoice.clearCheck();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "1번 문제입니다.", Toast.LENGTH_SHORT).show();
                }

                if (solvePick.substring(3, 4).equals("m") && problemName[target].length() > 7){
                    if (Integer.parseInt(problemName[target].substring(6, 8)) > 24) {
                        {
                            radioChoice.setVisibility(GONE);
                            edtJu.setVisibility(View.VISIBLE);
                            edtJu.setText("");
                            answers[target+1] = Integer.parseInt(edtJu.getText().toString());
                        }
                    } else {
                        radioChoice.setVisibility(View.VISIBLE);
                        edtJu.setVisibility(GONE);
                        edtJu.setText("");
                    }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        outOfExam();
    }

    public void OnClickPoseBtn(View view)
    {
        outOfExam();
    }

    public void goToResult(int[] submitAnswers, int[] finalAnswers ,int[] division, int[] finalExamScores ,String solvePick, int selSub){
        Intent resultIntent = new Intent(getApplicationContext(), SolveResult.class);
        resultIntent.putExtra("submitAnswer", submitAnswers);
        resultIntent.putExtra("finalAnswers", finalAnswers);
        resultIntent.putExtra("division", division);
        resultIntent.putExtra("solvePick", solvePick);
        resultIntent.putExtra("selSub", selSub);
        resultIntent.putExtra("examScore", finalExamScores);
        startActivity(resultIntent);
    }

    private int[] initLoadDDB(String solvePick) {
        DivisionDBAdapter mDbHelper = new DivisionDBAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        int[] answer = mDbHelper.getTableData(solvePick);

        mDbHelper.close();

        return answer;
    }

    private int[] initLoadADB(String solvePick) {
        AnswerDBAdapter mDbHelper = new AnswerDBAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        int[] answer = mDbHelper.getTableData(solvePick);

        mDbHelper.close();

        return answer;
    }

    private int[] initLoadESDB(String solvePick){
        ExamScoreDBAdapter mDbHelper = new ExamScoreDBAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        int[] answer = mDbHelper.getTableData(solvePick);

        mDbHelper.close();

        return answer;
    }

    private void outOfExam(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("문제풀이 중지하기").setMessage("문제풀이를 중지하고 나가시겠습니까?");

        builder.setPositiveButton("그만하기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                //이전 스택 다날리는법 알면 수정할 것.
                Intent quitIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(quitIntent);
            }
        });

        builder.setNegativeButton("계속풀기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                return;
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

