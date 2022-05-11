package com.example.project_01;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.CustomViewHolder> {

    private ArrayList<PersonalData> mList = null;
    private Activity context = null;

    public ScoreAdapter(Activity context, ArrayList<PersonalData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView subject;
        protected TextView year;
        protected TextView score;
        protected TextView id;

        public CustomViewHolder(View view) {
            super(view);
            this.subject = (TextView) view.findViewById(R.id.list_subject);
            this.year = (TextView) view.findViewById(R.id.list_year);
            this.score = (TextView) view.findViewById(R.id.list_score);
            this.id = (TextView) view.findViewById(R.id.list_id);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grade_item,
                null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int position) {

        viewHolder.subject.setText(mList.get(position).getGrade_subject());
        viewHolder.year.setText(mList.get(position).getGrade_year() + " 풀이");
        viewHolder.score.setText(mList.get(position).getGrade_score() + "점");
        viewHolder.id.setText(mList.get(position).getGrade_id());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
