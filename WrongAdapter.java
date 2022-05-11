package com.example.project_01;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class WrongAdapter extends RecyclerView.Adapter<WrongAdapter.CustomViewHolder> {

    private ArrayList<WrongData> mList = null;
    private Activity context = null;





    public WrongAdapter(Activity context, ArrayList<WrongData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView mwn_no;
        protected TextView mwn_allnumber;
        protected TextView mwn_wrong_wrongnumber;
        protected TextView mwn_answer;
        protected TextView list_id;



        public CustomViewHolder(View view) {
            super(view);
            this.mwn_no = (TextView) view.findViewById(R.id.textView_list_no);
            this.mwn_allnumber = (TextView) view.findViewById(R.id.textView_list_allnumber);
            this.mwn_wrong_wrongnumber = (TextView) view.findViewById(R.id.textview_wrong_rightnumber);
            this.mwn_answer = (TextView) view.findViewById(R.id.textview_bookmark_id);
            this.list_id = (TextView) view.findViewById(R.id.list_id);


        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wrongitem_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.mwn_no.setText("푼 날짜 : " + mList.get(position).getWrong_no().substring(0,2) + "년"
                + mList.get(position).getWrong_no().substring(2,4) + "월"
                + mList.get(position).getWrong_no().substring(4,6) + "일");
        viewholder.mwn_allnumber.setText(mList.get(position).getWrong_allnumber() + "개");
        viewholder.mwn_wrong_wrongnumber.setText(mList.get(position).getWrong_wrongnumber());
        viewholder.mwn_answer.setText(mList.get(position).getWrong_answer());
        viewholder.list_id.setText("사용자 : " + mList.get(position).getWrong_id());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}