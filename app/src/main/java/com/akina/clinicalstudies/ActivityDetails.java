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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class  ActivityDetails extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView progress_txt = findViewById(R.id.percentage);
        ProgressBar progress_bar = findViewById(R.id.progress_circle);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer pos = extras.getInt(MainActivity.POSITION);
        ActivityItem obj = MainActivity.itemList.get(pos);

        // Show all items
        progress_bar.setProgress(obj.m_progress);
        progress_txt.setText(progress_bar.getProgress() + "%");

        TextView startEnd = findViewById(R.id.start_end_date);
        DateFormat dateFormat = new SimpleDateFormat("d MMMM YYYY", Locale.ENGLISH);

        startEnd.setText("Started on " + dateFormat.format(obj.m_startTime.getTimeInMillis()) +
                        "\nEnd on " + dateFormat.format(obj.m_endTime.getTimeInMillis()));

        TextView title = findViewById(R.id.activity_title);
        title.setText(obj.m_title);

        TextView subtext = findViewById(R.id.subtext);
        subtext.setText(obj.m_subtext);




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
