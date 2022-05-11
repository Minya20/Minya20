package com.example.project_01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class WrongNoteDetail extends AppCompatActivity {

    private static String IP_ADDRESS = "172.16.61.95";
    private static String TAG = "phptest";


    private ArrayList<WrongData> mArrayList;
    private WrongAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private String mJsonString;
    Button btnback, btnmain;
    private String myId;
    private String myNN;
    private String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrongnotedetail);
        mRecyclerView = (RecyclerView) findViewById(R.id.listView_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnback = (Button) findViewById(R.id.btnback);
        btnmain = (Button) findViewById(R.id.btnmain);
        Intent intent = getIntent();
        myId = intent.getStringExtra("checkuser");
        myNN = intent.getStringExtra("nextname");

        //mTextViewResult.setMovementMethod(new ScrollingMovementMethod());



        mArrayList = new ArrayList<>();

        mAdapter = new WrongAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        mArrayList.clear();
        mAdapter.notifyDataSetChanged();

        GetData task = new GetData();
        task.execute( "http://" + IP_ADDRESS + "/MWN.php","");
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("my_user",myId);
                intent.putExtra("wnName",myNN);
                startActivity(intent);
            }
        });
    }



    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(WrongNoteDetail.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "response - " + result);

            if (result == null){

            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String postParameters = params[1];


            try {

                URL url = new URL(serverURL);
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
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){

        String TAG_JSON="webnautes";
        String TAG_NO = "mwn_no";
        String TAG_SUBJECT = "mwn_subject";
        String TAG_ALLNUMBER = "mwn_allnum";
        String TAG_WRONGNUMBER = "mwn_wrongnum";
        String TAG_ANSWER_NO ="answer_answer_no";
        String TAG_ID ="user_user_id";


        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);


                String no = item.getString(TAG_NO);
                String allnum = item.getString(TAG_ALLNUMBER);
                String wrongnum = item.getString(TAG_WRONGNUMBER);
                String answer_no = item.getString(TAG_ANSWER_NO);
                String id = item.getString(TAG_ID);

                Intent intent = getIntent();
                String myid = intent.getStringExtra("checkuser");
                if (myid.equals(id)){

                WrongData wrongData = new WrongData();

                wrongData.setWrong_no(no);
                wrongData.setWrong_allnumber(allnum);
                wrongData.setWrong_wrongnumber(wrongnum);
                wrongData.setWrong_answer(answer_no);
                wrongData.setWrong_id(id);

                mArrayList.add(wrongData);
                mAdapter.notifyDataSetChanged();
                }
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}
