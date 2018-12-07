package com.akina.clinicalstudies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RVAdapter.ItemClickListener {

    public static final String POSITION = "Position";
    static RVAdapter adapter;
    public static ArrayList<ActivityItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout scanQRBtn = findViewById(R.id.scan_qr_btn);
        scanQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTabView();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvElems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RVAdapter(this, itemList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void goToTabView()
    {
        Intent intent = new Intent(this, ActivityTabs.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {

        // Go to next activity depending on type
        Intent intent = new Intent(this, ActivityDetails.class);
        Bundle extras = new Bundle();

        extras.putInt(POSITION, position);
        intent.putExtras(extras);
        startActivity(intent);
    }

}
