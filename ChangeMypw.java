package com.example.project_01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChangeMypw extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private String user_pw;
    private String user_id;
    private String checkpw;

    EditText newmypw, checkmypw;
    Button btnchangemypw;
    TextView tvresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changemypw);

        newmypw = (EditText) findViewById(R.id.newmypw);
        checkmypw = (EditText) findViewById(R.id.checkmypw);
        btnchangemypw = (Button) findViewById(R.id.btnchangemypw);
        tvresult = (TextView) findViewById(R.id.tvresult);


        btnchangemypw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_pw = newmypw.getText().toString();
                checkpw = checkmypw.getText().toString();
                if(user_pw.equals(checkpw)){
                    Intent getintent = getIntent();
                    user_id = getintent.getStringExtra("myid");
                    Log.d("넘어온 아이디 값",user_id);
                    GetData task = new GetData();
                    task.execute("http://"+IP_ADDRESS+"/mainpage/changemyforgotpw.php" ,user_id,user_pw);
                    tvresult.setText("비밀번호가 변경되었습니다.");
                    Intent backintent = new Intent(getApplicationContext(),Login.class);
                    startActivity(backintent);
                }
            }
        });
    }
    class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ChangeMypw.this,
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

                //jsonString = result;
                //showResult();

            }
        }


        @Override
        protected String doInBackground(String... params) {

            String user_id = (String)params[1];
            String user_pw = (String)params[2];
            String serverURL = params[0];
            //String postParameters = params[1];

            //String serverURL = (String)params[0];
            String postParameters = "user_id=" + user_id + "&user_pw=" + user_pw;


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
}
