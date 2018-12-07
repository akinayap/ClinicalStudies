package com.akina.clinicalstudies;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class  ActivityDetails extends AppCompatActivity {

    String datatype;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView progress_txt = findViewById(R.id.percentage);
        ProgressBar progress_bar = findViewById(R.id.progress_circle);
        progress_txt.setText(progress_bar.getProgress() + "%");

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

        Button help_btn = findViewById(R.id.help_btn);
        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_dialog);

                Button okButton = dialog.findViewById(R.id.ok_btn);
                // if button is clicked, close the custom dialog
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}
