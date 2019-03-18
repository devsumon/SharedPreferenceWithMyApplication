package com.example.sharedpreferencewithmyapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText savenewusername, savenewpassword, savenewemail;
    private Button cancelbtn, savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        savenewusername = (TextInputEditText) findViewById(R.id.newusernameid);
        savenewpassword = (TextInputEditText) findViewById(R.id.newpasswordid);
        savenewemail = (TextInputEditText)findViewById(R.id.newemailid);

        cancelbtn =(Button)findViewById(R.id.btncancelid);
        savebtn =(Button)findViewById(R.id.btnsaveid);


        cancelbtn.setOnClickListener(this);
        savebtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnsaveid)
        {
            String newusername = savenewusername.getText().toString();
            String newpassword = savenewpassword.getText().toString();
            String newemail = savenewemail.getText().toString();

            if (newusername.equals("") && newpassword.equals("") && newemail.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please enter some data",Toast.LENGTH_SHORT).show();
            }else
            {
                //writing data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("usernameKey", newusername);
                editor.putString("passwordKey", newpassword);
                editor.putString("passwordKey", newemail);
                editor.commit();

                Toast.makeText(getApplicationContext(), "Data is store successfully",Toast.LENGTH_SHORT).show();
                savenewusername.setText("");
                savenewpassword.setText("");
                savenewemail.setText("");
            }



        }
        else if (v.getId()==R.id.btncancelid)
        {

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        }

    }









    }

