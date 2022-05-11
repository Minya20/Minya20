package com.example.project_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Forgotten extends AppCompatActivity {
    Button btnfindid, btnfindpass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotten);

        btnfindid = (Button) findViewById(R.id.btnfindid);
        btnfindpass = (Button) findViewById(R.id.btnfindpass);
        ImageView toolBarMenu;
        toolBarMenu = findViewById(R.id.toolbar_menu);
        toolBarMenu.setVisibility(View.GONE);

        btnfindid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotId.class);
                startActivity(intent);
            }
        });
        btnfindpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPw.class);
                startActivity(intent);
            }
        });
    }
}
