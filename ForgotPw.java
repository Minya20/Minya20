package com.example.project_01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class ForgotPw extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private String user_email;
    private String user_id;
    private String jsonString;

    EditText forgotmyid, forgotmyemail;
    Button btnfindmypw;
    TextView tvresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_forgot_password);

        forgotmyid = (EditText) findViewById(R.id.forgotmyid);
        forgotmyemail = (EditText) findViewById(R.id.forgotmyemail);
        btnfindmypw = (Button) findViewById(R.id.btnfindmypw);
        tvresult = (TextView) findViewById(R.id.tvresult);

        ImageView toolBarMenu;
        toolBarMenu = findViewById(R.id.toolbar_menu);

        toolBarMenu.setVisibility(View.GONE);


        btnfindmypw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_email = forgotmyemail.getText().toString();
                GetData task = new GetData();
                task.execute("http://"+IP_ADDRESS+"/mainpage/findmyid.php" ,user_email);
            }
        });
    }
    class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ForgotPw.this,
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

            String user_email = (String)params[1];
            //String user_pw = (String)params[2];
            String serverURL = params[0];
            //String postParameters = params[1];

            //String serverURL = (String)params[0];
            String postParameters = "user_email=" + user_email;


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
            user_id = forgotmyid.getText().toString();
            user_email =  forgotmyemail.getText().toString();
            Log.d("id값",user_id);
            Log.d("email값",user_email);
            JSONObject jsonObject = new JSONObject(jsonString);
            Log.d("어레이",String.valueOf(jsonString));


            boolean id = jsonObject.getBoolean("success");
            if (id) {
                int length = jsonObject.length();
                for (int i=0; i<=length; i++) {
                    String user_emails =jsonObject.getString(String.valueOf(i+1));
                    String user_ids =jsonObject.getString(String.valueOf(i));
                    Log.d("user_emails 값",user_emails);
                    if (user_ids.equals(user_id)){
                        Log.d("아이디 값","일치함" );
                        if(user_emails.equals(user_email)){
                            Log.d("이메일 값","일치함" );
                            Toast.makeText(getApplicationContext(),"둘다 있음!!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ChangeMypw.class);
                            intent.putExtra("myid",user_ids);
                            startActivity(intent);
                            break;
                        }
                        else{
                            Log.d("이메일 값","불일치" );
                            Toast.makeText(getApplicationContext(),"존재하지 않는 이메일입니다.",Toast.LENGTH_SHORT).show();
                            tvresult.setText("이메일 불일치");
                            break;
                        }
                    }
                    else {
                        Log.d("아이디 값","불일치" );
                        Toast.makeText(getApplicationContext(),"존재하지 않는 아이디입니다.",Toast.LENGTH_SHORT).show();
                        tvresult.setText("아이디 불일치");
                        break;
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
