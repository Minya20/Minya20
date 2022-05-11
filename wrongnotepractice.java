package com.example.project_01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.os.AsyncTask.THREAD_POOL_EXECUTOR;

public class wrongnotepractice extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private String jsonString;
    private String jsonString2;
    private String myId;
    TextView tvallnumber, tvrightnumber, tvwrongnumber, tvbookmark,tvsubject1,tvsubject2,tvsubject3;
    Button btncheckmyresults, btnbackmainpage, btnchecksubresults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrongnotepractice);

        Intent getintent = getIntent();
        myId = getintent.getStringExtra("nextUser");
        //Log.d("오답노트로 넘어온 아이디 값 : ",myId);

        tvallnumber = (TextView) findViewById(R.id.tvallnumber);
        tvrightnumber = (TextView) findViewById(R.id.tvrightnumber);
        tvwrongnumber = (TextView) findViewById(R.id.tvwrongnumber);
        tvbookmark = (TextView) findViewById(R.id.tvbookmark);
        btnbackmainpage = (Button) findViewById(R.id.btnbackmainpage);
        btnchecksubresults = (Button) findViewById(R.id.btnchecksubresults);

        btncheckmyresults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData task = new GetData();
                task.execute("http://"+IP_ADDRESS+"/mainpage/checkwrongNote.php" ,"");

            }
        });
        btnchecksubresults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checkintent = new Intent(getApplicationContext(),WrongNoteDetail.class);
                checkintent.putExtra("checkuser",myId);
                startActivity(checkintent);
            }
        });
        btnbackmainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(wrongnotepractice.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Log.d(TAG, "POST response  - " + result);
            if (result == null){

            }
            else {

                jsonString = result;
                showResult();

            }

        }


        @Override
        protected String doInBackground(String... params) {

            //String user_id = (String)params[1];
            //String user_pw = (String)params[2];
            String serverURL = params[0];
            String postParameters = params[1];

            //String serverURL = (String)params[0];
            //String postParameters = "user_id=" + user_id + "&user_pw=" + user_pw;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

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
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }
    class GetData2 extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(wrongnotepractice.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Log.d(TAG, "POST response  - " + result);
            if (result == null){

            }
            else {

                jsonString2 = result;
                showResult2();

            }

        }


        @Override
        protected String doInBackground(String... params) {

            //String user_id = (String)params[1];
            //String user_pw = (String)params[2];
            String serverURL = params[0];
            String postParameters = params[1];

            //String serverURL = (String)params[0];
            //String postParameters = "user_id=" + user_id + "&user_pw=" + user_pw;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

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
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }

    private void showResult(){


        try {
            Intent getintent = getIntent();
            myId = getintent.getStringExtra("nextUser");
            Log.d("오답노트로 넘어온 아이디 값 : ",myId);

            JSONObject jsonObject = new JSONObject(jsonString);
            Log.d("어레이",String.valueOf(jsonString));


            boolean id = jsonObject.getBoolean("suceess");
            if (id) {
                int length = jsonObject.length();
                for (int i=0; i<=length; i=i+6) {
                    String user_id =jsonObject.getString(String.valueOf(i+5));
                    //user_id 값을 jsonObject로 가져오는데 valueof 값이 i+5인 이유는 user_id값이 5번째에 있어서
                    Log.d("user_id로 가져온 값: ",user_id);
                    if (user_id.equals(myId)){
                        //JSON으로 가져온 값이랑 로그인한 아이디가 같으면 아래 코드를 수행한다.
                        String user_allnumber =jsonObject.getString(String.valueOf(i+1));
                        //모든 문제수 가져오기
                        String user_rightnumber =jsonObject.getString(String.valueOf(i+2));
                        String user_wrongnumber =jsonObject.getString(String.valueOf(i+3));
                        String user_bookmark =jsonObject.getString(String.valueOf(i+4));
                        tvallnumber.setText(user_allnumber);
                        tvrightnumber.setText(user_rightnumber);
                        tvwrongnumber.setText(user_wrongnumber);
                        tvbookmark.setText(user_bookmark);
                        break;

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"아이디 관련 오류",Toast.LENGTH_SHORT).show();
                    }

                }
            }
            else{
                Toast.makeText(getApplicationContext(),"인터넷 연결 확인좀",Toast.LENGTH_SHORT).show();

                return;
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }
    private void showResult2(){


        try {
            Intent getintent = getIntent();
            myId = getintent.getStringExtra("nextUser");
            Log.d("오답노트로 넘어온 아이디 값 : ",myId);

            JSONObject jsonObject2 = new JSONObject(jsonString2);
            Log.d("어레이",String.valueOf(jsonString2));


            boolean id = jsonObject2.getBoolean("suceess");
            if (id) {
                int length = jsonObject2.length();
                for (int i=0; i<=length; i=i+6) {
                    String user_id =jsonObject2.getString(String.valueOf(i+5));
                    //user_id 값을 jsonObject로 가져오는데 valueof 값이 i+5인 이유는 user_id값이 5번째에 있어서
                    Log.d("user_id로 가져온 값: ",user_id);
                    if (user_id.equals(myId)){
                        //JSON으로 가져온 값이랑 로그인한 아이디가 같으면 아래 코드를 수행한다.
                        String user_date =jsonObject2.getString(String.valueOf(i));
                        //데이트값 가져오기
                        String user_subject =jsonObject2.getString(String.valueOf(i+1));
                        //과목 값 가져오기
                        String user_allnum =jsonObject2.getString(String.valueOf(i+2));
                        //모든 문제수
                        String user_wrongnum =jsonObject2.getString(String.valueOf(i+3));
                        //틀린 문제수
                        String user_answer_answer_no =jsonObject2.getString(String.valueOf(i+4));
                        //과목번호
                        //tvsubject1.setText(user_date.substring(0,2) + "년");
                        //tvsubject2.setText(user_date.substring(2,2) + "월");
                        tvsubject3.setText(user_subject);
                        //tvbookmark.setText(user_wrongnum);
                        break;

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"아이디 관련 오류",Toast.LENGTH_SHORT).show();
                    }

                }
            }
            else{
                Toast.makeText(getApplicationContext(),"인터넷 연결 확인좀",Toast.LENGTH_SHORT).show();

                return;
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }
}
