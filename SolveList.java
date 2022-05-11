package com.example.project_01;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.TextView;

        import java.util.ArrayList;

public class SolveList extends AppCompatActivity {
    public static final String TAG = "SolveList";
    Fragment solveListFragment;
    ArrayList<String> testDay;
    ArrayList<String> testGroup;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solve_list);

        testDay = new ArrayList<>();
        testGroup = new ArrayList<>();

        TextView solveListSelSubjectTV = (TextView) findViewById(R.id.solveListSelSubject);
        TextView solveListSelSubTV = (TextView) findViewById(R.id.solveListSelSub);

        //인텐트에서 선택한 영역, 선택과목 불러오기
        Intent mIntent = getIntent();
        String subject = mIntent.getStringExtra("subject");
        int selSub = mIntent.getIntExtra("selSub", 0);

        // 선택과목 구분하기
        String selSubStr = " ";
        String subjectStr = " ";
        if (subject.equals("k")) {
            subjectStr = "국어 영역";
            switch (selSub) {
                case 1:
                    selSubStr = "선택과목 : 화법과작문";
                    break;
                case 2:
                    selSubStr = "선택과목 : 언어와매체";
                    break;
            }
            //1: 미적분 2: 확률과 통계 3: 기하학
        } else if (subject.equals("m")) {
            subjectStr = "수리 영역";
            switch (selSub) {
                case 1:
                    selSubStr = "선택과목 : 미적분";
                    break;
                case 2:
                    selSubStr = "선택과목 : 확률과통계";
                    break;
                case 3:
                    selSubStr = "선택과목 : 기하";
                    break;
            }
        } else subjectStr = "영어 영역";
        solveListSelSubjectTV.setText(subjectStr);
        solveListSelSubTV.setText(selSubStr);

        //과목별 데이터 집어넣기.
        putData(subject);

        //userSolveDay 데이터베이스에 입력도 만들어야하는데,,
        TextView toolbarText;
        toolbarText = (TextView) findViewById(R.id.tv_logo);

        toolbarText.setText("기출문제풀이");
        toolbarText.setTextSize(24);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.solveRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SolveListAdapter adapter = new SolveListAdapter(testDay, testGroup);
        recyclerView.setAdapter(adapter);

        String finalSelSubStr = selSubStr;
        adapter.setOnItemClickListener(new SolveListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                item = adapter.item;
                Log.d(TAG, item);

                if (item.substring(8, 9).equals("수"))
                    item = "a" + item.substring(2, 4) + subject + "11";
                else item = "a" + item.substring(2, 4) + subject + item.substring(8, 9);

                Log.d(TAG, item + "여기야 여기");
                Intent intent = new Intent(getApplicationContext(), SolveBasic.class);
                intent.putExtra("selSub", selSub);
                intent.putExtra("solvePick", item);
                startActivity(intent);
            }
        });


    }

    private void putData(String subject) {
        String[] userSolveDay = {"10.08", "10.14", "", "10.27", "10.08", "10.11", "", "11.01", "10.08", "04.14", "", "04.27"};

        if (subject.equals("k")) {
//            testDay.add("2018학년도 수능");
            testDay.add("2018학년도 3월 모의고사");
            testDay.add("2018학년도 6월 모의고사");
//            testDay.add("2018학년도 9월 모의고사");

            testGroup.add("국어(2018)                                      " + userSolveDay[0]);
            testGroup.add("국어(2018)                                      " + userSolveDay[1]);
//            testGroup.add("국어(2018)                                      " + userSolveDay[2]);
//            testGroup.add("국어(2018)                                      " + userSolveDay[3]);

//            testDay.add("2019학년도 수능");
//            testDay.add("2019학년도 3월 모의고사");
//            testDay.add("2019학년도 6월 모의고사");
//            testDay.add("2019학년도 9월 모의고사");
//
//            testGroup.add("국어(2019)                                      " + userSolveDay[4]);
//            testGroup.add("국어(2019)                                      " + userSolveDay[5]);
//            testGroup.add("국어(2019)                                      " + userSolveDay[6]);
//            testGroup.add("국어(2019)                                      " + userSolveDay[7]);
//
//            testDay.add("2020학년도 수능");
//            testDay.add("2020학년도 3월 모의고사");
//            testDay.add("2020학년도 6월 모의고사");
//            testDay.add("2020학년도 9월 모의고사");
//
//            testGroup.add("국어(2020)                                      " + userSolveDay[8]);
//            testGroup.add("국어(2020)                                      " + userSolveDay[9]);
//            testGroup.add("국어(2020)                                      " + userSolveDay[10]);
//            testGroup.add("국어(2020)                                      " + userSolveDay[11]);
        } else if (subject.equals("m")) {
//            testDay.add("2018학년도 수능");
            testDay.add("2018학년도 3월 모의고사");
//            testDay.add("2018학년도 6월 모의고사");
//            testDay.add("2018학년도 9월 모의고사");

            testGroup.add("수학(2018)                                      " + userSolveDay[0]);
//            testGroup.add("수학(2018)                                      " + userSolveDay[1]);
//            testGroup.add("수학(2018)                                      " + userSolveDay[2]);
//            testGroup.add("수학(2018)                                      " + userSolveDay[3]);
//
//            testDay.add("2019학년도 수능");
//            testDay.add("2019학년도 3월 모의고사");
//            testDay.add("2019학년도 6월 모의고사");
//            testDay.add("2019학년도 9월 모의고사");
//
//            testGroup.add("수학(2019)                                      " + userSolveDay[4]);
//            testGroup.add("수학(2019)                                      " + userSolveDay[5]);
//            testGroup.add("수학(2019)                                      " + userSolveDay[6]);
//            testGroup.add("수학(2019)                                      " + userSolveDay[7]);
//
//            testDay.add("2020학년도 수능");
//            testDay.add("2020학년도 3월 모의고사");
//            testDay.add("2020학년도 6월 모의고사");
//            testDay.add("2020학년도 9월 모의고사");
//
//            testGroup.add("수학(2020)                                      " + userSolveDay[8]);
//            testGroup.add("수학(2020)                                      " + userSolveDay[9]);
//            testGroup.add("수학(2020)                                      " + userSolveDay[10]);
//            testGroup.add("수학(2020)                                      " + userSolveDay[11]);
//        }else{
//            testDay.add("2018학년도 수능");
//            testDay.add("2018학년도 3월 모의고사");
//            testDay.add("2018학년도 6월 모의고사");
//            testDay.add("2018학년도 9월 모의고사");
//
//            testGroup.add("영어(2018)                                      " + userSolveDay[0]);
//            testGroup.add("영어(2018)                                      " + userSolveDay[1]);
//            testGroup.add("영어(2018)                                      " + userSolveDay[2]);
//            testGroup.add("영어(2018)                                      " + userSolveDay[3]);
//
//            testDay.add("2019학년도 수능");
//            testDay.add("2019학년도 3월 모의고사");
//            testDay.add("2019학년도 6월 모의고사");
//            testDay.add("2019학년도 9월 모의고사");
//
//            testGroup.add("영어(2019)                                      " + userSolveDay[4]);
//            testGroup.add("영어(2019)                                      " + userSolveDay[5]);
//            testGroup.add("영어(2019)                                      " + userSolveDay[6]);
//            testGroup.add("영어(2019)                                      " + userSolveDay[7]);
//
//            testDay.add("2020학년도 수능");
//            testDay.add("2020학년도 3월 모의고사");
//            testDay.add("2020학년도 6월 모의고사");
//            testDay.add("2020학년도 9월 모의고사");
//
//            testGroup.add("영어(2020)                                      " + userSolveDay[8]);
//            testGroup.add("영어(2020)                                      " + userSolveDay[9]);
//            testGroup.add("영어(2020)                                      " + userSolveDay[10]);
//            testGroup.add("영어(2020)                                      " + userSolveDay[11]);
//
//        }
        }

    }
}

