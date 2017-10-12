package com.example.android.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditAge extends AppCompatActivity implements View.OnClickListener{

    private Button buttonCancelUpdate , buttonUpdateAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_age);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonCancelUpdate = (Button)findViewById(R.id.buttonCancelUpdate);
        buttonUpdateAge=(Button)findViewById(R.id.buttonUpdateAge);
    }
    @Override
    public void onClick(View view)
    {
        if(view==buttonCancelUpdate)
            startActivity(new Intent(this,EditProfile.class));
        //if(view==buttonUpdateAge)
    }
}
