package com.example.tewq.eyasapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

        Button bLogin, bRegister;
        EditText etUsername, etPassword;
        private static String URL  ="http://eyas.epizy.com/login.php";
        private Snackbar snackbar;
        private ProgressDialog pd;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            etUsername = (EditText) findViewById(R.id.etUsername);
            etPassword = (EditText) findViewById(R.id.etPassword);
            pd = new ProgressDialog(LoginActivity.this);
            bLogin = (Button) findViewById(R.id.bLogin);
            bRegister = (Button) findViewById(R.id.bRegister);

            bRegister.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {

                    Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    LoginActivity.this.startActivity(registerIntent);
                }
            });

            bLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginRequest();
                }
            });


        }

        private void loginRequest(){
            pd.setMessage("Signing In . . .");
            pd.show();
            RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
            String response = null;

            final String finalResponse = response;

            StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {

                            pd.hide();
                            showSnackbar(response);

                            if(response.equals("Login")) {

                                startActivity(new Intent(getApplicationContext(), UserActivity.class));
                            }


                        }

                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            pd.hide();
                            Log.d("ErrorResponse", finalResponse);

                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("username", etUsername.getText().toString());
                    params.put("password", etPassword.getText().toString());
                    return params;
                }
            };
            postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(postRequest);



        }
        public void showSnackbar(String stringSnackbar){
            snackbar.make(findViewById(android.R.id.content), stringSnackbar.toString(), Snackbar.LENGTH_SHORT)
                    .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                    .show();
        }


    public void clickexit(View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}