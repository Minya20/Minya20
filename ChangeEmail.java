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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChangeEmail extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private String jsonString;
    private String user_id;
    private String user_email;
    EditText edtchangeemail;
    Button btncheckemail;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeemail);

        btncheckemail = (Button) findViewById(R.id.btncheckemail);
        edtchangeemail = (EditText)findViewById(R.id.edtchangeemail);
        Intent getintent = getIntent();
        user_id = getintent.getStringExtra("myuser");

        btncheckemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_email = edtchangeemail.getText().toString();
                InsertData task = new InsertData();
                task.execute("http://"+IP_ADDRESS+"/mainpage/changeemail.php" ,user_id,user_email);
                Toast.makeText(getApplicationContext(),"이메일이 변경되었습니다.",Toast.LENGTH_SHORT).show();
                Intent mainintent = new Intent(getApplicationContext(),Login.class);
                startActivity(mainintent);
            }
        });
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ChangeEmail.this,
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
            String user_email = (String)params[2];


            String serverURL = (String)params[0];
            String postParameters = "user_id=" + user_id + "&user_email=" + user_email;


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
