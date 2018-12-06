package com.akina.clinicalstudies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public enum Datatype {
        FOODREC,
        BLOODGLUCOSE,
        PAIN
    }

    public static final String DATA_TYPE = "NONE";

    RelativeLayout frBtn, bgBtn, pBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frBtn = findViewById(R.id.food_rec_btn);
        bgBtn = findViewById(R.id.blood_glucose_btn);
        pBtn = findViewById(R.id.pain_btn);

        frBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData(Datatype.FOODREC);
            }
        });

        bgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData(Datatype.BLOODGLUCOSE);
            }
        });

        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData(Datatype.PAIN);
            }
        });
    }

    public void showData(Datatype type)
    {
        Intent intent = new Intent(this, ActivityDetails.class);

        Bundle extras = new Bundle();
        extras.putString(DATA_TYPE, type.name());
        Log.e("type", type.name());
        intent.putExtras(extras);
        startActivity(intent);
    }
}
