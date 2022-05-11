package com.example.project_01;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SolveListAdapter extends RecyclerView.Adapter<SolveListAdapter.ViewHolder> {
    private static final String TAG = "SolveListAdapter";
    private ArrayList<String> solveDay = null;
    private ArrayList<String> solveGroup = null;
    public static String item;

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView testDay = null, testGroupDay = null;
        LinearLayout solveList;

    ViewHolder(View itemView){
        super(itemView);

        testDay = (TextView) itemView.findViewById(R.id.testDay);
        testGroupDay = (TextView) itemView.findViewById(R.id.testGroupDay);
        solveList = (LinearLayout) itemView.findViewById(R.id.solveList);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                if(pos != RecyclerView.NO_POSITION){
                    item = solveDay.get(pos);
                    mListener.onItemClick(v, pos) ;
                }
            }
        });
    }
}

    SolveListAdapter(ArrayList<String> testDay, ArrayList<String> testGroupDay){
        solveDay = testDay;
        solveGroup = testGroupDay;
    }//데이터 리스트 객체 전달

    @NonNull
    @Override
    public SolveListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.solvelist_item, parent, false);
        SolveListAdapter.ViewHolder vh = new SolveListAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SolveListAdapter.ViewHolder holder, int position) {
        String text1 = solveDay.get(position);
        String text2 = solveGroup.get(position);

        if(text2.length() > 49){
            holder.solveList.setBackgroundColor(Color.parseColor("#FCDDDD"));
            Log.d(TAG, String.valueOf(text2.length()));
        }

        holder.testDay.setText(text1);
        holder.testGroupDay.setText(text2);
    }

    @Override
    public int getItemCount() {
        return solveDay.size();
    }
}
