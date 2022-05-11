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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private String ids;
    private String pws;
    private String jsonString;
    EditText idEdt, PassEdt;
    Button LoginBtn;
    TextView signInText, findIdPass;
    ImageView toolBarMenu;

    //Google 로그인
    private SignInButton btnGLogin;
    private GoogleApiClient googleApiClient;
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        idEdt = (EditText)findViewById(R.id.idEdt);
        PassEdt = (EditText)findViewById(R.id.passEdt);
        LoginBtn = (Button)findViewById(R.id.LoginBtn);
        signInText = (TextView) findViewById(R.id.signInText);
        findIdPass = (TextView) findViewById(R.id.findIdPass);

        toolBarMenu = findViewById(R.id.toolbar_menu);

        toolBarMenu.setVisibility(View.GONE);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        mAuth = FirebaseAuth.getInstance();

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData task = new GetData();
                task.execute("http://"+IP_ADDRESS+"/json/myjson.php" ,""/*user_id,user_pw*/);
            }
        });
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });
        findIdPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Forgotten.class);
                startActivity(intent);
            }
        });

        btnGLogin = findViewById(R.id.btnGLogin);
        btnGLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, RC_SIGN_IN);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                resultLogin(account);
            }
        }
    }

    private void resultLogin(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            Intent intentG = new Intent(getApplicationContext(),MainActivity.class);
                            intentG.putExtra("Gnickname",account.getDisplayName());
                            intentG.putExtra("email",account.getEmail());
                            intentG.putExtra("photourl",String.valueOf(account.getPhotoUrl()));
                            startActivity(intentG);
                        }else{
                            Toast.makeText(Login.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(Login.this,
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
            /*if (result2 == 1){
                    user_id = edtId.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),navi.class);
                    intent.putExtra("idname",user_id);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"실패",Toast.LENGTH_SHORT).show();
            }*/
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
            ids =  idEdt.getText().toString();
            pws =  PassEdt.getText().toString();
            Log.d("id값",ids);
            Log.d("pw값",pws);
            JSONObject jsonObject = new JSONObject(jsonString);
            Log.d("어레이",String.valueOf(jsonString));


            boolean id = jsonObject.getBoolean("suceess");
            if (id) {
                int length = jsonObject.length();
                for (int i=0; i<=length; i=i+4) {
                    String user_id =jsonObject.getString(String.valueOf(i));
                    String user_nickname =jsonObject.getString(String.valueOf(i+2));
                    Log.d("컬럼1",String.valueOf(jsonObject.length()));
                    Log.d("컬럼2", String.valueOf(i));
                    Log.d("user_id 값",user_id);
                    if (user_id.equals(ids)){
                        //tvResult.setText("일치");
                        Log.d("값","떴음" );
                        if (pws.equals(jsonObject.getString(String.valueOf(i+1)))){
                            Log.d("비번값","떴음12" );
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("id",user_id);
                            intent.putExtra("nickname",user_nickname);
                            startActivity(intent);
                            break;
                        }
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
