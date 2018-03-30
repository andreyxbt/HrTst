package com.test.here.heretest.repository.network;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.repository.TimetableGetaway;
import com.flixbus.flixbustest.repository.network.api.TimetablesApi;
import com.flixbus.flixbustest.repository.network.transport.TimetableApiEntity;
import com.test.here.heretest.domain.entities.Repository;
import com.test.here.heretest.repository.network.api.RepositoriesApi;
import com.test.here.heretest.repository.network.transport.RepositoryApiEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class RetrofitRepositoriesGetaway implements RepositoriesGetaway {

    @NonNull
    private final RepositoriesApi api;
    @NonNull
    private final String authToken;

    public RetrofitRepositoriesGetaway(@NonNull final RepositoriesApi api, @NonNull final String authToken) {
        this.api = api;
        this.authToken = authToken;
    }

    @Override
    public Observable<List<RepositoryApiEntity>> getRepositories() {
        return api.getTimetableObservable(authToken)
                .map(timetableResponseTransport -> timetableResponseTransport.timetable)
                .subscribeOn(Schedulers.io());
    }
}
