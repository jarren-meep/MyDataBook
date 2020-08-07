package com.myapplicationdev.android.mydatabook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutUsActivity extends AppCompatActivity {
ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


    }
}