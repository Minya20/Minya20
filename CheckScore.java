package com.example.project_01;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckScore extends AppCompatActivity {

    private LineChart gChart;
    private static String IP_ADDRESS = "172.16.61.95";
    private static String TAG = "php";


    private String mJsonString,mJsonString2;
    private ArrayList<PersonalData> mArrayList;
    private ScoreAdapter mAdapter;
    private RecyclerView mRecyclerView;
    TextView list_subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_score);

        gChart = (LineChart) findViewById(R.id.gChart);
        mRecyclerView = (RecyclerView) findViewById(R.id.listView_grade);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        list_subject = (TextView)findViewById(R.id.list_subject);


        mArrayList = new ArrayList<>();

        mAdapter = new ScoreAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        mArrayList.clear();
        mAdapter.notifyDataSetChanged();

        /*
        ArrayList<String> xAxislabels = new ArrayList<String>();
        xAxislabels.add("");  //첫자리 비우기
        xAxislabels.add("19년3월");
        xAxislabels.add("19년6월");
        xAxislabels.add("19년9월");
        xAxislabels.add("19년수능");
        xAxislabels.add("20년3월");
        xAxislabels.add(""); //끝자리 비우기

        ArrayList<String>yAxislabels = new ArrayList<String>();

        //차트에 표시할 데이터 추가
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1,74));
        entries.add(new Entry(2,60));
        entries.add(new Entry(3,80));
        entries.add(new Entry(4,90));
        entries.add(new Entry(5,83));


        LineDataSet lineDataSet = new LineDataSet(entries,"점수"); //속성
        lineDataSet.setLineWidth(1.5f);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleColor(Color.parseColor("#DE8A8A"));
        lineDataSet.setCircleHoleColor(Color.parseColor("#DE8A8A"));
        lineDataSet.setColor(Color.parseColor("#AD5656"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        gChart.setData(lineData);
        gChart.animateX(1500);
        gChart.getDescription().setEnabled(false);
        gChart.setDrawGridBackground(false);
        gChart.invalidate();

        XAxis xAxis = gChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxislabels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12);
        xAxis.setTextColor(Color.parseColor("#AD5656"));
        xAxis.setDrawGridLines(false);
        xAxis.setAxisLineWidth(1.5f);
        xAxis.setAxisLineColor(Color.parseColor("#EBB0B0"));
        xAxis.setLabelCount(7,true);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(6);
        xAxis.setTypeface(typeface);

        YAxis yLeftAxis = gChart.getAxisLeft();
        yLeftAxis.setDrawGridLines(true);
        yLeftAxis.setGridLineWidth(1);
        yLeftAxis.setGridColor(Color.parseColor("#AD5656"));
        yLeftAxis.setTextSize(18);
        yLeftAxis.setTextColor(Color.parseColor("#AD5656"));
        yLeftAxis.setAxisLineWidth(1.5f);
        yLeftAxis.setAxisLineColor(Color.parseColor("#EBB0B0"));
        yLeftAxis.setAxisMinimum(0);
        yLeftAxis.setAxisMaximum(100);
        yLeftAxis.setTypeface(typeface);

        YAxis yRightAxis = gChart.getAxisRight();
        yRightAxis.setDrawGridLines(false);
        yRightAxis.setAxisLineWidth(1.5f);
        yRightAxis.setAxisLineColor(Color.parseColor("#EBB0B0"));
        yRightAxis.setTextColor(Color.parseColor("#00ff0000"));



        //마커 등록
        marker marker = new marker(this,R.layout.marker);
        marker.setChartView(gChart);
        gChart.setMarker(marker);
        */


        GetData task = new GetData();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://"+IP_ADDRESS+"/grade.php","");
        GetData2 graph = new GetData2();
        graph.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://"+IP_ADDRESS+"/test.php","");



    }

    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(CheckScore.this,
                    "불러오는 중",null, true,true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

            Log.d(TAG, "response  - " + result);

            if (result == null){

            }
            else {

                mJsonString = result;
                showResult();
            }
        }

        @Override
        protected String doInBackground(String...params) {
            String serverURL = params[0];
            String postParameters = params[1];

            try{

                URL url= new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();

                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG,"response code - "+responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == httpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }else{
                    inputStream =httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                bufferedReader.close();

                return sb.toString().trim();

            }catch (Exception e) {
                Log.d(TAG,"GetData : error ", e);
                errorString = e.toString();

                return null;
            }
        }
    }

    private void showResult() {


        String TAG_JSON="webnautes";
        String TAG_year="rc_year";
        String TAG_subject="answer_answer_no";
        String TAG_score="rc_score";
        String TAG_id="user_user_id";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for (int i=0; i<jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);

                String subject = item.getString(TAG_subject);
                String score = item.getString(TAG_score);
                String year = item.getString(TAG_year);
                String id = item.getString(TAG_id);


                PersonalData personalData =new PersonalData();

                personalData.setGrade_year(year);
                personalData.setGrade_subject(subject);
                personalData.setGrade_score(score);
                personalData.setGrade_id(id);

                mArrayList.add(personalData);
                mAdapter.notifyDataSetChanged();

            }

        }catch (JSONException e) {
            Log.d(TAG,"showresult : ", e);
        }
    }
    private class GetData2 extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(CheckScore.this,
                    "불러오는 중",null, true,true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

            Log.d(TAG, "response  - " + result);

            if (result == null){

            }
            else {
                mJsonString2 = result;
                showResult2();
            }
        }

        @Override
        protected String doInBackground(String...params) {
            String serverURL = params[0];
            String postParameters = params[1];

            try{

                URL url= new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();

                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG,"response code - "+responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == httpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }else{
                    inputStream =httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                bufferedReader.close();

                return sb.toString().trim();

            }catch (Exception e) {
                Log.d(TAG,"GetData : error ", e);
                errorString = e.toString();

                return null;
            }
        }
    }

    private void showResult2() {


        String myId = "db658";
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/tmoneyroundwindextrabold.ttf");



        try {

            JSONObject jsonObject = new JSONObject(mJsonString2);

            boolean graph = jsonObject.getBoolean("good");

            if (graph) {
                int length = jsonObject.length();
                //String user_user_id = jsonObject.getString(String.valueOf(e));


                ArrayList<String> xAxislabels = new ArrayList<String>();
                xAxislabels.add("");  //첫자리 비우기
                xAxislabels.add("11월6일");
                xAxislabels.add("11월7일");
                xAxislabels.add("11월8일");
                xAxislabels.add("11월9일");
                xAxislabels.add("11월10일");
                xAxislabels.add(""); //끝자리 비우기
                    /* 이름 바꾸기
                    int x = 1;
                    xAxislabels.add("");  //첫자리 비우기
                for(int l=1; l <=9; l= l+2, x++) {
                    xAxislabels.add(jsonObject.getString(String.valueOf(l)));
                }
                    xAxislabels.add(""); //끝자리 비우기
                     */

                //차트에 표시할 데이터 추가, length 바꿀수있으면 바꾸기
                List<Entry> entries = new ArrayList<>();
                int d = 1;
                for (int y=0; y <=9; y= y+2,d++) {

                    entries.add(new Entry(d, Float.parseFloat(jsonObject.getString(String.valueOf(y)))));
                }


                LineDataSet lineDataSet = new LineDataSet(entries,"점수"); //속성
                lineDataSet.setLineWidth(1.5f);
                lineDataSet.setCircleRadius(6);
                lineDataSet.setCircleColor(Color.parseColor("#DE8A8A"));
                lineDataSet.setCircleHoleColor(Color.parseColor("#DE8A8A"));
                lineDataSet.setColor(Color.parseColor("#AD5656"));
                lineDataSet.setDrawCircleHole(true);
                lineDataSet.setDrawCircles(true);
                lineDataSet.setDrawHorizontalHighlightIndicator(false);
                lineDataSet.setDrawHighlightIndicators(false);
                lineDataSet.setDrawValues(false);

                LineData lineData = new LineData(lineDataSet);
                gChart.setData(lineData);
                gChart.animateX(1500);
                gChart.getDescription().setEnabled(false);
                gChart.setDrawGridBackground(false);
                gChart.invalidate();

                XAxis xAxis = gChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxislabels));
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setTextSize(12);
                xAxis.setTextColor(Color.parseColor("#AD5656"));
                xAxis.setDrawGridLines(false);
                xAxis.setAxisLineWidth(1.5f);
                xAxis.setAxisLineColor(Color.parseColor("#EBB0B0"));
                xAxis.setLabelCount(7,true);
                xAxis.setAxisMinimum(0);
                xAxis.setAxisMaximum(6);
                xAxis.setTypeface(typeface);

                YAxis yLeftAxis = gChart.getAxisLeft();
                yLeftAxis.setDrawGridLines(true);
                yLeftAxis.setGridLineWidth(1);
                yLeftAxis.setGridColor(Color.parseColor("#AD5656"));
                yLeftAxis.setTextSize(14);
                yLeftAxis.setTextColor(Color.parseColor("#AD5656"));
                yLeftAxis.setAxisLineWidth(1.5f);
                yLeftAxis.setAxisLineColor(Color.parseColor("#EBB0B0"));
                yLeftAxis.setAxisMinimum(0);
                yLeftAxis.setAxisMaximum(100);
                yLeftAxis.setTypeface(typeface);

                YAxis yRightAxis = gChart.getAxisRight();
                yRightAxis.setDrawGridLines(false);
                yRightAxis.setAxisLineWidth(1.5f);
                yRightAxis.setAxisLineColor(Color.parseColor("#EBB0B0"));
                yRightAxis.setTextColor(Color.parseColor("#00ff0000"));



                //마커 등록
                Marker marker = new Marker(this,R.layout.marker);
                marker.setChartView(gChart);
                gChart.setMarker(marker);


            }



        }catch (JSONException e) {
            Log.d(TAG,"showresult : ", e);
        }
    }

}