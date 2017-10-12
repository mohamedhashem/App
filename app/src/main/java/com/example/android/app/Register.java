package com.example.android.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button buttonRegNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonRegNext =(Button) findViewById(R.id.buttonRegNext);
    }

    @Override
    public void onClick(View view)
    {
        if (view==buttonRegNext)
        {
            startActivity(new Intent(this,CreateAccount.class));
        }

    }
}

