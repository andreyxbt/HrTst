package com.test.here.heretest.presentation.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.flixbus.flixbustest.R;

class TimetableAdapter extends FragmentPagerAdapter {

    @NonNull
    private final Context context;

    public TimetableAdapter(@NonNull final Context context, @NonNull final FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(final int position) {
        return position == 0 ? new ArrivalsFragment() : new DeparturesFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return position == 0
                ? context.getString(R.string.page_title_arrivals)
                : context.getString(R.string.page_title_departures);
    }
}
