package com.example.android.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * In android side to maintain a user login session, here we are using SharedPreferenes.
 * Inside SharedPreferences we will store the data of currently logged in user. So that we can use it in our application.
 * So to handle all the sharedpreferences task at one place we are having this class
 */
//here for this class we are using a singleton pattern
//store usr data which we get from the database via php code
public class SharedPrefManger {

    //the constants
    private static SharedPrefManger mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref1";
    private static final String KEY_ID = "keyID";
    private static final String KEY_FIRST = "keyFIRST";
    private static final String KEY_LAST = "keyLAST";
    private static final String KEY_GENDER = "keyGender";
    private static final String KEY_AGE = "userAGE";
    private static final String KEY_PHONE = "userPHONE";
    private static final String KEY_ADDRESS = "userADDRESS";
    private static final String KEY_EMAIL = "userEmail";
    private static final String KEY_PASSWORD = "userPASSWORD";

    //the constructor
    private SharedPrefManger(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManger getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManger(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences

    public void userLogin(user user1) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID,user1.getId());
        editor.putString(KEY_FIRST, user1.getFirst());
        editor.putString(KEY_LAST, user1.getLast());
        editor.putString(KEY_GENDER, user1.getGender());
        editor.putInt(KEY_AGE,user1.getAge());
        editor.putInt(KEY_PHONE,user1.getPhone());
        editor.putString(KEY_ADDRESS, user1.getAddress());
        editor.putString(KEY_EMAIL, user1.getEmail());
        editor.putString(KEY_PASSWORD, user1.getPassword());
        editor.apply();
    }


    //check if user is log in
   public boolean IsLoggedIn(){
       SharedPreferences sharedPreferences =mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
       if(sharedPreferences.getString(KEY_EMAIL,null) !=null){
           return true;
       }
       return false;
   }

    //this method will give the logged in user
    public user getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new user(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_FIRST, null),
                sharedPreferences.getString(KEY_LAST, null),
                sharedPreferences.getString(KEY_GENDER, null),
                sharedPreferences.getInt(KEY_AGE, -1),
                sharedPreferences.getInt(KEY_PHONE, -1),
                sharedPreferences.getString(KEY_ADDRESS, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_PASSWORD, null)
        );
    }



    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, login.class));
    }


}

