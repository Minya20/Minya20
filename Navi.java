package com.example.project_01;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Navi extends AppCompatActivity {
    private static String IP_ADDRESS = "172.16.61.94";
    private static String TAG = "phptest";
    private FirebaseAuth mAuth;
    TextView tvUser, tvNickname;
    ImageButton btnlogout,btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi);
        setTitle("나비");

        Intent intentG = getIntent();
        String Gnickname = intentG.getStringExtra("Gnickname");
        String email = intentG.getStringExtra("email");
        String photourl = intentG.getStringExtra("photourl");


        tvUser = (TextView) findViewById(R.id.tvUser);
        tvNickname = (TextView) findViewById(R.id.tvNickname);
        btnlogin = (ImageButton) findViewById(R.id.btnlogin);
        btnlogout = (ImageButton) findViewById(R.id.btnlogout);
        mAuth = FirebaseAuth.getInstance();

        tvUser.setText(email);
        tvNickname.setText(Gnickname);
        Glide.with(this).load(photourl).into(btnlogin);


        Intent intent = getIntent();
        String message =  intent.getStringExtra("id");
        String message2 = intent.getStringExtra("nickname");

        tvUser.setText(message);
        tvNickname.setText(message2);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvUser.setText("게스트");
                tvNickname.setText("게스트");
                FirebaseAuth.getInstance().signOut();
                mAuth.getCurrentUser().delete();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });

    }
}