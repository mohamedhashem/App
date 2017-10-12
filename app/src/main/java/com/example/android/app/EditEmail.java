package com.example.android.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditEmail extends AppCompatActivity implements View.OnClickListener{
    private Button buttonCancelUpdate , buttonUpdateEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonCancelUpdate = (Button)findViewById(R.id.buttonCancelUpdate);
        buttonUpdateEmail=(Button)findViewById(R.id.buttonUpdateEmail);
    }
    @Override
    public void onClick(View view)
    {
        if(view==buttonCancelUpdate)
            startActivity(new Intent(this,EditProfile.class));
        //if(view==buttonUpdateEmail)
    }
}
