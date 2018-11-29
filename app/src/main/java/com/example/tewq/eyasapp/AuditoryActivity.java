package com.example.tewq.eyasapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuditoryActivity extends AppCompatActivity 
{

    Button bGameone,bGametwo,bBack;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditory);

        bBack=findViewById(R.id.bBack);
        bGameone=findViewById(R.id.bGameone);
        bGametwo=findViewById(R.id.bGametwo);

        bBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(AuditoryActivity.this, TrainingModeActivity2.class);
                AuditoryActivity.this.startActivity(backIntent);
            }
        });

        bGameone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Go to first game
                Intent intent1 = new Intent(AuditoryActivity.this, Audio_1.class);
                AuditoryActivity.this.startActivity(intent1);
            }
        });

        bGametwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Go to second game
                Intent intent2 = new Intent(AuditoryActivity.this, Audio_2.class);
                AuditoryActivity.this.startActivity(intent2);
            }
        });
    }
}
