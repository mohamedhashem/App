package com.example.android.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AltraBottom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altra_bottom);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
