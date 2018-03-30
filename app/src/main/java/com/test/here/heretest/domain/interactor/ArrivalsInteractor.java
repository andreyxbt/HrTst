package com.test.here.heretest.domain.interactor;

import android.arch.paging.DataSource;
import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.TimetableRepository;
import com.flixbus.flixbustest.domain.entities.Arrival;

import io.reactivex.Completable;

public class ArrivalsInteractor {
    @NonNull
    private final TimetableRepository repository;

    public ArrivalsInteractor(@NonNull final TimetableRepository repository) {
        this.repository = repository;
    }

    @NonNull
    public DataSource.Factory<Integer, Arrival> getArrivals() {
        return repository.getArrivals();
    }

    @NonNull
    public Completable softUpdate() {
        if (repository.isCacheValid(System.currentTimeMillis())) {
            return Completable.complete();
        }
        return update();
    }

    @NonNull
    public Completable update() {
        return repository.updateTimetable();
    }

    public long getLastUpdateTime() {
        return repository.getLastUpdateTime();
    }
}
