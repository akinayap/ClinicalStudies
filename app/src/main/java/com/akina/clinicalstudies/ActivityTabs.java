package com.akina.clinicalstudies;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;

public class ActivityTabs extends AppCompatActivity {
    ConstraintLayout desc, eligibility, contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        desc = findViewById(R.id.desc_box);
        eligibility = findViewById(R.id.eligible_box);
        contact = findViewById(R.id.contact_box);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

                desc.setVisibility(View.INVISIBLE);
                eligibility.setVisibility(View.INVISIBLE);
                contact.setVisibility(View.INVISIBLE);

                switch (pos)
                {
                    case 0:
                        desc.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        eligibility.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        contact.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
}
