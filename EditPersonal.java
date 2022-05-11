package com.example.project_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditPersonal extends AppCompatActivity {
    Button btnchangepw, btnchangeemail,btnchangenickname, btnback, btndropuser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editpersonal);
        btnchangeemail = (Button) findViewById(R.id.btnchangeemail);
        btnchangepw = (Button) findViewById(R.id.btnchangepw);
        btnback = (Button) findViewById(R.id.btnback);
        btndropuser = (Button) findViewById(R.id.btndropuser);
        btnback.setVisibility(View.INVISIBLE);
        btnchangenickname = (Button) findViewById(R.id.btnchangenickname);

        Intent intent = getIntent();
        String user = intent.getStringExtra("tvUser");
        String passw = intent.getStringExtra("tvPw");
        String nickname = intent.getStringExtra("name");
        Log.d("아이디 값",user);
        Log.d("비밀번호 값",passw);
        Log.d("닉네임 값",nickname);

        btnchangepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pwintent = new Intent(getApplicationContext(), ChangePw.class);
                pwintent.putExtra("mypw",passw);
                pwintent.putExtra("myuser",user);
                startActivity(pwintent);
                //비밀번호 변경하러 가기
            }
        });
        btnchangenickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nicknameintent = new Intent(getApplicationContext(), ChangeNickname.class);
                nicknameintent.putExtra("mypw",passw);
                nicknameintent.putExtra("myuser",user);
                nicknameintent.putExtra("mynickname",nickname);
                startActivity(nicknameintent);
                //닉네임 변경하러 가기
            }
        });

        btnchangeemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailintent = new Intent(getApplicationContext(), ChangeEmail.class);
                emailintent.putExtra("mypw",passw);
                emailintent.putExtra("myuser",user);
                startActivity(emailintent);
                //이메일 변경하러가기
            }
        });
        btndropuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dropintent = new Intent(getApplicationContext(), DropUser.class);
                dropintent.putExtra("mypw",passw);
                dropintent.putExtra("myuser",user);
                startActivity(dropintent);
                //이메일 변경하러가기
            }
        });

    }

}
