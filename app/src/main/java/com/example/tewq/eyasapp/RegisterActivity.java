package com.example.tewq.eyasapp;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
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

public class RegisterActivity extends AppCompatActivity {
    private static String S_URL ="https://youngashly.000webhostapp.com/signup.php";
    EditText etEmail,etUsername,etPassword;
    Button bRegister, bLogin;
    RadioButton radioButton2;private Snackbar snackbar;   private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pd = new ProgressDialog(RegisterActivity.this);
        bRegister =(Button)findViewById(R.id.bRegister);
        bLogin = (Button) findViewById(R.id.bLogin);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etUsername =(EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);

        bLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                                      Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                                      RegisterActivity.this.startActivity(loginIntent);
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton2.isChecked() == true){

                    signupRequest();

                }else{

                    Toast.makeText(getApplicationContext(),"Please Accept Terms & Services",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void signupRequest(){
        pd.setMessage("Signing Up . . .");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        String response = null;
        final String finalResponse = response;


        StringRequest postRequest = new StringRequest(Request.Method.POST, S_URL,
                new Response.Listener<String>()
                {

                    @Override
                    public void onResponse(String response) {
                        pd.hide();
                        //Response
                        showSnackbar(response);

                        if(response.equals("Successfully Signed In"))
                        {

                            startActivity(new Intent(getApplicationContext(), UserActivity.class));

                        }
                        else
                            {
                                Toast.makeText(getApplicationContext(),"here",Toast.LENGTH_SHORT).show();
                            }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("ErrorResponse", finalResponse);


                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();

                params.put("email", etEmail.getText().toString());
                params.put("password", etPassword.getText().toString());
                params.put("username", etUsername.getText().toString());

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



