package com.example.project_01;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignIn extends AppCompatActivity {
    //컴퓨터의 IP 입력
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";

    private EditText edtId;
    private EditText edtPw;
    private EditText edtEmail;
    private EditText edtNickname;
    private EditText edtdoublepw;

    Button btnSignIn, LoginBtn;

    TextView tvcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        setTitle("st로그인");
        btnSignIn = (Button) findViewById(R.id.btnSignIn);    //가입하기 버튼
        LoginBtn = (Button) findViewById(R.id.LoginBtn);  //아이디 중복확인
        edtId = (EditText) findViewById(R.id.idEdt);            //아이디
        edtPw = (EditText) findViewById(R.id.passEdt);          //패스워드
        edtEmail = (EditText) findViewById(R.id.edtEmail);      //이메일
        edtNickname = (EditText) findViewById(R.id.edtNickName);      //닉네임
        edtdoublepw = (EditText) findViewById(R.id.passReEdt); //아이디 재확인
        tvcheck = (TextView) findViewById(R.id.tvcheck);    //유효성 검사 나올 내용

        ImageView toolBarMenu;
        toolBarMenu = findViewById(R.id.toolbar_menu);
        toolBarMenu.setVisibility(View.GONE);

        String user_id = edtId.getText().toString();
        String user_pw = edtPw.getText().toString();
        String user_email = edtEmail.getText().toString();
        String user_nickname = edtNickname.getText().toString();
        String user_pwc = edtdoublepw.getText().toString();    //비밀번호 다시 입력


        //회원가입 버튼
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_id = edtId.getText().toString();
                String user_pw = edtPw.getText().toString();
                String user_email = edtEmail.getText().toString();
                String user_nickname = edtNickname.getText().toString();
                String user_pwc = edtdoublepw.getText().toString();


                InsertData task = new InsertData();
                task.execute("http://" + IP_ADDRESS + "/mainpage/signUp.php", user_id,user_pw,user_email,user_nickname,user_pwc);


                edtId.setText("");
                edtPw.setText("");
                edtEmail.setText("");
                edtNickname.setText("");
                edtdoublepw.setText("");

            }
        });
        //아이디 중복확인 버튼
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_id = edtId.getText().toString();



                InsertData task = new InsertData();
                task.execute("http://" + IP_ADDRESS + "/mainpage/signUp.php", user_id,user_pw,user_email,user_nickname, user_pwc);


            }
        });
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SignIn.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            tvcheck.setText(result);
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String user_id = (String)params[1];
            String user_pw = (String)params[2];
            String user_email = (String)params[3];
            String user_nickname = (String)params[4];
            String user_pwc = (String)params[5];


            String serverURL = (String)params[0];
            String postParameters = "user_id=" + user_id + "&user_pw=" + user_pw + "&user_email=" + user_email + "&user_nickname=" +user_nickname + "&user_pwc=" + user_pwc;


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
