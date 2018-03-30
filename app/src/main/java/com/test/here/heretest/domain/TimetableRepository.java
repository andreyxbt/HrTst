package com.test.here.heretest.domain;

import android.arch.paging.DataSource;
import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Arrival;
import com.flixbus.flixbustest.domain.entities.Departure;

import io.reactivex.Completable;

public interface TimetableRepository {

    @NonNull
    DataSource.Factory<Integer, Arrival> getArrivals();

    @NonNull
    DataSource.Factory<Integer, Departure> getDepartures();

    @NonNull
    Completable updateTimetable();

    boolean isCacheValid(final long timeInMillis);

    long getLastUpdateTime();
}
