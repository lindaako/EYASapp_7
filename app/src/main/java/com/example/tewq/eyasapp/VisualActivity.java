package com.example.tewq.eyasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VisualActivity extends AppCompatActivity 
{

    Button bGameone,bGametwo,bBack;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual);

        bBack=findViewById(R.id.bBack);
        bGameone=findViewById(R.id.bGameone);
        bGametwo=findViewById(R.id.bGametwo);

        bBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(VisualActivity.this, TrainingModeActivity2.class);
                VisualActivity.this.startActivity(backIntent);
            }
        });

        bGameone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Go to first game
                /*Intent backIntent = new Intent(VisualActivity.this, UserActivity.class);
                VisualActivity.this.startActivity(backIntent);*/
            }
        });

        bGametwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Go to second game
                /*Intent backIntent = new Intent(VisualActivity.this, UserActivity.class);
                VisualActivity.this.startActivity(backIntent);*/
            }
        });
    }
}
