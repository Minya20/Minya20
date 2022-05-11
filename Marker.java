package com.example.project_01;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class Marker extends MarkerView {

    private TextView mkContent;

    public Marker(Context context, int layoutResource) {
        super(context,layoutResource);

        mkContent = (TextView) findViewById(R.id.mkContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        if (e instanceof CandleEntry) {

            CandleEntry ce = (CandleEntry)e;
            mkContent.setText(Utils.formatNumber(ce.getHigh(), 0,true)+"점");
        } else {
            mkContent.setText(Utils.formatNumber(e.getY(),0,true)+"점");
        }

        super.refreshContent(e,highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
