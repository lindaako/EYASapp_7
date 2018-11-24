package com.example.tewq.eyasapp;

import android.app.AlertDialog;
import android.net.Uri;
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


public class ForgotPasswordActivity extends AppCompatActivity
{
    LoginActivity.Singleton pass_reset=LoginActivity.Singleton.getInstance();
    final String passwordResetCodes = pass_reset.getCodeString();
    private static String URL ="http://eyas.dx.am/login.php";
    LoginActivity.Singleton e_mail=LoginActivity.Singleton.getInstance();
    final String user_email = e_mail.getString();
    EditText etEmail, etPassResetCode,etNewPassword;
    Button bResetPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etEmail =  findViewById(R.id.etEmail);
        etEmail.setText(user_email);

        etPassResetCode =  findViewById(R.id.etPassResetCode);
        etNewPassword =  findViewById(R.id.etNewPassword);
        bResetPassword = findViewById(R.id.bResetPassword);


        bResetPassword.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                String PRcode = etPassResetCode.getText().toString();
                String passwordResetCode = String.valueOf(passwordResetCodes);

        if ((passwordResetCode.equals(PRcode)))
        {
            Toast.makeText(getApplicationContext(), "The codes match!", Toast.LENGTH_SHORT).show();
        }

        else
            {
                Toast.makeText(getApplicationContext(), "The codes do not match,try again!", Toast.LENGTH_SHORT).show();
            }
            }

        });
    }








    }
