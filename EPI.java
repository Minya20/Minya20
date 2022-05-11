package com.example.project_01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class EPI extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    Button btncheckpw;
    EditText edtcheckpw;
    private String checkpw;
    private String jsonString;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epi);
        //이 자바파일은 "개인정보 수정" 버튼을 누르면 나오는 곳을 나타냄
        btncheckpw = (Button) findViewById(R.id.btncheckpw);
        edtcheckpw = (EditText) findViewById(R.id.edtcheckpw);

        Intent intent = getIntent();
        String thisnickname = intent.getStringExtra("nickname");
        String thisuser = intent.getStringExtra("tvUser");
        Log.d("EPI 닉네임",thisnickname);
        Log.d("EPI 유저",thisuser);




        btncheckpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkPw = edtcheckpw.getText().toString();

                GetData task = new GetData();
                task.execute("http://"+IP_ADDRESS+"/json/pwjson.php" ,""/*user_id,user_pw*/);
            }
        });


    }
    class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(EPI.this,
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

            String serverURL = params[0];
            String postParameters = params[1];




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
            checkpw =  edtcheckpw.getText().toString();
            Intent intent = getIntent();
            String user = intent.getStringExtra("tvUser");
            String name = intent.getStringExtra("nickname");
            //메인 액티비티에서 받아온 "tvUser"의 값을 받아옴
            JSONObject jsonObject = new JSONObject(jsonString);
            //postexecute로 얻어온 result값을 JSONObject로 받아옴
            Log.d("어레이",String.valueOf(jsonString));


            boolean id = jsonObject.getBoolean("suceess");
            //php sucess의 boolean 값을 id 변수에 집어넣는다
            if (id) {
                int length = jsonObject.length();
                for (int i=0; i<=length; i++) {
                    String user_pw =jsonObject.getString(String.valueOf(i));
                    //pw의 값 밸류를 user_pw에 for문으로 받는다
                    Log.d("컬럼1",String.valueOf(jsonObject.length()));
                    Log.d("컬럼2", String.valueOf(i));
                    Log.d("pw 값",user_pw);
                    if (user_pw.equals(checkpw))
                    //받아온 user_pw를 EditText로 받아온 checkpw로 비교한다.
                    {
                        Log.d("값","떴음" );
                        Intent nextintent =new Intent(getApplicationContext(), EditPersonal.class);
                        nextintent.putExtra("tvUser",user);
                        nextintent.putExtra("tvPw",user_pw);
                        nextintent.putExtra("name",name);
                        //메인 액티비티 에서 받아온 id 값이랑 user_pw 값을 다음 액티비티에 전달한다.
                        startActivity(nextintent);
                        break;


                    }

                    else {
                        Log.d("값","안뜸" );

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
