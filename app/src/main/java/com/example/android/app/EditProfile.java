package com.example.android.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity implements View.OnClickListener{

    private TextView editFirst,editLast,editEmail,editPassword,editPhone,editAddress,editAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        editFirst= (TextView)findViewById(R.id.editfirstname);
        editLast= (TextView)findViewById(R.id.editlastname);
        editEmail= (TextView)findViewById(R.id.editEmail);
        editPassword= (TextView)findViewById(R.id.editPassword);
        editPhone= (TextView)findViewById(R.id.editPhone);
        editAddress= (TextView)findViewById(R.id.editAddress);
        editAge= (TextView)findViewById(R.id.editAge);


    }


    @Override
    public void onClick(View view)
    {
        if(view==editFirst)
            startActivity(new Intent(this,EditName.class));
        if(view==editLast)
            startActivity(new Intent(this,EditName.class));
        if(view==editEmail)
            startActivity(new Intent(this,EditEmail.class));
        if(view==editPassword)
            startActivity(new Intent(this,EditPassword.class));
        if(view==editPhone)
            startActivity(new Intent(this,EditPhone.class));
        if(view==editAddress)
            startActivity(new Intent(this,EditAddress.class));
        if(view==editAge)
            startActivity(new Intent(this,EditAge.class));
    }
}
