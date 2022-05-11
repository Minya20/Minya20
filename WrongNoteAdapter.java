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

public class WrongNoteAdapter extends RecyclerView.Adapter<WrongNoteAdapter.ViewHolder> {
    final String TAG = "WrongNoteAdapter";
    private int[] wrongCount = null;
    private String[] code;

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(WrongNoteAdapter.OnItemClickListener listener){
        this.mListener = listener;
    }

    private WrongNoteAdapter.OnItemClickListener mListener = null;


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView wNSubject, wNSolvePick, wNSolveDay, wrongCount, perfectCount;

        ViewHolder(View itemView){
            super(itemView);

            wNSubject = itemView.findViewById(R.id.wNSubject);
            wNSolvePick = itemView.findViewById(R.id.wNSolvePick);
            wNSolveDay = itemView.findViewById(R.id.wNSolveDay);
            wrongCount = itemView.findViewById(R.id.wrongCount);
            perfectCount = itemView.findViewById(R.id.perfectCount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        mListener.onItemClick(v, pos) ;
                    }
                }
            });

        }
    }

    WrongNoteAdapter(int[] wrongCount1, String Code[]){
        wrongCount = wrongCount1;
        code = Code;
    }

    @NonNull
    @Override
    public WrongNoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.wrongnote_item, parent, false);
        WrongNoteAdapter.ViewHolder vh = new WrongNoteAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String resultNum = Integer.toString(position+1) + ".";
        String subject;

        if(code[position].substring(14,15).equals("k")){subject = "국어";}
        else if(code[position].substring(14,15).equals("m")){subject = "수학";}
        else subject = "영어";

        holder.wNSubject.setText(subject);
        holder.wNSolvePick.setText("20" + code[position].substring(12,14) + "년 " + code[position].substring(15,16) + "월 모의고사");
        holder.wNSolveDay.setText(code[position].substring(0,2) + "." + code[position].substring(2,4) + "." + code[position].substring(4,6) + "풀이");
        holder.wrongCount.setText(Integer.toString(wrongCount[position]));
        holder.perfectCount.setText("0");
    }

    @Override
    public int getItemCount() {
        return wrongCount == null ? 0 : wrongCount.length;
    }

    public String returnCode(int position){return code[position];}
}



