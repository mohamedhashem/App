package com.example.android.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogin ;
    private Button buttonReg;

    private EditText edittextEmail ;
    private EditText edittextPassword;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //To Display Back Arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        buttonLogin=(Button)findViewById(R.id.buttonLogin);
        buttonReg=(Button)findViewById(R.id.buttonReg);
        edittextPassword = (EditText)findViewById(R.id.edittextPassword);
        edittextEmail = (EditText)findViewById(R.id.edittextEmail);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait.....");

       // buttonLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        if(view==buttonReg)
            startActivity(new Intent(getApplicationContext(),Register.class));

    }

}

