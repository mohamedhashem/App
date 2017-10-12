package com.example.android.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends AppCompatActivity implements View.OnClickListener {

    private Button buttonEditProfile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonEditProfile = (Button)findViewById(R.id.buttonEditProfile);
    }

    @Override
    public void onClick(View view)
    {
        if(view==buttonEditProfile)
            startActivity(new Intent(this,EditProfile.class));
    }
}
