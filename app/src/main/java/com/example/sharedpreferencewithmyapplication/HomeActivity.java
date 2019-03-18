package com.example.sharedpreferencewithmyapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


    private TextInputEditText saveusername, ssavepassword;
    private Button btnsignup, btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       saveusername = (TextInputEditText)findViewById(R.id.usernameid);
       ssavepassword = (TextInputEditText)findViewById(R.id.usernameid);

        btnsignup = (Button) findViewById(R.id.btnsignupid);
        btnsignin = (Button) findViewById(R.id.btnsigninid);


        btnsignup.setOnClickListener(this);
        btnsignin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnsigninid)
        {
            String username = saveusername.getText().toString();
            String password = ssavepassword.getText().toString();

            if (username.equals("") && password.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please enter some data",Toast.LENGTH_SHORT).show();
            }else
            {
                //writing data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("usernameKey", username);
                editor.putString("passwordKey", password);
                //String userpassDetails = sharedPreferences.getString(username + password + "data", "username password incorrect");


                editor.commit();
                //Toast.makeText(getApplicationContext(), "Data is store successfully",Toast.LENGTH_SHORT).show();

                Intent welcomeScreen = new Intent(HomeActivity.this, WelcomeActivity.class);
                startActivity(welcomeScreen);
            }



        }
        else if (v.getId()==R.id.btnsignupid)
        {

            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);

        }

    }




}
