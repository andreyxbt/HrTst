package com.test.here.heretest.presentation.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.flixbus.flixbustest.R;

public class TimetableActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        final ViewPager viewPager = findViewById(R.id.timetable_viewpager);
        final TabLayout tabLayout = findViewById(R.id.timetable_tabs);
        final TimetableAdapter adapter = new TimetableAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
