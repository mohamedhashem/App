package com.example.android.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{

    //Define view objects

    private EditText editTextFirstName, editTextAge,editTextPhone,editTextAddress,editTextEmail, editTextPassword,editTextLastName;
    private Button buttonConfirm;
    RadioGroup RadioGroupGender;

    private ProgressDialog progressDialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //if the user is already logged in we will directly start the profile activity
        if (SharedPrefManger.getInstance(this).IsLoggedIn()) {
            finish();
            startActivity(new Intent(this, Profile.class));
            return;
        }

        //get views from xml


        progressDialog = new ProgressDialog(this);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        RadioGroupGender = (RadioGroup) findViewById(R.id.RadioGroupGender);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonConfirm=(Button)findViewById(R.id.buttonConfirm);




        }

    private void registerUser() {
        final String firstName = editTextFirstName.getText().toString().trim();
        final String lastName = editTextLastName.getText().toString().trim();
        final String gender = ((RadioButton) findViewById(RadioGroupGender.getCheckedRadioButtonId())).getText().toString();
        final String age = editTextAge.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String address = editTextAddress.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();


        //check validations
        if (TextUtils.isEmpty(firstName)) {
            editTextFirstName.setError("Enter your first name");
            editTextFirstName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            editTextLastName.setError("Enter your last name");
            editTextLastName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(age)) {
            editTextAge.setError("Enter your age");
            editTextAge.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            editTextPhone.setError("Enter your phone");
            editTextPhone.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            editTextAddress.setError("Enter your address");
            editTextAddress.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter password");
            editTextPassword.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        //  progressDialog.dismiss();

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);


                            //if no error in response
                            if (!obj.getBoolean("error")) {


                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");



                                //creating a new user object
                                user user1 = new user(
                                        userJson.getInt("id"),
                                        userJson.getString("first"),
                                        userJson.getString("last"),
                                        userJson.getString("gender"),
                                        userJson.getInt("age"),
                                        userJson.getInt("phone"),
                                        userJson.getString("address"),
                                        userJson.getString("email"),
                                        userJson.getString("password")

                                );

                                //storing the user in shared preferences
                                SharedPrefManger.getInstance(getApplicationContext()).userLogin(user1);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(),Profile.class));
                            } else {

                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("first",firstName);
                params.put("last", lastName);
                params.put("gender", gender);
                params.put("age", age);
                params.put("phone", phone);
                params.put("address", address);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    @Override
    public void onClick(View view) {
        //if user pressed on button register
        //here we will register the user to server
        if (view==buttonConfirm)
            registerUser();
    }

    }





