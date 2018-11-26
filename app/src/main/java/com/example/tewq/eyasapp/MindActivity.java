package com.example.tewq.eyasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MindActivity extends AppCompatActivity
{
    Button bGameone,bGametwo,bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind);

        bBack=findViewById(R.id.bBack);
        bGameone=findViewById(R.id.bGameone);
        bGametwo=findViewById(R.id.bGametwo);

        bBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(MindActivity.this, TrainingModeActivity2.class);
                MindActivity.this.startActivity(backIntent);
            }
        });

        bGameone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Go to first game
                /*Intent backIntent = new Intent(MindActivity.this, UserActivity.class);
                MindActivity.this.startActivity(backIntent);*/
            }
        });

        bGametwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Go to second game
                /*Intent backIntent = new Intent(MindActivity.this, UserActivity.class);
                MindActivity.this.startActivity(backIntent);*/
            }
        });
    }
}
