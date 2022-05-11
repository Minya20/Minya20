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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChangePw extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private String jsonString;

    EditText edtnextpw, edtrepeatpw;
    Button btnpwconfirm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepw);

        btnpwconfirm = (Button) findViewById(R.id.btnpwconfirm);
        edtnextpw = (EditText) findViewById(R.id.edtnextpw);
        edtrepeatpw = (EditText) findViewById(R.id.edtrepeatpw);


        btnpwconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String next = edtnextpw.getText().toString();
                String repeat = edtrepeatpw.getText().toString();
                Intent intent = getIntent();
                String user_pw = intent.getStringExtra("mypw");
                String user_id = intent.getStringExtra("myuser");

                if(next.equals(repeat)){
                    //새로운 비밀번호와 재입력 비밀번호가 일치한다면
                    InsertData task =new InsertData();
                    task.execute("http://"+IP_ADDRESS+"/mainpage/changepw.php" ,user_id,next);
                    Toast.makeText(getApplicationContext(),"비밀번호가 변경되었습니다.",Toast.LENGTH_SHORT).show();
                    Intent backintent = new Intent(getApplicationContext(),MainActivity.class);
                    //backintent.putExtra("changepw",next);
                    //backintent.putExtra("myuser",user_id);
                    startActivity(backintent);
                    //비밀번호 변경후 메인 페이지로 돌아간다
                }
                else {
                    Toast.makeText(getApplicationContext(),"바꿀 비밀번호가 서로 일치 하지 않습니다.",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ChangePw.this,
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

            }
        }


        @Override
        protected String doInBackground(String... params) {

            String user_id = (String)params[1];
            String next = (String)params[2];


            String serverURL = (String)params[0];
            String postParameters = "user_id=" + user_id + "&user_pw=" + next;


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
