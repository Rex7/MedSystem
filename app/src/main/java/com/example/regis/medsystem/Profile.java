package com.example.regis.medsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Profile extends AppCompatActivity implements View.OnClickListener {
    TextView titleName, aboutMe, Art, Count;
    Button LogOut, edit;
    SessionManage sessionManage;
    HashMap<String, String> userData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String userName = getIntent().getExtras().get("userName").toString();


        sessionManage = new SessionManage(getApplicationContext());
        sessionManage.checkLogin();
        userData = sessionManage.getUserDetail();


        setContentView(R.layout.activity_profile);
        aboutMe = (TextView) findViewById(R.id.aboutMe);
        titleName = (TextView) findViewById(R.id.title_name);
        Art = (TextView) findViewById(R.id.art);
        Count = (TextView) findViewById(R.id.count);
        titleName.setText(userName);
        LogOut = (Button) findViewById(R.id.LogOut);
        edit = (Button) findViewById(R.id.editor);
        LogOut.setOnClickListener(this);
        edit.setOnClickListener(this);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/DancingScript-Regular.ttf");
        Art.setTypeface(typeface);
        Count.setTypeface(typeface);
        aboutMe.setTypeface(typeface);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LogOut:
                sessionManage.Logout();
                break;
            case R.id.editor:
                startActivity(new Intent(this, ArticleDemo.class));
                break;
        }

    }
}