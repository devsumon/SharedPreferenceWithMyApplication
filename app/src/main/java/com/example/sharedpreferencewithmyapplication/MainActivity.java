package com.example.sharedpreferencewithmyapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences pref = this.getSharedPreferences("TestApp", Activity.MODE_PRIVATE);
        boolean isLogedIn = pref.getBoolean("IS_LOGED_IN", false);

      if (isLogedIn){
          Intent i = new Intent(MainActivity.this, HomeActivity.class);
          startActivity(i);
          finish();
      }else {
          Intent i = new Intent(MainActivity.this, SplashActivity.class);
          startActivity(i);
          finish();
      }



    }
}
