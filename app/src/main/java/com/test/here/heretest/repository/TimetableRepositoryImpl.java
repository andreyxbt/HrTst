package com.test.here.heretest.repository;

import android.arch.paging.DataSource;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.flixbus.flixbustest.domain.TimetableRepository;
import com.flixbus.flixbustest.domain.entities.Arrival;
import com.flixbus.flixbustest.domain.entities.Departure;
import com.flixbus.flixbustest.repository.database.FlixbusDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

import static com.flixbus.flixbustest.repository.database.utils.ArrivalDBMatcher.toDbArrivals;
import static com.flixbus.flixbustest.repository.database.utils.DepartureDBMatcher.toDbDepartures;
import static com.flixbus.flixbustest.repository.database.utils.Downcaster.downcastFactory;

public class TimetableRepositoryImpl implements TimetableRepository {

    @NonNull
    private static final String TAG = "[TimetableRepository]";
    @NonNull
    private final RepositoriesGetaway repositoriesGetaway;
    @NonNull
    private final FlixbusDatabase flixbusDatabase;
    @NonNull
    private final CacheHelper cacheHelper;
    @Nullable
    private Completable timetableUpdate;

    public TimetableRepositoryImpl(@NonNull final RepositoriesGetaway repositoriesGetaway,
                                   @NonNull final FlixbusDatabase flixbusDatabase,
                                   @NonNull final CacheHelper cacheHelper) {
        this.repositoriesGetaway = repositoriesGetaway;
        this.flixbusDatabase = flixbusDatabase;
        this.cacheHelper = cacheHelper;
    }

    private void updateArrivals(@NonNull final List<? extends Arrival> arrivals) {
        flixbusDatabase.arrivalsDao().deleteAll();
        flixbusDatabase.arrivalsDao().insertAll(toDbArrivals(arrivals));
    }

    private void updateDepartures(@NonNull final List<? extends Departure> departures) {
        flixbusDatabase.departuresDao().deleteAll();
        flixbusDatabase.departuresDao().insertAll(toDbDepartures(departures));
    }

    @NonNull
    @Override
    public DataSource.Factory<Integer, Arrival> getArrivals() {
        return downcastFactory(flixbusDatabase.arrivalsDao().getAllDataSource());
    }

    @NonNull
    @Override
    public DataSource.Factory<Integer, Departure> getDepartures() {
        return downcastFactory(flixbusDatabase.departuresDao().getAllDataSource());
    }

    @NonNull
    public Completable updateTimetable() {
        if (timetableUpdate == null) {
            timetableUpdate = getTablesUpdate();
        }
        timetableUpdate
                .subscribeOn(Schedulers.io())
                .subscribe(
                        () -> {
                        },
                        throwable ->
                                Log.d(TAG, "Unable to update timetable. Error: " + throwable.toString(), throwable)
                );
        return timetableUpdate;
    }

    @Override
    public boolean isCacheValid(final long timeInMillis) {
        return cacheHelper.isCacheValid(timeInMillis);
    }

    @Override
    public long getLastUpdateTime() {
        return cacheHelper.getCacheTimestamp();
    }

    @NonNull
    private Completable getTablesUpdate() {
        return repositoriesGetaway.getTimetable()
                .flatMapCompletable(timetable -> {
                    TimetableRepositoryImpl.this.updateArrivals(timetable.arrivals);
                    TimetableRepositoryImpl.this.updateDepartures(timetable.departures);
                    cacheHelper.setCacheTimestamp(System.currentTimeMillis());
                    return Completable.complete();
                });
    }
}
