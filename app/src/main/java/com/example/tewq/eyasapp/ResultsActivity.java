package com.example.tewq.eyasapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    Button bBack;
    TextView etAuditoryLevValueA, etAuditoryAccValueA, etAuditoryReaValueA, etVisualReaValueA, etVisualAccValueA, etVisuaLevValueA,
            etMindReaValueA, etMindAccValueA, etMindLevValueA;




    private AlertDialog.Builder exit_declaration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        final LoginActivity.Singleton A_leveldata=LoginActivity.Singleton.getInstance();
        final int ALevdata=A_leveldata.getData();
        final LoginActivity.Singleton A_accuracydata=LoginActivity.Singleton.getInstance();
        final int AAdata=A_accuracydata.getData();
        final LoginActivity.Singleton A_reactiontimedata=LoginActivity.Singleton.getInstance();
        final int ARTdata=A_reactiontimedata.getData();

        final LoginActivity.Singleton V_leveldata=LoginActivity.Singleton.getInstance();
        final int VLevdata=V_leveldata.getData();
        final LoginActivity.Singleton V_accuracydata=LoginActivity.Singleton.getInstance();
        final int VAdata=V_accuracydata.getData();
        final LoginActivity.Singleton V_reactiontimedata=LoginActivity.Singleton.getInstance();
        final int VRTdata=V_reactiontimedata.getData();

        final LoginActivity.Singleton M_leveldata=LoginActivity.Singleton.getInstance();
        final int MLevdata=M_leveldata.getData();
        final LoginActivity.Singleton M_accuracydata=LoginActivity.Singleton.getInstance();
        final int MAdata=M_accuracydata.getData();
        final LoginActivity.Singleton M_reactiontimedata=LoginActivity.Singleton.getInstance();
        final int MRTdata=M_reactiontimedata.getData();

        bBack = findViewById(R.id.bBack);

        etMindLevValueA = findViewById(R.id.etMindLevValueA);
        etMindAccValueA = findViewById(R.id.etMindAccValueA);
        etMindReaValueA = findViewById(R.id.etMindReaValueA);

        etVisuaLevValueA = findViewById(R.id.etVisuaLevValueA);
        etVisualAccValueA = findViewById(R.id.etVisualAccValueA);
        etVisualReaValueA = findViewById(R.id.etVisualReaValueA);

        etAuditoryLevValueA = findViewById(R.id.etAuditoryLevValueA);
        etAuditoryAccValueA = findViewById(R.id.etAuditoryAccValueA);
        etAuditoryReaValueA = findViewById(R.id.etAuditoryReaValueA);


        String mlevdata = String.valueOf(MLevdata);
        etMindLevValueA.setText(mlevdata);
        String madata = String.valueOf(MAdata);
        etMindAccValueA.setText(madata);
        String mrtdata = String.valueOf(MRTdata);
        etMindReaValueA .setText(mrtdata);

        String vlevdata = String.valueOf(VLevdata);
        etVisuaLevValueA.setText(vlevdata);
        String vadata = String.valueOf(VAdata);
        etVisualAccValueA.setText(vadata);
        String vrtdata = String.valueOf(VRTdata);
        etVisualReaValueA.setText(vrtdata);

        String alevdata = String.valueOf(ALevdata);
        etAuditoryLevValueA.setText(alevdata);
        String aadata = String.valueOf(AAdata);
        etAuditoryAccValueA.setText(aadata);
        String artdata = String.valueOf(ARTdata);
        etAuditoryLevValueA.setText(artdata);



        bBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(ResultsActivity.this, UserActivity.class);
                ResultsActivity.this.startActivity(backIntent);
            }
        });
    }

    public void clickexit(View v)
    {

        exit_declaration = new AlertDialog.Builder(ResultsActivity.this);
        exit_declaration.setMessage("종료 하시겠습니까?");
        exit_declaration.setPositiveButton("예", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int whichButton)
            {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });

        exit_declaration.setNegativeButton("아니", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton)
            {
                dialog.cancel();
            }
        });

        exit_declaration.show();


    }
}
