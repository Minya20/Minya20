package com.example.project_01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SolveResultAdapter extends RecyclerView.Adapter<SolveResultAdapter.ViewHolder> {
    final String TAG = "SolveResultAdapter";
    private int[] resultAnswer = null;
    private int[] realAnswer = null;
    private boolean[] wrongAnswer = new boolean[45];
    private int counter = 1;
    private int[] Division = null;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView resultProblemNum, resultXO;
        ImageView selectAns1, selectAns2, selectAns3, selectAns4, selectAns5;

        ViewHolder(View itemView){
            super(itemView);

            resultProblemNum = itemView.findViewById(R.id.resultProblemNum);
            resultXO = itemView.findViewById(R.id.resultXO);
            selectAns1 = itemView.findViewById(R.id.selectAns1);
            selectAns2 = itemView.findViewById(R.id.selectAns2);
            selectAns3 = itemView.findViewById(R.id.selectAns3);
            selectAns4 = itemView.findViewById(R.id.selectAns4);
            selectAns5 = itemView.findViewById(R.id.selectAns5);
        }
    }

    SolveResultAdapter(int[] resultAns, int[] realAns){
        resultAnswer = resultAns;
        realAnswer = realAns;
    }

    @NonNull
    @Override
    public SolveResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.solveresult_item, parent, false);
        SolveResultAdapter.ViewHolder vh = new SolveResultAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String resultNum = Integer.toString(position+1) + ".";
        holder.resultProblemNum.setText(resultNum);

        try {
            if (resultAnswer[position] == realAnswer[position]) {
                holder.resultXO.setText("O");
                wrongAnswer[position] = true;
                Log.d(TAG, resultAnswer[position]  + ":" + realAnswer[position]);
            } else {
                holder.resultXO.setText("X");
                Integer integerPos = Integer.valueOf(position);
                wrongAnswer[position] = false;
            }
        }catch (NullPointerException e){
            Log.d(TAG, "OUTOFRANGE");
        }

        if(resultAnswer[position] != 0){
            switch (resultAnswer[position]){
                case 1:
                    holder.selectAns1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    holder.selectAns2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    holder.selectAns3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    holder.selectAns4.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    holder.selectAns5.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    void SolveListAdapter(int[] submitAnswer, int[] imRealAnswer){
        resultAnswer = submitAnswer;
        realAnswer = imRealAnswer;
    }//데이터 리스트 객체 전달

    public boolean[] getWrongAnswer(){return wrongAnswer;}

    @Override
    public int getItemCount() {
        return realAnswer == null ? 0 : realAnswer.length;
    }
}
