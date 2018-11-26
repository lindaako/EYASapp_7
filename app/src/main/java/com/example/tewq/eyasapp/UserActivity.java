package com.example.tewq.eyasapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity
{

    Button bAssessmentmode,bTrainingmode,bResults,bLogout,bBack;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final LoginActivity.Singleton training = LoginActivity.Singleton.getInstance();

        bBack = findViewById(R.id.bBack);
        bTrainingmode = findViewById(R.id.bTrainingmode);
        bAssessmentmode = findViewById(R.id.bAssessmentmode);
        bLogout = findViewById(R.id.bLogout);
        bResults = findViewById(R.id.bResults);

        bBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(UserActivity.this, LoginActivity.class);
                UserActivity.this.startActivity(backIntent);
            }
        });

        bLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent logoutIntent = new Intent(UserActivity.this, LoginActivity.class);
                UserActivity.this.startActivity(logoutIntent);
            }
        });

        bTrainingmode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                training.setData(1);
                Intent trainingIntent = new Intent(UserActivity.this, TrainingModeActivity2.class);
                UserActivity.this.startActivity(trainingIntent);
            }
        });

        bAssessmentmode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                training.setData(0);
                Intent trainingIntent = new Intent(UserActivity.this, TrainingModeActivity2.class);
                UserActivity.this.startActivity(trainingIntent);
            }
        });

        bResults.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*
                Intent trainingIntent = new Intent(UserActivity.this, TrainingModeActivity2.class);
                UserActivity.this.startActivity(trainingIntent);
                */
            }
        });
    }



    public void clickexit(View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
