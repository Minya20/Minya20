package com.example.project_01;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "MainActivity";
    ViewFlipper viewMain;
    TextView tvUser, tvUser2, tvNickname, tvNickname2;
    ImageButton basicSolveBtn, studygroupBtn, scoreBtn, btnNextWrong;
    public static Context mContext;
    final View[] dialogView = {null, null, null};
    View nameCard, btnPrivate,btnlogout;
    ImageView btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        basicSolveBtn = (ImageButton) findViewById(R.id.basicBtn);
        viewMain = (ViewFlipper) findViewById(R.id.viewMain);
        btnlogout = findViewById(R.id.btnlogout);
        btnPrivate = findViewById(R.id.btnprivate);
        btnNextWrong = (ImageButton) findViewById(R.id.btnWrongNote);
        tvUser = (TextView) findViewById(R.id.tvUser);
        tvUser2 = (TextView) findViewById(R.id.tvUser);
        tvNickname = (TextView) findViewById(R.id.tvNickname);
        tvNickname2 = (TextView) findViewById(R.id.tvNickname);
        nameCard = (RelativeLayout) findViewById(R.id.namecard);
        btnlogin = findViewById(R.id.btnlogin);




        tvUser.setText("Guest");
        tvNickname.setText("????????? ????????????");

        Intent intent =getIntent();
        String message =  intent.getStringExtra("id");
        String message2 = intent.getStringExtra("nickname");
        String message3 = intent.getStringExtra("my_user");
        String message4 = intent.getStringExtra("wnName");

        Intent intentG = getIntent();
        String Gnickname = intentG.getStringExtra("Gnickname");
        String email = intentG.getStringExtra("email");
        String photourl = intentG.getStringExtra("photourl");

        if(message == null && message3 ==null && Gnickname ==null){
            tvUser.setText("Guest");
            tvNickname.setText("????????? ????????????");
        }
        else if(message3 != null){
            tvUser.setText(message3);
            tvNickname.setText(message4);
        }
        else if(Gnickname != null) {
            tvUser.setText(email);
            tvNickname.setText(Gnickname);
            Glide.with(this).load(photourl).into(btnlogin);
        }
        else{
            tvUser.setText(message);
            tvNickname.setText(message2);
        }

        //studygroup??? ?????? ????????? ????????? ????????? ????????? ?????? ???????????? ??????
        studygroupBtn = (ImageButton) findViewById(R.id.studygroupBtn);
        scoreBtn = (ImageButton) findViewById(R.id.scoreBtn);

        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Cintent = new Intent(getApplicationContext(),CheckScore.class);
                startActivity(Cintent);
            }
        });

        nameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        studygroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnPrivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EPI.class);
                intent.putExtra("tvUser",message);
                intent.putExtra("nickname",message2);
                startActivity(intent);
            }
        });
        btnNextWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WrongNote.class);
                startActivity(intent);
            }
        });

        //???????????? ??????
        //TODO : ????????? putExtra.
        basicSolveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SolveList.class);

                //alertdialog ?????? 0: ?????? 1: ?????? ???????????? 2: ?????? ????????????
                        dialogView[0] = (View)View.inflate(MainActivity.this, R.layout.select_exam_dialog_subject, null);
                        dialogView[1] = (View)View.inflate(MainActivity.this, R.layout.select_exam_dialog_korean, null);
                        dialogView[2] = (View)View.inflate(MainActivity.this, R.layout.select_exam_dialog_math, null);

                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setView(dialogView[0]);

                        final AlertDialog alertDialog = dlg.create();
                        alertDialog.show();

                        //?????? ???????????? ?????? ??????
                        Button btnSelectKor = alertDialog.findViewById(R.id.btnSelectKor);
                        Button btnSelectMath = alertDialog.findViewById(R.id.btnSelectMath);
                        Button btnSelectEng = alertDialog.findViewById(R.id.btnSelectEng);

                        //?????? ?????? - dissmiss?????? ?????? ?????????
                        btnSelectKor.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent.putExtra("subject", "k");
                                alertDialog.dismiss();
                                dlg.setView(dialogView[1]);

                                final AlertDialog alertDialog1 = dlg.create();
                                alertDialog1.show();

                                Button btnSelectSpeech = alertDialog1.findViewById(R.id.btnSelectSpeech);
                                Button btnSelectLan = alertDialog1.findViewById(R.id.btnSelectLan);

                                btnSelectSpeech.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        intent.putExtra("selSub", 1);
                                        startActivity(intent);
                                    }
                                });

                                btnSelectLan.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        intent.putExtra("selSub", 2);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });

                         //?????? ?????? - dissmiss?????? ?????? ?????????
                        btnSelectMath.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent.putExtra("subject", "m");
                                alertDialog.dismiss();
                                dlg.setView(dialogView[2]);

                                final AlertDialog alertDialog1 = dlg.create();
                                alertDialog1.show();

                                Button btnSelectCal = alertDialog1.findViewById(R.id.btnSelectCal);
                                Button btnSelectPER = alertDialog1.findViewById(R.id.btnSelectPER);
                                Button btnSelectGIHAHAK = alertDialog1.findViewById(R.id.btnSelectGIHAHAK);

                                //1: ????????? 2: ????????? ?????? 3: ?????????
                                btnSelectCal.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        intent.putExtra("selSub", 1);
                                        startActivity(intent);
                                    }
                                });

                                btnSelectPER.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        intent.putExtra("selSub", 2);
                                        startActivity(intent);
                                    }
                                });

                                btnSelectGIHAHAK.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        intent.putExtra("selSub", 3);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });

                        btnSelectEng.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent.putExtra("subject", "e");
                                intent.putExtra("selSub", 0);
                                startActivity(intent);
                            }
                        });

                        alertDialog.show();

            }
        });

        viewMain.setInAnimation(showIn);
        viewMain.setOutAnimation(this, android.R.anim.slide_out_right);

        viewMain.setFlipInterval(2000);
        viewMain.startFlipping();
        toolbarDrawerSetting();
    }

    public void toolbarDrawerSetting(){
        DrawerLayout draw;
        View drawerView;
        ImageView toolbar_menu;
        RelativeLayout namecard;

        DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) { }
            @Override
            public void onDrawerOpened(@NonNull View drawerView) { }
            @Override
            public void onDrawerClosed(@NonNull View drawerView) { }
            @Override
            public void onDrawerStateChanged(int newState) { }
        };
        draw = (DrawerLayout) findViewById(R.id.draw);
        drawerView=(View) findViewById(R.id.drawerView);
        draw.setDrawerListener(listener);
        toolbar_menu = (ImageView) findViewById(R.id.toolbar_menu);
        namecard = (RelativeLayout) findViewById(R.id.namecard);


        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw.openDrawer(GravityCompat.START);
            }
        });

        namecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplication(), Login.class);
                startActivity(loginIntent);
            }
        });

        Log.d(TAG, "????????? ???????????????");
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("?????????????????? ??????").setMessage("?????????????????? ?????????????????????????");

        builder.setPositiveButton("??????", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                exitProgram();
            }
        });

        builder.setNegativeButton("????????????.", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                return;
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    private void exitProgram() {
        // ???????????? ?????????????????? ??????
        moveTaskToBack(true);

        //???????????? ??????
        if (Build.VERSION.SDK_INT >= 21) {
            // ???????????? ?????? + ????????? ??????????????? ?????????
            finishAndRemoveTask();
        } else {
            // ???????????? ??????
            finish();
        }
        System.exit(0);
    }

}