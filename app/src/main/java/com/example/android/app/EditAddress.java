package com.example.android.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditAddress extends AppCompatActivity implements View.OnClickListener {

    private Button buttonCancelUpdate , buttonUpdateAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonCancelUpdate = (Button)findViewById(R.id.buttonCancelUpdate);
        buttonUpdateAddress=(Button)findViewById(R.id.buttonUpdateAddress);
    }

    @Override
    public void onClick(View view)
    {
        if(view==buttonCancelUpdate)
            startActivity(new Intent(this,EditProfile.class));
        //if(view==buttonUpdateAddress)
    }
}
