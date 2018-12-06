package com.akina.clinicalstudies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDetails extends AppCompatActivity {

    String datatype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        TextView title = findViewById(R.id.add_title);
        datatype = extras.getString(MainActivity.DATA_TYPE);
        switch (datatype)
        {
            case "FOODREC":
                title.setText("Food Recommendation");
                break;
            case "BLOODGLUCOSE":
                title.setText("Blood Glucose");
                break;
            case "PAIN":
                title.setText("Pain");
                break;
        }

        Button back = findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityDetails.super.finish();
            }
        });
    }
}
