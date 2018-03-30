package com.test.here.heretest.repository.network;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.repository.TimetableGetaway;
import com.flixbus.flixbustest.repository.network.api.TimetablesApi;
import com.flixbus.flixbustest.repository.providers.TimetableGetawayFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoriesGetawayFactoryImpl implements TimetableGetawayFactory {

    @NonNull
    private final String baseUrl;
    @NonNull
    private final String authToken;

    public RepositoriesGetawayFactoryImpl(@NonNull final String baseUrl, @NonNull final String authToken) {
        this.baseUrl = baseUrl;
        this.authToken = authToken;
    }

    @NonNull
    public TimetableGetaway getTimetableGataway() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final TimetablesApi flixbusApi = retrofit.create(TimetablesApi.class);
        return new RetrofitRepositoriesGetaway(flixbusApi, authToken);
    }
}
