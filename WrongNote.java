package com.example.project_01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WrongNote extends AppCompatActivity {
    final String TAG = "WrongNote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrongnote);
        Log.d(TAG, "살려주세요");

        WNDBHelper wNDBHelper;
        wNDBHelper = new WNDBHelper(getApplicationContext());
        int WrongCount = 0;
        final View[] dialogView = {null};

        SQLiteDatabase sqlDB;
        sqlDB = wNDBHelper.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("SELECT * FROM wrong_note;", null);

        ArrayList<String> solvePick = new ArrayList<String>();
        ArrayList<Integer> wrongCount = new ArrayList<Integer>();
        ArrayList<Integer> examLen = new ArrayList<Integer>();
        ArrayList<String> selSub = new ArrayList<String>();
        ArrayList<Integer> trueFalse = new ArrayList<Integer>();
        //substring 12 - 16

        while (cursor.moveToNext()){
            WrongCount = 0;

            solvePick.add(cursor.getString(0));
            selSub.add(cursor.getString(1));
            examLen.add(Integer.parseInt(cursor.getString(2)));

            for(int i = 3; i < 3 + Integer.parseInt(cursor.getString(2)); i++){
                trueFalse.add(Integer.parseInt(cursor.getString(i)));
            }

            for(int i = 3; i < 3 + Integer.parseInt(cursor.getString(2)); i++){
                if(cursor.getString(i).equals("0")){
                    WrongCount++;
                    Log.d(TAG, "살려주세요");
                }
            }
            wrongCount.add(WrongCount);
            Log.d(TAG, cursor.getString(0));
        }

        cursor.close();
        sqlDB.close();

        String[] solvePicks = new String[wrongCount.size()];
        int[] wrongCounts = new int[wrongCount.size()];
        for(int i = 0; i < wrongCount.size(); i++){
            solvePicks[i] = solvePick.get(i);
            wrongCounts[i] = wrongCount.get(i);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.wrongNoteRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        WrongNoteAdapter adapter = new WrongNoteAdapter(wrongCounts, solvePicks);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new WrongNoteAdapter.OnItemClickListener(){
                @Override
                public void onItemClick(View v, int position) {
                    String code = adapter.returnCode(position);
                    code = "a" + code.substring(12,16);

                    dialogView[0] = (View)View.inflate(WrongNote.this, R.layout.wrongnote_dialog, null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(WrongNote.this);
                    dlg.setView(dialogView[0]);

                    final AlertDialog alertDialog = dlg.create();
                    alertDialog.show();

                    TextView alertText1 = alertDialog.findViewById(R.id.selExamWN);
                    Button btnSelectResult, btnSelectWrong, btnSelectReStart, btnSelectShare;
                    btnSelectResult = alertDialog.findViewById(R.id.btnSelectResult);
                    btnSelectWrong = alertDialog.findViewById(R.id.btnSelectWrong);
                    btnSelectReStart = alertDialog.findViewById(R.id.btnSelectReStart);
                    btnSelectShare = alertDialog.findViewById(R.id.btnSelectShare);

                    String finalCode = code;
                    btnSelectReStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), SolveBasic.class);
                            intent.putExtra("selSub", selSub.get(position));
                            Log.d(TAG, selSub.get(position));
                            intent.putExtra("solvePick", finalCode);
                            startActivity(intent);
                        }
                    });
                }
            });


    }
}
